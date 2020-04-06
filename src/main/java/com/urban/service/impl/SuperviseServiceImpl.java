package com.urban.service.impl;

import com.urban.core.AbstractService;
import com.urban.mapper.SuperviseMapper;
import com.urban.model.Supervise;
import com.urban.service.SuperviseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SuperviseServiceImpl extends AbstractService<Supervise> implements SuperviseService {

    @Resource
    private SuperviseMapper superviseMapper;

    @Override
    public List<Supervise> getByStausList(Integer status) {
        return superviseMapper.selectByStatus(status);
    }
}
