<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="${path}/plugins/layui/css/layui.css">
    <link rel="stylesheet" href="${path}/css/fit-action/fit-action.css">
    <link rel="stylesheet" href="${path}/css/nav/nav.css">

    <title>健身动作</title>
</head>

<body>
    <!-- 响应式导航 begin -->
    <%@ include file="../nav/nav.jsp"%>
    <!-- 导航栏结束 -->

    <div class="action">
        <div class="action-main">
            <div class="action-img">
                <a href="${path}/action/action-detail" target="_blank">
                    <img src="${path}/imgs/fit-action/action.jpg" alt="臀桥">
                </a>
            </div>
            <div class="action-name">
                <span>臀桥</span>
            </div>
        </div>

        <div class="action-main">
            <div class="action-img">
                <a href="${path}/action/action-detail" target="_blank">
                    <img src="${path}/imgs/fit-action/action02.jpg" alt="腹肌激活">
                </a>
            </div>
            <div class="action-name">
                <span>腹肌激活</span>
            </div>
        </div>
        <div class="action-main">
            <div class="action-img">
                <a href="${path}/action/action-detail" target="_blank">
                    <img src="${path}/imgs/fit-action/action03.jpg" alt="四点支撑">
                </a>
            </div>
            <div class="action-name">
                <span>四点支撑</span>
            </div>
        </div>
        <div class="action-main">
            <div class="action-img">
                <a href="${path}/action/action-detail" target="_blank">
                    <img src="https://static1.keepcdn.com/thumbnail/2016/5/26/yogathumbnail135.jpg" alt="坐姿右侧拉伸">
                </a>
            </div>
            <div class="action-name">
                <span>坐姿右侧拉伸</span>
            </div>
        </div>
        <div class="action-main">
            <div class="action-img">
                <a href="${path}/action/action-detail" target="_blank">
                    <img src="https://static1.keepcdn.com/picture/2016/05/26/11/553ac4df32800000.jpg" alt="坐姿左侧拉伸">
                </a>
            </div>
            <div class="action-name">
                <span>坐姿左侧拉伸</span>
            </div>
        </div>
        <div class="action-main">
            <div class="action-img">
                <a href="${path}/action/action-detail" target="_blank">
                    <img src="https://static1.keepcdn.com/thumbnail/2016/5/26/yogathumbnail135.jpg" alt="四角支撑式">
                </a>
            </div>
            <div class="action-name">
                <span>四角支撑式</span>
            </div>
        </div>
        <div class="action-main">
            <div class="action-img">
                <a href="${path}/action/action-detail" target="_blank">
                    <img src="https://static1.keepcdn.com/thumbnail/2016/5/26/yogathumbnail136.jpg" alt="左侧穿针式">
                </a>
            </div>
            <div class="action-name">
                <span>左侧穿针式</span>
            </div>
        </div>
        <div class="action-main">
            <div class="action-img">
                <a href="${path}/action/action-detail" target="_blank">
                    <img src="https://static1.keepcdn.com/thumbnail/2016/5/26/yogathumbnail144.jpg" alt="简易上犬式">
                </a>
            </div>
            <div class="action-name">
                <span>简易上犬式</span>
            </div>
        </div>
        <div class="action-main">
            <div class="action-img">
                <a href="${path}/action/action-detail" target="_blank">
                    <img src="https://static1.keepcdn.com/thumbnail/2016/5/26/yogathumbnail148.jpg" alt="右侧低弓步扭转">
                </a>
            </div>
            <div class="action-name">
                <span>右侧低弓步扭转</span>
            </div>
        </div>
        <div class="action-main">
            <div class="action-img">
                <a href="${path}/action/action-detail" target="_blank">
                    <img src="https://static1.keepcdn.com/picture/2016/05/26/11/553ac54f2bc00000.jpg" alt="半站姿前屈">
                </a>
            </div>
            <div class="action-name">
                <span>半站姿前屈</span>
            </div>
        </div>
        <div class="action-main">
            <div class="action-img">
                <a href="${path}/action/action-detail" target="_blank">
                    <img src="https://static1.keepcdn.com/thumbnail/2016/5/26/yogathumbnail158.jpg" alt="左侧半神猴式">
                </a>
            </div>
            <div class="action-name">
                <span>左侧半神猴式</span>
            </div>
        </div>
        <div class="action-main">
            <div class="action-img">
                <a href="${path}/action/action-detail" target="_blank">
                    <img src="https://static1.keepcdn.com/thumbnail/2016/5/26/yogathumbnail161.jpg" alt="八支式">
                </a>
            </div>
            <div class="action-name">
                <span>八支式</span>
            </div>
        </div>
    </div>


    <!-- 主体内容结束 -->
    <script src="${path}/plugins/layui/layui.js"></script>

</body>

</html>