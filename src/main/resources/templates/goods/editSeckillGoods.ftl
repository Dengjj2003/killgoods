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
<div style="padding:15px 0px;">
    <div class="layui-condition">
        <form id="fm" name="fm" action="/" method="post" class="layui-form">
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label" style="width: 100px;text-align: left;">秒杀活动时间:</label>
                    <div class="layui-input-inline" style="width:280px;">
                        <input type="text" class="layui-input" id="dt">
                    </div>
                    <div class="layui-input-inline">
                        <button class="layui-btn" id="btn_search" type="button"><i class="fa fa-search fa-right"></i>查 询
                        </button>
                        <button class="layui-btn" id="btn_save" type="button"><i class="fa fa-search fa-right"></i>保 存
                        </button>
                    </div>
                </div>

            </div>
        </form>
    </div>
    <div class="layui-fluid" style="margin-top:-18px;">
        <table id="tb_goods" class="layui-table" lay-filter="tb_goods" style="margin-top:-5px;">
        </table>
    </div>
</div>
<script src="/static/js/layui/layui.js"></script>
<script src="/static/js/goods/editSeckillGoods.js"></script>
</body>
</html>