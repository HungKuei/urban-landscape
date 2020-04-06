package com.urban.service;

import com.urban.core.Service;
import com.urban.model.Qualification;
import com.urban.model.vo.QueryParamVO;

import java.util.List;

public interface QualificationService extends Service<Qualification> {
    List<Qualification> getPageListByQueryParam(QueryParamVO queryParamVO);
}
