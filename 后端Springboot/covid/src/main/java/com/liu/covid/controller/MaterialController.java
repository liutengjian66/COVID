package com.liu.covid.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liu.covid.entity.EmpIs;
import com.liu.covid.entity.MaterialManage;
import com.liu.covid.mapper.MaterialMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Material")
public class MaterialController {

    @Autowired
    private MaterialMapper mapper;

    //分页查询
    @GetMapping("/findAll/{page}/{size}")
    public Page<MaterialManage> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        Page<MaterialManage> page1= new Page<>(page,size);
        Page<MaterialManage> result=mapper.selectPage(page1,null);
        return result;
    }

    @PostMapping("/save")
    public String save(@RequestBody MaterialManage material){
        int result = mapper.insert(material);
        if (result==1){
            return "success";
        }else {
            return "error";
        }
    }

    @GetMapping("/findById/{id}")
    public MaterialManage findById(@PathVariable("id") Integer id){
        return mapper.selectById(id);
    }

    @PutMapping("/update")
    public String update(@RequestBody MaterialManage material){
        int result=mapper.updateById(material);
        if (result==1){
            return "success";
        }else {
            return "error";
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id")Long id){
        mapper.deleteById(id+"L");
    }

    @GetMapping("/search/{searchkey}/{stext}")
    public List<MaterialManage> search(@PathVariable("searchkey")String searchkey, @PathVariable("stext")String stext){
        QueryWrapper<MaterialManage> userQueryWrapper = Wrappers.query();
        userQueryWrapper.like(searchkey,stext);
        return mapper.selectList(userQueryWrapper);
    }
}
