<%--
  Created by IntelliJ IDEA.
  User: Eastzzz
  Date: 2019/9/27
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<link rel="stylesheet" href="${path}/plugins/layui/css/layui.css">
<link rel="stylesheet" href="${path}/css/nav/nav.css">
<link rel="stylesheet" href="${path}/css/person-info/person-info.css">
<body>
<!-- 响应式导航 begin -->
<%@ include file="../nav/nav.jsp"%>
<!-- 响应式导航 end -->
<div class="km">

    <div class="o-personal page">
        <div class="inner">
            <!--面包屑导航开始-->
            <div class="daohang">
                    <span class="layui-breadcrumb">
                        <a href="${path}/person/center">个人中心</a>
                        <a><cite>个人信息</cite></a>
                    </span>
            </div>
            <!-- 面包屑导航结束 -->
            <div class="o-personal-bd">
                <div class="col-main">
                    <div class="o-user-form base-profile">
                        <div style="color:red;font-size:13px;">以身高和体重自动计算你的体脂，来测测你的体质吧！亲！</div><br>
                        <input type="hidden" id="id">
                        <div class="line">
                            <span class="label">体重</span>
                            <div class="layui-input-block">
                                <input type="number" id="weight" name="weight" lay-verify="title" autocomplete="off"
                                       placeholder="体重" class="layui-input"><em>kg</em>
                            </div>
                        </div>
                        <div class="line">
                            <span class="label">身高</span>
                            <div class="layui-input-block">
                                <input type="number" id="height" name="height" lay-verify="title" autocomplete="off"
                                       placeholder="身高" class="layui-input"><em>cm</em>
                            </div>
                        </div>

                        <div class="line">
                            <span class="label">体脂</span>
                            <div class="layui-input-block">
                                <input type="text" id="tizhi" name="tizhi" lay-verify="title" autocomplete="off" style="background:#efeeee;"
                                       readonly="readonly"  placeholder="体脂" class="layui-input"> <em>% <a href=""
                                                                                                           class="standar-guide">仅供参考</a></em>
                            </div>
                        </div>
                        <div class="action" style="margin-top: 50px;">
                            <a href="javascript:void(0)" class="u-button save" >保存</a>
                        </div>
                    </div>
                </div>
                <div class="col-aside">
                    <div class="o-personal-nav">
                        <ul>
                            <li><a href="per2"><em><i></i>基本资料</em></a></li>
                            <li class="cur"><a href="per1"><em><i></i>身体素质</em></a></li>
                            <li><a href="per3"><em><i></i>账号设置</em></a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="${path}/plugins/layui/layui.js"></script>
<script src="${path}/js/nav/nav.js"></script>
<script src="${path}/plugins/jquery/jquery.min.js"></script>
<script type="text/javascript">
    $(function(){
        $.post("getUserBaseInfo",function(msg){
            console.log(msg)
            $("#height").val(msg.height);
            $("#weight").val(msg.weight);
            $("#id").val(msg.userId);
            var tz = getTz(msg.weight,msg.height);
            $("#tizhi").val(tz);
        });
        //失去焦点就计算
        $("#weight").blur(function(){
            if($(this).val() == ""){
                alert("体重不能为空");
                return false
            }
            setTZ()
        })
        //失去焦点就计算
        $("#height").blur(function(){
            if($(this).val() == ""){
                alert("身高不能为空");
                return false
            }
            setTZ()
        })
        //给体脂肪输入框赋值
        function setTZ(){
            var h =  $("#height").val();
            var w = $("#weight").val()
            var tz = getTz(w,h);
            $("#tizhi").val(tz);
        }
        //计算体脂百分比
        function getTz(weight,height){
            var tz = Math.round(weight / height * 10000) / 100.00 + '%';
            return tz;
        }
        $(".save").click(function(){
            if($("#height").val() == ""){
                alert("身高不能为空");
                return false
            }
            if($("#weight").val() == ""){
                alert("体重不能为空");
                return false
            }
            var params = {
                //返回   中的值
                userId:$("#id").val(),
                weight:$("#height").val(),
                height:$("#weight").val()
            }
            $.post("editUserByUserId",params,function(msg){
                console.log(msg)
                if(msg == 1){
                    alert("保存成功")
                }else{
                    alert("保存失败")
                }

            });
        });
    })

</script>
</body>
</html>
