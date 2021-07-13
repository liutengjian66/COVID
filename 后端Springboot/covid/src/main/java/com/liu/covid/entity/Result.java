package com.liu.covid.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:
 * @author: Liu
 * @time: 2021/7/13
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {
    /**
     * 错误码
     */
    private Integer code;

    /**
     * 错误信息
     */
    private String errors;

    /**
     * 具体数据内容
     */
    private  T data;

    /**
     * 提示信息
     */
    private String msg;

}
