package com.liu.covid.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liu.covid.entity.MaterialManage;
import com.liu.covid.service.impl.MaterialManageServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 防疫物资管理(MaterialManage)表控制层
 *
 * @author tengjian
 * @since 2021-07-13 21:55:38
 */
@RestController
@RequestMapping("/materialManage")
public class MaterialManageController{
    /**
     * 服务对象
     */
    private MaterialManageServiceImpl materialManageService;

    public MaterialManageController (MaterialManageServiceImpl materialManageService){
        this.materialManageService=materialManageService;
    }
    
    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param materialManage 查询实体
     * @return 所有数据
     */
    @PostMapping
    public List<MaterialManage> selectAll(Page<MaterialManage> page, MaterialManage materialManage) {
        return this.materialManageService.page(page, new QueryWrapper<>(materialManage)).getRecords();
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @PostMapping("/get/{id}")
    public MaterialManage selectOne(@PathVariable("id") Long id) {
        return this.materialManageService.getById(id);
    }

    /**
     * 新增数据
     *
     * @param materialManage 实体对象
     * @return 新增结果
     */
    @PostMapping("/insert")
    public int insert(@RequestBody MaterialManage materialManage) {
        return this.materialManageService.save(materialManage)?1:0;
    }

    /**
     * 修改数据
     *
     * @param materialManage 实体对象
     * @return 修改结果
     */
    @PostMapping("/update")
    public int update(@RequestBody MaterialManage materialManage) {
        return this.materialManageService.updateById(materialManage)?1:0;
    }

    /**
     * 删除数据
     *
     * @param id 主键id
     * @return 删除结果
     */
    @PostMapping("/delete/{id}")
    public int delete(@PathVariable("id") Long id) {
        return this.materialManageService.removeById(id)?1:0;
    }
}