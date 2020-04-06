package com.urban.model;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;

@Data
public class Enterprise implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Integer id;

    private String creditCode;

    private String enterpriseName;

    private String legalPerson;

    private String person;

    private String phone;

    private String registerCode;

    private String address;

    private Integer enterpriseType;

    private Integer registerCapital;

    private String website;

    private String email;

    private Integer isForeign;

    private String status;

    private Date foundTime;

    private Integer userId;

    private Date createTime;

    private Date updateTime;

    @Transient
    private String qualification;
}
