package com.urban.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.urban.core.Result;
import com.urban.core.ResultGenerator;
import com.urban.model.Project;
import com.urban.model.vo.QueryParamVO;
import com.urban.service.ProjectService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 项目管理
 */
@RestController
@RequestMapping("/api/project")
public class ProjectController {

    @Resource
    private ProjectService projectService;

    @PostMapping("/list")
    public Result list(@RequestBody QueryParamVO queryParamVO) {
        PageHelper.startPage(queryParamVO.getPage(), queryParamVO.getLimit(), queryParamVO.getSort());
        List<Project> list = projectService.getPageListByQueryParam(queryParamVO);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @GetMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        Project project = projectService.findById(id);
        if (project == null) return ResultGenerator.genFailResult("不存在id为" + id + "的项目！");
        return ResultGenerator.genSuccessResult(project);
    }

    @PostMapping("/add")
    public Result add(@RequestBody Project project) {
        if(StringUtils.isBlank(project.getProjectName())) return ResultGenerator.genFailResult("项目名称不能为空！");
        if(StringUtils.isBlank(project.getEnterpriseName())) return ResultGenerator.genFailResult("企业名称不能为空！");
        projectService.save(project);
        return ResultGenerator.genSuccessResult();
    }


    @PutMapping("/update")
    public Result update(@RequestBody Project project) {
        projectService.update(project);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        projectService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }
}
