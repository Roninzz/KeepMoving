<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <link rel="stylesheet" href="${path}/plugins/layui/css/layui.css">
    <link rel="stylesheet" href="${path}/css/nav/nav.css">
    <link rel="stylesheet" href="${path}/css/action/action.css">
    <script src="https://cdn.bootcss.com/video.js/7.6.5/alt/video-js-cdn.css"></script>
    <title>动作视频</title>
    <style>
        .daohang{margin:15px 0px 15px 0px;}
    </style>
</head>

<body>
    <!-- 响应式导航 begin -->
    <%@ include file="../nav/nav.jsp"%>
    <!-- 响应式导航 end -->


    <div class="action">
        <!--面包屑导航开始-->
        <div class="daohang">
            <span class="layui-breadcrumb">
                <a href="${path}/action/action-list">健身动作</a>
                <a><cite>动作视频</cite></a>
            </span>
        </div>
        <!-- 面包屑导航结束 -->
        <div class="action-video">
            <video id="video" controls class="video-js vjs-default-skin">
                <source src="${path}/video/action/action.mp4" type="video/mp4">
                <source src="${path}/video/action/action.ogg" type="video/ogg">
            </video>
        </div>

        <div class="action-direction">
            <div class="name">
                <span>简易死虫式</span>
            </div>
            <div class="action-tutorial">
                <ul style="margin-left: -10px;">
                    <li>躺于垫上，手臂伸直举起，与地面呈90°，屈膝抬腿，大腿与地面呈90°</li>
                    <li>臀下部微微离地，让腰部压紧地面，异侧手臂和腿分别下放至与地面呈30°</li>
                    <li>下放时腰部始终保持贴地</li>
                    <li>保持身体平衡，不要晃动</li>
                </ul>
            </div>
        </div>
    </div>
    <!-- 训练计划日历 结束 -->
    <script src="${path}/plugins/layui/layui.js"></script>
    <script src="${path}/js/nav/nav.js"></script>
    <script src="${path}/plugins/jquery/jquery.min.js"></script>

</body>

</html>