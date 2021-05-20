package com.liu.covid.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.liu.covid.entity.EmpIden;
import com.liu.covid.entity.EmpIs;

import com.liu.covid.mapper.EmpIdenMapper;
import com.liu.covid.mapper.EmpIsMapper;
import com.liu.covid.vo.LineVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Wrapper;
import java.text.SimpleDateFormat;
import java.util.*;


@SpringBootTest
class MaterialControllerTest {
    @Autowired
    private EmpIdenMapper mapper;

    @Test
    void find() {
        LineVO lineVO=new LineVO();
        Date date=new Date();
        Calendar cal = Calendar.getInstance();
        List<String> month=new ArrayList<>();
        Map<String,Integer> status=new HashMap<>();
        Map<String,Map> all=new HashMap<>();
        String type[]={"确诊","疑似","治愈","死亡"};

        for (int i=0;i<7;i++) {
            cal.setTime(date);
            cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) - i);
            SimpleDateFormat ft=new SimpleDateFormat("yyyy-MM");
            String mon=ft.format(cal.getTime());
            month.add(mon);
        }
        //设置折线图月份
        lineVO.setMonth(month);
        //  设置 类型-数量 键值对
        for (String t : type) {
        int j=0;
        while (j<7){
            QueryWrapper<EmpIden> userQueryWrapper = Wrappers.query();
            userQueryWrapper.like("status", t).likeRight("idate", month.get(j));
            Integer count = mapper.selectCount(userQueryWrapper);
            status.put(month.get(j++),count);
            userQueryWrapper.clear();
        }
        all.put(t,status);

    }
        System.out.println(all.toString());
    }

}