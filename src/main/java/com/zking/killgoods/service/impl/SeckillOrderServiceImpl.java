package com.zking.killgoods.service.impl;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.zking.killgoods.mapper.OrderMapper;
import com.zking.killgoods.model.Order;
import com.zking.killgoods.model.SeckillGoods;
import com.zking.killgoods.model.SeckillOrder;
import com.zking.killgoods.mapper.SeckillOrderMapper;
import com.zking.killgoods.model.User;
import com.zking.killgoods.service.IOrderService;
import com.zking.killgoods.service.ISeckillGoodsService;
import com.zking.killgoods.service.ISeckillOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zking.killgoods.util.SnowFlake;
import com.zking.killgoods.vo.SeckillGoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 秒杀订单信息表 服务实现类
 * </p>
 *
 * @author zsy
 * @since 2022-03-07
 */
@Service
public class SeckillOrderServiceImpl extends ServiceImpl<SeckillOrderMapper, SeckillOrder> implements ISeckillOrderService {

    @Autowired
    private ISeckillGoodsService seckillGoodsService;
    @Autowired
    private IOrderService orderService;
    @Override
    public void addOrder(User user, SeckillGoodsVo seckillGoodsVo) {
//       实现秒杀商品库存-1
        //update t_seckill_goods set stock_count=stock_count-1 where goods_id=1 and stock_count>0
        seckillGoodsService.update(new UpdateWrapper<SeckillGoods>()
                .setSql("stock_count=stock_count-1")
                .eq("id", seckillGoodsVo.getId())
                .gt("stock_count",0));
//        新增订单(生成雪花ID)
        SnowFlake sf=new SnowFlake(2,3);
        Order order=new Order();
        order.setOid(sf.nextId());
        order.setUserId(user.getId());
        order.setGoodsId(seckillGoodsVo.getGoodsId());
        order.setGoodsName(seckillGoodsVo.getGoodsName());
        order.setGoodsCount(seckillGoodsVo.getStockCount());
        order.setGoodsPrice(seckillGoodsVo.getSeckillPrice());
        orderService.save(order);
    }
}
