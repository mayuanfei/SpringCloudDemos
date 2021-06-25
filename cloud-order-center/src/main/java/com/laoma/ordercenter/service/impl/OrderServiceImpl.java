package com.laoma.ordercenter.service.impl;

import com.alibaba.fastjson.JSON;
import com.laoma.ordercenter.dao.entity.OrderMaster;
import com.laoma.ordercenter.dao.mapper.OrderMasterMapper;
import com.laoma.ordercenter.dto.response.OrderSearchResponse;
import com.laoma.ordercenter.dto.response.UserInfoResponse;
import com.laoma.ordercenter.feignclilent.UserCenterFeignClient;
import com.laoma.ordercenter.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @program: SpringCloudDemos
 * @description: 订单服务实现类
 * @author: 老马
 * @create: 2021-06-22 14:16
 **/
@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderMasterMapper masterMapper;
    @Resource
    UserCenterFeignClient userCenterFeignClient;


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
        //采用Feign调用
        UserInfoResponse userInfoResponse = this.userCenterFeignClient.findUserByWxid(orderMaster.getBuyerWxid());
        if(userInfoResponse!=null) {
            orderResponse.setBuyerNickName(userInfoResponse.getWxNickname());
            orderResponse.setAvatarUrl(userInfoResponse.getAvatarUrl());
            orderResponse.setBonus(userInfoResponse.getBonus());
        }
        return orderResponse;
    }

    /**
     * @param orderid
     * @Description: 通过id获得订单主信息
     * @param: orderid
     * @return: com.laoma.ordercenter.dao.entity.OrderMaster
     * @author: 老马
     * @Date: 2021/6/25 9:34
     */
    @Override
    public OrderMaster orderQueryById(String orderid) {
        return this.masterMapper.selectByPrimaryKey(orderid);
    }
}
