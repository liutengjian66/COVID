package com.liu.covid.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liu.covid.dao.DepartmentDao;
import com.liu.covid.entity.Department;
import com.liu.covid.service.DepartmentService;
import org.springframework.stereotype.Service;

/**
 * 部门(department)表服务实现类
 *
 * @author Tengjian
 * @since 2021/07/08
 */
@Service("departmentService")
public class DepartmentServiceImpl extends ServiceImpl<DepartmentDao, Department> implements DepartmentService {

}
