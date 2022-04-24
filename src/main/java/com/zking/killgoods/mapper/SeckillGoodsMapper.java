package com.zking.killgoods.mapper;

import com.zking.killgoods.model.SeckillGoods;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zking.killgoods.vo.SeckillGoodsVo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 秒杀商品信息表 Mapper 接口
 * </p>
 *
 * @author zsy
 * @since 2022-03-07
 */
@Repository
public interface SeckillGoodsMapper extends BaseMapper<SeckillGoods> {

    List<SeckillGoodsVo> querySeckillGoods(SeckillGoodsVo seckillGoodsVo);

    int addSeckillGoods(SeckillGoodsVo seckillGoodsVo);

    Map<String,Object> querySingleSeckillGoodsById(Long id);

    SeckillGoodsVo querySeckillGoodsById(Long id);


}
