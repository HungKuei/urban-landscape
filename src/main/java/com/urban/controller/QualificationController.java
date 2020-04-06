package com.urban.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.urban.core.Result;
import com.urban.core.ResultGenerator;
import com.urban.model.Qualification;
import com.urban.model.vo.QueryParamVO;
import com.urban.service.QualificationService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 企业资质
 */
@RestController
@RequestMapping("/api/qualification")
public class QualificationController {

    @Resource
    private QualificationService qualificationService;

    @PostMapping("/list")
    public Result list(@RequestBody QueryParamVO queryParamVO) {
        PageHelper.startPage(queryParamVO.getPage(), queryParamVO.getLimit(), queryParamVO.getSort());
        List<Qualification> list = qualificationService.getPageListByQueryParam(queryParamVO);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @GetMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        Qualification qualification = qualificationService.findById(id);
        return ResultGenerator.genSuccessResult(qualification);
    }

    @PostMapping("/add")
    public Result add(@RequestBody Qualification qualification){
        if (StringUtils.isBlank(qualification.getCertificateCode())){
            return ResultGenerator.genFailResult("证书编号不能为空");
        }
        if (StringUtils.isBlank(qualification.getPeriodValidity())){
            return ResultGenerator.genFailResult("核发机关不能为空！");
        }
        qualificationService.save(qualification);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping("/update")
    public Result update(@RequestBody Qualification qualification){
        qualificationService.update(qualification);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/delete")
    public Result delete(Integer id){
        qualificationService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }
}
