package com.liu.covid.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.liu.covid.entity.Enum.ImpEnum;
import lombok.Data;

import java.util.Date;

@Data
@TableName(value = "material_manage")
public class MaterialManage {


    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private int count;
    private String type;
    @TableField(value = "isImp")
    private ImpEnum isImp;
    private String charge;
    private Long cnum;
    @TableField(value = "updateTime" ,fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date updateTime;

}
