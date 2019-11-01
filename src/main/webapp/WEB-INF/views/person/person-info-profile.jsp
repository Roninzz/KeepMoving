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
    <script src="${path}/plugins/jquery/jquery.min.js"></script>
    <link rel="stylesheet" href="${path}/plugins/layui/css/layui.css">
    <link rel="stylesheet" href="${path}/css/person-info/tcal.css">
    <link rel="stylesheet" href="${path}/css/nav/nav.css">
    <link rel="stylesheet" href="${path}/css/person-info/person-info.css">
</head>
<body>
<!-- 响应式导航 begin -->
<%@ include file="../nav/nav.jsp"%>
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
<!-- 响应式导航 end -->
<!-- 最外层 -->
<div class="km">

    <div class="o-personal page">
        <div class="inner">
            <!--面包屑导航开始-->
            <div class="daohang">
                    <span class="layui-breadcrumb">
                        <a href="${path}/person/center">个人中心</a>
                        <a><cite>基本信息</cite></a>
                    </span>
            </div>
            <!-- 面包屑导航结束 -->
            <!-- 基本信息界面begin -->
            <div class="o-personal-bd">
                <div class="col-main">
                    <div class="o-user-form base-profile">
                        <form id="formEdit" method="post" enctype="multipart/form-data"
                              action="/personal/UpdateProfile" target="ifEdit" lay-filter="formTest">
                            <div class="line">
                                <span class="label">头像</span>
                                <div class="ibox-content">
                                    <div class="layui-upload">

                                        <div class="layui-upload-list">
                                            <img class="layui-upload-img" id="demo1">
                                            <p id="demoText"></p>
                                        </div>
                                        <button type="button" class="layui-btn" id="test1">上传图片</button>
                                    </div>
                                </div>
                            </div>

                            <div class="line" style="margin-top: 10px;">
                                <span class="label">昵称</span>
                                <div class="layui-input-block">
                                    <input type="text" id="nickname" name="nickname" lay-verify="title" autocomplete="off"
                                           placeholder="昵称" class="layui-input">
                                </div>
                            </div>

                            <div class="line">
                                <span class="label">城市</span>
                                <div id="address">
                                    <select class="select" id="province" name="province">
                                        <option value="">选择省份</option>
                                    </select>
                                    <select name="city" id="city">
                                        <option value="">选择城市</option>
                                    </select>
                                    <select name="town" id="town">
                                        <option value="">选择区域</option>
                                    </select>
                                </div>
                                <input id="area" type="text" name="area" class="layui-input" style="margin-left: 58px;margin-top: 10px;">
                            </div>
                            <div class="line">
                                <div class="layui-inline">
                                    <span>生日</span>
                                    <div class="layui-input-inline" style="margin-left: 25px;">
                                        <input type="text" class="layui-input" id="birth" name="birth" placeholder="生日">
                                    </div>
                                </div>
                            </div>

                            <div class="line">
                                <span class="label">性别</span>
                                <div class="layui-input-block block">
                                    <!-- <input type="radio" name="sex" value="男" title="男" checked> -->
                                    <input type="radio" name="sex" id="sex1" value="男" title="男" >
                                    <div class="layui-unselect layui-form-radio sex1 layui-form-radioed">
                                        <i id="layui-anim" class="layui-anim layui-icon layui-anim-scaleSpring"></i>
                                        <div>男</div>
                                    </div>
                                    <input type="radio" name="sex" id="sex2" value="女" title="女">
                                    <div class="layui-unselect layui-form-radio sex2">
                                        <i id="layui-anim" class="layui-anim layui-icon"></i>
                                        <div>女</div>
                                    </div>
                                </div>
                            </div>
                            <!-- <input type="hidden" class="layui-input" id="birth" name="birth"> -->
                            <input type="hidden" class="layui-input" id="id" name="id">
                            <div class="action">
                                <a href="javascript:void(0)" class="u-button save">保存</a>
                            </div>
                        </form>
                    </div>
                </div>
                <div class="col-aside">
                    <div class="o-personal-nav">
                        <ul>
                            <li class="cur"><a href="per2"><em><i></i>基本资料</em></a></li>
                            <li><a href="per1"><em><i></i>身体素质</em></a></li>
                            <li><a href="per3"><em><i></i>账号设置</em></a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <!-- 基本资料end -->
        </div>
    </div>
