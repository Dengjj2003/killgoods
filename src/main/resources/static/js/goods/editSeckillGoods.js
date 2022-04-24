let form,table,layer,$,laydate;
layui.use(['form','table','layer','jquery','laydate'],function(){
    layer=layui.layer,form=layui.form,table=layui.table,$=layui.jquery,laydate=layui.laydate;

    //初始化商品列表
    initGoods();
    //日期范围组件初始化
    laydate.render({
        elem: '#dt'
        ,type: 'datetime'
        ,range: '~' //或 range: '~' 来自定义分割字符
    });

    $('#btn_search').click(function(){
        initGoods();
    });

    $('#btn_save').click(function(){
        //1.获取活动时间
        let dt=$('#dt').val().trim();
        //2.获取参与秒杀活动的商品
        let rows=table.checkStatus('tb_goods').data;
        //判断
        if(""==dt){
            layer.msg('请选择秒杀商品活动时间',function(){});
            return false;
        }
        if(rows.length==0){
            layer.msg('请选择参与秒杀活动的商品',function(){});
            return false;
        }
        //查询参数
        let params={
            startDate:dt.split('~')[0].trim(),
            endDate:dt.split('~')[1].trim(),
            goods:rows
        }
        console.log(params);
        $.ajax({
            url:'/seckillGoods/addSeckillGoods',
            data:JSON.stringify(params),
            dataType:'json',
            contentType:'application/json',
            type:'post',
            async:false,
            success:function (rs) {
                if(rs.code==200){
                    //先得到当前iframe层的索引
                    var index = parent.layer.getFrameIndex(window.name);
                    //再执行关闭
                    parent.layer.close(index);
                    //调用父窗口中方法
                    parent.querySeckillGoods();
                }else{
                    layer.msg(rs.msg,function(){});
                }
            },
            error:function (err) {
                console.log(err);
            }
        });
    });
});

function initGoods(){
    table.render({           //执行渲染
        elem: '#tb_goods',   //指定原始表格元素选择器（推荐id选择器）
        url:'/goods/queryGoods',
        height: 300,         //自定义高度
        loading: true,       //是否显示加载条（默认 true）
        page:true,
        cols: [[             //设置表头
            {field: 'chk', type:'checkbox'},
            {field: 'goodsName', title: '商品名称', width: 120},
            {field: 'goodsTitle', title: '商品标题', width: 180},
            {field: 'goodsPrice', title: '秒杀价', width: 140},
            {field: 'goodsStock', title: '秒杀数量', width: 120}
        ]],
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
}