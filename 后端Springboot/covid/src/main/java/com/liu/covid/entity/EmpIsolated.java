package com.liu.covid.entity;

import java.util.Date;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * 隔离人员(EmpIsolated)表实体类
 *
 * @author tengjian
 * @since 2021-07-13 21:55:38
 */
@Data
@TableName(value = "emp_isolated",autoResultMap = true)
public class EmpIsolated implements Serializable {
        
    /**
     * 主键id
     */    
    @TableId(type = IdType.AUTO)   
    private Integer id;
        
    /**
     * 体温
     */   
    private Double temperature;
        
    /**
     * 隔离方式
     */   
    private String type;
        
    /**
     * 隔离地点
     */   
    private String isolatedPlace;
        
    /**
     * 隔离开始时间
     */   
    private Date beginDate;
        
    /**
     * 隔离结束时间
     */   
    private Date endDate;
        
    /**
     * 出发地
     */   
    private String leavedArea;
        
    /**
     * 备注
     */   
    private String memo;
        
    /**
     * 途径地
     */   
    private String arrivedArea;
        
    /**
     * 部门id
     */   
    private Integer departmentId;
        
    /**
     * 打卡记录id
     */   
    private Integer empHealthId;
}