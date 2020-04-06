package com.urban.mapper;

import com.urban.core.Mapper;
import com.urban.model.Qualification;
import com.urban.model.vo.QueryParamVO;

import java.util.List;

public interface QualificationMapper extends Mapper<Qualification> {

    List<Qualification> selectByQueryParam(QueryParamVO queryParamVO);

    List<Qualification> selectByEnterpriseName(String enterpriseName);
}
