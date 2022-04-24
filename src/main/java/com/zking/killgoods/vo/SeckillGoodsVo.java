package com.zking.killgoods.vo;

import com.zking.killgoods.model.Goods;
import com.zking.killgoods.model.SeckillGoods;
import lombok.Data;

import java.util.List;

@Data
public class SeckillGoodsVo extends SeckillGoods {

    private String goodsName;
    private List<Goods> goods;
}
