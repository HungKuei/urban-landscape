package com.urban.service;

import com.urban.core.Service;
import com.urban.model.Enterprise;
import com.urban.model.vo.QueryParamVO;

import java.util.List;

public interface EnterpriseService extends Service<Enterprise> {
    List<Enterprise> getPageListByQueryParam(QueryParamVO queryParamVO);

    List<Enterprise> getAllList();
}
