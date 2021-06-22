package com.laoma.ordercenter.service;

import com.laoma.ordercenter.dto.response.OrderSearchResponse;

/**
 * @program: SpringCloudDemos
 * @description: 订单服务接口类
 * @author: 老马
 * @create: 2021-06-22 14:15
 **/
public interface OrderService {

    /**
    * @Description: 订单查询
    * @param: request
    * @return: java.util.List<com.laoma.ordercenter.dto.response.OrderSearchResponse>
    * @author: 老马
    * @Date: 2021/6/22 14:16
    */
    OrderSearchResponse orderQuery(String orderId);
}

