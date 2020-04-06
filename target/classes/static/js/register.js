$(function () {
    $('#foundTime').datetimepicker({
        format: 'YYYY-MM-DD',
        locale: moment.locale('zh-cn')
    });
});
/*注册*/
$("#registerBtn").click(function () {
    if($("#username").val()==""){
        layer.msg("请输入用户名")
        return;
    };

    if($("#password").val()==""){
        layer.msg("请输入密码")
        return;
    };

    if($("#password").val() != $("#isPassword").val()){
        layer.msg("两次输入密码不相同")
        return;
    };


    if($("#creditCode").val()==""){
        layer.msg("请输入统一社会信用代码")
        return;
    };

    if($("#enterpriseName").val()==""){
        layer.msg("请输入单位名称")
        return;
    };

    if($("#address").val()==""){
        layer.msg("请输入营业执照上的地址")
        return;
    };

    if($("#dateTime").val()==""){
        layer.msg("请输入企业注册成立时间")
        return;
    };

    if($("#legalPerson").val()==""){
        layer.msg("请输入法定代表人")
        return;
    };

    if($("#person").val()==""){
        layer.msg("输入企业联系人")
        return;
    };

    if($("#phone").val()==""){
        layer.msg("请输入经办人的手机/座机号如023-688888888")
        return;
    };

    if($("#email").val()==""){
        layer.msg("请输入常用联系邮箱")
        return;
    };
    $.ajax({
        type: 'POST',
        url: '/register',
        data: $("#registerEnterprise").serialize(),
        success: function (data){
            if(data.code==200){
                setTimeout(layer.msg("提交成功"),3000);
                location.reload();
            }else {
                layer.msg(data.msg)
            }
        },
        error: function () {
            setTimeout(layer.msg("系统错误"),3000);
            location.reload();
        }
    });
})
