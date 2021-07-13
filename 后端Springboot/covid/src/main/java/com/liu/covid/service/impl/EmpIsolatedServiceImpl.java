package com.liu.covid.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liu.covid.dao.EmpIsolatedMapper;
import com.liu.covid.entity.EmpIsolated;
import com.liu.covid.service.EmpIsolatedService;
import org.springframework.stereotype.Service;

/**
 * 隔离人员(EmpIsolated)表服务实现类
 *
 * @author tengjian
 * @since 2021-07-13 21:55:38
 */
@Service("empIsolatedService")
public class EmpIsolatedServiceImpl extends ServiceImpl<EmpIsolatedMapper, EmpIsolated> implements EmpIsolatedService {

}