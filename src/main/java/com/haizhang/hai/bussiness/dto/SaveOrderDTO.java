package com.haizhang.hai.bussiness.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @author admin_z by 2020/7/2
 * @ClassName SaveOrderDTO
 */
@Data
public class SaveOrderDTO {

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
    private Timestamp payDate;

    /**超时时间*/
    private Timestamp overDate;
}
