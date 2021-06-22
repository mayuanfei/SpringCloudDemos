package com.laoma.ordercenter.common.mapper;

import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @program: upcashier
 * @description: 用于自增id的表
 * @author: 老马
 * @create: 2021-03-01 10:42
 **/
public interface BaseAutoIdMapper<T> extends BaseMapper<T>, MySqlMapper<T> {
}

