package com.laoma.ordercenter.dao.mapper;

import com.laoma.ordercenter.common.mapper.BaseMapper;
import com.laoma.ordercenter.dao.entity.OrderMaster;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface OrderMasterMapper extends BaseMapper<OrderMaster> {
}