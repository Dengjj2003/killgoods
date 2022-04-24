package com.zking.killgoods.service;

import com.zking.killgoods.model.SeckillOrder;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zking.killgoods.model.User;
import com.zking.killgoods.vo.SeckillGoodsVo;

/**
 * <p>
 * 秒杀订单信息表 服务类
 * </p>
 *
 * @author zsy
 * @since 2022-03-07
 */
public interface ISeckillOrderService extends IService<SeckillOrder> {

    void addOrder(User user, SeckillGoodsVo seckillGoodsVo);
}
