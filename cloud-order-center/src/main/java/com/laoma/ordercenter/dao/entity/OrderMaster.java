package com.laoma.ordercenter.dao.entity;

import com.laoma.ordercenter.common.entity.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Table(name = "order_master")
public class OrderMaster extends BaseEntity {
    /**
     * 订单号
     */
    @Id
    @Column(name = "order_id")
    private String orderId;

    /**
     * 买家名字
     */
    @Column(name = "buyer_name")
    private String buyerName;

    /**
     * 买家电话
     */
    @Column(name = "buyer_phone")
    private String buyerPhone;

    /**
     * 买家地址
     */
    @Column(name = "buyer_address")
    private String buyerAddress;

    /**
     * 买家微信id

     */
    @Column(name = "buyer_wxid")
    private String buyerWxid;

    /**
     * 订单总金额
     */
    @Column(name = "order_amount")
    private BigDecimal orderAmount;

    /**
     * 订单状态, 默认为新下单
     */
    @Column(name = "order_status")
    private Byte orderStatus;

    /**
     * 支付状态, 默认未支付
     */
    @Column(name = "pay_status")
    private Byte payStatus;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @Column(name = "update_time")
    private Date updateTime;
}