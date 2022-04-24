package com.zking.killgoods.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zking.killgoods.exception.BusinessException;
import com.zking.killgoods.model.Order;
import com.zking.killgoods.model.SeckillOrder;
import com.zking.killgoods.model.User;
import com.zking.killgoods.service.IOrderService;
import com.zking.killgoods.service.ISeckillGoodsService;
import com.zking.killgoods.service.ISeckillOrderService;
import com.zking.killgoods.util.JsonResponseBody;
import com.zking.killgoods.util.JsonResponseStatus;
import com.zking.killgoods.vo.SeckillGoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 秒杀订单信息表 前端控制器
 * </p>
 *
 * @author zsy
 * @since 2022-03-07
 */
@RestController
@RequestMapping("/seckillOrder")
public class SeckillOrderController {
    @Autowired
    private ISeckillGoodsService seckillGoodsService;
    @Autowired
    private ISeckillOrderService seckillOrderService;
    @Autowired
    private IOrderService orderService;


    @RequestMapping("/addOrder")
    public JsonResponseBody<?> addOrder(User user,Long id){
        //判断用户是否登录
        //判断被秒杀商品库存是否足够
        SeckillGoodsVo seckillGoodsVo = seckillGoodsService.querySeckillGoodsById(id);
        if(seckillGoodsVo.getStockCount()<1)
            throw new BusinessException(JsonResponseStatus.SECKILL_GOODS_COUNT_ERROR);

        //根据用户ID和商品ID判断是否重复秒杀商品
        Order one = orderService.getOne(new QueryWrapper<Order>()
                .eq("user_id", user.getId())
                .eq("goods_id", seckillGoodsVo.getGoodsId()));
        if(null!=one)
            throw new BusinessException(JsonResponseStatus.SECKILL_ORDER_REPEAT);
        seckillOrderService.addOrder(user,seckillGoodsVo);
        return new JsonResponseBody<>();
    }
}
