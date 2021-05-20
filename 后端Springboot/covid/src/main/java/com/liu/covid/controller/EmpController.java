package com.liu.covid.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liu.covid.entity.EmpHealth;
import com.liu.covid.mapper.EmpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmpController {
    @Autowired
    private EmpMapper mapper;

    //分页查询
    @GetMapping("/findAll/{page}/{size}")
    public Page<EmpHealth> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        QueryWrapper<EmpHealth> wrapper=new QueryWrapper<>();
        wrapper.orderByDesc("createTime");
        Page<EmpHealth> page1= new Page<>(page,size);
        Page<EmpHealth> result=mapper.selectPage(page1,wrapper).addOrder();
        return result;
    }


    @PostMapping("/save")
    public String save(@RequestBody EmpHealth emp){
        int result = mapper.insert(emp);
        if (result==1){
            return "success";
        }else {
            return "error";
        }
    }

    @GetMapping("/findById/{id}")
    public EmpHealth findById(@PathVariable("id") Integer id){
        return mapper.selectById(id);
    }

    @PutMapping("/update")
    public String update(@RequestBody EmpHealth emp){
        int result=mapper.updateById(emp);
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
    public List<EmpHealth> search(@PathVariable("searchkey")String searchkey, @PathVariable("stext")String stext){
        QueryWrapper<EmpHealth> userQueryWrapper = Wrappers.query();
        userQueryWrapper.like(searchkey,stext);
        return mapper.selectList(userQueryWrapper);
    }
}
