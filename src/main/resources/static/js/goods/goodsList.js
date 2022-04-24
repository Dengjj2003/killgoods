let layer,form,table,$;
var row;
layui.use(['layer','form','table'],function(){
    layer=layui.layer,form=layui.form,table=layui.table,$=layui.jquery;

    //初始化商品列表
    initGoods();
    //初始化秒杀商品列表
    initSeckillGoods();
    //绑定查询按钮的点击事件
    $('#btn_goods_search').click(function(){
        queryGoods();
    });
    //绑定新增按钮的点击事件
    $('#btn_goods_add').click(function(){
        row=null;
        openLayer('/input/goods/editGoods');
    });
    //绑定秒杀商品列表的查询事件
    $('#btn_seckillGoods_search').click(function(){
       querySeckillGoods();
    });
    //绑定新增秒杀商品的点击事件
    $('#btn_seckillGoods_add').click(function(){
       openSeckillGoods("/input/goods/editSeckillGoods");
    });
});

//1.初始化商品列表
function initGoods(){
    table.render({           //执行渲染
        elem: '#tb_goods',   //指定原始表格元素选择器（推荐id选择器）
        height: 500,         //自定义高度
        loading: false,      //是否显示加载条（默认 true）
        cols: [[             //设置表头
            {field: 'gid', title: '商品编号', width: 180},
            {field: 'goodsName', title: '商品名称', width: 120},
            {field: 'goodsTitle', title: '商品标题', width: 180},
            {
                field: 'goodsImg', title: '商品图片', width: 160, style: "height:140px;", templet: function (d) {
                    return "<div style='position:relative;top:0;width:100%;height:100%;'><img src='" + d.goodsImg + "' style='height:140px;'></div>";
                }
            },
            {field: 'goodsPrice', title: '商品价格', width: 140},
            {field: 'goodsStock', title: '商品库存', width: 120},
            {field: '', title: '操作', width: 210, toolbar: '#tbGoods'}
        ]]
    });
}

//2.分页查询商品信息
function queryGoods(){
    table.reload('tb_goods', {
        url: '/goods/queryGoods',     //请求地址
        method: 'POST',                    //请求方式，GET或者POST
        loading: true,                     //是否显示加载条（默认 true）
        page: true,                        //是否分页
        where: {                           //设定异步数据接口的额外参数，任意设
            goodsName:$('#goodsName').val()
        },
        request: {                         //自定义分页请求参数名
            pageName: 'page', //页码的参数名称，默认：page
            limitName: 'rows' //每页数据量的参数名，默认：limit
        },
        //parseData数据格式解析的回调函数，用于将返回的任意数据格式解析成 table 组件规定的数据格式。
        parseData: function (res) { //res 即为原始返回的数据
            return {
                "code": res.code == 200 ? 0 : res.code, //解析接口状态，返回结果的code值必须为0
                "msg": res.msg,                         //解析提示文本
                "count": res.total,                     //解析数据长度
                "data": res.data                        //解析数据列表
            };
        },
        done: function (res, curr, count) {
            //查询完成的回调函数
        }
    });

    table.on('tool(tb_goods)', function(obj){ //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
        row = obj.data; //获得当前行数据
        var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
        var tr = obj.tr; //获得当前行 tr 的DOM对象
        if(layEvent === 'del'){ //删除
            layer.confirm('确认删除该商品吗？', {icon: 3, title:'提示'}, function(index){
                // let rs= doAjax('/goods/delGoods',{gid:row.gid}); //rs={code:'',msg:'',total:'',data:''}
                $.post('/goods/delGoods',{gid:row.gid},function(rs){
                    if(rs.code==200){
                        layer.msg(rs.msg);
                        queryGoods();
                    }else
                        layer.msg(rs.msg,{icon:5});
                })

                layer.close(index);
            });

        } else{ //编辑
           openLayer('/input/goods/editGoods');
        }
    });
}

