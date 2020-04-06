package com.urban.mapper;

import com.urban.core.Mapper;
import com.urban.model.News;
import com.urban.model.vo.QueryParamVO;

import java.util.List;

public interface NewsMapper extends Mapper<News> {
    List<News> selectByQueryParam(QueryParamVO queryParamVO);
}
