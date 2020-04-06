package com.urban.mapper;

import com.urban.core.Mapper;
import com.urban.model.Enterprise;
import com.urban.model.vo.QueryParamVO;

import java.util.List;

public interface EnterpriseMapper extends Mapper<Enterprise> {

    List<Enterprise> selectByQueryParam(QueryParamVO queryParamVO);
}