<!DOCTYPE html>
<html lang="en">
<head>
    <#include "../common/head.ftl"/>
    <script src="/static/js/goods/goodsList.js"></script>
</head>
<style>
    .layui-table-cell {height: inherit;}
</style>
<body>
<div class="layui-tab layui-tab-brief" lay-filter="docDemoTabBrief">
    <ul class="layui-tab-title">
        <li class="layui-this">商品管理</li>
        <li>秒杀商品</li>
        <li style="float: right">安全退出</li>
    </ul>
    <div style="position: absolute;top:20px;right:110px;">你好，<span style="font-weight:bold">${user}</span></div>
    <div class="layui-tab-content">
        <div class="layui-tab-item layui-show">
            <#--搜索栏-->
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">商品名称：</label>
                    <div class="layui-input-inline">
                        <input type="text" id="goodsName" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-inline">
                    <button id="btn_goods_search" class="layui-btn layui-btn-normal">
                        <i class="layui-icon">&#xe615;</i> 查询
                    </button>
                    <button id="btn_goods_add" class="layui-btn">
                        <i class="layui-icon">&#xe654;</i> 新增
                    </button>
                </div>
            </div>
            <#-- 数据表格 -->
            <table style="margin-top:-15px;" id="tb_goods" lay-filter="tb_goods"></table>
        </div>
        <div class="layui-tab-item">
            <#--搜索栏-->
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">商品名称：</label>
                    <div class="layui-input-inline">
                        <input type="text" id="seckillGoodsName" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-inline">
                    <button id="btn_seckillGoods_search" class="layui-btn layui-btn-normal">
                        <i class="layui-icon">&#xe615;</i> 查询
                    </button>
                    <button id="btn_seckillGoods_add" class="layui-btn">
                        <i class="layui-icon">&#xe654;</i> 新增秒杀商品
                    </button>
                </div>
            </div>
            <#-- 数据表格 -->
            <table style="margin-top:-15px;" id="tb_seckillGoods" lay-filter="tb_seckillGoods"></table>
        </div>
    </div>
</div>
<script type="text/html" id="tbGoods">
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
</body>
</html>