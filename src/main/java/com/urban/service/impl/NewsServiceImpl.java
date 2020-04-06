package com.urban.service.impl;

import com.urban.core.AbstractService;
import com.urban.mapper.NewsMapper;
import com.urban.model.News;
import com.urban.model.vo.QueryParamVO;
import com.urban.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class NewsServiceImpl extends AbstractService<News> implements NewsService {

    @Resource
    private NewsMapper newsMapper;

    @Override
    public List<News> getPageListByQueryParam(QueryParamVO queryParamVO) {
        return newsMapper.selectByQueryParam(queryParamVO);
    }
}
