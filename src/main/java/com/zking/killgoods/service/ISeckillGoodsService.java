package com.zking.killgoods.service;

import com.zking.killgoods.model.SeckillGoods;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zking.killgoods.util.JsonResponseBody;
import com.zking.killgoods.vo.SeckillGoodsVo;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 秒杀商品信息表 服务类
 * </p>
 *
 * @author zsy
 * @since 2022-03-07
 */
public interface ISeckillGoodsService extends IService<SeckillGoods> {

    JsonResponseBody<List<SeckillGoodsVo>> querySeckillGoods(SeckillGoodsVo seckillGoodsVo);


    JsonResponseBody<?> addSeckillGoods(SeckillGoodsVo seckillGoodsVo);

    Map<String,Object> querySingleSeckillGoodsById(Long id);

    SeckillGoodsVo querySeckillGoodsById(Long id);

}
