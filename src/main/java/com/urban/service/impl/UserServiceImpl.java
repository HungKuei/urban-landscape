package com.urban.service.impl;

import com.urban.core.AbstractService;
import com.urban.core.ProjectConstant;
import com.urban.mapper.UserMapper;
import com.urban.model.Enterprise;
import com.urban.model.User;
import com.urban.model.dto.EnterpriseRegisterDTO;
import com.urban.service.EnterpriseService;
import com.urban.service.UserService;
import com.urban.utils.EmptyUtil;
import com.urban.utils.MD5Util;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.util.DateUtils;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl extends AbstractService<User> implements UserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private EnterpriseService enterpriseService;

    @Override
    public User getByUsername(String username) {
        User user = new User();
        user.setUsername(username);
        return userMapper.selectOne(user);
    }

    @Override
    public List<User> getUserByPage(Integer page, Integer limit) {
        if (EmptyUtil.isEmpty(page) || EmptyUtil.isEmpty(limit)){
            return userMapper.selectAll();
        }
        page = (page - 1) * limit;
        return userMapper.selectByLimit(page, limit);
    }

    @Override
    public boolean register(EnterpriseRegisterDTO registerDTO) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date dateTime = null;
        try {
            dateTime = format.parse(registerDTO.getFoundTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String username = registerDTO.getUsername();
        String password = registerDTO.getPassword();
        User user = new User();
        user.setUsername(username);
        user.setPassword(MD5Util.md5(password));
        user.setStatus(ProjectConstant.DEFAULT_USER_STATUS);
        user.setRole(ProjectConstant.DEFAULT_USER_ROLE);
        save(user);
        User newUser = getByUsername(username);
        // 创建企业
        Enterprise enterprise = new Enterprise();
        enterprise.setCreditCode(registerDTO.getCreditCode());
        enterprise.setEnterpriseName(registerDTO.getEnterpriseName());
        enterprise.setLegalPerson(registerDTO.getLegalPerson());
        enterprise.setPerson(registerDTO.getPerson());
        enterprise.setPhone(registerDTO.getPhone());
        enterprise.setAddress(registerDTO.getAddress());
        enterprise.setEnterpriseType(ProjectConstant.DEFAULT_USER_STATUS);
        enterprise.setEmail(registerDTO.getEmail());
        enterprise.setFoundTime(dateTime);
        enterprise.setUserId(newUser.getId());
        enterpriseService.save(enterprise);
        return true;
    }
}
