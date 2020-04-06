package com.urban.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.urban.core.ProjectConstant;
import com.urban.core.Result;
import com.urban.core.ResultGenerator;
import com.urban.model.*;
import com.urban.model.vo.QueryParamVO;
import com.urban.service.NewsService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 新闻、政策、公告
 */
@RestController
@RequestMapping("/api/news")
public class NewsController {

    @Resource
    private NewsService newsService;

    @PostMapping("/list")
    public Result list(@RequestBody QueryParamVO queryParamVO) {
        PageHelper.startPage(queryParamVO.getPage(), queryParamVO.getLimit(), queryParamVO.getSort());
        List<News> list = newsService.getPageListByQueryParam(queryParamVO);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @GetMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        News news = newsService.findById(id);
        return ResultGenerator.genSuccessResult(news);
    }

    @PostMapping("/add")
    public Result add(@RequestBody News news){
        if (StringUtils.isBlank(news.getTitle())){
            return ResultGenerator.genFailResult("标题不能为空！");
        }
        if (StringUtils.isBlank(news.getContent())){
            return ResultGenerator.genFailResult("内容不能为空！");
        }
        news.setIsRem(ProjectConstant.DEFAULT_USER_STATUS);
        newsService.save(news);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping("/update")
    public Result update(@RequestBody News news){
        newsService.update(news);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/delete")
    public Result delete(Integer id){
        newsService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }
}
