package com.liu.covid.controller;

import com.liu.covid.entity.EmpHealth;
import com.liu.covid.entity.User;
import com.liu.covid.mapper.EmpMapper;
import com.liu.covid.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.DigestUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


@SpringBootTest
class LoginServiceTest {
    @Autowired
private UserMapper mapper;
    @Test
    void register(){
        User user=new User();
        String pw=DigestUtils.md5DigestAsHex("99409".getBytes());
        user.setUsername("994091246");
        user.setPassword(pw);
        int message= mapper.insert(user);
        System.out.println(message);
    }
}