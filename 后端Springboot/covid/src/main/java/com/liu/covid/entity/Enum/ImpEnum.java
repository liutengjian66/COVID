package com.liu.covid.entity.Enum;

import com.baomidou.mybatisplus.annotation.EnumValue;

public enum  ImpEnum {
    是(1,"是"),
    否(0,"否");

    ImpEnum(Integer code, String isImp) {
        this.code = code;
        this.isImp = isImp;
    }

    @EnumValue
    private  Integer code;
    private  String isImp;
}
