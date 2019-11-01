<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>密码登录</title>

    <link rel="stylesheet" href="${path}/plugins/layui/css/layui.css">
    <link rel="stylesheet" href="${path}/plugins/font-awesome/css/font-awesome.css">
    <link rel="stylesheet" href="${path}/css/user/bootstrap.css">
    <link rel="stylesheet" href="${path}/css/user/find-password.css">
    <link rel="stylesheet" href="${path}/css/nav/nav.css">
    <link rel="stylesheet" href="${path}/css/user/user.css">
</head>
<%@ include file="../nav/nav.jsp" %>


<body id="bgImg">
    <!-- 响应式导航 begin -->

    <!-- 响应式导航 end -->

    <div>
        <section class="mysection">
            <div class="row2">
                <div class="row2zuo">
                    <h2>密码登录</h2>
                    <form>
                        <div class="form-horizontal">
                            <div class="form-group" style="margin-top: 30px;">

                                <label for="exampleInputName2" class="col-sm-3 control-label" style="margin-top: 20px;">手机号码:</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="tel" placeholder="输入手机号码"
                                           maxlength="11" style="margin-top: 20px;" onblur="logincheckPhone(this)">
                                    <img src="${path}/imgs/user/yonghu.png" alt="" width=15px; >
                                </div>
                                <span id="span_phone" style="color:red;margin-left:120px;"></span>
                            </div>

                            <div class="form-group" style="margin-top: 20px;">
                                <label for="exampleInputName2" class="col-sm-3 control-label" style="margin-top: 20px;">密码:</label>
                                <div class="col-sm-9">
                                    <input type="password" class="form-control" id="pwd" placeholder="输入密码"
                                           maxlength="11" style="margin-top: 20px;">
                                    <img src="${path}/imgs/user/yuechi_o.png" alt="" width=22px; >
                                </div>
                                <span id="span_password" style="color:red;margin-left:120px;"></span>
                            </div>

                        </div>
                    </form>
                    <button type="button" class="btn btn-danger" style="margin-top: 30px;"  id="loginBtn">登录</button>

                </div>
                <div class="row2you">
                    <div class="d2">
                        <h2>其他操作？</h2>
                        <button type="button" class="btn btn-danger"><a href="${path}/loginAct">使用验证码登录</a></button>
                        <button type="button" class="btn btn-danger"><a href="${path}/registerAct">前往注册</a></button>
                    </div>
                </div>
            </div>
        </section>
    </div>
    <script src="${path}/plugins/layui/layui.all.js"></script>
    <script src="${path}/plugins/jquery/jquery.min.js"></script>

<script>
    function logincheckPhone(obj) {
        var phone = obj.value;//记录输入框的电话号码
        var regex = /^(13[0-9]|14[579]|15[0-3,5-9]|16[6]|17[0135678]|18[0-9]|19[89])\d{8}$/;
        if (!regex.test(phone)){
            $("#span_phone").html("请输入正确的手机号");
            document.getElementById("btn_message").disabled = true;
        }else {
            $.get("${path}/judgePhoneAct?phone=" + phone, function (data) {
                if (data == "yes") {
                    //                   alert("ok");
                    $("#span_phone").html("手机号不存在，请先注册");
                } else if (data == "no") {
                    $("#span_phone").html("");
                }
            });
        }
    }

    $("#loginBtn").click(function(){
        var tel = $("#tel").val();
        var pwd = $("#pwd").val();
        var data = {"tel":tel,"pwd":pwd};
        $.post("${path}/user/checkLogins",data,function(data){
           if (data.flag == false){
               layer.msg("密码错误",{icon:1,time:1000});
           } else {
               window.location = "${path}/goIndex?phone=" + tel;
           }
        });
    });






</script>

</body>
</html>