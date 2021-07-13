package com.liu.covid.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liu.covid.entity.Staff;
import com.liu.covid.service.impl.StaffServiceImpl;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.io.Serializable;
import java.util.List;

/**
 * 人员管理(Staff)表控制层
 *
 * @author tengjian
 * @since 2021-07-13 21:43:18
 */
@Validated
@RestController
@RequestMapping("/staff")
public class StaffController{
    /**
     * 服务对象
     */
    private StaffServiceImpl staffService;

    public StaffController (StaffServiceImpl staffService){
        this.staffService=staffService;
    }
    
    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param staff 查询实体
     * @return 所有数据
     */
    @PostMapping
    public List<Staff> selectAll(Page<Staff> page, Staff staff) {
        return this.staffService.page(page, new QueryWrapper<>(staff)).getRecords();
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @PostMapping("/get/{id}")
    public Staff selectOne(@PathVariable("id") Long id) {
        return this.staffService.getById(id);
    }

    /**
     * 新增数据
     *
     * @param staff 实体对象
     * @return 新增结果
     */
    @PostMapping("/insert")
    public int insert(@Valid @RequestBody Staff staff) {
        return this.staffService.save(staff)?1:0;
    }

    /**
     * 修改数据
     *
     * @param staff 实体对象
     * @return 修改结果
     */
    @PostMapping("/update")
    public int update(@Valid @RequestBody Staff staff) {
        return this.staffService.updateById(staff)?1:0;
    }

    /**
     * 删除数据
     *
     * @param id 主键id
     * @return 删除结果
     */
    @PostMapping("/delete/{id}")
    public int delete(@PathVariable("id") Long id) {
        return this.staffService.removeById(id)?1:0;
    }
}