package com.zking.killgoods.controller;


import com.zking.killgoods.service.ISeckillGoodsService;
import com.zking.killgoods.util.JsonResponseBody;
import com.zking.killgoods.vo.SeckillGoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 秒杀商品信息表 前端控制器
 * </p>
 *
 * @author zsy
 * @since 2022-03-07
 */
@Controller
@RequestMapping("/seckillGoods")
public class SeckillGoodsController {
    @Autowired
    private ISeckillGoodsService seckillGoodsService;

    @RequestMapping("/querySeckillGoods")
    @ResponseBody
    public JsonResponseBody<List<SeckillGoodsVo>> querySeckillGoods(SeckillGoodsVo seckillGoodsVo){
        return seckillGoodsService.querySeckillGoods(seckillGoodsVo);
    }

    @RequestMapping("/addSeckillGoods")
    @ResponseBody
    public JsonResponseBody<?> addSeckillGoods(@RequestBody SeckillGoodsVo seckillGoodsVo){
        return seckillGoodsService.addSeckillGoods(seckillGoodsVo);
    }

    @RequestMapping("/querySingle")
    public String querySingleSeckillGoodsById(Long id, Model model) {
       Map<String, Object> singleSeckillGoods = seckillGoodsService.querySingleSeckillGoodsById(id);
       model.addAttribute("goods",singleSeckillGoods);
        return "goods/goodsSeckill";
    }


}
