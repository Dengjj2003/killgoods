package com.zking.killgoods.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zking.killgoods.model.Goods;
import com.zking.killgoods.mapper.GoodsMapper;
import com.zking.killgoods.service.IGoodsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zking.killgoods.util.JsonResponseBody;
import com.zking.killgoods.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 商品信息表 服务实现类
 * </p>
 *
 * @author zsy
 * @since 2022-03-07
 */
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements IGoodsService {

    @Autowired
    private GoodsMapper goodsMapper;
    @Override
    public JsonResponseBody<List<Goods>> queryGoodsPage(Goods goods, PageBean pageBean) {
        //创建批量查询的对象（“where 1=1 and”）
        QueryWrapper<Goods> query=new QueryWrapper();
        if(StringUtils.isNotBlank(goods.getGoodsName())){
            query.like("goods_name",goods.getGoodsName());
        }
        //排序
        query.orderBy(true,true,"gid");
        IPage<Goods> goodsPage = goodsMapper.selectPage(new Page<Goods>()
                        .setSize(pageBean.getRows())
                        .setCurrent(pageBean.getPage())
                , query);
        return new JsonResponseBody<>(goodsPage.getRecords(),goodsPage.getTotal());
    }
}
