package com.liu.covid.entity.Enum;

import com.baomidou.mybatisplus.annotation.EnumValue;

public enum  GenderEnum {
    男(1,"男"),
    女(0,"女");

    GenderEnum(Integer code, String gender) {
        this.code = code;
        this.gender = gender;
    }

    @EnumValue
    private Integer code;
    private String gender;
}
