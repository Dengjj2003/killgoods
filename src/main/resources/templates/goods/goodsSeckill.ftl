<!DOCTYPE html>
<html lang="en">
<head>
    <#include "../common/head.ftl"/>
</head>
<body>
<table style="position: absolute;top:-10px;" class="layui-table" border="1" cellpadding="0" cellspacing="0">
    <tr>
        <td style="width:120px;">商品图片</td>
        <td>
            <img src="${goods.goods_img}">
        </td>
    </tr>
    <tr>
        <td>商品名称</td>
        <td>
            ${goods.goods_name}
        </td>
    </tr>
    <tr>
        <td>商品标题</td>
        <td>
            ${goods.goods_title}
        </td>
    </tr>
    <tr>
        <td>商品价格</td>
        <td>
            ${goods.seckill_price}
        </td>
    </tr>
    <tr>
        <td>商品详情</td>
        <td>
            ${goods.goods_detail!""}
        </td>
    </tr>
    <tr>
        <td>开始时间</td>
        <td>

            <div style="position: relative;${(goods.seckill_status==1)?string('top:10px;','')}">
                ${goods.start_date?string("yyyy-MM-dd HH:mm:ss")} - ${goods.end_date?string("yyyy-MM-dd HH:mm:ss")}
                <#if goods.seckill_status==0>
                    活动未开始
                <#elseif goods.seckill_status==1>
                    活动热卖中
                    <div style="position:relative;top:-10px;float:right;">
                        <input type="hidden" id="goodsId" value="${goods.id}" name="goodsId"/>
                        <button class="layui-btn" id="buy">立即抢购</button>
                    </div>
                <#else>
                    活动已结束
                </#if>
            </div>
        </td>
    </tr>
</table>
<script src="/static/js/goods/goodsSeckill.js"></script>
</body>
</html>