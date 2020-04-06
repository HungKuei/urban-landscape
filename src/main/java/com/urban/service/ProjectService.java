package com.urban.service;

import com.urban.core.Service;
import com.urban.model.Project;
import com.urban.model.vo.QueryParamVO;

import java.util.List;


public interface ProjectService extends Service<Project> {

    List<Project> getPageListByQueryParam(QueryParamVO queryParamVO);
}