</div>

<!-- 主体内容结束 -->
<script src="${path}/plugins/layui/layui.js"></script>
<script src="${path}/js/nav/nav.js"></script>
<script src="${path}/plugins/jquery/jquery.min.js"></script>
<!-- 文件上传 -->
<script>
    layui.use(['upload',"form"], function () {
        var $ = layui.jquery
            ,form = layui.form
            , upload = layui.upload;
        //获取用户头像

        $.post("getPhoto",function(msg){
            console.log(msg)
            //把URL放进去
            $('#demo1').attr('src', "."+ msg.imgUrl);
        });

        //获取用户信息
        $.post("getUserBaseInfo",function(msg){
            console.log(msg)
            //移除类名
            $(".layui-form-radio").removeClass("layui-form-radioed");
            if(msg.gender == "男"){
                //添加类名
                $(".sex1").addClass("layui-form-radioed");
                $("#sex1").attr("checked","checked");
            }else{
                $(".sex2").addClass("layui-form-radioed");
                $("#sex2").attr("checked","checked");
            }
            //province city town
            $("#nickname").val(msg.username);
            $("#birth").val(msg.birthday);
            $("#id").val(msg.userId);
            $("#area").val(msg.city);
            // $("#").val(msg.);
            console.log( $('input[name="sex"]:checked').val())
            form.render(); //更新全部
        });
        $(".save").click(function(){
            var params = {
                userId:$("#id").val(),
                username:$("#nickname").val(),
                birthday:$("#birth").val(),
                // birthday:$("#birth").val(),

                gender:$('input[name="sex"]:checked').val(),
                city:$("#area").val()
            };
            $.post("editAllByUserId",params,function(msg){
                if(msg == 1){
                    alert("保存成功")
                }
            });
            $.post("editByUserId",params,function (msg) {
                if (msg == 1){

                }
            })
        });
        //普通图片上传
        var uploadInst = upload.render({
            elem: '#test1'
            , url: 'uploadPhoto'
            , before: function (obj) {
                //预读本地文件示例，不支持ie8
                obj.preview(function (index, file, result) {
                    console.log(file)
                    $('#demo1').attr('src', result); //图片链接（base64）
                });
            }
            , done: function (res) {
                console.log(res)
                //如果上传失败
                if (res.msg = 1) {
                    return layer.msg('上传成功');
                }else{
                    return layer.msg('上传失败');
                }
                //上传成功
            }
            , error: function () {
                //演示失败状态，并实现重传
                var demoText = $('#demoText');
                demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-xs demo-reload">重试</a>');
                demoText.find('.demo-reload').on('click', function () {
                    uploadInst.upload();
                });
            }
        });
    })

    // 日期
    layui.use(['form', 'layedit', 'laydate'], function () {
        var form = layui.form
            , layer = layui.layer
            , layedit = layui.layedit
            , laydate = layui.laydate;

        //日期
        laydate.render({
            elem: '#date'
        });
        laydate.render({
            elem: '#date1'
        });

    })
</script>
<script>
    $('.layui-input-block .layui-form-radio').click(function () {
        if($(this).text().indexOf("男") > -1){
            $("#sex1").attr("checked","checked");
        }else{
            $("#sex2").attr("checked","checked");
        }
        $(this).addClass('layui-form-radioed').siblings().removeClass('layui-form-radioed');
    })
</script>

<script>
    layui.use('laydate', function () {
        var laydate = layui.laydate;
        //日期时间选择器
        laydate.render({
            elem: '#birth'
            , type: 'datetime'
        });
    });
</script>

<script type="text/javascript" src="${path}/plugins/jquery/addres.js"></script>
<script type="text/javascript">
    $(function(){
        $("#address").selectAddress()
        $("#town").click(function(){
            //返回被选元素的内容
            var province = $("#province option:selected").html()
            var city = $("#city option:selected").html()
            var town = $("#town option:selected").html()
            //没有选择判断
            if(province!= '选择省份' && city!="选择城市" && town!='选择区域'){
                $("#area").val(province+'-'+city+'-'+town)
            }
        })
    })
</script>

</body>
</html>
