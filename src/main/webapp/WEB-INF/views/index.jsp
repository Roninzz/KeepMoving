<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.net.URLDecoder" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="nav/nav.jsp" %>
<!DOCTYPE html>
<html lang='en'>
<head>
    <meta charset='UTF-8'>
    <meta name='viewport' content='width=device-width, initial-scale=1.0'>
    <meta http-equiv='X-UA-Compatible' content='ie=edge'>
    <title>KeepMoving</title>
    <link rel="stylesheet" href="${path}/css/index/index.css">
    <link rel="stylesheet" href="${path}/plugins/index/1.css">
    <link rel="stylesheet" href="${path}/plugins/index/2.css">
    <link rel="stylesheet" href="${path}/plugins/index/3.css">
    <link rel="stylesheet" href="${path}/plugins/layui/css/layui.css">
    <link rel="stylesheet" href="${path}/css/nav/nav.css">

    <link rel="stylesheet" href="http://cache.amap.com/lbs/static/main1119.css"/>
</head>
<body>
<script src="http://cache.amap.com/lbs/static/es5.min.js"></script>
<script type="text/javascript" src="https://webapi.amap.com/maps?v=1.4.15&key=86b55ba09229724ff90fd03195b637e4"></script>
<script src="//webapi.amap.com/ui/1.0/main.js?v=1.0.11"></script>





<%--<!-- 响应式导航 begin -->--%>


<!-- 响应式导航 end -->

<div class="video-large-wrap" style="display: none;">
    <div id="video-close">
        <!-- <i class="keep-icon-close"></i> -->
    </div>
    <video src="${path}/video/index.mp4" controls></video>
</div>


<script>
    (function () {
        var height = window.innerHeight,
            width = document.body.clientWidth;
        if (typeof height != 'number') {
            height = document.body.clientHeight;
        }
        var ratio = height / width;
        document.write('<style>.video-head-wrap{padding-bottom:' + ratio * 100 + '% !important;}.body-wrap{padding-top:' + ratio * 100 + '%;}</style>');
        //背景视频为1280*720
        if (ratio > (720 / 1280)) {
            var leftOffset = -(height * 1280 / 720 - width) / 2;
            document.write('<style>#video-bg{height:100%;margin-left:' + leftOffset + 'px;}</style>');
        } else {
            var topOffset = -(width * 720 / 1280 - height) / 2;
            document.write('<style>#video-bg{width:100%;margin-top:' + topOffset + 'px;}</style>');
        }
    })();
</script>

<div class="body-wrap">

    <!-- 上部视频开始 -->
    <div id="div1">
        <header class="video-head-wrap" style="z-index: -1;">
            <a href="#plan">
                <div class="video-container">
                    <div id="div1"></div>
                    <video id="video-bg" src="${path}/video/index.mp4" muted="" autoplay="" loop="">
                    </video>

                    <div class="video-control" id="jump" style="background: rgba(34,34,34,0.8);opacity: 0.6;">
                        <img style="opacity: 1;" src="${path}/imgs/index/index-text.png" alt="">

                    </div>

                    <div class="video-bottom">
                        <div class="bottom-left">Keep Moving<br><br>运动使我快乐!</div>

                    </div>
                </div>
            </a>

        </header>
        <!-- 上部视频结束 -->

    </div>
