<%--
  Created by IntelliJ IDEA.
  User: Eastzzz
  Date: 2019/10/10
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- 响应式导航 begin -->
<div class="o-header">
    <!-- 响应式导航 begin -->
    <div class="layui-header header header-index">
        <a class="logo" href="${path}/index/hello">
            KeepMoving
        </a>

        <ul class="layui-nav layui-layout-right" >
            <li class="layui-nav-item"><a href="${path}/index/hello">首页</a></li>
            <li class="layui-nav-item">
                <a href="${path}/plan/plan-index.html">训练计划</a>
            </li>
            <li class="layui-nav-item"><a href="${path}/action/action-list">健身动作</a></li>
            <li class="layui-nav-item"><a href="${path}/food/food-list">饮食健康</a></li>

            <c:if test="${sessionScope.userInfo == null}">
                <li class="layui-nav-item ">
                    <a href="${path}/loginAct">登录</a>
                </li>
                <li class="layui-nav-item ">
                    <a href="${path}/registerAct">注册</a>
                </li>
            </c:if>



            <c:if test="${sessionScope.userInfo != null}">
                <li class="layui-nav-item ">
                    <%--<a href="javascript:;"><img src="${sessionScope.userImg.imgUrl}" class="layui-nav-img" id="userimg">${sessionScope.userInfo.username}</a>--%>
                        <a href="javascript:;">
                            <c:if test="${sessionScope.userImg == null}">
                                <img src="http://pz01d7jiu.bkt.clouddn.com/photo.png" class="layui-nav-img">${sessionScope.userInfo.username}
                            </c:if>
                            <c:if test="${sessionScope.userImg != null}">
                                <img src="${sessionScope.userImg.imgUrl}" class="layui-nav-img">${sessionScope.userInfo.username}
                            </c:if>

                        </a>

                        <dl class="layui-nav-child">
                        <dd><a href="${path}/person/center" style="line-height: 36px;">个人中心</a></dd>
                        <dd><a href="${path}/per1" style="line-height: 36px;">账号设置</a></dd>
                        <dd><a href="javascript:exit()" id="Exit" style="line-height: 36px;">退出账号</a></dd>
                        </dl>
                </li>
            </c:if>
            <c:if test="${sessionScope.userInfo == null}">
                <li class="layui-nav-item ">
                    <a href="${path}/loginAct"><img src="http://pz01d7jiu.bkt.clouddn.com/photo.png" class="layui-nav-img">未登录</a>
                </li>
            </c:if>

        </ul>
    </div>
    <!-- 导航栏结束 -->
</div>
<script src="${path}/plugins/layui/layui.js"></script>
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
<!-- 响应式导航 end -->

<script>
    <%--$(function () {--%>
        <%--$("#Exit").click(function () {--%>
            <%--$.get('${path}/exit');--%>
        <%--});--%>

    <%--});--%>

    function exit() {
        <%--$.get('${path}/exit');--%> //不能用ajax因为局部刷新了
        window.location = "${path}/exit";
    }
</script>
