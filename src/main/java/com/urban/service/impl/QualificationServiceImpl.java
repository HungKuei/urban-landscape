package com.urban.service.impl;

import com.urban.core.AbstractService;
import com.urban.mapper.QualificationMapper;
import com.urban.model.Qualification;
import com.urban.model.vo.QueryParamVO;
import com.urban.service.QualificationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class QualificationServiceImpl extends AbstractService<Qualification> implements QualificationService {

    @Resource
    private QualificationMapper qualificationMapper;

    @Override
    public List<Qualification> getPageListByQueryParam(QueryParamVO queryParamVO) {
        return qualificationMapper.selectByQueryParam(queryParamVO);
    }
}
