package com.haizhang.hai.bussiness.model.entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * @author LiJing
 * @ClassName: Order
 * @Description: 订单实体
 * @date 2019/8/9 15:33
 */
@Data
@Entity
@Table(name = "T_ORDER")
public class Order extends BaseEntity{

    /** 订单编号*/
    private String orderNo;

    /** 订单名称*/
    private String name;

    /** 客户id*/
    private Long customerId;

    /** 产品id*/
    private Long goodsId;

    /** 商品价格*/
    private BigDecimal goodsPrice;

    /** 订单实付金额*/
    private BigDecimal orderAmount;

    /** 订单状态:10:待支付(初始下单)  20:待使用(已支付) 30:已使用(已支付) 100:已取消(未支付)*/
    private Integer status;

    /** 支付类型:微信1,支付宝2*/
    private Integer payType;

    /** 支付状态:0未支付 1 已支付*/
    private Integer payStatus;

    /**支付时间*/
//    private Timestamp payDate;
//
//    /**超时时间*/
//    private Timestamp overDate;
}
