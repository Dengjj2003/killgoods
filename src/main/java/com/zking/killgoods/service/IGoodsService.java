package com.zking.killgoods.service;

import com.zking.killgoods.model.Goods;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zking.killgoods.util.JsonResponseBody;
import com.zking.killgoods.util.PageBean;

import java.util.List;

/**
 * <p>
 * 商品信息表 服务类
 * </p>
 *
 * @author zsy
 * @since 2022-03-07
 */
public interface IGoodsService extends IService<Goods> {

    JsonResponseBody<List<Goods>> queryGoodsPage(Goods goods, PageBean pageBean);
}
