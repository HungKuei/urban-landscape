package com.urban.service.impl;

import com.urban.core.AbstractService;
import com.urban.mapper.ProjectMapper;
import com.urban.model.Project;
import com.urban.model.vo.QueryParamVO;
import com.urban.service.ProjectService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


@Service
@Transactional
public class ProjectServiceImpl extends AbstractService<Project> implements ProjectService {

    @Resource
    private ProjectMapper projectMapper;

    @Override
    public List<Project> getPageListByQueryParam(QueryParamVO queryParamVO) {
        return projectMapper.selectByQueryParam(queryParamVO);
    }
}
