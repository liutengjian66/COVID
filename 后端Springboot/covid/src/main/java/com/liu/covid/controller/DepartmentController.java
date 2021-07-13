package com.liu.covid.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liu.covid.entity.Department;
import com.liu.covid.service.impl.DepartmentServiceImpl;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 部门(Department)表控制层
 *
 * @author tengjian
 * @since 2021-07-12 15:54:22
 */
@Validated
@RestController
@RequestMapping("/department")
public class DepartmentController{
    /**
     * 服务对象
     */
    private DepartmentServiceImpl departmentService;

    public DepartmentController (DepartmentServiceImpl departmentService){
        this.departmentService=departmentService;
    }
    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param department 查询实体
     * @return 所有数据
     */
    @PostMapping
    public List<Department> selectAll(Page<Department> page, Department department) {
        return this.departmentService.page(page, new QueryWrapper<>(department)).getRecords();
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @PostMapping("/getOne/{id}")
    public Department selectOne(@PathVariable("id") Long id) {
        return this.departmentService.getById(id);
    }

    /**
     * 新增数据
     *
     * @param department 实体对象
     * @return 新增结果
     */
    @PostMapping("/insert")
    public int insert(@Valid @RequestBody Department department) {
        return this.departmentService.save(department)?1:0;
    }

    /**
     * 修改数据
     *
     * @param department 实体对象
     * @return 修改结果
     */
    @PostMapping("/update")
    public int update(@Valid @RequestBody Department department) {
        return this.departmentService.updateById(department)?1:0;
    }

    /**
     * 删除数据
     *
     * @param id 主键id
     * @return 删除结果
     */
    @PostMapping("/delete/{id}")
    public int delete(@PathVariable("id") Long id) {
        return this.departmentService.removeById(id)?1:0;
    }
}