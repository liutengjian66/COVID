package com.liu.covid.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liu.covid.dao.DepartmentMapper;
import com.liu.covid.entity.Department;
import com.liu.covid.entity.ResponseCode;
import com.liu.covid.service.DepartmentService;
import net.xuanyutech.framework.exception.ApplicationException;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.validation.constraints.NotEmpty;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * 部门(Department)表服务实现类
 *
 * @author tengjian
 * @since 2021-07-12 15:54:22
 */
@Service("departmentService")
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements DepartmentService {

    @Override
    public boolean save(Department department) {
        checkExist(department);
        return super.save(department);
    }

    private void checkExist(Department department){
        if (Objects.nonNull(department)){
            String code = department.getCode();
            if (!StringUtils.isEmpty(code)){
                LambdaQueryWrapper lambdaQueryWrapper= Wrappers.<Department>lambdaQuery()
                        .eq(Department::getCode,code);
                List<Department> list = this.list(lambdaQueryWrapper);
                if (CollectionUtils.isNotEmpty(list)){
                    throw ResponseCode.ALREADY_EXIST.exception("部门编号");
                }
            }
        }
    }
}