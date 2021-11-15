package com.laoma.ordercenter.service.impl;

import com.alibaba.fastjson.JSON;
import com.laoma.ordercenter.dao.entity.OrderMaster;
import com.laoma.ordercenter.dao.mapper.OrderMasterMapper;
import com.laoma.ordercenter.dto.request.OrderSearchRequest;
import com.laoma.ordercenter.dto.request.UserInfoSearchRequest;
import com.laoma.ordercenter.dto.response.OrderSearchResponse;
import com.laoma.ordercenter.dto.response.UserInfoResponse;
import com.laoma.ordercenter.feignclilent.UserCenterFeignClient;
import com.laoma.ordercenter.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

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
     * @param request
     * @Description: 调用userService的list1.json
     * @param: request
     * @return: com.laoma.ordercenter.dto.response.OrderSearchResponse
     * @author: 老马
     * @Date: 2021/11/12 16:31
     */
    @Override
    public OrderSearchResponse orderQuery1(OrderSearchRequest request) {
        //获得主信息
        OrderMaster orderMaster = this.masterMapper.selectByPrimaryKey(request.getOrderId());
        //转换成返回的DTO对象
        OrderSearchResponse orderResponse = JSON.parseObject(JSON.toJSONString(orderMaster), OrderSearchResponse.class);
        //采用Feign调用
        UserInfoSearchRequest userInfoSearchRequest = UserInfoSearchRequest.builder()
                .id(request.getBuyerId())
                .wxId(request.getBuyerWxId())
                .wxNickname(request.getBuyerWxNickName())
                .build();
        UserInfoResponse userInfoResponse = this.userCenterFeignClient.findUser1(userInfoSearchRequest);
        if(userInfoResponse!=null) {
            orderResponse.setBuyerNickName(userInfoResponse.getWxNickname());
            orderResponse.setAvatarUrl(userInfoResponse.getAvatarUrl());
            orderResponse.setBonus(userInfoResponse.getBonus());
        }
        return orderResponse;
    }

    /**
     * @param request
     * @Description: 调用userService的/{id}/list2.json
     * @param: request
     * @return: com.laoma.ordercenter.dto.response.OrderSearchResponse
     * @author: 老马
     * @Date: 2021/11/12 16:31
     */
    @Override
    public OrderSearchResponse orderQuery2(OrderSearchRequest request) {
        //获得主信息
        OrderMaster orderMaster = this.masterMapper.selectByPrimaryKey(request.getOrderId());
        //转换成返回的DTO对象
        OrderSearchResponse orderResponse = JSON.parseObject(JSON.toJSONString(orderMaster), OrderSearchResponse.class);
        //采用Feign调用
        UserInfoResponse userInfoResponse = this.userCenterFeignClient.findUser2(request.getBuyerWxId(), request.getBuyerId(), request.getBuyerWxNickName());
        if(userInfoResponse!=null) {
            orderResponse.setBuyerNickName(userInfoResponse.getWxNickname());
            orderResponse.setAvatarUrl(userInfoResponse.getAvatarUrl());
            orderResponse.setBonus(userInfoResponse.getBonus());
        }
        return orderResponse;
    }

    /**
     * @param request
     * @Description: 调用userService的/list3.json
     * @param: request
     * @return: com.laoma.ordercenter.dto.response.OrderSearchResponse
     * @author: 老马
     * @Date: 2021/11/12 16:31
     */
    @Override
    public OrderSearchResponse orderQuery3(OrderSearchRequest request) {
        //获得主信息
        OrderMaster orderMaster = this.masterMapper.selectByPrimaryKey(request.getOrderId());
        //转换成返回的DTO对象
        OrderSearchResponse orderResponse = JSON.parseObject(JSON.toJSONString(orderMaster), OrderSearchResponse.class);
        //采用Feign调用
        Map<String, Object> map = new HashMap<>();
        map.put("wxid", request.getBuyerWxId());
        map.put("wxNickname", request.getBuyerWxNickName());
        UserInfoResponse response  = this.userCenterFeignClient.findUser3(map);
        if(response !=null) {
            orderResponse.setBuyerNickName(response.getWxNickname());
            orderResponse.setAvatarUrl(response.getAvatarUrl());
            orderResponse.setBonus(response.getBonus());
        }
        return orderResponse;
    }

    /**
     * @param request
     * @Description: 通过post传参查询
     * @param: request
     * @return: com.laoma.ordercenter.dto.response.OrderSearchResponse
     * @author: 老马
     * @Date: 2021/11/15 11:06
     */
    @Override
    public OrderSearchResponse postQuery1(OrderSearchRequest request) {
        //获得主信息
        OrderMaster orderMaster = this.masterMapper.selectByPrimaryKey(request.getOrderId());
        //转换成返回的DTO对象
        OrderSearchResponse orderResponse = JSON.parseObject(JSON.toJSONString(orderMaster), OrderSearchResponse.class);
        //采用Feign调用
        UserInfoSearchRequest userInfoSearchRequest = UserInfoSearchRequest.builder()
                .id(request.getBuyerId())
                .wxId(request.getBuyerWxId())
                .wxNickname(request.getBuyerWxNickName())
                .build();
        UserInfoResponse userInfoResponse = this.userCenterFeignClient.postFindUser1(userInfoSearchRequest);
        if(userInfoResponse!=null) {
            orderResponse.setBuyerNickName(userInfoResponse.getWxNickname());
            orderResponse.setAvatarUrl(userInfoResponse.getAvatarUrl());
            orderResponse.setBonus(userInfoResponse.getBonus());
        }
        return orderResponse;
    }

    /**
     * @param request
     * @Description: 通过post的Form表单传参
     * @param: request
     * @return: com.laoma.ordercenter.dto.response.OrderSearchResponse
     * @author: 老马
     * @Date: 2021/11/15 11:06
     */
    @Override
    public OrderSearchResponse postQuery2(OrderSearchRequest request) {
        //获得主信息
        OrderMaster orderMaster = this.masterMapper.selectByPrimaryKey(request.getOrderId());
        //转换成返回的DTO对象
        OrderSearchResponse orderResponse = JSON.parseObject(JSON.toJSONString(orderMaster), OrderSearchResponse.class);
        //采用Feign调用
        UserInfoSearchRequest userInfoSearchRequest = UserInfoSearchRequest.builder()
                .id(request.getBuyerId())
                .wxId(request.getBuyerWxId())
                .wxNickname(request.getBuyerWxNickName())
                .build();
        UserInfoResponse userInfoResponse = this.userCenterFeignClient.postFindUser2(userInfoSearchRequest);
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
