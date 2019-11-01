<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/10/2
  Time: 11:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">

<head>
    <!-- Meta tag Keywords -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="keywords" content="XXX"/>
    <link rel="stylesheet" href="${path}/css/course-detail/course-detail.css">
    <link rel="stylesheet" href="${path}/plugins/layui/css/layui.css">
    <link rel="stylesheet" href="${path}/css/nav/nav.css">

    <title>课程详情</title>
</head>

<body>

<!--面包屑导航开始-->
<%@ include file="../nav/nav.jsp"%>
<div class="daohang" style="margin: 10px 0px 10px 310px;">
        <span class="layui-breadcrumb">
            <%--<a href="plan-index.html">训练计划</a>--%>
            <a href="${path}/plan/plan-index.html">训练计划</a>
            <%--<a href="${path}/plan-detail/detail">计划日历</a>--%>
            <a href="javascript:plandetail('${did}')">计划日历</a>
            <%--<a href="${path}/courselist/list">每日课程列表</a>--%>
            <a href="javascript:goCourse('${pid}','${did}')">每日课程列表</a>
            <a><cite>具体课程</cite></a>
        </span>
</div>

<div id="total" style="width: 911px;height: 512px;">



    <!-- 视频begin -->
    <div id="div0">
        <center>
            <video id="video-time" class="video-js vjs-default-skin" controls data-setup="{}" width="911px">
                <source src="${vs.vediosUrl}">
            </video>
            <input type="hidden" id="time" value="0">
        </center>
    </div>
    <!-- 视频end -->

    <div id="div2">
        <span><strong>类型:</strong>&nbsp;&nbsp; ${course.catetory}</span><br>
        <br>
        <span><strong>级别:</strong></span>&nbsp;&nbsp; <a>${course.level}</a>
    </div>

    <div id="div3">
        <span><strong>主要肌肉群:</strong></span>&nbsp;&nbsp; <a>肱四头肌</a><br>
        <br>
        <span><strong>其他肌肉:</strong></span>&nbsp;&nbsp; <a>小腿肌群</a>
    </div>

    <div id="div4">
        <span><strong>主要肌肉群:</strong></span>&nbsp;&nbsp; <a>其他机械</a><br>
    </div>

    <div id="div5">

            <span>
                <h3 style="font-weight: bolder">动作要领图</h3>
            </span>
        <br>

        <%--判断begin--%>
        <c:if test="${courseImgs != null}">
            <c:forEach items="${courseImgs}" var="cimg">
                <div id="img1">
                        <%--<img src="http://py5ztkhmu.bkt.clouddn.com/daea3d4a-43d1-4de3-af11-c1b04fa14790.webp"--%>
                        <%--style="width: 300px;height: 200px;">--%>

                        <%--图片延时加载Jquery lazyload--%>
                    <img class="lazy" data-original="${cimg.imgUrl}" style="width: 300px;height: 200px;" alt="图片丢失啦！">

                </div>

            </c:forEach>
        </c:if>
        <%--判断end--%>
    </div>

</div>

<%--延时加载图片begin--%>
<%--<script src="${path}/js/course-detail/jquery-1.11.0.min.js"></script>--%>
<%--<script src="${path}/plugins/jquery/jquery.min.js"></script>--%>
<script src="${pageContext.request.contextPath}/plugins/jquery/jquery.min.js"></script>
<script src="${path}/plugins/layui/layui.js"></script>
<script src="${path}/js/course-detail/jquery.lazyload.js"></script>
<script>
    $(function () {
        $("img.lazy").lazyload({effect: "fadeIn"});
    });
    //         在图片中也可以不使用 class="lazy"，初始化时使用：
    // $("img").lazyload({effect: "fadeIn"});
    // 这样就可以对全局的图片都有效！
</script>
<%--延时加载图片end--%>

<script>
    function goCourse(pid,did) {
        console.log("A:" +pid,"B"+did);
        window.location = "${pageContext.request.contextPath}/courselist/list?pid=" + pid + "&did=" + did;
    };
    function plandetail(did) {
        console.log(did);
        window.location = "${pageContext.request.contextPath}/plan-detail/detail?id=" + did;
    };
</script>
</body>

</html>