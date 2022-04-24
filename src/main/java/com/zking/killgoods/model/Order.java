package com.zking.killgoods.model;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 订单信息表
 * </p>
 *
 * @author zsy
 * @since 2022-03-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_order")
public class Order implements Serializable {


    /**
     * 订单ID
     */
    @TableId(value = "oid", type = IdType.AUTO)
    private Long oid;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 商品ID
     */
    private Long goodsId;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 商品数量
     */
    private Integer goodsCount;

    /**
     * 商品单价
     */
    private BigDecimal goodsPrice;

    /**
     * 1=pc,2=android,3=ios
     */
    private Integer orderChannel;

    /**
     * 订单状态,0=创建未支付,1=已支付,2=已取消,3=已发货,4=已退款,5=已完成
     */
    private Integer status;

    /**
     * 订单创建时间
     */
    private Date createDate;

    /**
     * 支付时间
     */
    private Date payDate;


}
