package com.liu.covid.config;

import com.liu.covid.entity.Result;

/**
 * @description:
 * @author: Liu
 * @time: 2021/7/13
 */
public class ResponseData<T> {

    public Result<T> success(T data){
        return new Result<T>(100, null, data, "success");
    }

    public Result<T> error(Integer code,String errors){
        return new Result<T>(code, errors, null, "error");
    }
}
