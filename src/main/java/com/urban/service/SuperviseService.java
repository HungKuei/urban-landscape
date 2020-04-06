package com.urban.service;

import com.urban.core.Service;
import com.urban.model.Supervise;

import java.util.List;

public interface SuperviseService extends Service<Supervise> {
    List<Supervise> getByStausList(Integer status);
}
