package com.laoma.ordercenter.dao.mapper;

import com.laoma.ordercenter.common.mapper.BaseMapper;
import com.laoma.ordercenter.dao.entity.OrderMaster;
import com.laoma.ordercenter.dto.request.OrderSearchRequest;
import com.laoma.ordercenter.dto.response.OrderSearchResponse;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrderMasterMapper extends BaseMapper<OrderMaster> {

    //查询订单主信息
    @Select("<script>" +
                "SELECT " +
                "   * " +
                "FROM " +
                "   order_master t " +
                "WHERE 1 = 1 " +
                "<if test=\"search.orderId != null and search.orderId != ''\">" +
                "   AND order_id = #{search.orderId} " +
                "</if>" +
                "<if test=\"search.buyerName != null and search.buyerName != ''\">" +
                "   AND buyer_name like concat('%',#{search.buyerName},'%') " +
                "</if>" +
            "</script>"
    )
    List<OrderSearchResponse> selectOrderMaster(OrderSearchRequest search);
}