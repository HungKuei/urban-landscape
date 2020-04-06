package com.urban.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.urban.core.Result;
import com.urban.core.ResultGenerator;
import com.urban.model.Enterprise;
import com.urban.model.News;
import com.urban.model.vo.QueryParamVO;
import com.urban.service.EnterpriseService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 企业信息管理
 */
@RestController
@RequestMapping("/api/enterprise")
public class EnterpriseController {

    @Resource
    private EnterpriseService enterpriseService;


    @PostMapping("/list")
    public Result list(@RequestBody QueryParamVO queryParamVO) {
        PageHelper.startPage(queryParamVO.getPage(), queryParamVO.getLimit(), queryParamVO.getSort());
        List<Enterprise> list = enterpriseService.getPageListByQueryParam(queryParamVO);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @GetMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        Enterprise enterprise = enterpriseService.findById(id);
        return ResultGenerator.genSuccessResult(enterprise);
    }

    @PostMapping("/add")
    public Result add(@RequestBody Enterprise enterprise){
        if (StringUtils.isBlank(enterprise.getEnterpriseName())){
            return ResultGenerator.genFailResult("企业名称不能为空！");
        }
        if (StringUtils.isBlank(enterprise.getCreditCode())){
            return ResultGenerator.genFailResult("企业信用代码不能为空！");
        }
        enterpriseService.save(enterprise);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping("/update")
    public Result update(@RequestBody Enterprise enterprise){
        enterpriseService.update(enterprise);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/delete")
    public Result delete(Integer id){
        enterpriseService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }
}
