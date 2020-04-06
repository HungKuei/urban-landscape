package com.urban.model;

import lombok.Data;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Data
public class Qualification implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Integer id;

    private String enterpriseName;

    private Integer type;

    private String certificateCode;

    private String level;

    private String issuedBy;

    private Date vestingDate;

    private String periodValidity;

    private String good;

    private String bad;
}
