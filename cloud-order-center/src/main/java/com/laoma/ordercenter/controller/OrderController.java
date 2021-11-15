package com.laoma.ordercenter.controller;

import com.laoma.ordercenter.common.CommonResponse;
import com.laoma.ordercenter.dao.entity.OrderMaster;
import com.laoma.ordercenter.dto.request.OrderSearchRequest;
import com.laoma.ordercenter.dto.response.OrderSearchResponse;
import com.laoma.ordercenter.service.OrderService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @program: SpringCloudDemos
 * @description: 订单处理
 * @author: 老马
 * @create: 2021-06-16 09:08
 **/
@RefreshScope
@RestController
@RequestMapping("/order")
public class OrderController {

    @Value("${ipwhitelist}")
    private String ipwhitelist;

    @Value("${spring.datasource.password}")
    private String dbpwd;

    @Resource
    private OrderService orderService;

    @RequestMapping("/{id}/info.json")
    public OrderSearchResponse orderQuery(@PathVariable("id") String orderId) throws Exception {
        return this.orderService.orderQuery(orderId);
    }

    @RequestMapping("/info1.json")
    public OrderSearchResponse orderQuery1(OrderSearchRequest request) throws Exception {
        return this.orderService.orderQuery1(request);
    }

    @RequestMapping("/{id}/info2.json")
    public OrderSearchResponse orderQuery2(@PathVariable("id") String orderId, OrderSearchRequest request) throws Exception {
        request.setOrderId(orderId);
        return this.orderService.orderQuery2(request);
    }

    @RequestMapping("/info3.json")
    public OrderSearchResponse orderQuery3(OrderSearchRequest request) throws Exception {
        return this.orderService.orderQuery3(request);
    }

    @PostMapping("/postinfo1.json")
    public OrderSearchResponse postOrderQuery1(@RequestBody OrderSearchRequest request) throws Exception {
        return this.orderService.postQuery1(request);
    }

    @PostMapping("/postinfo2.json")
    public OrderSearchResponse postOrderQuery2(OrderSearchRequest request) throws Exception {
        return this.orderService.postQuery2(request);
    }


    //测试数据库密码更改是否生效
    @RequestMapping("/{id}/dbchangpwd.json")
    public CommonResponse dbchangpwd(@PathVariable("id") String orderId) {
        OrderMaster orderMaster = this.orderService.orderQueryById(orderId);
        return CommonResponse.buildSuccessCommonResponseWithData(orderMaster);
    }

    //测试属性变化
    @RequestMapping("/ipwl.json")
    public String getIpwhitelist() {
        return this.ipwhitelist;
    }


}
