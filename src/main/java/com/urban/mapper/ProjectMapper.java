package com.urban.mapper;

import com.urban.core.Mapper;
import com.urban.model.Project;
import com.urban.model.vo.QueryParamVO;

import java.util.List;

public interface ProjectMapper extends Mapper<Project> {
    List<Project> selectByQueryParam(QueryParamVO queryParamVO);

    List<Project> selectByEnterpriseName(String enterpriseName);
}
