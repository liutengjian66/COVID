package com.liu.covid.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liu.covid.entity.EmpIden;
import com.liu.covid.entity.User;
import com.liu.covid.mapper.EmpIdenMapper;
import com.liu.covid.mapper.UserMapper;
import com.liu.covid.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    UserMapper mapper;
    @Override
    public String login(User user) {
        QueryWrapper<User> userQueryWrapper = Wrappers.query();
        userQueryWrapper.like("username", user.getUsername());
        List<User> list = mapper.selectList(userQueryWrapper);
        if (list.size()!=0){
            String password= DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
            if (list.get(0).getPassword().equals(password)){
                return "success";
            }else return "error";
        }else return "error";
    }

    @Override
    public String register(User user) {
        if (user!=null){
            boolean flag=true;
            for (User list:mapper.selectList(null)){
                if (list.getUsername().equals(user.getUsername()))
                    flag=false;
            }
            if (flag){
                String pw=DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
                user.setPassword(pw);
            int index=mapper.insert(user);
            if (index==1){return "success";}else return "error";
            }else return "repeat";
        }else return "error";
    }
}
