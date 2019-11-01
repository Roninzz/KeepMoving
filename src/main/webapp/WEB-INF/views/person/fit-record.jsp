<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>更多训练记录</title>
    <link rel="stylesheet" href="${path}/plugins/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="${path}/plugins/font-awesome/css/font-awesome.css" media="all">
    <link rel="stylesheet" href="${path}/css/fit-record/fit-record.css">
    <link rel="stylesheet" href="${path}/css/nav/nav.css">
</head>

<body>
     <!-- 响应式导航 begin -->
     <%@ include file="../nav/nav.jsp"%>
        <!-- 响应式导航 end -->

    <div class="layui-container">
        <div class="layui-row">
            <!--面包屑导航开始-->
            <div class="daohang">
                <span class="layui-breadcrumb">
                    <a href="${path}/person/center">个人中心</a>
                    <a><cite>更多健身记录</cite></a>
                </span>
            </div>
            <!-- 面包屑导航结束 -->
            <div class="layui-tab layui-tab-brief" lay-filter="docDemoTabBrief">
                <ul class="layui-tab-title">
                    <li class="layui-this">未完成</li>
                    <li>已完成</li>
                </ul>
                <div class="layui-tab-content">
                    <div class="layui-tab-item layui-show">
                        <div class="layui-row layui-col-space1">

                                <div class="fit-plan ">
                                    <div class="plan-img">
                                        <img src="${requestScope.nplan.url}" alt="图片加载失败">
                                    </div>
                                    <div class="plan-title">
                                        <span>第一阶段</span>
                                        <span>第一天</span>
                                        <span>${requestScope.nplan.planName}</span>
                                    </div>
                                    <a href="#" class="btn-calendar">
                                        <i class="fa fa-calendar fa-2x" aria-hidden="true"></i>
                                    </a>

                                    <div class="plan-target">
                                        <a href="#" class="btn-check">
                                            <i class="fa fa-check-circle-o fa-2x" aria-hidden="true"></i>
                                        </a>
                                        <p>腹肌唤醒</p>
                                    </div>

                                    <a href="#" class="plan-start" target="_blank">开始训练</a>
                                </div>


                        </div>
                    </div>
                    <div class="layui-tab-item">
                        <div class="layui-row layui-col-space1">
                        <c:forEach items="${requestScope.plans}" var="p">
                            <div class="fit-plan ">
                                <div class="plan-img">
                                    <img src="${p.url}" alt="图片加载失败">
                                </div>
                                <div class="plan-title">
                                    <span>第一阶段</span>
                                    <span>第一天</span>
                                    <span>${p.planName}</span>
                                </div>
                                <a href="#" class="btn-calendar">
                                    <i class="fa fa-calendar fa-2x" aria-hidden="true"></i>
                                </a>

                                <div class="plan-target">
                                    <a href="#" class="btn-check">
                                        <i class="fa fa-check-circle-o fa-2x" aria-hidden="true"></i>
                                    </a>
                                    <p>腹肌唤醒</p>
                                </div>

                                <a href="#" class="plan-start" target="_blank">重新训练</a>
                            </div>
                        </c:forEach>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </div>
    </div>

    <script src="${path}/plugins/layui/layui.js" charset="utf-8"></script>
    <script src="${path}/js/nav/nav.js"></script>
    <script>
        layui.use('element', function () {
            var $ = layui.jquery
                , element = layui.element; //Tab的切换功能，切换事件监听等，需要依赖element模块

        });
    </script>
</body>

</html>