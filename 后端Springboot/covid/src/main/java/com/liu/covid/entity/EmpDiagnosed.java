package com.liu.covid.entity;

import java.util.Date;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * 确诊人员(EmpDiagnosed)表实体类
 *
 * @author tengjian
 * @since 2021-07-13 21:55:38
 */
@Data
@TableName(value = "emp_diagnosed",autoResultMap = true)
public class EmpDiagnosed implements Serializable {
        
    /**
     * 主键id
     */    
    @TableId(type = IdType.AUTO)   
    private Integer id;
        
    /**
     * 健康状况
     */   
    private String healthStatus;
        
    /**
     * 身份证号
     */   
    private Integer idCard;
        
    /**
     * 确诊日期
     */   
    private Date diagnosisDate;
        
    /**
     * 确诊地点
     */   
    private String diagnosisPlace;
        
    /**
     * 部门id
     */   
    private Integer departmentId;
        
    /**
     * 登记时间
     */   
    private Date registerTime;
        
    /**
     * 打卡记录id
     */   
    private Integer empHealthId;
}