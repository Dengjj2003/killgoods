package com.zking.killgoods.service.impl;

import com.zking.killgoods.model.Order;
import com.zking.killgoods.mapper.OrderMapper;
import com.zking.killgoods.service.IOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单信息表 服务实现类
 * </p>
 *
 * @author zsy
 * @since 2022-03-07
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {

}
