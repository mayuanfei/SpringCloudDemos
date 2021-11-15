package com.laoma.ordercenter.service;

import com.laoma.ordercenter.dao.entity.OrderMaster;
import com.laoma.ordercenter.dto.request.OrderSearchRequest;
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

    /**
    * @Description: 调用userService的list1.json
    * @param: request
    * @return: com.laoma.ordercenter.dto.response.OrderSearchResponse
    * @author: 老马
    * @Date: 2021/11/12 16:31
    */
    OrderSearchResponse orderQuery1(OrderSearchRequest request);

    /**
     * @Description: 调用userService的/{id}/list2.json
     * @param: request
     * @return: com.laoma.ordercenter.dto.response.OrderSearchResponse
     * @author: 老马
     * @Date: 2021/11/12 16:31
     */
    OrderSearchResponse orderQuery2(OrderSearchRequest request);

    /**
     * @Description: 调用userService的/list3.json
     * @param: request
     * @return: com.laoma.ordercenter.dto.response.OrderSearchResponse
     * @author: 老马
     * @Date: 2021/11/12 16:31
     */
    OrderSearchResponse orderQuery3(OrderSearchRequest request);

    /**
    * @Description: 通过id获得订单主信息
    * @param: orderid
    * @return: com.laoma.ordercenter.dao.entity.OrderMaster
    * @author: 老马
    * @Date: 2021/6/25 9:34
    */
    OrderMaster orderQueryById(String orderid);

    /**
    * @Description: 通过post传参查询
    * @param: request
    * @return: com.laoma.ordercenter.dto.response.OrderSearchResponse
    * @author: 老马
    * @Date: 2021/11/15 11:06
    */
    OrderSearchResponse postQuery1(OrderSearchRequest request);

    /**
     * @Description: 通过post的Form表单传参
     * @param: request
     * @return: com.laoma.ordercenter.dto.response.OrderSearchResponse
     * @author: 老马
     * @Date: 2021/11/15 11:06
     */
    OrderSearchResponse postQuery2(OrderSearchRequest request);
}

