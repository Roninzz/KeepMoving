<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/10/1
  Time: 10:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../nav/nav.jsp"%>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>用户注册</title>

    <link rel="stylesheet" href="${path}/plugins/layui/css/layui.css">
    <link rel="stylesheet" href="${path}/plugins/font-awesome/css/font-awesome.css">
    <link rel="stylesheet" href="${path}/css/user/bootstrap.css">
    <link rel="stylesheet" href="${path}/css/nav/nav.css">
    <link rel="stylesheet" href="${path}/css/user/user.css">
</head>

<body id="bgImg">
<!-- 响应式导航 begin -->

<!-- 响应式导航 end -->
</div>
<!-- 响应式导航 end -->
<section class="mysection">
    <div class="row2">
        <div class="row2zuo">
            <h2>注册</h2>
            <form style="margin-top: 20px;">
                <div class="form-horizontal">
                    <div class="form-group" style="margin-top: 10px;">

                        <label for="exampleInputName2" class="col-sm-3 control-label" style="padding-top: 20px;" >用户名:</label>
                        <div class="col-sm-9" style="margin-top: 15px;">
                            <input type="text" name="username" class="form-control" id="exampleInputName2" placeholder="输入用户名" maxlength="15" id="uname" onblur="checkUsername(this)">

                            <img src="${path}/imgs/user/yonghu.png" alt="" width="15px;" height="15px;" style="margin-top: -25px;">
                        </div>
                        <span id="span_uname" style="color:red;margin-left:120px;"></span>
                    </div>
                    <div class="form-group" style="margin-top: 10px;">
                        <label for="exampleInputPassword1" class="col-sm-3 control-label" style="padding-top: 20px;">手机号码:</label>
                        <div class="col-sm-9" style="margin-top: 15px;">
                            <input type="tel" class="form-control" id="exampleInputUsername"
                                 name="phone" maxlength="11" placeholder="输入手机号码" onblur="checkPhone(this)" >
                            <img src="${path}/imgs/user/yuechi_o.png" width="22px" height="22px" style="margin-top: -27px;">


                        </div>
                        <span id="span_phone" style="color:red;margin-left:120px;"></span>

                    </div>
                    <div class="form-group" style="margin-top: 10px;">
                        <label for="exampleInputPassword1" class="col-sm-3 control-label" style="padding-top: 20px;">密码:</label>
                        <div class="col-sm-9" style="margin-top: 15px;">
                            <input type="password" class="form-control" id="exampleInputPassword1"
                                   name="password" placeholder="输入密码" onblur="checkPassword(this)">
                            <img src="${path}/imgs/user/yuechi_o.png" alt="" width=22px; height=22px; style="margin-top: -27px;">
                        </div>

                    </div>
                    <span id="span_pwd" style="color:red;margin-left:120px;"></span>
                    <div class="form-group" style="margin-top: 10px;">
                        <label for="exampleInputPassword2" class="col-sm-3 control-label" style="padding-top: 20px;">确认密码:</label>
                        <div class="col-sm-9" style="margin-top: 15px;">
                            <input type="password" class="form-control" id="exampleInputPassword2"
                                   placeholder="请确认密码" onblur="checkPassword1(this)">
                            <img src="${path}/imgs/user/yuechi_o.png" alt="" width=22px; height=22px; style="margin-top: -27px;">
                        </div>
                        <span id="span_pwd1" style="color:red;margin-left:120px;"></span>
                    </div>
                    <button type="button" class="btn btn-info" onclick="register()" style="margin-top: 40px;" id="registerBtn" disabled="true">注册</button>
                </div>
            </form>
        </div>

        <div class="row2you">
            <div class="d2">
                <h1>我已注册账号</h1>
                <button type="button" class="btn btn-danger" onclick="goLogin()">登录</button>
            </div>
        </div>
    </div>
</section>

<%--隐藏域上下文路径--%>
<input id="path" type="hidden" value="${pageContext.request.contextPath}">

<script src="${path}/plugins/layui/layui.js"></script>
<script src="${path}/js/nav/nav.js"></script>
<script src="${path}/plugins/jquery/jquery.min.js"></script>
<script src="${path}/js/login-register/register.js"></script>



</body>

</html>