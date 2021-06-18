package com.laoma.provider.common.mapper;

import tk.mybatis.mapper.additional.insert.InsertListMapper;

/**
 * @program: upcashier
 * @description: 用于手动设置的id的表
 * @author: 老马
 * @create: 2021-03-01 10:43
 **/
public interface BaseHandIdMapper<T> extends BaseMapper<T>, InsertListMapper<T> {
}

