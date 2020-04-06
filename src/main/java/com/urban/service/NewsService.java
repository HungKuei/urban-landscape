package com.urban.service;

import com.urban.core.Service;
import com.urban.model.News;
import com.urban.model.vo.QueryParamVO;

import java.util.List;

public interface NewsService extends Service<News> {

    List<News> getPageListByQueryParam(QueryParamVO queryParamVO);
}
