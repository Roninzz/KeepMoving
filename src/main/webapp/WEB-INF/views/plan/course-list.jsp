<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Eastzzz
  Date: 2019/9/27
  Time: 20:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../nav/nav.jsp"%>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${path}/css/course-list/course-list.css">
    <link rel="stylesheet" href="${path}/plugins/layui/css/layui.css">
    <link rel="stylesheet" href="${path}/css/plan-detail/plan-detail.css">
    <link rel="stylesheet" href="${path}/css/nav/nav.css">

</head>
<body>


<!-- 最外层 -->

<!-- 头部背景图 -->
<div class="plan-detail-title">
    <div class="plan-title">
        <h2>${name}</h2>
        <div class="plan-introduction">
            <span>${core}</span>
        </div>
    </div>
</div>

<!--面包屑导航开始-->
<div class="daohang" style="margin:20px 0px 0px 340px">
    <span class="layui-breadcrumb">
        <a href="${path}/plan/plan-index.html">训练计划</a>
        <a href="javascript:plandetail('${pid}')">计划日历</a>
        <a><cite>每日课程列表</cite></a>
    </span>
</div>
<!-- 面包屑导航结束 -->

<div class="km">
    <!-- 中间列表 -->
    <div class="list">
        <!-- 中间 第一列简介 -->
        <div class="list-core">
            <div class="core-top">
                <span>第${did}天</span>
                <span>${dayTitle}</span>
                <button class="core-btn"><a href="javascript:plandetail('${pid}')" style="color:white">计划首页</a></button>

            </div>
            <%--<hr class="hr">--%>

            <%--<p class="core-p">--%>
               <%--${daytitle}--%>
            <%--</p>--%>
        </div>
        <!-- 列表 循环的地方 li-->
        <ul class="group-list">

            <c:forEach items="${pageContext.request.getAttribute('courselist')}" var="t">
                <li>
                    <div class="core">
                        <div class="core-core">
                            <div class="intro">
                                <span class="sort"></span>
                            </div>
                            <ul class="action-list">
                                <li>
                                    <div class="list-item">
                                        <h3>
                                                <%--原来的--%>
                                                <%--<a href="course-as.html">${t.courseName}</a>--%>
                                                <%--修改的--%>
                                                <%--点击课程名字时，获取其courseId--%>
                                            <a href="javascript:getCourseId(${t.courseId})">${t.courseName}</a>
                                        </h3>
                                        <p>${t.courseIntroduction}</p>
                                        <div class="img-core">
                                            <img src="${t.imgUrl}" alt="">
                                        </div>
                                    </div>
                                </li>
                            </ul>
                        </div>
                    </div>
                </li>
            </c:forEach>

        </ul>
        <!-- 列表end -->


    </div>

    <div class="LAY_preview">
        <fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
            <legend>你想要的,我们都有!</legend>
        </fieldset>
        <ul class="site-doc-icon site-doc-anim">

            <li>
                <div class="out">
                    <div class="layui-anim">
                        <a href="">
                            <img src="${path}/imgs/course-list/1.jpg" alt="">
                        </a>
                    </div>
                </div>
            </li>
            <li>
                <div class="out">
                    <div class="layui-anim">
                        <a href="">
                            <img src="${path}/imgs/course-list/3.jpg" alt="">
                        </a>
                    </div>
                </div>
            </li>
            <li>
                <div class="out">
                    <div class="layui-anim">
                        <a href="">
                            <img src="${path}/imgs/course-list/20.jpg" alt="">
                        </a>
                    </div>
                </div>
            </li>
            <li>
                <div class="out">
                    <div class="layui-anim">
                        <a href="">
                            <img src="${path}/imgs/course-list/5.jpg" alt="">
                        </a>
                    </div>
                </div>
            </li>
            <li>
                <div class="out">
                    <div class="layui-anim">
                        <a href="">
                            <img src="${path}/imgs/course-list/6.jpg" alt="">
                        </a>
                    </div>
                </div>
            </li>
            <li>
                <div class="out">
                    <div class="layui-anim">
                        <a href="">
                            <img src="${path}/imgs/course-list/7.jpg" alt="">
                        </a>
                    </div>
                </div>
            </li>
            <li>
                <div class="out">
                    <div class="layui-anim">
                        <a href="">
                            <img src="${path}/imgs/course-list/8.jpg" alt="">
                        </a>
                    </div>
                </div>
            </li>
            <li>
                <div class="out">
                    <div class="layui-anim">
                        <a href="">
                            <img src="${path}/imgs/course-list/9.png" alt="">
                        </a>
                    </div>
                </div>
            </li>
            <li>
                <div class="out">
                    <div class="layui-anim">
                        <a href="">
                            <img src="${path}/imgs/course-list/19.jpg" alt="">
                        </a>
                    </div>
                </div>
            </li>
            <li>
                <div class="out">
                    <div class="layui-anim">
                        <a href="">
                            <img src="${path}/imgs/course-list/11.jpg" alt="">
                        </a>
                    </div>
                </div>
            </li>
            <li>
                <div class="out">
                    <div class="layui-anim">
                        <a href="">
                            <img src="${path}/imgs/course-list/12.jpg" alt="">
                        </a>
                    </div>
                </div>
            </li>
            <li>
                <div class="out">
                    <div class="layui-anim">
                        <a href="">
                            <img src="${path}/imgs/course-list/13.jpg" alt="">
                        </a>
                    </div>
                </div>
            </li>
            <li>
                <div class="out">
                    <div class="layui-anim">
                        <a href="">
                            <img src="${path}/imgs/course-list/14.jpg" alt="">
                        </a>
                    </div>
                </div>
            </li>
            <li>
                <div class="out">
                    <div class="layui-anim">
                        <a href="">
                            <img src="${path}/imgs/course-list/15.jpg" alt="">
                        </a>
                    </div>
                </div>
            </li>
            <li>
                <div class="out">
                    <div class="layui-anim">
                        <a href="">
                            <img src="${path}/imgs/course-list/18.jpg" alt="">
                        </a>
                    </div>
                </div>
            </li>
            <li>
                <div class="out">
                    <div class="layui-anim">
                        <a href="">
                            <img src="${path}/imgs/course-list/17.jpg" alt="">
                        </a>
                    </div>
                </div>
            </li>

        </ul>
    </div>
</div>


<script src="${path}/plugins/layui/layui.js"></script>
<script src="${path}/js/nav/nav.js"></script>
<script src="${pageContext.request.contextPath}/plugins/jquery/jquery.min.js"></script>

<script>
    //点击课程时获取其id
    function getCourseId(id) {
        window.location = "${pageContext.request.contextPath}/coursedetail/goCourseDetail?courseId=" + id;
    }

    function plandetail(id) {
        window.location = "${path}/plan-detail/detail?id="+id;
    }
</script>
</body>
</html>
