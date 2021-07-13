package com.liu.covid.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liu.covid.dao.EmpDiagnosedMapper;
import com.liu.covid.entity.EmpDiagnosed;
import com.liu.covid.service.EmpDiagnosedService;
import org.springframework.stereotype.Service;

/**
 * 确诊人员(EmpDiagnosed)表服务实现类
 *
 * @author tengjian
 * @since 2021-07-13 21:55:38
 */
@Service("empDiagnosedService")
public class EmpDiagnosedServiceImpl extends ServiceImpl<EmpDiagnosedMapper, EmpDiagnosed> implements EmpDiagnosedService {

}