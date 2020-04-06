package com.urban.model;

import lombok.Data;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Data
public class Supervise implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Integer id;

    private Integer type;

    private String username;

    private String phone;

    private String email;

    private String address;

    private String title;

    private String content;

    private String reply;

    private Integer status;

    private Date createTime;
}
