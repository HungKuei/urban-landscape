package com.urban.model.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class QueryParamVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer page;

    private Integer limit;

    private String title;

    private Integer type;

    private String sort;
}
