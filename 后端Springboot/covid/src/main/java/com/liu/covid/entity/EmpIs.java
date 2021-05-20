package com.liu.covid.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.liu.covid.entity.Enum.GenderEnum;
import lombok.Data;

import java.util.Date;

@Data
public class EmpIs {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private GenderEnum sex;
    private Long phone;
    private float temp;
    private String type;
    private String place;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date begin;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private  Date end;
    private String leaved;
    private String content;
    private String arrived;
    private String depart;
}
