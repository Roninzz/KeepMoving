<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML>
<html lang="en">

<head>

    <!-- Meta tag Keywords -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="keywords" content="XXX" />
    <title>饮食详情</title>
    <link rel="stylesheet" href="${path}/plugins/layui/css/layui.css">
    <link rel="stylesheet" href="${path}/css/food-detail/food-detail.css">
    <link rel="stylesheet" href="${path}/css/nav/nav.css">
</head>

<body>
    <!-- 响应式导航 begin -->
    <%@ include file="../nav/nav.jsp"%>
    <!-- 响应式导航 end -->


    <!-- 轮播图开始 -->
    <div class="layui-container banner">
        <div class="layui-carousel" id="banner" style="margin: 0 auto;">
            <div carousel-item="">
                <div>
                    <img src="${path}/imgs/foods/food-banner/banner01.jpg" alt="">
                </div>
                <div>
                    <img src="${path}/static/imgs/foods/food-banner/banner02.jpg" alt="">
                </div>
                <div>
                    <img src="${path}/static/imgs/foods/food-banner/banner03.jpg" alt="">
                </div>
                <div>
                    <img src="${path}/static/imgs/foods/food-banner/banner04.jpg" alt="">
                </div>
                <div>
                    <img src="${path}/static/imgs/foods/food-banner/banner05.jpg" alt="">
                </div>
            </div>
        </div>
    </div>

    <!-- 轮播图结束 -->


    <div class="layui-container" id="food2">
        <div class="layui-col-md12">
            <div class="layui-breadcrumb" style="font-size: 14px;">
                <span>当前位置：</span>
                <span ><a href="food.jsp" style="font-size: 14px;">饮食健康</a> / </span>
                <span>饮食详情</span>
            </div>
        </div>
    </div>


    <div class="layui-container" id="food3" style="margin-top:20px; ">
        <div class="layui-col-md8" style="border: 1px solid rgb(236, 233, 233);padding-left:10px;height: 40px;line-height: 40px;box-shadow: -1px -2px Azure;">
            <span>谷薯芋、杂豆、主食</span>
        </div>

        <div class="layui-col-md8" style="border: 1px solid rgb(236, 233, 233);height: 80px;line-height: 80px;box-shadow: -1px -2px Azure;">
            <!-- <img src="../imgs/foods/food-detail/mantou.webp" width="50px" height="50px">
                    <h3>馒头</h3> -->
            <a href="#" target="_blank">
                <div class="layui-col-md1" style="height:80px;padding-left:10px;">
                    <img src="${path}/imgs/foods/food-detail/mantou.webp" width="50px" height="50px" alt="馒头">
                </div>
                <div class="layui-col-md11" style="height: 80px;padding-left:10px;">
                    <h6 style="display:inline">馒头</h6>
                    <span>热量：116 大卡（100克）</span>
                </div>
            </a>

        </div>

        <div class="layui-col-md8"
            style="border: 1px solid rgb(236, 233, 233);height: 80px;line-height: 80px;overflow: hidden;box-shadow: -1px -2px Azure;">
            <!-- <img src="../imgs/foods/food-detail/mantou.webp" width="50px" height="50px">
                        <h3>馒头</h3> -->
            <a href="#" target="_blank">
                <div class="layui-col-md1" style="height:80px;padding-left:10px;">
                    <img src="${path}/imgs/foods/food-detail/yanmai.webp" width="50px" height="50px" alt="燕麦">
                </div>
                <div class="layui-col-md11" style="height: 80px;padding-left:10px;">
                    <h6 style="display:inline">燕麦</h6>
                    <span>热量：367 大卡（100克）</span>
                </div>
            </a>
        </div>
        <div class="layui-col-md8"
            style="border: 1px solid rgb(236, 233, 233);height: 80px;line-height: 80px;overflow: hidden;box-shadow: -1px -2px Azure;">
            <!-- <img src="../imgs/foods/food-detail/mantou.webp" width="50px" height="50px">
                <h3>馒头</h3> -->
            <a href="#" target="_blank">
                <div class="layui-col-md1" style="height:80px;padding-left:10px;">
                    <img src="${path}/imgs/foods/food-detail/yumi.webp" width="50px" height="50px" alt="玉米">
                </div>
                <div class="layui-col-md11" style="height: 80px;padding-left:10px;">
                    <h6 style="display:inline">玉米</h6>
                    <span>热量：312 大卡（100克）</span>
                </div>
            </a>

        </div>

        <div class="layui-col-md8"
            style="border: 1px solid rgb(236, 233, 233);height: 80px;line-height: 80px;overflow: hidden;box-shadow: -1px -2px Azure;">
            <!-- <img src="../imgs/foods/food-detail/mantou.webp" width="50px" height="50px">
                    <h3>馒头</h3> -->
            <a href="#" target="_blank">
                <div class="layui-col-md1" style="height:80px;padding-left:10px;">
                    <img src="${path}/imgs/foods/food-detail/zhou.webp" width="50px" height="50px" alt="粥">
                </div>
                <div class="layui-col-md11" style="height: 80px;padding-left:10px;">
                    <h6 style="display:inline">粥</h6>
                    <span>热量：221 大卡（100克）</span>
                </div>
            </a>

        </div>

        <div class="layui-col-md8"
            style="border: 1px solid rgb(236, 233, 233);height: 80px;line-height: 80px;overflow: hidden;box-shadow: -1px -2px Azure;">
            <!-- <img src="../imgs/foods/food-detail/mantou.webp" width="50px" height="50px">
                        <h3>馒头</h3> -->
            <a href="#" target="_blank">
                <div class="layui-col-md1" style="height:80px;padding-left:10px;">
                    <img src="${path}/imgs/foods/food-detail/miantiao.webp" width="50px" height="50px" alt="面条">
                </div>
                <div class="layui-col-md11" style="height: 80px;padding-left:10px;">
                    <h6 style="display:inline">面条</h6>
                    <span>热量：284 大卡（100克）</span>
                </div>
            </a>

        </div>

        <div class="layui-col-md8"
            style="border: 1px solid rgb(236, 233, 233);height: 80px;line-height: 80px;overflow: hidden;box-shadow: -1px -2px Azure;">
            <!-- <img src="../imgs/foods/food-detail/mantou.webp" width="50px" height="50px">
                            <h3>馒头</h3> -->
            <a href="#" target="_blank">
                <div class="layui-col-md1" style="height:80px;padding-left:10px;">
                    <img src="${path}/imgs/foods/food-detail/youtiao.webp" width="50px" height="50px" alt="油条">
                </div>
                <div class="layui-col-md11" style="height: 80px;padding-left:10px;">
                    <h6 style="display:inline">油条</h6>
                    <span>热量：255 大卡（100克）</span>
                </div>
            </a>

        </div>

        <div class="layui-col-md8" style="border: 1px solid rgb(236, 233, 233);height: 80px;line-height: 80px;box-shadow: -1px -2px Azure;">
            <!-- <img src="../imgs/foods/food-detail/mantou.webp" width="50px" height="50px">
                        <h3>馒头</h3> -->
            <a href="#" target="_blank">
                <div class="layui-col-md1" style="height:80px;padding-left:10px;">
                    <img src="${path}/imgs/foods/food-detail/laobing.webp" width="50px" height="50px" alt="馒头">
                </div>
                <div class="layui-col-md11" style="height: 80px;padding-left:10px;">
                    <h6 style="display:inline">烙饼</h6>
                    <span>热量：386 大卡（100克）</span>
                </div>
            </a>

        </div>

        <div class="layui-col-md8" style="border: 1px solid rgb(236, 233, 233);height: 80px;line-height: 80px;box-shadow: -1px -2px Azure;">
            <!-- <img src="../imgs/foods/food-detail/mantou.webp" width="50px" height="50px">
                            <h3>馒头</h3> -->
            <a href="#" target="_blank">
                <div class="layui-col-md1" style="height:80px;padding-left:10px; ">
                    <img src="${path}/imgs/foods/food-detail/mianbao.webp" width="50px" height="50px" alt="馒头">
                </div>
                <div class="layui-col-md11" style="height: 80px;padding-left:10px;">
                    <h6 style="display:inline">面包</h6>
                    <span>热量：117 大卡（100克）</span>
                </div>
            </a>

        </div>


        <div class="layui-col-md4" id="food4">
            <table>
                <tr>
                    <td>常见食物分类</td>
                </tr>
                <tr>
                    <td><a>谷薯芋、杂豆、主食</a>， <a>蛋类、肉类及制品</a>， <a>奶类及制品</a></td>
                </tr>
                <tr>
                    <td><a>蔬果和菌藻</a>， <a>坚果、大豆及制品</a>， <a>饮料</a></td>
                </tr>
                <tr>
                    <td><a>蔬果和菌藻</a>， <a>坚果、大豆及制品</a>， <a>饮料</a></td>
                </tr>
                <tr>
                    <td><a>蔬果和菌藻</a>， <a>坚果、大豆及制品</a>， <a>饮料</a></td>
                </tr>
            </table>
        </div>
    </div>

    <!-- 底部begin -->
    <!-- <div>

    </div> -->
    <!-- 底部end -->


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

    <script>
        layui.use(['carousel', 'form'], function () {
            var carousel = layui.carousel
                , form = layui.form;


            //改变下时间间隔、动画类型、高度
            carousel.render({
                elem: '#banner'
                , interval: 1800
                , anim: 'fade'
                , width: '990px'
                , height: '360px'
                , indicator: 'inside'
            });
        });
    </script>


</body>

</html>