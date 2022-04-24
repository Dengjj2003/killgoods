let layer,form,$;
layui.use(['layer','form','jquery'],function(){
    layer=layui.layer,form=layui.form,$=layui.jquery;

    form.render();
    //表单赋值
    setRows();
});

/**
 * 该方法用于完成商品编辑页面的快速赋值操作
 */
function setRows(){
    if(null!=parent.row){
        console.log(111);
        //因为layui.each内部的逻辑问题导致的所以要先深拷贝一份然后再去val
        //parent.row：表格行对象
        form.val('book',$.extend({}, parent.row||{}));
    }
}

function getData(){
    //在获取表单数据之前先完成表单验证
    return form.val('book');
}