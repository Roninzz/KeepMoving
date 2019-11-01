<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>个人中心</title>

    <!-- 加载layui框架样式 -->
    <link rel="stylesheet" href="${path}/css/user/bootstrap.css">
    <link rel="stylesheet" href="${path}/plugins/layui/css/layui.css">
    <link rel="stylesheet" href="${path}/css/person-center/person.css">
    <link rel="stylesheet" href="${path}/plugins/font-awesome/css/font-awesome.css">
    <link rel="stylesheet" href="${path}/css/person-center/animate.css">
    <link rel="stylesheet" href="${path}/css/person-center/style.css">
    <link rel="stylesheet" href="${path}/plugins/fullcalendar/css/fullcalendar.css">
    <link rel="stylesheet" href="${path}/plugins/fullcalendar/css/fullcalendar.print.css">
    <link rel="stylesheet" href="${path}/css/nav/nav.css">
</head>

<body>
    <!-- 响应式导航 begin -->
    <%@ include file="../nav/nav.jsp"%>
    <!-- 响应式导航 end -->


    <div class="layui-container">
        <div class="layui-row">
            <!-- 个人信息开始 -->
            <div class="person">
                <div class="person-img">
                    <img src="${path}/imgs/person-center/person-img.jpg" alt="个人头像">
                </div>
                <div class="person-name">
                    <span>${userBaseInfo.getUsername()}</span>
                    <c:if test="${userBaseInfo.gender == '男'}">
                        <i class="fa fa-mars" aria-hidden="true"></i>
                    </c:if>
                    <c:if test="${userBaseInfo.gender == '女'}">
                        <i class="fa fa-mercury" aria-hidden="true"></i>
                    </c:if>
                </div>
                <div class="person-intro">
                    <p>${userBaseInfo.getSignature()}</p>
                </div>
            </div>
            <!-- 个人信息结束 -->

            <div class="layui-tab layui-tab-brief" lay-filter="docDemoTabBrief">
                <ul class="layui-tab-title">
                    <li class="layui-this">正在训练</li>
                    <li>训练记录</li>
                    <li>我的评论</li>
                    <li>我的回复</li>

                </ul>
                <div class="layui-tab-content" style="height: 100px;">
                    <!-- 正在训练开始 -->
                    <div class="layui-tab-item layui-show">
                        <div class="wrapper wrapper-content">
                            <div class="row animated fadeInDown">
                                <div class="col-sm-9">
                                    <div class="ibox float-e-margins">
                                        <div class="ibox-title">
                                            <a><h5 id="go-plan">${plan}</h5></a>
                                        </div>
                                        <div class="ibox-content p-data">
                                            <div id="calendar"></div>

                                            <!-- 当前参与计划 -->
                                            <div class="data">
                                                <div class="join-plan-data" id="plan-data"></div>
                                                <p>当前参与计划完成度</p>
                                            </div>
                                        </div>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- 正在训练结束 -->

                    <!-- 训练记录开始 -->
                    <div class="layui-tab-item">

                        <div class="fit-plan">
                            <div class="plan-img">
                                <img src="${path}/imgs/person-center/planning.webp" alt="图片加载失败">
                            </div>
                            <div class="plan-title">
                                <span id="plan-name" style="margin-left: 20px;"></span>
                            </div>
                            <a id="btn-c" class="btn-calendar">
                                <i class="fa fa-calendar fa-2x" aria-hidden="true"></i>
                            </a>
                            <a id="restart" class="plan-start" target="_blank" style="margin-top: 10px;">重新开始训练</a>
                                <%--评分开始--%>
                            <div id="test2" style="margin-left: 30px; margin-top: 10px;" ></div>
                                <%--评分结束--%>
                        </div>

                    </div>
                    <!-- 训练记录结束 -->
                    <!-- 我的评论开始 -->
                    <div class="layui-tab-item">
                        <div class="wrapper wrapper-content">
                            <div class="row animated fadeInRight">
                                <div id="comment-page">
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- 我的评论结束 -->
                    <!-- 我的回复开始 -->
                    <div class="layui-tab-item">
                        <div class="wrapper wrapper-content">
                            <div class="row animated fadeInRight">
                                <div id="reply-page"></div>
                            </div>
                        </div>
                    </div>
                    <!-- 我的回复结束 -->
                </div>
            </div>
        </div>
    </div>

    <script src="https://cdn.bootcss.com/echarts/4.3.0-rc.2/echarts-en.common.js"></script>

    <script src="${path}/plugins/jquery/jquery.min.js"></script>
    <script src="${path}/plugins/layui/layui.all.js"></script>
    <script src="${path}/plugins/fullcalendar/js/jquery-ui.custom.min.js"></script>
    <script src="${path}/plugins/fullcalendar/js/fullcalendar.min.js"></script>
    <script src="${path}/plugins/fullcalendar/js/moment.min.js"></script>
    <script src="${path}/js/nav/nav.js"></script>
    <script>
        $(function(){
            $("#comment-page").load("${path}/person/comment");
        });

        $(function(){
            $("#reply-page").load("${path}/person/reply");
        });

        $("#go-plan").click(function () {
            if (${plan != "暂无任何训练计划"}){
                window.location.href = "${path}/plan-detail/detail?id="+${pid};
            }
        });

        $.get("http://localhost:8081/KeepMovingFiness/person/fit-record",{"uid":"${sessionScope.userInfo.userId}"},function (result) {
            if (result.flag == true){
                var data = result.data;
                $("#plan-name").text(data["planName"]);
                $("#btn-c").click(function () {
                    window.location.href = "${path}/plan-detail/detail?id="+data["id"];
                });
                $("#restart").click(function () {
                    window.location.href = "${path}/plan-detail/detail?id="+data["id"];
                });
            }
        })

    </script>


    <script>

        // 计划完成度
        // 初始化echarts实例
        var chart = echarts.init(document.getElementById("plan-data"));

        $.get("http://localhost:8081/KeepMovingFiness/person/data",{"uid":"${sessionScope.userInfo.userId}"},function(result){
            var data = result.data;
            var complete = data["complete"];
            var all = data["all"];
            var notComplete = all - complete;
            if (notComplete != complete){
                option = {
                    tooltip: {
                        trigger: 'item',
                        formatter: "{a} <br/>{b}: {c} ({d}%)"
                    },
                    series: [
                        {
                            name: '计划完成度',
                            type: 'pie',
                            radius: ['50%', '70%'],
                            avoidLabelOverlap: false,
                            label: {
                                normal: {
                                    show: false,
                                    position: 'center'
                                },
                                emphasis: {
                                    show: true,
                                    textStyle: {
                                        fontSize: '16',
                                        fontWeight: 'bold'
                                    }
                                }
                            },
                            labelLine: {
                                normal: {
                                    show: false
                                }
                            },
                            data: [
                                { value: complete, name: '已完成天数' },
                                { value: notComplete, name: '未完成天数' },
                            ]
                        }
                    ]
                };
                chart.setOption(option);
            } else {
                option = {
                    tooltip: {
                        trigger: 'item',
                        formatter: "{a} <br/>{b}: {c} ({d}%)"
                    },
                    series: [
                        {
                            name: '计划完成度',
                            type: 'pie',
                            radius: ['50%', '70%'],
                            avoidLabelOverlap: false,
                            label: {
                                normal: {
                                    show: false,
                                    position: 'center'
                                },
                                emphasis: {
                                    show: true,
                                    textStyle: {
                                        fontSize: '16',
                                        fontWeight: 'bold'
                                    }
                                }
                            },
                            labelLine: {
                                normal: {
                                    show: false
                                }
                            },
                            data: [
                                { value: all, name: '计划全部完成' }
                            ]
                        }
                    ]
                };
                chart.setOption(option);
            }

        });


        $(document).ready(function () {

            /* initialize the calendar
             -----------------------------------------------------------------*/
            var date = new Date();
            var d = date.getDate();
            var m = date.getMonth();
            var y = date.getFullYear();

            $('#calendar').fullCalendar({

                header: {
                    left: 'prev,next',
                    center: 'title'
                },
                droppable: true,
                backgroundColor: "#666666",
                editable: false,
                events: function(start,end,callback) {
                    $.get("http://localhost:8081/KeepMovingFiness/person/train?uid="+"${sessionScope.userInfo.userId}",success=function(result){
                        if (result.codeStatus == "OK"){
                           console.log(result);
                           var data = result.data;
                           var date = data["addTime"];
                           var startDate = new Date(data["addTime"]);
                           var events = [];

                           $.each(data["trainList"],function(index,element){
                               events.push({
                                   title: element,
                                   start: startDate,
                               });
                               startDate = addDate(startDate,1);
                           });
                       }
                        callback(events);
                    });
                }

            })
        });

        // 获取结束天数
        function addDate(date, days) {
            if(days == undefined || days == '') {
                 days = 1;
             }
            var date = new Date(date);
            date.setDate(date.getDate() + days);
            var month = date.getMonth() + 1;
            var day = date.getDate();
            var mm = "'" + month + "'";
            var dd = "'" + day + "'";
            //单位数前面加0
             if(mm.length == 3) {
                     month = "0" + month;
                 }
             if(dd.length == 3) {
                    day = "0" + day;
                }

             var time = date.getFullYear() + "-" + month + "-" + day;
             // console.log(time);
             // var date = new Date(time).format("yyyy-MM-dd");
             return time;
        }
    </script>

    <%--评分--%>
    <script>
        layui.use(['rate'], function(){
            var rate = layui.rate;
            rate.render({
                elem: '#test2'
                ,value: 3
                ,half: true
                ,text: true
                ,choose: function(value){
                    layer.msg('感谢您打了:'+value+'分!');
                    var userscore = {
                        userId: 9,
                        planId: 9,
                        score:value
                    }
                    $.post("score",userscore);
                    // value = 5;
                    rate.render({   //再一次渲染rate评分
                        elem: '#test2'
                        ,value: value   //设置value
                        ,half: true
                        ,text: true
                        ,readonly: true  //设置只读

                    });
                }
            })
        });

    </script>
    <%--评分结束--%>


</body>

</html>