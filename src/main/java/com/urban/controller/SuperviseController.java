package com.urban.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.urban.core.Result;
import com.urban.core.ResultGenerator;
import com.urban.model.Supervise;
import com.urban.service.SuperviseService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 社会监督
 */
@RestController
@RequestMapping("/api/supervise")
public class SuperviseController {

    @Resource
    private SuperviseService uperviseService;

    @GetMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "10") Integer limit) {
        PageHelper.startPage(page, limit, "create_time desc");
        List<Supervise> list = uperviseService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @GetMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        Supervise supervise = uperviseService.findById(id);
        return ResultGenerator.genSuccessResult(supervise);
    }

    @PostMapping("/add")
    public Result add(@RequestBody Supervise supervise){
        if (StringUtils.isBlank(supervise.getTitle())){
            return ResultGenerator.genFailResult("标题不能为空！");
        }
        if (StringUtils.isBlank(supervise.getContent())){
            return ResultGenerator.genFailResult("内容不能为空！");
        }
        uperviseService.save(supervise);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping("/update")
    public Result update(@RequestBody Supervise supervise){
        uperviseService.update(supervise);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/delete")
    public Result delete(Integer id){
        uperviseService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }
}
