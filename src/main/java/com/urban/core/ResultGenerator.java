package com.urban.core;


import java.util.List;

/**
 * 响应结果生成工具
 */
public class ResultGenerator {
    private static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";

    public static Result genSuccessResult() {
        return init(ResultCode.SUCCESS.code(), DEFAULT_SUCCESS_MESSAGE, null);
    }

    public static <T> Result<T> genSuccessResult(T data) {
        return init(ResultCode.SUCCESS.code(), DEFAULT_SUCCESS_MESSAGE, data);
    }

    public static <T> Result<T> genSuccessPageResult(List<T> data, Long total) {
        return init(ResultCode.SUCCESS.code(), DEFAULT_SUCCESS_MESSAGE, data, total);
    }

    public static Result genFailResult(String msg) {
        return init(ResultCode.FAIL.code(), msg, null);
    }

    public static Result init(int code, String msg, Object data){
        return new Result(code, msg, data);
    }
    public static Result init(Integer code, String msg, List<?> data, Long count){
        return new Result(code, msg, data, count);
    }
}
