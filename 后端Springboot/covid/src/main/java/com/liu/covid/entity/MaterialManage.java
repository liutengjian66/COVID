package com.liu.covid.entity;

import java.util.Date;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * 防疫物资管理(MaterialManage)表实体类
 *
 * @author tengjian
 * @since 2021-07-13 21:55:38
 */
@Data
@TableName(value = "material_manage",autoResultMap = true)
public class MaterialManage implements Serializable {
        
    /**
     * 主键id
     */    
    @TableId(type = IdType.AUTO)   
    private Integer id;
        
    /**
     * 物资名称
     */   
    private String name;
        
    /**
     * 物资数量
     */   
    private Integer number;
        
    /**
     * 物资单位
     */   
    private String unit;
        
    /**
     * 是否为重要物资
     */   
    private Object isImportment;
        
    /**
     * 负责人id
     */   
    private Integer principalId;
        
    /**
     * 物资更新时间
     */   
    private Date updateTime;
}