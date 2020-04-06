package com.urban.model;

import lombok.Data;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Data
public class News implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Integer id;

    private String title;

    private Integer type;

    private String origin;

    private String newImg;

    private Long clicks;

    private Integer isRem;

    private Date createTime;

    private Date updateTime;

    private String content;
}
