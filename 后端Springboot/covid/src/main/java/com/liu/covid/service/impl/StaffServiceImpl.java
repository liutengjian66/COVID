package com.liu.covid.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liu.covid.dao.StaffMapper;
import com.liu.covid.entity.Staff;
import com.liu.covid.service.StaffService;
import org.springframework.stereotype.Service;

/**
 * 人员管理(Staff)表服务实现类
 *
 * @author tengjian
 * @since 2021-07-13 21:43:18
 */
@Service("staffService")
public class StaffServiceImpl extends ServiceImpl<StaffMapper, Staff> implements StaffService {

}