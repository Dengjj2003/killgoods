let layer,form,$;
layui.use(['layer','form'],function(){
    layer=layui.layer,form=layui.form,$=layui.jquery;

    $('#buy').click(function(){
        $.ajax({
            url:'/seckillOrder/addOrder',
            data:{id:$('#goodsId').val()},
            dataType:'json',
            type:'post',
            async:false,
            success:function (rs) {
                if(rs.code==200){
                    layer.msg(rs.msg,function(){});
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