<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>饮食健康</title>
    <!-- 加载layui框架样式 -->
    <link rel="stylesheet" href="${path}/plugins/layui/css/layui.css">
    <!-- 引入外部css样式 -->
    <link rel="stylesheet" href="${path}/css/food/food.css">
    <link rel="stylesheet" href="${path}/css/nav/nav.css">
</head>

<body>
    <!-- 响应式导航 begin -->
    <%@ include file="../nav/nav.jsp"%>

    <!-- 导航栏结束 -->
    <!-- 轮播图开始 -->
    <div class="layui-carousel" id="banner" style="margin: 0 auto;">
        <div carousel-item="">
            <div>
                <img src="${path}/imgs/foods/food-banner/banner01.jpg" alt="">
            </div>
            <div>
                <img src="${path}/imgs/foods/food-banner/banner02.jpg" alt="">
            </div>
            <div>
                <img src="${path}/imgs/foods/food-banner/banner03.jpg" alt="">
            </div>
            <div>
                <img src="${path}/imgs/foods/food-banner/banner04.jpg" alt="">
            </div>
            <div>
                <img src="${path}/imgs/foods/food-banner/banner05.jpg" alt="">
            </div>
        </div>
    </div>

    <!-- 轮播图结束 -->

    <!-- 主体内容开始 -->
    <div class="food-main">
        <!-- 内容标题 start -->
        <div class="food-title">
            <h3>常见食物分类</h3>
        </div>
        <!-- 内容标题 end -->

        <!-- 具体食物列表 start -->
        <div class="food-list">
            <ul>
                <li class="food-group">
                    <a href="${path}/food/food-detail">
                        <div class="food-img">
                            <img src="${path}/imgs/foods/food-detail/staple_food.png" alt="">
                        </div>
                        <div class="food-name">
                            <span>主食、杂粮</span>
                        </div>
                        <!-- 具体的食物 -->
                        <div class="food-detail">
                            <span>米饭，玉米(鲜)，馒头，燕麦片，面包</span>
                        </div>
                    </a>
                </li>
                <li class="food-group">
                    <a href="${path}/food/food-detail">
                        <div class="food-img">
                            <img src="${path}/imgs/foods/food-detail/egg-meat.png" alt="">
                        </div>
                        <div class="food-name">
                            <span>蛋类、肉类及制品</span>
                        </div>
                        <!-- 具体的食物 -->
                        <div class="food-detail">
                            <span>鸡蛋，猪肉(瘦)，鸡蛋（煮），鸡，火腿肠</span>
                        </div>
                    </a>
                </li>
                <li class="food-group">
                    <a href="${path}/food/food-detail">
                        <div class="food-img">
                            <img src="${path}/imgs/foods/food-detail/milk.png" alt="">
                        </div>
                        <div class="food-name">
                            <span>奶类及制品</span>
                        </div>
                        <!-- 具体的食物 -->
                        <div class="food-detail">
                            <span>酸奶，牛奶，酸奶(中脂)，酸奶(脱脂)，牛奶</span>
                        </div>
                    </a>
                </li>
                <li class="food-group">
                    <a href="${path}/food/food-detail">
                        <div class="food-img">
                            <img src="${path}/imgs/foods/food-detail/vegetables.png" alt="">
                        </div>
                        <div class="food-name">
                            <span>蔬菜、水果</span>
                        </div>
                        <!-- 具体的食物 -->
                        <div class="food-detail">
                            <span>苹果，香蕉，番茄，黄瓜，西瓜</span>
                        </div>
                    </a>
                </li>
                <li class="food-group">
                    <a href="${path}/food/food-detail">
                        <div class="food-img">
                            <img src="${path}/imgs/foods/food-detail/nut-soy.png" alt="">
                        </div>
                        <div class="food-name">
                            <span>坚果、大豆及制品</span>
                        </div>
                        <!-- 具体的食物 -->
                        <div class="food-detail">
                            <span>豆浆，豆浆（甜），豆腐，核桃(干)，豆腐(南)</span>
                        </div>
                    </a>
                </li>
                <li class="food-group">
                    <a href="${path}/food/food-detail">
                        <div class="food-img">
                            <img src="${path}/imgs/foods/food-detail/drink.png" alt="">
                        </div>
                        <div class="food-name">
                            <span>饮料</span>
                        </div>
                        <!-- 具体的食物 -->
                        <div class="food-detail">
                            <span>薄荷 玉米须茶，雀巢咖啡MIX【韩文版】，咖啡粉，麦斯威尔原味咖啡，黑咖啡</span>
                        </div>
                    </a>
                </li>
                <li class="food-group">
                    <a href="${path}/food/food-detail">
                        <div class="food-img">
                            <img src="${path}/imgs/foods/food-detail/oils.png" alt="">
                        </div>
                        <div class="food-name">
                            <span>食用油、油脂及制品</span>
                        </div>
                        <!-- 具体的食物 -->
                        <div class="food-detail">
                            <span>色拉油，花生油，豆油，混合油(菜+棕)，葵花籽油</span>
                        </div>
                    </a>
                </li>
                <li class="food-group">
                    <a href="${path}/food/food-detail">
                        <div class="food-img">
                            <img src="${path}/imgs/foods/food-detail/condiment.png" alt="">
                        </div>
                        <div class="food-name">
                            <span>调味品</span>
                        </div>
                        <!-- 具体的食物 -->
                        <div class="food-detail">
                            <span>蜂蜜，蜂蜜（槐花），红糖，榨菜，白砂糖</span>
                        </div>
                    </a>
                </li>
                <li class="food-group">
                    <a href="${path}/food/food-detail">
                        <div class="food-img">
                            <img src="${path}/imgs/foods/food-detail/snack.png" alt="">
                        </div>
                        <div class="food-name">
                            <span>零食、点心</span>
                        </div>
                        <!-- 具体的食物 -->
                        <div class="food-detail">
                            <span>饼干，蛋糕(黄蛋糕)，薄荷松仁粽子糖，巧克力</span>
                        </div>
                    </a>
                </li>
                <li class="food-group">
                    <a href="${path}/food/food-detail">
                        <div class="food-img">
                            <img src="${path}/imgs/foods/food-detail/health.png" alt="">
                        </div>
                        <div class="food-name">
                            <span>养身</span>
                        </div>
                        <!-- 具体的食物 -->
                        <div class="food-detail">
                            <span>枸杞子，绿芙蓉龟苓膏（罐装），油面筋，陈皮，栝楼根粉</span>
                        </div>
                    </a>
                </li>
                <li class="food-group">
                    <a href="${path}/food/food-detail">
                        <div class="food-img">
                            <img src="${path}/imgs/foods/food-detail/staple_food.png" alt="主食">
                        </div>
                        <div class="food-name">
                            <span>菜肴</span>
                        </div>
                        <!-- 具体的食物 -->
                        <div class="food-detail">
                            <span>炒空心菜，绿豆汤，素炒小白菜，蜂蜜柠檬水，烧茄子</span>
                        </div>
                    </a>
                </li>
            </ul>
        </div>
        <!-- 具体食物列表 end -->
    </div>


    <!-- 主体内容结束 -->
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