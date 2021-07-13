package com.liu.covid.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liu.covid.dao.EmpHealthMapper;
import com.liu.covid.entity.EmpHealth;
import com.liu.covid.service.EmpHealthService;
import org.springframework.stereotype.Service;

/**
 * 健康打卡(EmpHealth)表服务实现类
 *
 * @author tengjian
 * @since 2021-07-13 21:55:38
 */
@Service("empHealthService")
public class EmpHealthServiceImpl extends ServiceImpl<EmpHealthMapper, EmpHealth> implements EmpHealthService {

}