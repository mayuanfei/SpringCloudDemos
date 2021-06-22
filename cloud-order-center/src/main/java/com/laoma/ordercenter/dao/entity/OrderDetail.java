package com.laoma.ordercenter.dao.entity;

import com.laoma.ordercenter.common.entity.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Table(name = "order_detail")
public class OrderDetail extends BaseEntity {
    @Id
    @Column(name = "detail_id")
    private Integer detailId;

    /**
     * 订单号
     */
    @Column(name = "order_id")
    private String orderId;

    /**
     * 产品id
     */
    @Column(name = "product_id")
    private String productId;

    /**
     * 商品名称
     */
    @Column(name = "product_name")
    private String productName;

    /**
     * 当前价格,单位分
     */
    @Column(name = "product_price")
    private BigDecimal productPrice;

    /**
     * 数量
     */
    @Column(name = "product_quantity")
    private Integer productQuantity;

    /**
     * 小图
     */
    @Column(name = "product_icon")
    private String productIcon;

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