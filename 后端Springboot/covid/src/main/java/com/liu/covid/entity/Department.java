package com.liu.covid.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Department {
    @TableId
    private Integer id;
    private String name;
    private String charge;

}
