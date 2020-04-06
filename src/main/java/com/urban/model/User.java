package com.urban.model;

import lombok.Data;

import javax.persistence.Id;
import java.util.Date;

@Data
public class User {

    @Id
    private Integer id;

    private String username;

    private String password;

    private String role;

    private String phone;

    private String email;

    private String sex;

    private String avatar;

    private String preInfo;

    private Integer status;

    private Date createTime;

    private Date updateTime;
}
