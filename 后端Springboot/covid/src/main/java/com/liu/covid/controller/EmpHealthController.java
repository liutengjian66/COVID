package com.liu.covid.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liu.covid.entity.EmpHealth;
import com.liu.covid.service.impl.EmpHealthServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 健康打卡(EmpHealth)表控制层
 *
 * @author tengjian
 * @since 2021-07-13 21:55:38
 */
@RestController
@RequestMapping("/empHealth")
public class EmpHealthController{
    /**
     * 服务对象
     */
    private EmpHealthServiceImpl empHealthService;

    public EmpHealthController (EmpHealthServiceImpl empHealthService){
        this.empHealthService=empHealthService;
    }
    
    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param empHealth 查询实体
     * @return 所有数据
     */
    @PostMapping
    public List<EmpHealth> selectAll(Page<EmpHealth> page, EmpHealth empHealth) {
        return this.empHealthService.page(page, new QueryWrapper<>(empHealth)).getRecords();
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @PostMapping("/get/{id}")
    public EmpHealth selectOne(@PathVariable("id") Long id) {
        return this.empHealthService.getById(id);
    }

    /**
     * 新增数据
     *
     * @param empHealth 实体对象
     * @return 新增结果
     */
    @PostMapping("/insert")
    public int insert(@RequestBody EmpHealth empHealth) {
        return this.empHealthService.save(empHealth)?1:0;
    }

    /**
     * 修改数据
     *
     * @param empHealth 实体对象
     * @return 修改结果
     */
    @PostMapping("/update")
    public int update(@RequestBody EmpHealth empHealth) {
        return this.empHealthService.updateById(empHealth)?1:0;
    }

    /**
     * 删除数据
     *
     * @param id 主键id
     * @return 删除结果
     */
    @PostMapping("/delete/{id}")
    public int delete(@PathVariable("id") Long id) {
        return this.empHealthService.removeById(id)?1:0;
    }
}