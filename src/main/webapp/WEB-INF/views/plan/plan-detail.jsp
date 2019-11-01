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
    <link rel="stylesheet" href="${path}/plugins/font-awesome/css/font-awesome.css">
    <link rel="stylesheet" href="${path}/css/user/bootstrap.css">
    <!-- Sweet Alert -->
    <link href="${path}/css/user/sweetalert.css" rel="stylesheet">
    <link rel="stylesheet" href="${path}/css/person-center/animate.css">
    <link rel="stylesheet" href="${path}/css/person-center/style.css">
    <link rel="stylesheet" href="${path}/css/plan-detail/plan-detail.css">

    <style>
        .joinPlan::before{
           content: "¥99.8";
            color: red;
        }
        .plan-detail .joinPlan{
            top:26px;
            width: 162px;
        }
    </style>


    <title>计划介绍</title>
    
</head>

<body>
<%--<%@ include file="../nav/nav.jsp"%>--%>
    <!-- 响应式导航 begin -->
    <%@ include file="../nav/nav.jsp"%>
    <!-- 响应式导航 end -->
    <!-- 计划详情开始 -->
    <div class="plan-detail-title">
        <div class="plan-title">
            <h2 id="planName"></h2>
            <div class="plan-introduction">
                <span id="plan-introduction"></span>
            </div>
        </div>
    </div>

    <!-- 训练计划日历 开始 -->
    <div class="plan">
        <!--计划详情开始-->
        <div class="plan-detail"></div>

        <!-- 计划详情结束 -->

        <!--面包屑导航开始-->
        <div class="daohang">
            <span class="layui-breadcrumb">
                <a href="${path}/plan/plan-index.html">所有训练计划</a>
                <a><cite>计划日历</cite></a>
            </span>
        </div>
        <!-- 面包屑导航结束 -->
        <div id="plan-calender"></div>
    </div>
    <!-- 训练计划日历 结束 -->

    <!-- 评论开始 -->
    <div class="container comment">
        <div class="comment-all">
            <div class="c-com">
                <span>评论</span>
            </div>
            <div class="c-num">
                <span id="commentNum"></span>
            </div>
        </div>

        <div class="user-comment">
            <div class="social-comment">
                <a href="" class="pull-left user-img">
                    <img alt="image" src="${path}/imgs/person-center/girl.jpg">
                </a>
                <div class="media-body context">
                    <textarea class="form-control" id="comment-text" placeholder="说点什么吧..." rows="3"></textarea>
                </div>

                <div class="fabiao">
                    <button type="button" id="c-btn" class="btn btn-primary">发表评论</button>
                </div>
            </div>
        </div>

        <div class="wrapper wrapper-content">
            <div class="row">
                <div class="col-md-11" id="comment">
                    <!-- 用户单条评论及多条回复 -->

                </div>
            </div>
        </div>

        <!-- 底部分页 -->
        <div class="page">
            <div id="comment-page"></div>
        </div>
    </div>
    <!-- 评论结束 -->

<script src="${path}/plugins/layui/layui.all.js"></script>
<script src="${path}/plugins/jquery/jquery.min.js"></script>
<script src="${path}/js/user/bootstrap.min.js"></script>
<script src="${path}/js/user/content.js"></script>
<script src="${path}/js/user/sweetalert.min.js"></script>
<script src="${path}/js/nav/nav.js"></script>

