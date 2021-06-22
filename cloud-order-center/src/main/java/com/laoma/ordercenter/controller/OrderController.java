package com.laoma.ordercenter.controller;

import com.laoma.ordercenter.dto.response.OrderSearchResponse;
import com.laoma.ordercenter.service.OrderService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @program: SpringCloudDemos
 * @description: 订单处理
 * @author: 老马
 * @create: 2021-06-16 09:08
 **/
@RestController
@RequestMapping("/order")
public class OrderController {

    @Resource
    private OrderService orderService;

    @RequestMapping("/{id}/info.json")
    public OrderSearchResponse orderQuery(@PathVariable("id") String orderId) throws Exception {
        return this.orderService.orderQuery(orderId);
    }
}
