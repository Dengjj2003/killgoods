package com.zking.killgoods.model;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 商品信息表
 * </p>
 *
 * @author zsy
 * @since 2022-03-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_goods")
public class Goods implements Serializable {


    /**
     * 商品ID
     */
    @TableId(value = "gid", type = IdType.AUTO)
    private Long gid;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 商品标题
     */
    private String goodsTitle;

    /**
     * 商品图片
     */
    private String goodsImg;

    /**
     * 商品详情
     */
    private String goodsDetail;

    /**
     * 商品价格
     */
    private BigDecimal goodsPrice;

    /**
     * 商品库存
     */
    private Integer goodsStock;


}
