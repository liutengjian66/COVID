package com.liu.covid.entity;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * 人员管理(Staff)表实体类
 *
 * @author tengjian
 * @since 2021-07-13 21:43:18
 */
@Data
@TableName(value = "staff",autoResultMap = true)
public class Staff implements Serializable {
        
    /**
     * 主键id
     */    
    @TableId(type = IdType.AUTO)   
    private Integer id;
        
    /**
     * 员工编号
     */
    @NotEmpty(message = "员工编号不能为空！")
    private String code;
        
    /**
     * 员工姓名
     */
    @NotEmpty(message = "员工姓名不能为空！")
    private String name;
        
    /**
     * 联系方式
     */
    @NotEmpty(message = "员工联系方式不能为空！")
    private String phone;
}