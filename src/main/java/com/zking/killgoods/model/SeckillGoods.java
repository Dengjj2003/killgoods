package com.zking.killgoods.model;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>
 * 秒杀商品信息表
 * </p>
 *
 * @author zsy
 * @since 2022-03-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_seckill_goods")
public class SeckillGoods implements Serializable {

    private Long id;

    /**
     * 商品ID
     */
    private Long goodsId;

    /**
     * 秒杀价
     */
    private BigDecimal seckillPrice;

    /**
     * 存库数量
     */
    private Integer stockCount;

    /**
     * 秒杀开始时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startDate;

    /**
     * 秒杀结束时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endDate;


}
