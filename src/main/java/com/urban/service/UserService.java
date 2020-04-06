package com.urban.service;


import com.urban.core.Service;
import com.urban.model.User;
import com.urban.model.dto.EnterpriseRegisterDTO;

import java.util.List;

public interface UserService extends Service<User> {
    User getByUsername(String username);

    List<User> getUserByPage(Integer page, Integer limit);

    boolean register(EnterpriseRegisterDTO registerDTO);
}
