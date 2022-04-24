let layer,$;
layui.use(['layer','jquery'],function(){
        $=layui.jquery,layer=layui.layer;
        $('#login').click(function(){
          let username = $("#username").val();

          let password = $("#password").val();
          let salt='f1g2h3j4';
          let str=salt.charAt(1)+""+salt.charAt(5)+password+salt.charAt(0)+""+salt.charAt(3);
          //前端加密密码
          let pwd=md5(str);
          console.log(pwd);
          login(username,pwd)
        });
});
//用户登录
function login(username,password){
    $.ajax({
            url:"user/userLogin",
            data:{mobile:username,password:password},
            type:"post",
            dataType:"json",
            success:function(data){
               if(data.code==200){
                   layer.msg(data.msg,{icon:6},
                       function(){
                          location.href="goods/toGoods";
                       })
               }else{
                   layer.msg(data.msg,{icon:5});
               }
            }
    }
    )
}