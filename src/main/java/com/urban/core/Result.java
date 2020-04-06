package com.urban.core;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


/**
 * 统一API响应结果封装
 */
@Data
@NoArgsConstructor
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 171791176757477130L;

    private int code;
    private String msg;
    private T data;
    private Long total;

    public Result(int code, String msg, T data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Result(int code, String msg, T data, Long total){
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.total = total;
    }

}
