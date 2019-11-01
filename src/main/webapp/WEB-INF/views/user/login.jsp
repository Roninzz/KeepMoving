<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/9/27
  Time: 15:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../nav/nav.jsp" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>用户登录</title>
    <base href="/">
    <link rel="stylesheet" href="${path}/plugins/layui/css/layui.css">
    <link rel="stylesheet" href="${path}/plugins/font-awesome/css/font-awesome.css">
    <link rel="stylesheet" href="${path}/css/user/bootstrap.css">
    <link rel="stylesheet" href="${path}/css/nav/nav.css">
    <link rel="stylesheet" href="${path}/css/user/user.css">

</head>


<body id="bgImg">
<!-- 响应式导航 begin -->

<!-- 响应式导航 end -->
<div>
    <section class="mysection">
        <div class="row2">
            <div class="row2zuo ">
                <h2>登录</h2>
                <form>
                    <div class="form-horizontal">
                        <div class="form-group" style="margin-top: 30px;">

                            <label for="exampleInputName2" class="col-sm-3 control-label" style="margin-top: 20px;">手机号码:</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="exampleInputName2" placeholder="输入手机号码"
                                       maxlength="11" style="margin-top: 20px;" onblur="logincheckPhone(this)">
                                <%--<input type="tel" class="form-control" id="exampleInputName2" placeholder="输入手机号码"--%>
                                <%--maxlength="11" style="margin-top: 20px;">--%>
                                <img src="${path}/imgs/user/yonghu.png" alt="" width=15px; style="margin-top:-25px">
                                       <%--maxlength="11" style="margin-top: 20px;">--%>

                            </div>
                            <span id="span_phone" style="color:red;margin-left:120px;"></span>
                        </div>

                        <div class="form-group" style="margin-bottom:-24px;margin-top:20px;">
                            <div class="">
                                <label for="exampleInputName4" class="col-sm-3 control-label" style="margin-top: 20px;">验证码:</label>
                            </div>

                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="exampleInputName4" placeholder="输入验证码"
                                       maxlength="4"
                                       style="width: 120px; padding-left:0px;display: inline;margin-top: 20px;">
                                <button id="btn_message" type="button" style=" width: 120px;height: 40px;margin-top: 20px;margin-bottom: 20px;
                               border-radius: 10px; float: right;color: black;">获取短信验证码
                                </button>
                            </div>
                            <span id="span_check" style="color:red;margin-left:120px;"></span>
                        </div>

                        <button type="button" class="btn btn-danger" style="margin-top: 30px;" onclick="goIndex()"
                                id="loginBtn">登录
                        </button>
                        <div class="forget">
<%--                            <label>--%>
<%--                            <input type="checkbox" id="blankCheckbox" value="option1" aria-label="...">--%>
<%--                            </label>--%>
<%--                            <strong>使用密码进行登录</strong>--%>
                            <a href="${path}/user/login" style="text-decoration: none;">密码登录</a>
                        </div>
                    </div>
                </form>
            </div>
            <div class="row2you">
                <div class="d2">
                    <h1>没有账号？立即注册</h1>
                    <button type="button" class="btn btn-info" onclick="goRegister()">免费注册</button>
                </div>
            </div>
        </div>
    </section>
</div>

<div id="container" style="width:300px; height: 180px; "></div>

<%--隐藏域上下文路径--%>
<input id="path" type="hidden" value="${pageContext.request.contextPath}">

<script src="${path}/plugins/layui/layui.js"></script>
<script src="${path}/js/nav/nav.js"></script>
<script src="${path}/plugins/jquery/jquery.min.js"></script>
<script src="${path}/js/login-register/login.js"></script>

<script>
    layui.use('element', function () {
        var element = layui.element; //导航的hover效果、二级菜单等功能，需要依赖element模块

//监听导航点击
        element.on('nav(demo)', function (elem) {
//console.log(elem)
            layer.msg(elem.text());
        });
    });
</script>

</body>

</html>
