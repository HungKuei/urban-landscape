package com.urban.mapper;


import com.urban.core.Mapper;
import com.urban.model.Supervise;

import java.util.List;

public interface SuperviseMapper extends Mapper<Supervise> {
    List<Supervise> selectByStatus(Integer status);
}
