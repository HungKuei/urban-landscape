package com.urban.configurer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.urban.core.Result;
import com.urban.core.ResultCode;
import com.urban.core.ServiceException;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Spring MVC 配置
 */

public class WebMvcConfigurer extends WebMvcConfigurationSupport {

    private final Logger logger = LoggerFactory.getLogger(WebMvcConfigurer.class);

    @Value("${blog.cipher}")
    private String CIPHER;

    @Value("${blog.upload.dir}")
    private String UPLOAD_DIR;

    @Value("${blog.upload.url}")
    private String UPLOAD_URL;

    //添加拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //接口签名认证拦截器，该签名认证比较简单，实际项目中可以使用Json Web Token或其他更好的方式替代。
        if (!"dev".equals("ENV")) { //开发环境忽略签名认证
            registry.addInterceptor(new HandlerInterceptorAdapter() {
                @Override
                public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
                    //验证签名
                    boolean pass = validateSign(request);
                    if (pass) {
                        return true;
                    } else {
                        logger.warn("签名认证失败，请求接口：{}，请求IP：{}，请求参数：{}", request.getRequestURI(), getIpAddress(request), JSON.toJSONString(request.getParameterMap()));
                        Result result = new Result();
                        result.setCode(ResultCode.UNAUTHORIZED.code());
                        result.setMsg("签名认证失败");
                        responseResult(response, result);
                        return false;
                    }
                }
            }).excludePathPatterns("/upload/**"); // 排除图片请求签名
        }

        // 管理员登录拦截器，实现简单的权限控制
        if (!"dev".equals("ENV")) { //开发环境忽略该拦截器
            registry.addInterceptor(new HandlerInterceptorAdapter() {
                @Override
                public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

                    if (request.getSession().getAttribute("admin") != null) {
                        return true;
                    }

                    Result result = new Result();
                    result.setCode(ResultCode.NOT_LOGIN.code());
                    result.setMsg("用户未登录");
                    responseResult(response, result);
                    return false;

                }
            }).addPathPatterns("/admin/**").excludePathPatterns("/admin/admin/login", "/admin/detail");
        }
    }

    private void responseResult(HttpServletResponse response, Result result) {
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-type", "application/json;charset=UTF-8");
        response.setStatus(200);
        try {
            response.getWriter().write(JSON.toJSONString(result));
        } catch (IOException ex) {
            logger.error(ex.getMessage());
        }
    }

    /**
     * 一个简单的签名认证，规则：
     * 1. 将请求参数按ascii码排序
     * 2. 拼接为a=value&b=value...这样的字符串（不包含sign）
     * 3. 混合密钥（secret）进行md5获得签名，与请求的签名进行比较
     */
    private boolean validateSign(HttpServletRequest request) throws UnsupportedEncodingException {
        String requestSign = request.getParameter("sign");//获得请求签名，如sign=19e907700db7ad91318424a97c54ed57
        if (StringUtils.isEmpty(requestSign)) {
            return false;
        }
        List<String> keys = new ArrayList<String>(request.getParameterMap().keySet());
        keys.remove("sign");//排除sign参数
        Collections.sort(keys);//排序

        StringBuilder sb = new StringBuilder();
        for (String key : keys) {
            sb.append(key).append("=").append(request.getParameter(key)).append("&");//拼接字符串
        }
        String linkString = sb.toString();
        linkString = StringUtils.substring(linkString, 0, linkString.length() - 1);//去除最后一个'&'

        // 将各种字符转成数字，防止因为编码不同导致mdHex结果不同，进而导致签名认证失败
        String sign = DigestUtils.md5Hex(toByteString(linkString + CIPHER));//混合密钥md5

        return StringUtils.equals(sign, requestSign);//比较
    }

    private String toByteString(String string) throws UnsupportedEncodingException{
        return toByteString(string, "utf8");
    }

    private String toByteString(String string, String alg) throws UnsupportedEncodingException {
        if (string == null) return null;
        byte[] bytes = string.getBytes(alg);
        StringBuilder sb = new StringBuilder();
        for(byte b : bytes) {
            // java 默认是signed的byte，此处转为unsigned
            sb.append((b < 0) ? (b + 256) : b);
        }
        return sb.toString();
    }

    private String getIpAddress(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        // 如果是多级代理，那么取第一个ip为客户端ip
        if (ip != null && ip.indexOf(",") != -1) {
            ip = ip.substring(0, ip.indexOf(",")).trim();
        }

        return ip;
    }
}
