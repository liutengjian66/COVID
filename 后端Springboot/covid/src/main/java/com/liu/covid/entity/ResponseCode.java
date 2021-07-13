package com.liu.covid.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.xuanyutech.framework.model.AppCode;

/**
 * 全局返回状态码
 * @author tengjian
 */
@Getter
@RequiredArgsConstructor
public enum ResponseCode implements AppCode {

    /**
     * 不能为空
     */
    NOT_EXIST(1002,"%s不存在"),
    ILLEGAL_ARGUMENT(1003,"非法参数%"),
    MISSING_ARGUMENT(1004,"缺少参数%s"),
    EXIST_REFERENCE(1005,"%s还在使用中，不可删除"),
    ILLEGAL_STATUS(1006,"%s状态错误"),
    ALREADY_EXIST(1007,"%s已存在");

    private final int code;
    private final String message;

}
