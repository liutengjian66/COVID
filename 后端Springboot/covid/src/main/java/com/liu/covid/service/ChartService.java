package com.liu.covid.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.liu.covid.entity.EmpIden;
import com.liu.covid.vo.LineVO;
import com.liu.covid.vo.PieVo;

import java.util.List;
import java.util.Map;

public interface ChartService extends IService<EmpIden> {
    public LineVO lineVOList();
    public List<PieVo> pieVOMap();
}
