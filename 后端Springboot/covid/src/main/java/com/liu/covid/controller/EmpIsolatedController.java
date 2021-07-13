package com.liu.covid.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liu.covid.entity.EmpIsolated;
import com.liu.covid.service.impl.EmpIsolatedServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 隔离人员(EmpIsolated)表控制层
 *
 * @author tengjian
 * @since 2021-07-13 21:55:38
 */
@RestController
@RequestMapping("/empIsolated")
public class EmpIsolatedController{
    /**
     * 服务对象
     */
    private EmpIsolatedServiceImpl empIsolatedService;

    public EmpIsolatedController (EmpIsolatedServiceImpl empIsolatedService){
        this.empIsolatedService=empIsolatedService;
    }
    
    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param empIsolated 查询实体
     * @return 所有数据
     */
    @PostMapping
    public List<EmpIsolated> selectAll(Page<EmpIsolated> page, EmpIsolated empIsolated) {
        return this.empIsolatedService.page(page, new QueryWrapper<>(empIsolated)).getRecords();
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @PostMapping("/get/{id}")
    public EmpIsolated selectOne(@PathVariable("id") Long id) {
        return this.empIsolatedService.getById(id);
    }

    /**
     * 新增数据
     *
     * @param empIsolated 实体对象
     * @return 新增结果
     */
    @PostMapping("/insert")
    public int insert(@RequestBody EmpIsolated empIsolated) {
        return this.empIsolatedService.save(empIsolated)?1:0;
    }

    /**
     * 修改数据
     *
     * @param empIsolated 实体对象
     * @return 修改结果
     */
    @PostMapping("/update")
    public int update(@RequestBody EmpIsolated empIsolated) {
        return this.empIsolatedService.updateById(empIsolated)?1:0;
    }

    /**
     * 删除数据
     *
     * @param id 主键id
     * @return 删除结果
     */
    @PostMapping("/delete/{id}")
    public int delete(@PathVariable("id") Long id) {
        return this.empIsolatedService.removeById(id)?1:0;
    }
}