package com.laoma.ordercenter.dto.response;

import lombok.Data;

/**
 * @program: SpringCloudDemos
 * @description: 订单查询返回
 * @author: 老马
 * @create: 2021-06-22 14:03
 **/
@Data
public class OrderSearchResponse {
    //订单号
    private String orderId;

    //买家名字
    private String buyerName;

     //买家电话
    private String buyerPhone;

    //买家地址
    private String buyerAddress;

    // 买家昵称
    private String buyerNickName;

    //买家积分
    private Integer bonus;

    //买家头像
    private String avatarUrl;

}
