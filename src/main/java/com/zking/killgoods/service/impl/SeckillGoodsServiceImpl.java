package com.zking.killgoods.service.impl;

import com.zking.killgoods.exception.BusinessException;
import com.zking.killgoods.model.SeckillGoods;
import com.zking.killgoods.mapper.SeckillGoodsMapper;
import com.zking.killgoods.service.ISeckillGoodsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zking.killgoods.util.JsonResponseBody;
import com.zking.killgoods.util.JsonResponseStatus;
import com.zking.killgoods.vo.SeckillGoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 秒杀商品信息表 服务实现类
 * </p>
 *
 * @author zsy
 * @since 2022-03-07
 */
@Service
public class SeckillGoodsServiceImpl extends ServiceImpl<SeckillGoodsMapper, SeckillGoods> implements ISeckillGoodsService {

    @Autowired
    private SeckillGoodsMapper seckillGoodsMapper;
    @Override
    public JsonResponseBody<List<SeckillGoodsVo>> querySeckillGoods(SeckillGoodsVo seckillGoodsVo) {
        return new JsonResponseBody<List<SeckillGoodsVo>>(seckillGoodsMapper.querySeckillGoods(seckillGoodsVo),0);
    }

    @Override
    public JsonResponseBody<?> addSeckillGoods(SeckillGoodsVo seckillGoodsVo) {
        int n = seckillGoodsMapper.addSeckillGoods(seckillGoodsVo);
        if(n<1)
            throw new BusinessException(JsonResponseStatus.SECKILL_GOODS_ADD_ERROR);
        return new JsonResponseBody<>();
    }

    @Override
    public Map<String, Object> querySingleSeckillGoodsById(Long id) {

        return seckillGoodsMapper.querySingleSeckillGoodsById(id);
    }

    @Override
    public SeckillGoodsVo querySeckillGoodsById(Long id)
    {
        return seckillGoodsMapper.querySeckillGoodsById(id);
    }
}
