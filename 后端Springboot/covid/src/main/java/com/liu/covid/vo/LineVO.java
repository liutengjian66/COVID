package com.liu.covid.vo;

import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class LineVO {
    private List<String> month;
    private Map<String,List> status;
}
