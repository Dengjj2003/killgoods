<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Layui</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="/static/js/layui/css/layui.css" media="all">
</head>
<body>
<div style="padding:10px;">
    <form class="layui-form layui-form-pane" lay-filter="book">
        <input type="hidden" name="gid"/>
        <div class="layui-form-item">
            <label class="layui-form-label">商品名称</label>
            <div class="layui-input-block">
                <input type="text" name="goodsName" autocomplete="off" placeholder="请输入标题" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">商品标题</label>
            <div class="layui-input-block">
                <input type="text" name="goodsTitle" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">商品图片</label>
            <div class="layui-input-block">
                <select name="goodsImg">
                    <option value="">---请选择---</option>
                    <option value="/static/images/mi10.png">小米10</option>
                    <option value="/static/images/mi11.png">小米11</option>
                    <option value="/static/images/redminote9pro.png">红米 note 9 pro</option>
                </select>
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">商品价格</label>
            <div class="layui-input-block">
                <input type="text" name="goodsPrice" placeholder="请输入价格" autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">商品库存</label>
            <div class="layui-input-block">
                <input type="text" name="goodsStock" placeholder="请输入库存" autocomplete="off" class="layui-input">
            </div>
        </div>


        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">商品描述</label>
            <div class="layui-input-block">
                <textarea name="goodsDetail" placeholder="请输入内容" class="layui-textarea"></textarea>
            </div>
        </div>
        <!--<div class="layui-form-item">
            <button class="layui-btn" id="btn_save" type="button"><i class="fa fa-search fa-right"></i>保 存
            </button>
        </div>-->
    </form>
</div>
<script src="/static/js/layui/layui.js" charset="utf-8"></script>
<script src="/static/js/goods/editGoods.js"></script>
</body>
</html>