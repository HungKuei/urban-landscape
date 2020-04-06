package com.urban.mapper;

import com.urban.core.Mapper;
import com.urban.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper extends Mapper<User> {
    List<User> selectByLimit(@Param("page") Integer page, @Param("limit") Integer limit);
}
