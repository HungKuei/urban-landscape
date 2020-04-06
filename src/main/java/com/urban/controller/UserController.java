package com.urban.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.urban.core.ProjectConstant;
import com.urban.core.Result;
import com.urban.core.ResultGenerator;
import com.urban.model.Enterprise;
import com.urban.model.User;
import com.urban.model.dto.EnterpriseRegisterDTO;
import com.urban.service.UserService;
import com.urban.utils.EmptyUtil;
import com.urban.utils.MD5Util;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/list")
    public Result getList(@RequestParam(defaultValue = "0")Integer page, @RequestParam(defaultValue = "10")Integer limit){
        PageHelper.startPage(page, limit, "create_time desc");
        List<User> users = userService.findAll();
        PageInfo pageInfo = new PageInfo(users);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @GetMapping("/get")
    public Result detail(HttpServletRequest request) {
        String username = (String) request.getSession().getAttribute("user");
        if (StringUtil.isEmpty(username)){
            return ResultGenerator.genFailResult("登录账号已过期，请重新登录");
        }
        User user = userService.getByUsername(username);
        user.setPassword(null);
        return ResultGenerator.genSuccessResult(user);
    }

    @PostMapping("/add")
    public Result<User> add(@RequestBody User user){
        if (StringUtils.isEmpty(user.getUsername())){
            return ResultGenerator.genFailResult("账号或密码不能为空");
        }
        User dbUser = userService.getByUsername(user.getUsername());
        if (!StringUtils.isEmpty(dbUser)) {
            return ResultGenerator.genFailResult("账号已存在");
        }
        user.setStatus(ProjectConstant.DEFAULT_USER_STATUS);
        user.setPassword(MD5Util.md5(user.getPassword()));
        userService.save(user);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping("/update")
    public Result<User> update(@RequestBody User user){
        if (!StringUtils.isEmpty(user.getPassword())){
            user.setPassword(MD5Util.md5(user.getPassword()));
        }
        userService.update(user);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/delete")
    public Result<User> delete(Integer id){
        userService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/login")
    public Result login(String username, String password, HttpServletRequest request) {

        if (EmptyUtil.isEmpty(username) || EmptyUtil.isEmpty(password)){
            return ResultGenerator.genFailResult("账号或密码不能为空");
        }
        User user = userService.getByUsername(username);
        if (EmptyUtil.isEmpty(user)){
            return ResultGenerator.genFailResult("账号不存在");
        }
        if (!MD5Util.verify(password,user.getPassword())) {
            return ResultGenerator.genFailResult("账号或密码错误");
        }
        request.getSession().setAttribute("user", user.getUsername());
        Map<String, String> tokenMap = new HashMap<>();
        String token = getToken();
        tokenMap.put("token", token);
        request.getSession().setAttribute("token", token);
        return ResultGenerator.genSuccessResult(tokenMap);
    }

    @PostMapping("/logout")
    public Result logout(HttpServletRequest request) {
        if(request.getSession().getAttribute("user") == null) {
            return ResultGenerator.genFailResult("注销失败，当前并没有用户登录！");
        }
        request.getSession().setAttribute("user", null);
        return ResultGenerator.genSuccessResult("注销成功！");
    }

    private String getToken() {
        return UUID.randomUUID().toString();
    }

}
