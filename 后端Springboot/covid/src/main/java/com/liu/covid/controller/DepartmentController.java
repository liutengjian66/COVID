package com.liu.covid.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liu.covid.entity.Department;
import com.liu.covid.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 部门(department)表控制层
 *
 * @author Tengjian
 * @since 2021/07/08
 */
@RestController
@RequestMapping("department")
public class DepartmentController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private DepartmentService departmentService;

    /**
     * 分页查询所有数据
     *
     * @param page       分页对象
     * @param department 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<Department> page, Department department) {
        return success(this.departmentService.page(page, new QueryWrapper<>(department)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.departmentService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param department 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody Department department) {
        return success(this.departmentService.save(department));
    }

    /**
     * 修改数据
     *
     * @param department 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody Department department) {
        return success(this.departmentService.updateById(department));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.departmentService.removeByIds(idList));
    }
}