//3.弹出对话框（新增和编辑共用一个页面）
function openLayer(url){
    layer.open({
        type: 2,                    //layer提供了5种层类型。可传入的值有：0（信息框，默认）1（页面层）2（iframe层）3（加载层）4（tips层）
        title:null==row?'新增':'修改',
        area: ['660px', '500px'],   //宽高
        skin: 'layui-layer-rim',    //样式类名
        content: url,               //弹出内容。可以传入普通的html内容，还可以指定DOM，更可以随着type的不同而不同
        btn: ['保存', '关闭'],
        yes: function(index,layero){
            //调用子页面中提供的getData方法，快速获取子页面的form表单数据
            let data= $(layero).find("iframe")[0].contentWindow.getData();
            let url= null==row?'/goods/saveGoods':'/goods/updateGoods';
            // let rs= doAjax(url,data); //rs={code:'',msg:'',total:'',data:''}
            $.post(url,data,function(rs){
                if(rs.code==200){
                    layer.msg(rs.msg);
                    layer.closeAll();
                    queryGoods();
                }else
                    layer.msg(rs.msg,{icon:5});
            })

        },
        btn2: function(){
            layer.closeAll();
        }
    });
}

/*******************************秒杀商品*************************************/
/**
 * 初始化秒杀商品列表
 */
function initSeckillGoods(){
    table.render({
        elem: '#tb_seckillGoods',
        height: 500,
        loading: false,
        cols: [[
            {field: 'goodsName', title: '商品名称', width:150},
            {field: 'seckillPrice', title: '秒杀价格', width:100},
            {field: 'stockCount', title: '库存数量', width:100},
            {field: 'startDate', title: '活动开始时间', width: 190},
            {field: 'endDate', title: '活动结束时间', width: 190},
            {field: 'operator', title: '操作',width:140,
                templet:function(d) {
                    return '<div>' +
                        '<a href="javascript:void(0);" onclick="delSeckillGoods('+d.id+')" class="layui-btn layui-btn-xs">删除</a>' +
                        '<a href="javascript:void(0);" onclick="getSeckillGoods('+d.id+')" class="layui-btn layui-btn-xs layui-btn-normal">秒杀</a>' +
                        '</div>';
                }
            }
        ]]
    });
}

/**
 * 秒杀商品查询方法
 */
function querySeckillGoods(){
    table.reload('tb_seckillGoods', {
        url: '/seckillGoods/querySeckillGoods',     //请求地址
        method: 'POST',                    //请求方式，GET或者POST
        loading: true,                     //是否显示加载条（默认 true）
        page: true,                        //是否分页
        where: {                           //设定异步数据接口的额外参数，任意设
            goodsName:$('#seckillGoodsName').val()
        },
        request: {                         //自定义分页请求参数名
            pageName: 'page', //页码的参数名称，默认：page
            limitName: 'rows' //每页数据量的参数名，默认：limit
        },
        //parseData数据格式解析的回调函数，用于将返回的任意数据格式解析成 table 组件规定的数据格式。
        parseData: function (res) { //res 即为原始返回的数据
            return {
                "code": res.code == 200 ? 0 : res.code, //解析接口状态，返回结果的code值必须为0
                "msg": res.msg,                         //解析提示文本
                "count": res.total,                     //解析数据长度
                "data": res.data                        //解析数据列表
            };
        },
        done: function (res, curr, count) {
            //查询完成的回调函数
            console.log(res);
        }
    });
}

function openSeckillGoods(url){
    layer.open({
        type: 2,                    //layer提供了5种层类型。可传入的值有：0（信息框，默认）1（页面层）2（iframe层）3（加载层）4（tips层）
        title:'秒杀商品',
        area: ['660px', '500px'],   //宽高
        skin: 'layui-layer-rim',    //样式类名
        content: url                //弹出内容。可以传入普通的html内容，还可以指定DOM，更可以随着type的不同而不同
    });
}

function getSeckillGoods(sid){
    location.href='/seckillGoods/querySingle?id='+sid;
}







