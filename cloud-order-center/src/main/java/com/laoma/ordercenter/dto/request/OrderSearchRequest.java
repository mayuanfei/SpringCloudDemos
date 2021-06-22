package com.laoma.ordercenter.dto.request;

import lombok.Data;

/**
 * @program: SpringCloudDemos
 * @description: 订单查询请求
 * @author: 老马
 * @create: 2021-06-22 14:03
 **/
@Data
public class OrderSearchRequest {
    //通过订单号
    String orderId;

    //买家姓名
    String buyerName;
}
