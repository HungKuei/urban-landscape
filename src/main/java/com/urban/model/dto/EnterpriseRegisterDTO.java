package com.urban.model.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class EnterpriseRegisterDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String username;

    private String password;

    private String creditCode;

    private String enterpriseName;

    private String legalPerson;

    private String person;

    private String phone;

    private String address;

    private String email;

    private String foundTime;
}