</div>
<!-- 视频--课程展示中间文字 -->
<div class="content-wrap" style=" height: 100px; z-index:500;">
    <section>
        <div class="paragraph" id="plan">
            <div class="para-title">热门的健身计划</div>
            <div class="para-text">网罗最热门的健身计划。让你在健身中享受过程，在健康中体验快乐！</div>

        </div>
        <div class="training-wrap">
            <div class="training-wrap-inner">
                <div class="training-block">
                    <c:forEach items="${pageContext.request.getAttribute('hotplan')}" begin="0" end="3" var="u">
                        <a href="${path}/plan/plan-index.html" style="background-image: url('${u.planImgUrl}')" class="training-item">
                            <div class="training-detail">
                                <div class="training-title">热门计划</div>
                            </div>
                        </a>
                    </c:forEach>

                </div>
                <div class="training-text">
                    <div class="text-title">同步训练</div>
                    <div class="text-cont">同步你的训练进度,畅享自由。</div>
                </div>
                <div class="body-pic-wrap">
                    <img src="${path}/imgs/index/4.png" class="body-pic">
                    <img src="${path}/imgs/index/5.png" class="circle-pic">
                </div>


            </div>
        </div>
    </section>
    <section>
        <div class="paragraph community-para">
            <div class="para-title">实时健身用户推送</div>
            <div class="para-text">别人在努力改变自己的时候，你在干什么？快快加入进来吧！</div>
        </div>
        <div class="users-wrap">
            <div class="users-text">
                <div class="users-title">
                    <div>他们,在运动!</div>
                </div>
                <div class="users-cont">滴下的每一滴汗水,都是你日后的收获!</div>
            </div>

            <hr style="color: black; height: 2px;">
            <div class="user-list-wrapp" style="margin-right: 400px; margin-top: 80px; float:right;">
                <div class="scrollbox">
                    <div id="scrollDiv">
                        <ul>
                            <c:forEach items="${pageContext.request.getAttribute('hotplan')}" var="h">
                                <li>
                                    <h3><a href="#" class="linktit">${h.userName}</a></h3>
                                    <div>加入了:${h.planName}呦!</div>
                                </li>
                            </c:forEach>

                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <section>

        <div class="run-wrap">
            <%--<div style="background-color:rgb(58, 58, 58); height: 100%;" id="map">--%>
            <div style="height: 100%; z-index: 1;opacity: 0.7;overflow: inherit;" id="map">
                <div class="run-wrap-inner" style="z-index: 6">
                    <div class="run-tack-wrap">
                        <img src="${path}/imgs/index/road.png">

                    </div>
                </div>

                <div class="run-config-wrap" style="z-index: 9">
                    <div class="run-config-pace">
                        <div class="config-title"><i class="keep-icon-speed"></i><span>看看大家一周的运动热情</span></div>
                        <div class="config-cont"><span>网站跑步消耗卡路里</span></div>
                        <div class="speed-bar speed-bar1">
                            <div class="speed-bar-fill"></div>
                        </div>
                        <div class="speed-bar speed-bar2">
                            <div class="speed-bar-fill"></div>
                        </div>
                        <div class="speed-bar speed-bar3">
                            <div class="speed-bar-fill"></div>
                        </div>
                        <div class="speed-bar speed-bar4">
                            <div class="speed-bar-fill"></div>
                        </div>
                        <div class="speed-bar speed-bar5">
                            <div class="speed-bar-fill"></div>
                        </div>
                        <div class="speed-bar speed-bar6">
                            <div class="speed-bar-fill"></div>
                        </div>
                        <div class="speed-bar speed-bar7">
                            <div class="speed-bar-fill"></div>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </section>
</div>

<script src="${path}/plugins/jquery/jquery.min.js" type="text/javascript"></script>
<script src="${path}/plugins/jquery/jq_scroll.js" type="text/javascript"></script>
<script type="text/javascript" src="https://cache.amap.com/lbs/static/addToolbar.js"></script>

<script type="text/javascript">
    var map = new AMap.Map('map', {
        resizeEnable: true,
        zoom:11,
        center: [116.397428, 39.90923]//默认的地图中心经纬度
    });
</script>


<script>

        //定位
        map.plugin('AMap.Geolocation', function () {
            geolocation = new AMap.Geolocation({
                enableHighAccuracy: true,//是否使用高精度定位，默认:true
                timeout: 10000,          //超过10秒后停止定位，默认：无穷大
                maximumAge: 0,           //定位结果缓存0毫秒，默认：0
                convert: true,           //自动偏移坐标，偏移后的坐标为高德坐标，默认：true
                showButton: true,        //显示定位按钮，默认：true
                buttonPosition: 'LB',    //定位按钮停靠位置，默认：'LB'，左下角
                buttonOffset: new AMap.Pixel(10, 20),//定位按钮与设置的停靠位置的偏移量，默认：Pixel(10, 20)
                showMarker: true,        //定位成功后在定位到的位置显示点标记，默认：true
                showCircle: true,        //定位成功后用圆圈表示定位精度范围，默认：true
                panToLocation: true,     //定位成功后将定位到的位置作为地图中心点，默认：true
                zoomToAccuracy:true      //定位成功后调整地图视野范围使定位位置及精度范围视野内可见，默认：false
            });
            map.addControl(geolocation);
            geolocation.getCurrentPosition();
            AMap.event.addListener(geolocation, 'complete', onComplete);//返回定位信息
            AMap.event.addListener(geolocation, 'error', onError);      //返回定位出错信息
        });

        //解析定位结果
        function onComplete(data) {
            if(data.status == 1){
                console.log("定位成功");
                $("#addressInput").val(data.formattedAddress);
                sessionStorage.setItem("dingWei-lng",data.position.getLng());
                sessionStorage.setItem("dingWei-lat",data.position.getLat());
            }
            var str = [];
            str.push('经度：' + data.position.getLng());
            str.push('纬度：' + data.position.getLat());
            str.push('是否经过偏移：' + (data.isConverted ? '是' : '否'));
            console.log(str.join('<br>'));
        }
        function onError() {
            var str = [];
            str.push('定位失败');
            console.log(str.join('<br>'));
        }


</script>




<%--<script src="${path}/js/nav/nav.js"></script>--%>
<script>
    $(document).scroll(function () {
        if ($(document).scrollTop() > 60) {
            $("#o-header").addClass('o-header')
        } else {
            $("#o-header").removeClass('o-header')
        }
    })
</script>

<script type="text/javascript">
    $(document).ready(function () {
        $("#scrollDiv").Scroll({line: 1, speed: 600, timer: 2000, up: "but_up", down: "but_down"});
    });

</script>
</body>

</html>