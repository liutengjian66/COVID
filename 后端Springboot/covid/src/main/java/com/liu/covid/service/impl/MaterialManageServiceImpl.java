package com.liu.covid.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liu.covid.dao.MaterialManageMapper;
import com.liu.covid.entity.MaterialManage;
import com.liu.covid.service.MaterialManageService;
import org.springframework.stereotype.Service;

/**
 * 防疫物资管理(MaterialManage)表服务实现类
 *
 * @author tengjian
 * @since 2021-07-13 21:55:38
 */
@Service("materialManageService")
public class MaterialManageServiceImpl extends ServiceImpl<MaterialManageMapper, MaterialManage> implements MaterialManageService {

}