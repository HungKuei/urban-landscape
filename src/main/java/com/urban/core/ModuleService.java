package com.urban.core;


import com.urban.model.Enterprise;
import com.urban.model.News;
import com.urban.model.Project;
import com.urban.service.EnterpriseService;
import com.urban.service.NewsService;
import com.urban.service.ProjectService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Component("module")
@AllArgsConstructor
public class ModuleService {

    @Autowired
    private NewsService newsService;

    @Autowired
    private EnterpriseService enterpriseService;

    @Resource
    private ProjectService projectService;

    public Object get(String moduleName) {

        switch (moduleName) {
            //轮播文章
            case "allNewsList":
                return newsService.findAll();
            //新闻动态
            case "newsList":
                //新闻动态
                List<News> newsList = newsService.findAll().stream()
                        .filter(news -> news.getType() == 0)
                        .collect(Collectors.toList());
                return newsList;
            //政策法规
            case "policyList":
                //政策法规
                List<News> policyList = newsService.findAll().stream()
                        .filter(news -> news.getType() == 1)
                        .collect(Collectors.toList());
                return policyList;
            //通知公告
            case "noticeList":
                //通知公告
                List<News> noticeList = newsService.findAll().stream()
                        .filter(news -> news.getType() == 2)
                        .collect(Collectors.toList());
                return noticeList;
            //所有企业
            case "allList":
                return enterpriseService.getAllList();
            //设计企业
            case "designList":
                List<Enterprise> designList = enterpriseService.getAllList().stream()
                        .filter(enterprise -> enterprise.getEnterpriseType() == 0)
                        .collect(Collectors.toList());
                return designList;
            //施工企业
            case "buildList":
                List<Enterprise> buildList = enterpriseService.getAllList().stream()
                        .filter(enterprise -> enterprise.getEnterpriseType() == 1)
                        .collect(Collectors.toList());
                return buildList;
            //管护企业
            case "protectList":
                List<Enterprise> protectList = enterpriseService.getAllList().stream()
                        .filter(enterprise -> enterprise.getEnterpriseType() == 2)
                        .collect(Collectors.toList());
                return protectList;
            //监理企业
            case "supervisorList":
                List<Enterprise> supervisorList = enterpriseService.getAllList().stream()
                        .filter(enterprise -> enterprise.getEnterpriseType() == 3)
                        .collect(Collectors.toList());
                return supervisorList;
            //项目公示
            case "projectList":
                return projectService.findAll();
            //网站基本信息配置
            case "sysConfig":
                return sysConfig();
            default:
                return null;
        }
    }

    private Map<String, String> sysConfig(){
        Map<String, String> config = new HashMap<>();
        config.put("SITE_NAME", "城市园林绿化市场信用管理系统");
        return config;
    }
}
