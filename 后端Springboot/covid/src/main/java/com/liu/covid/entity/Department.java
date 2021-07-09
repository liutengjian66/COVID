package com.liu.covid.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;



/**
 * 部门(department)表实体类
 *
 * @author Tengjian
 * @since 2021/07/08
 */
@Data
public class Department extends Model<Department> {
    /**
     * 业务主键
     */
    private Long id;
    /**
     * 部门编号
     */
    private String code;
    /**
     * 部门名称
     */
    private String name;
    /**
     * 备注
     */
    private String memo;

}
