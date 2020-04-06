package com.urban.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.urban.core.ProjectConstant;
import com.urban.core.Result;
import com.urban.core.ResultGenerator;
import com.urban.mapper.ProjectMapper;
import com.urban.mapper.QualificationMapper;
import com.urban.model.*;
import com.urban.model.dto.EnterpriseRegisterDTO;
import com.urban.model.vo.QueryParamVO;
import com.urban.service.*;
import com.urban.utils.EmptyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class IndexController {

    @Autowired
    private NewsService newsService;

    @Autowired
    private EnterpriseService enterpriseService;

    @Autowired
    private ProjectService projectService;

    @Resource
    private SuperviseService superviseService;

    @Resource
    private UserService userService;

    @Resource
    private QualificationMapper qualificationMapper;

    @Resource
    private ProjectMapper projectMapper;

    /**
     * 首页
     *
     * @param model
     * @param vo
     * @return
     */
    @GetMapping("/")
    public String index(Model model, QueryParamVO vo) {
        List<News> all = newsService.findAll();
        List<News> newsList = all.stream().filter(news -> news.getIsRem() == 1).collect(Collectors.toList());
        //model.addAttribute("pageUrl", "urban/index");
        model.addAttribute("categoryId", "index");
        model.addAttribute("sliderList", newsList);//轮播文章
        model.addAttribute("newsList", all);//资讯
        //loadMainPage(model, vo);
        return "index";
    }

    /**
     * 资讯列表
     *
     * @param model
     * @return
     */
    @GetMapping("/news")
    public String getNewsList(Model model) {
        List<News> newsList = newsService.findAll();
        model.addAttribute("newsList", newsList);
        model.addAttribute("categoryId", "news");
        return "news/list";
    }

    /**
     * 企业信用
     *
     * @param model
     * @return
     */
    @GetMapping("/enterprises")
    public String getEnterprises(Model model) {
        List<Enterprise> enterpriseList = enterpriseService.findAll();
        //model.addAttribute("enterpriseList", enterpriseList);
        model.addAttribute("categoryId", "enterprises");
        return "enterprise/list";
    }

    /**
     * 项目公示
     *
     * @param model
     * @return
     */
    @GetMapping("/projects")
    public String getProjects(Model model) {
        List<Project> projectList = projectService.findAll();
        //model.addAttribute("projectList", projectList);
        model.addAttribute("categoryId", "projects");
        return "project/list";
    }

    /**
     * 社会监督
     *
     * @param model
     * @return
     */
    @GetMapping("/supervises")
    public String getSupervises(Model model) {
        model.addAttribute("categoryId", "supervises");
        return "supervise/list";
    }

    @PostMapping("/supervise")
    @ResponseBody
    public Result addSupervises(Supervise supervise) {
        supervise.setStatus(ProjectConstant.DEFAULT_USER_STATUS);
        superviseService.save(supervise);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/supervise/get")
    @ResponseBody
    public Result getSupervises(Integer page, Integer limit, Integer status) {
        PageHelper.startPage(page, limit, "create_time desc");
        List<Supervise> supervises = superviseService.getByStausList(status);
        PageInfo pageInfo = new PageInfo(supervises);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    /**
     * 资讯详情
     *
     * @param model
     * @param newsId
     * @return
     */
    @GetMapping("/news/{newsId}")
    public String getNews(Model model, @PathVariable("newsId") Integer newsId) {
        News news = newsService.findById(newsId);
        news.setClicks(news.getClicks() + 1);
        newsService.update(news);
        model.addAttribute("news", news);
        model.addAttribute("categoryId", "news");
        return "news/detail";
    }

    /**
     * 企业详情
     *
     * @param model
     * @param enterpriseId
     * @return
     */
    @GetMapping("/enterprise/{enterpriseId}")
    public String getEnterprise(Model model, @PathVariable("enterpriseId") Integer enterpriseId) {
        Enterprise enterprise = enterpriseService.findById(enterpriseId);
        List<Qualification> qualifications = qualificationMapper.selectByEnterpriseName(enterprise.getEnterpriseName());
        List<Project> projects = projectMapper.selectByEnterpriseName(enterprise.getEnterpriseName());
        model.addAttribute("enterprise", enterprise);
        model.addAttribute("qualifications", qualifications);
        model.addAttribute("projects", projects);
        model.addAttribute("categoryId", "enterprises");
        return "enterprise/detail";
    }

    /**
     * 项目详情
     *
     * @param model
     * @param projectId
     * @return
     */
    @GetMapping("/project/{projectId}")
    public String getProject(Model model, @PathVariable("projectId") Integer projectId) {
        Project project = projectService.findById(projectId);
        model.addAttribute("project", project);
        model.addAttribute("categoryId", "projects");
        return "project/detail";
    }

    /**
     * 企业注册
     *
     * @param model
     * @return
     */
    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("categoryId", "register");
        return "enterprise/register";
    }

    @PostMapping("/register")
    @ResponseBody
    public Result register(EnterpriseRegisterDTO registerDTO){

        if (EmptyUtil.isEmpty(registerDTO.getUsername()) || EmptyUtil.isEmpty(registerDTO.getPassword())){
            return ResultGenerator.genFailResult("账号或密码不能为空");
        }
        User dbUser = userService.getByUsername(registerDTO.getUsername());
        if (!StringUtils.isEmpty(dbUser)) {
            return ResultGenerator.genFailResult("账号已存在");
        }
        return userService.register(registerDTO) ? ResultGenerator.genSuccessResult() : ResultGenerator.genFailResult("企业注册失败");
    }
}