<%--当用户点击添加训练计划的时候,将对应的计划id发送到后台--%>
<script type="text/javascript">
    var flage = 0;
    if (${sessionScope.userInfo.userId != null}){
        data={"pid":${pid},"uid":"${sessionScope.userInfo.userId}"}
    } else {
        data={"pid":${pid},"uid":"0"}
    }

    $.get("http://localhost:8081/KeepMovingFiness/plan-detail/plan-data",
        data,
        success=function(data){
            var data = data.data;
            var flage = data["flage"];
            $("#planName").html(data["plan"].planName);
            $("#plan-introduction").html(data["plan"].planIntroduction);
            var join = "";
            if (flage == 0) {
                join = "                        <button class=\"btn btn-danger btn-sm demo4\" >+加入训练计划</button>\n"
            }else{
                join = "                        <button class=\"btn btn-default btn-sm demo3\">-取消训练计划</button>\n"
            }
            var plan =
                "                <div class=\"title-plan\">\n" +
                "                    <h2>"+data["plan"].planName+"</h2>\n" +
                "                </div>\n" +
                "                <div class=\"plan-info\">\n" +
                "                    <span>课时: "+data["plan"].planWeek+"周</span>\n" +
                "                    <span>天/周: "+data["plan"].planDay+"天</span>\n" +
                "                    <span>评分: "+data["planScore"]+"</span>\n" +
                "                    <span>难度: H"+data["plan"].planDifficult+"</span>\n" +
                "                    <span>参与人数: "+data["plan"].planNum+"人</span>\n" +
                "                    <button class=\"btn btn-white btn-xs\" style=\"margin-left: 300px;\" " +
                "                           id=\"btn_thump\" value='"+data["plan"].id+"'><i class=\"fa fa-thumbs-up\" " +
                "                           style=\"color: gray;\"></i> <strong>赞("+data["thump"].thumpNum+")</strong></button>" +
                "                    <button class=\"btn btn-white btn-xs\" style=\"margin-left: 300px;display: none\" id=\"btn_thump1\" value='"+data["plan"].id+"'></button>"+
                "                </div>\n" +
                "                <div class=\"plan-join\">\n" +
                "                    <a id=\"joinPlan\" class=\"joinPlan\">\n" +
                                                        join +
                "                    </a>\n" +
                "                </div>\n" +
                "                <div class=\"plan-intro\">\n" +
                "                    <p>"+data["description"]+"</p>\n" +
                "                </div>\n";
            $(".plan-detail").html(plan);


            if( ${sessionScope.userInfo==null} ){
                $("#joinPlan").removeClass("joinPlan")
                $('.plan-detail').on('click','.demo4',function () {
                    swal({
                            title: "请先登录!",
                            text: "登录后才可进行此操作！",
                            type: "warning",
                            showCancelButton: true,
                            confirmButtonColor: "#DD6B55",
                            confirmButtonText: "去登录！",
                            cancelButtonText: "取消",
                            closeOnConfirm: false,
                        },
                        function (isConfirm) {
                            if (isConfirm) {
                                window.location.href = "${path}/loginAct";
                            }
                        });
                });
            }
            else if (data.plan.status == 0) {
                $("#joinPlan").removeClass("joinPlan")
                $('.plan-detail').on('click','.demo4',function () {
                    $.get("${path}/person/checkJoin",{"uid":"${sessionScope.userInfo.userId}"},function(result){
                        if (result.flag == false){
                            layer.msg("亲，还有一个计划没有完成哦",{icon: 1, time: 1000});
                        } else {
                            swal({
                                    title: "您确定要加入这个计划吗",
                                    // text: "该计划为付费计划，请先购买！",
                                    type: "warning",
                                    showCancelButton: true,
                                    confirmButtonColor: "#DD6B55",
                                    confirmButtonText: "立即加入！",
                                    cancelButtonText: "让我再考虑一下…",
                                    closeOnConfirm: false,
                                    closeOnCancel: false
                                },
                                function (isConfirm) {
                                    if (isConfirm) {
                                        <%--window.location.href = "${path}/alipay/pay/web";--%>
                                        $(".demo4").removeClass("btn-danger demo4").addClass("btn-default demo3").html("-取消训练计划");
                                        var pid = data["plan"].id;
                                        if (${sessionScope.userInfo.userId != null}){
                                            $.post("${pageContext.request.contextPath}/person/join",{"pid":pid,"uid":"${sessionScope.userInfo.userId}"},success=function(data){
                                                if (data.codeStatus == "OK"){
                                                    swal("加入成功！", "您已成功加入该计划。", "success");
                                                }
                                            });
                                        }
                                    } else {
                                        swal("已取消", "您取消了该操作！", "error");
                                    }
                                });
                        }
                    });

                });
            }else{
                $('.plan-detail').on('click','.demo4',function () {
                    <%--$.get("${path}/person/checkJoin",{"uid":"${sessionScope.userInfo.userId}"},function(data){--%>
                        <%--if (data.flag == false){--%>
                            <%--layer.msg("亲，还有一个计划没有完成哦",{icon: 1, time: 1000});--%>
                        <%--} else {--%>
                            swal({
                                    title: "您确定要加入这个计划吗",
                                    text: "该计划为付费计划，请先购买！",
                                    type: "warning",
                                    showCancelButton: true,
                                    confirmButtonColor: "#DD6B55",
                                    confirmButtonText: "立即购买！",
                                    cancelButtonText: "让我再考虑一下…",
                                    closeOnConfirm: false,
                                    closeOnCancel: false
                                },
                                function (isConfirm) {
                                    if (isConfirm) {

                                        $(".demo4").removeClass("btn-danger demo4").addClass("btn-default demo3").html("-取消训练计划")
                                        var pid = data["plan"].id;
                                        if (${sessionScope.userInfo.userId != null}){
                                            $.post("${pageContext.request.contextPath}/person/join",{"pid":pid,"uid":"${sessionScope.userInfo.userId}"},success=function(data){
                                                if (data.codeStatus == "OK"){
                                                    // swal("加入成功！", "您已成功加入该计划。", "success");
                                                    window.location.href = "${path}/alipay/pay/web";
                                                }
                                            });
                                        }

                                    } else {
                                        swal("取消成功！", "每次流下的汗水是对努力最好的回报！","error");
                                    }
                                });
                        // }

                    // });
                });
            }
            $('.plan-detail').on('click','.demo3',function () {
                swal({
                        title: "您确定要取消这个计划吗",
                        type: "warning",
                        showCancelButton: true,
                        confirmButtonColor: "#DD6B55",
                        confirmButtonText: "确定",
                        cancelButtonText: "取消",
                        closeOnConfirm: false,
                        closeOnCancel: false
                    },
                    function (isConfirm) {
                        if (isConfirm) {
                            $(".demo3").removeClass("btn-default demo3").addClass("btn-danger demo4").html("+加入训练计划")
                            var pid = data["plan"].id;
                            $.post("${pageContext.request.contextPath}/person/cancelPlan",{"pid":pid},success=function(data){
                                if (data.codeStatus == "OK"){
                                    swal("取消成功！", "您已取消加入该计划。", "success");
                                }
                            });
                        } else {
                            swal("已取消该操作", "致敬还在奋斗的你！","error");
                        }
                    });
            });

            // 获取最外层的div
            var calender = document.getElementById("plan-calender");
            // 创建table
            var table = document.createElement("table");
            // table.setAttribute("border",1);
            var tbody = document.createElement("tbody");
            var theme = data["trainContent"];
            var planWeek = data["plan"].planWeek+1;

            // var theme = train.substring(1,train.length-1).split(",");
            // 去除空格
            for (var m = 0; m < theme.length; m++){
                theme[m] = theme[m].trim();
            }

            var day = 1;
            for (var i = 1; i < planWeek; i++) {
                // 创建tr
                var tr = document.createElement("tr");
                for (var j = 0; j < 8; j++) {
                    // 创建td
                    var td = document.createElement("td");
                    // 第一个td的选择器不同于之后的
                    if (j == 0) {
                        td.className = "t-head";
                        var span = document.createElement("span");
                        span.innerHTML = i + "周";
                        td.appendChild(span);
                        tr.appendChild(td);
                    } else {
                        td.className = "t-main";
                        // 创建a标签子节点
                        var a = document.createElement("a");
                        a.className = "t-item";
                        <%--a.setAttribute("href", "${path}/courselist/courseList");--%>
                        // 创建span子节点
                        var span = document.createElement("span");
                        if (day < 10) {
                            span.innerHTML = "0" + day;
                        } else {
                            span.innerHTML = day;
                        }
                        var p = document.createElement("p");
                        p.innerHTML = theme[j - 1];

                        // 将span标签添加到a标签中
                        a.appendChild(span);
                        // 将p标签添加到a标签中
                        a.appendChild(p);
                        // 将a标签绑定到td中
                        td.appendChild(a);
                        // 将td绑定到tr上
                        tr.appendChild(td);
                        day++;
                    }
                }
                // 将tr绑定在tbody中
                tbody.appendChild(tr);
            }
            // 将tbody绑定到table标签中
            table.appendChild(tbody);
            calender.appendChild(table);

            /*
             * 对休息日进行处理
             */
            var items = document.getElementsByClassName("t-item");
            var item_p;
            for (var i = 0; i < items.length; i++) {
                item_p = items[i].children[1].innerHTML;
                if (item_p == "休息日") {
                    // 设置父节点属性
                    items[i].parentNode.style = "background-color:CadetBlue";
                    items[i].parentNode.firstChild.setAttribute("href","javascript:void(0)");
                    items[i].style = "color:white";
                }
            }

            // 当点击每天的训练安排是，将数据放松到后台；
            $("#plan-calender").on("click",".t-item",function(){
                var day = $(this).find("span").text();
                var dayTitle = $(this).find("p").text();
                if (dayTitle != "休息日"){
                    //$.post("${path}/courselist/list",{"pid":data.plan.id,"did":day,"dayTitle":dayTitle},async = false)
                    window.location.href = "${path}/courselist/list?pid="+data.plan.id+"&did="+day+"&dayTitle="+dayTitle;
                }
            });
        }
    );
//    日期格式转换js
    Date.prototype.format = function(format) {
        var date = {
            "M+": this.getMonth() + 1,
            "d+": this.getDate(),
            "h+": this.getHours(),
            "m+": this.getMinutes(),
            "s+": this.getSeconds(),
            "q+": Math.floor((this.getMonth() + 3) / 3),
            "S+": this.getMilliseconds()
        };
        if (/(y+)/i.test(format)) {
            format = format.replace(RegExp.$1, (this.getFullYear() + '').substr(4 - RegExp.$1.length));
        }
        for (var k in date) {
            if (new RegExp("(" + k + ")").test(format)) {
                format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? date[k] : ("00" + date[k]).substr(("" + date[k]).length));
            }
        }
        return format;
    };


//    var date; //定义一个变量接收当前日期
    //点赞事件
    $(function () {

            $(".plan-detail").on("click","#btn_thump",function () {
                if(${sessionScope.userInfo==null}){
                    swal({
                            title: "请先登录!",
                            text: "登录后才可进行此操作！",
                            type: "warning",
                            showCancelButton: true,
                            confirmButtonColor: "#DD6B55",
                            confirmButtonText: "去登录！",
                            cancelButtonText: "取消",
                            closeOnConfirm: false,
                        },
                        function (isConfirm) {
                            if (isConfirm) {
                                window.location.href = "${path}/loginAct";
                            }
                        });
                    return;
                }
                var planId = $("#btn_thump").val();//获取到计划的id
//            date = new Date().format('hh:mm:ss');//获取当前日期的时分秒
                $.get("${pageContext.request.contextPath}/plan-detail/addThumpNum?planId="+planId,function (data) {
                    $("#btn_thump1").html("<i class='fa fa-thumbs-up' style='color: red;'></i>"+ "<strong> 赞(" + data + ")</strong>");
                    $("#btn_thump1").css("display","inline");
                    $("#btn_thump").css("display","none");
            })
        });

        //点击取消按钮时
        $(".plan-detail").on("click","#btn_thump1",function () {
            var planId = $("#btn_thump1").val();//获取到计划的id

            $.get("${pageContext.request.contextPath}/plan-detail/subThumpNum?planId="+planId,function (data) {
                $("#btn_thump").html("<i class='fa fa-thumbs-up' style='color: gray;'></i>"+ "<strong> 赞(" + data + ")</strong>");
                $("#btn_thump").css("display","inline");
                $("#btn_thump1").css("display","none");
            });
        });

    });



</script>

<script>

    // 获取评论框输入的内容
    $("#c-btn").click(function(){
        if ( $("#comment-text").val() == "") {
            layer.msg("评论内容不能为空!",{icon: 1, time: 1000});
            return false;
        }else if(${sessionScope.userInfo==null}){
            swal({
                    title: "请先登录!",
                    text: "登录后才可进行此操作！",
                    type: "warning",
                    showCancelButton: true,
                    confirmButtonColor: "#DD6B55",
                    confirmButtonText: "去登录！",
                    cancelButtonText: "取消",
                    closeOnConfirm: false,
                },
                function (isConfirm) {
                    if (isConfirm) {
                        window.location.href = "${path}/loginAct";
                    }
                });
            return;
        }else{
            // 发送评论内容到后台
            var datas={
                "userId":"${sessionScope.userInfo.userId}",
                "content":$("#comment-text").val(),
                "planId":${pid}
            };
            $.post("http://localhost:8081/KeepMovingFiness/plan-detail/saveComment", datas,function(comment){
                if (comment.codeStatus == "OK") {
                    layer.msg("评论成功",{icon:1,time:1000});

                    var data = comment.data;
                    console.log(data);
                    var comment_content =
                        "<div class=\"social-feed-separated\">" +
                        "  <div class=\"social-avatar\">" +
                        "     <a href=\"javascript:void(0)\">" +
                        "     <img alt= '头像' src='" + data.commentUserImg + "'>" +
                        "     </a>" +
                        "  </div>" +
                        "  <div class=\"social-feed-box\">" +
                        "  <div class=\"social-avatar\">" +
                        "     <a href=\"javascript:void(0)\">" + data.commentUserName + "</a>" +
                        "     <small class=\"text-muted\">" + data.date + "</small>" +
                        "  </div>" +
                        "  <div class=\"social-body\">" +
                        "  <p>" + data.content + "</p>" +
                        "  <div class=\"btn-group\">" +
                        "      <button class=\"btn btn-white btn-xs\" data-toggle=\"modal\" data-target=\"#u-reply\"><i class=\"fa fa-comments\"></i> 回复</button>" +
                        "  </div>" +
                        "  </div>" +
                        "  </div>" +
                        "  </div>";
                    // $("#comment").append(comment_content);
                    $("#comment").prepend(comment_content);
                } else {
                    layer.msg("评论失败");
                }
            });
        }
    });

    $("#comment").on("click","#huifu",function(){
        // $("input:hidden").each(function (i){
        //     console.log($(this).val());
        // });
        var value = $(this).parent().parent().next().val();
        // 通过父元素绑定一个事件监听
        $("#comment").on("click","#reply-s",function () {
            var value_r = $("#reply-content").val()
            if (value_r == ""){
                layer.msg("回复内容不能为空");
                return false;
            }else if(${sessionScope.userInfo==null}){
                swal({
                        title: "请先登录!",
                        text: "登录后才可进行此操作！",
                        type: "warning",
                        showCancelButton: true,
                        confirmButtonColor: "#DD6B55",
                        confirmButtonText: "去登录！",
                        cancelButtonText: "取消",
                        closeOnConfirm: false,
                    },
                    function (isConfirm) {
                        if (isConfirm) {
                            window.location.href = "${path}/loginAct";
                        }
                    });
                return;
            }
            if (${sessionScope.userInfo.userId != null}){

                var data = {
                    "commentId":value,
                    "replyContent":value_r,
                    "replyUserId":"${sessionScope.userInfo.userId}",
                    "planId":${pid}
                };
                $.post("http://localhost:8081/KeepMovingFiness/plan-detail/saveReply",data,function(result) {
                    if (result.codeStatus == "OK") {
                        layer.msg("回复成功!");
                        location.reload();
                    } else {
                        layer.msg("回复失败!");
                    }
                });
            }
        });
    });





    var pageNum = 1;
    var pageSize = 0;
    var pages = 0;
    var commentSize = 0;
    window.onload = function(){
        pageAjax(pageNum);
    }
    function pageAjax(pageNum) {
        $.get("http://localhost:8081/KeepMovingFiness/plan-detail/comment-data",{"pageNum":pageNum,"pid":${pid}},
            success = function (data) {
                var data = data.data;
                $("#commentNum").html("共" + data["commentSize"] + "条评论");
                pageNum = data["pageNum"];
                pageSize = data["pageSize"];
                pages = data["pages"];
                commentSize = data["commentSize"];
                page();
                var commentList = data["commentVoList"];
                console.log(commentList);
                var html = "";
                for (var i = 0; i < commentList.length; i++) {
                    var modal = "<h4 class=\"modal-title\" id='reply-user'>回复: @"+commentList[i].commentUserName+"</h4>";
                    html +=
                        "<div class=\"social-feed-separated\">" +
                        "  <div class=\"social-avatar\">" +
                        "     <a href=\"javascript:void(0)\">" +
                        "     <img alt= '头像' src='" + commentList[i].commentUserImg + "'>" +
                        "     </a>" +
                        "  </div>" +
                        "  <div class=\"social-feed-box\">" +
                        "  <div class=\"social-avatar\">" +
                        "     <a href=\"javascript:void(0)\">" + commentList[i].commentUserName + "</a>" +
                        "     <small class=\"text-muted\">" + commentList[i].date + "</small>" +
                        "  </div>" +
                        "  <div class=\"social-body\">" +
                        "  <p>" + commentList[i].content + "</p>" +
                        "  <div class=\"btn-group\">" +
                        "      <button class=\"btn btn-white btn-xs\" id='huifu' data-toggle=\"modal\" data-target=\"#u-reply\"><i class=\"fa fa-comments\"></i> 回复</button>" +
                        "  </div>" +
                        "  <div class=\"modal inmodal\" id=\"u-reply\" tabindex=\"-1\" role=\"dialog\"  aria-hidden=\"true\">" +
                        "  <div class=\"modal-dialog\">" +
                        "  <div class=\"modal-content animated fadeIn\">" +
                        "  <div class=\"modal-header\" id='data-modal'>" +
                        "       <button type=\"button\" class=\"close\" data-dismiss=\"modal\"><span aria-hidden=\"true\">&times;</span><span class=\"sr-only\">Close</span></button>" +
                        "       <i class=\"fa fa-clock-o modal-icon\"></i>" +
                        "       <h4 class=\"modal-title\" id='reply-user'>请输入您的回复内容</h4>" +
                        "  </div>" +
                        "  <div class=\"modal-body\">" +
                        "    <p>" +
                        "       <textarea class=\"form-control\" id=\"reply-content\" rows=\"3\"></textarea>" +
                        "    </p>" +
                        "  </div>" +
                        "  <div class=\"modal-footer\">" +
                        "     <button type=\"button\" class=\"btn btn-white\" data-dismiss=\"modal\">关闭</button>" +
                        "     <button type=\"button\" class=\"btn btn-primary\" data-dismiss=\"modal\" id=\"reply-s\">保存</button>" +
                        "  </div>" +
                        "  </div>" +
                        "  </div>" +
                        "  </div>" +
                        "  </div>";
                    html += "<input type='hidden' name='ch' class='hi' value='"+commentList[i].cid+"'>";
                    $("data-modal").append(modal);

                    if (commentList[i]["replyVoList"].length > 0) {
                        var replyList = commentList[i].replyVoList;
                        html += "<div class='social-footer' id='reply-content'>";
                        for (var j = 0; j < replyList.length; j++) {
                            html +=
                                "  <div class='social-comment reply-main'>" +
                                "    <a href=\"javascript:void(0)\" class=\"pull-left\">" +
                                "       <img alt='头像' src='" + replyList[j].replyUserImg + "' class=\"reply-img\">" +
                                "    </a>" +
                                "  <div class=\"media-body reply-detail\">" +
                                "  <a href=\"javascript:void(0)\">" + replyList[j].replyUserName + "</a>" +
                                "  <span>" + replyList[j].replyContent + "</span>" +
                                "  <br />" +
                                "  <small class=\"text-muted\">" + replyList[j].replyDate + "</small>" +
                                "</div>" +
                                "</div>";
                        }
                        html += "</div>";
                    }
                    html += "</div>" + "</div>";
                    $("#reply-user").val(commentList[i].commentUserName);
                }
                $("#comment").empty().append(html);
            }
        );
    }
    function page(){
        layui.use(['laypage', 'layer'], function (){
            var laypage = layui.laypage;
            var layer = layui.layer;
            laypage.render({
                elem:"comment-page",
                limit: pageSize,
                count: commentSize,
                groups: pages,
                curr: pageNum,
                jump:function(obj,first){
                    if (!first){
                        pageNum = obj.curr;
                        pageAjax(pageNum);
                    }
                }
            });
        })
    }

</script>

</body>

</html>