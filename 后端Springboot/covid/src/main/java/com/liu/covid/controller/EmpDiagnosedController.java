package com.liu.covid.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liu.covid.entity.EmpDiagnosed;
import com.liu.covid.service.impl.EmpDiagnosedServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 确诊人员(EmpDiagnosed)表控制层
 *
 * @author tengjian
 * @since 2021-07-13 21:55:38
 */
@RestController
@RequestMapping("/empDiagnosed")
public class EmpDiagnosedController{
    /**
     * 服务对象
     */
    private EmpDiagnosedServiceImpl empDiagnosedService;

    public EmpDiagnosedController (EmpDiagnosedServiceImpl empDiagnosedService){
        this.empDiagnosedService=empDiagnosedService;
    }
    
    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param empDiagnosed 查询实体
     * @return 所有数据
     */
    @PostMapping
    public List<EmpDiagnosed> selectAll(Page<EmpDiagnosed> page, EmpDiagnosed empDiagnosed) {
        return this.empDiagnosedService.page(page, new QueryWrapper<>(empDiagnosed)).getRecords();
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @PostMapping("/get/{id}")
    public EmpDiagnosed selectOne(@PathVariable("id") Long id) {
        return this.empDiagnosedService.getById(id);
    }

    /**
     * 新增数据
     *
     * @param empDiagnosed 实体对象
     * @return 新增结果
     */
    @PostMapping("/insert")
    public int insert(@RequestBody EmpDiagnosed empDiagnosed) {
        return this.empDiagnosedService.save(empDiagnosed)?1:0;
    }

    /**
     * 修改数据
     *
     * @param empDiagnosed 实体对象
     * @return 修改结果
     */
    @PostMapping("/update")
    public int update(@RequestBody EmpDiagnosed empDiagnosed) {
        return this.empDiagnosedService.updateById(empDiagnosed)?1:0;
    }

    /**
     * 删除数据
     *
     * @param id 主键id
     * @return 删除结果
     */
    @PostMapping("/delete/{id}")
    public int delete(@PathVariable("id") Long id) {
        return this.empDiagnosedService.removeById(id)?1:0;
    }
}