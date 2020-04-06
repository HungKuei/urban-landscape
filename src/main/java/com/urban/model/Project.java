package com.urban.model;

import lombok.Data;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Data
public class Project implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Integer id;

    private String enterpriseName;

    private String projectName;

    private Integer projectType;

    private Integer scale;

    private String region;

    private String location;

    private Double amount;

    private Date contractDate;

    private Date startDate;

    private String enterprisePerson;

    private String projectPerson;

    private String remart;

    private String status;
}
