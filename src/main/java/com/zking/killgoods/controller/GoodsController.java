package com.zking.killgoods.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zking.killgoods.exception.BusinessException;
import com.zking.killgoods.model.Goods;
import com.zking.killgoods.model.User;
import com.zking.killgoods.service.IGoodsService;
import com.zking.killgoods.util.JsonResponseBody;
import com.zking.killgoods.util.JsonResponseStatus;
import com.zking.killgoods.util.PageBean;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 * 商品信息表 前端控制器
 * </p>
 *
 * @author zsy
 * @since 2022-03-07
 */
@Controller
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private IGoodsService goodsService;
    @RequestMapping("toGoods")
    public String goGoods(User u, Model model){
        model.addAttribute("user",u.getNickname());
        return "goods/goodsList";
    }

    @PostMapping("/saveGoods")
    @ResponseBody
    public JsonResponseBody addGoods(HttpServletRequest req,Goods goods){
        boolean f = goodsService.save(goods);
        if(!f)
            throw new BusinessException(JsonResponseStatus.GOODS_SAVE_ERROR);
        return new JsonResponseBody(JsonResponseStatus.SUCCESS);
    }
    @PostMapping("/updateGoods")
    @ResponseBody
    public JsonResponseBody updateGoods(Goods goods){
        boolean f = goodsService.updateById(goods);
        if(!f)
            throw new BusinessException(JsonResponseStatus.GOODS_UPDATE_ERROR);
        return new JsonResponseBody(JsonResponseStatus.SUCCESS);

    }
    @PostMapping("/delGoods")
    @ResponseBody
    public JsonResponseBody delGoods(Goods goods){
        boolean f = goodsService.removeById(goods.getGid());
        if(!f)
            throw new BusinessException(JsonResponseStatus.GOODS_DEL_ERROR);
        return new JsonResponseBody(JsonResponseStatus.SUCCESS);
    }




    @RequestMapping("/queryGoods")
    @ResponseBody
    public JsonResponseBody<List<Goods>> queryGoodsPage(HttpServletRequest req,Goods goods){
        PageBean pageBean=new PageBean();
        pageBean.setRequest(req);
        return goodsService.queryGoodsPage(goods,pageBean);
    }

}
