package com.liu.covid.controller;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.Serializable;
import java.util.List;

/**
 * @description:
 * @author: Liu
 * @time: 2021/7/12
 */
public abstract class BaseController<PK extends Serializable,T,S extends ServiceImpl<BaseMapper<T>, T>> {
/*
    public BaseController() {
    }

    public T get(@PathVariable("id") PK id) {
        T one = S.getOne(id);
        return one;

    }

    public ResponseData<Integer> insert(@RequestBody T t) {
        return this.ok(this.getService().insert(t));
    }

    public ResponseData<Integer> update(@RequestBody T t) {
        return this.ok(this.getService().update(t));
    }

    public ResponseData<Integer> delete(@PathVariable("id") PK id) {
        return this.isLogicalDelete() ? this.ok(this.getService().disable(List.of(id))) : this.ok(this.getService().delete(List.of(id)));
    }

    public ResponseData<Object> deleteBatches(BO bo) {
        Object result = this.getService().deleteBatches(bo);
        if (result instanceof RowCellErrors) {
            throw ((RowCellErrors)result).toMultiErrorException();
        } else {
            return this.ok(result);
        }
    }*/
}
