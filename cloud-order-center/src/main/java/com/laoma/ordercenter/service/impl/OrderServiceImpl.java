package com.laoma.ordercenter.service.impl;

import com.alibaba.fastjson.JSON;
import com.laoma.ordercenter.dao.entity.OrderMaster;
import com.laoma.ordercenter.dao.mapper.OrderMasterMapper;
import com.laoma.ordercenter.dto.response.OrderSearchResponse;
import com.laoma.ordercenter.dto.response.UserInfoResponse;
import com.laoma.ordercenter.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @program: SpringCloudDemos
 * @description: 订单服务实现类
 * @author: 老马
 * @create: 2021-06-22 14:16
 **/
@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private RestTemplate restTemplate;
    @Resource
    private OrderMasterMapper masterMapper;

    /**
     * @Description: 订单查询
     * @param: request
     * @return: java.util.List<com.laoma.ordercenter.dto.response.OrderSearchResponse>
     * @author: 老马
     * @Date: 2021/6/22 14:16
     */
    @Override
    public OrderSearchResponse orderQuery(String orderId) {
        //获得主信息
        OrderMaster orderMaster = this.masterMapper.selectByPrimaryKey(orderId);
        //转换成返回的DTO对象
        OrderSearchResponse orderResponse = JSON.parseObject(JSON.toJSONString(orderMaster), OrderSearchResponse.class);
        //请求用户中心的信息
        String url = "http://localhost:7000/usercenter/user/{wxId}/info.json";
        UserInfoResponse userInfoResponse = this.restTemplate.getForObject(url, UserInfoResponse.class, orderMaster.getBuyerWxid());
        if(userInfoResponse!=null) {
            orderResponse.setBuyerNickName(userInfoResponse.getWxNickname());
            orderResponse.setAvatarUrl(userInfoResponse.getAvatarUrl());
            orderResponse.setBonus(userInfoResponse.getBonus());
        }
        return orderResponse;
    }
}
