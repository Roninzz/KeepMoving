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
    <link rel="stylesheet" href="${path}/css/person-info/person-info.css">
    <link rel="stylesheet" href="${path}/plugins/layui/css/layui.css">
    <link rel="stylesheet" href="${path}/css/nav/nav.css">
    <script src="${path}/plugins/jquery/jquery.min.js"></script>
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
            <div class="o-personal-bd">
                <div class="col-main">
                    <div class="o-user-form base-profile">
                        <div class="account-basic-wrapper">
                            <div class="section">
                                <div class="prop-info">
                                    <i></i>
                                    <div class="desc highlight">
                                        <h4>安全手机: <span class="showPhone"></span></h4>
                                       		 安全手机可以用于登录账号，重置密码或其它安全验证
                                       		 <input type="hidden" class="verifyHdn">
                                    </div>
                                </div>
                                <div class="action action-mobile">
                                    <a class="btn-primary check verifyBtn" data-mobile="3456789098764" href="javascript:;" style="color: #2196F3;">立即验证</a>
                                </div>
                            </div>
                            <div id="showVerify" style="display:none;border: 1px solid; margin-top: 20px; padding: 20px;">	
                            <form class="layui-form">
                            	 <div class="layui-form-item">
								    <label class="layui-form-label">手机号</label>
								    <div class="layui-input-inline">
								      <input type="text" id="verifyPhone" name="phone" required lay-verify="required" placeholder="请输入手机号" autocomplete="off" class="layui-input">
								    </div><div class="layui-form-mid layui-word-aux" style="color:red !important;">输入的手机号需要和你上面的手机号一致</div>
								  </div>
								  <div class="layui-form-item">
								    <label class="layui-form-label">验证码</label>
								    <div class="layui-input-inline">
								      <input type="text" id="code" name="code" required lay-verify="required" placeholder="请输入验证码" autocomplete="off" class="layui-input">
								    </div>
								    <button class="layui-btn layui-btn-normal" id="btn1" type="button" style="margin-top: -3px;">获取验证码</button>
								  </div>
								   <div class="layui-form-item">
								    <button class="layui-btn layui-btn-danger" id="closeBtn1" type="button" >取消</button>
								    <button class="layui-btn " id="toEdit" type="button" >立即验证</button>
								  </div>
		                        </form>
                            </div>
                            <div class="section">
                                <div class="prop-info">
                                    <i></i>
                                    <div class="desc highlight">
                                        <h4>账号密码</h4>
                                       	 用于保护账号信息和登录安全
                                    </div>
                                </div>
                                <div class="action">
                                    <a class="btn-primary change editBtn" href="javascript:;" style="color: #2196F3;">修改密码</a>
                                </div>
                            </div>
                            <div id="showEditPwd" style="display:none;border: 1px solid; margin-top: 20px; padding: 20px;">	
                            <form class="layui-form">
                            	 <div class="layui-form-item">
								    <label class="layui-form-label">手机号</label>
								    <div class="layui-input-inline">
								      <input type="text" id="phoneEdit" name="phoneEdit" required lay-verify="required" placeholder="请输入手机号" autocomplete="off" class="layui-input">
								    </div>
								  </div>
								  <div class="layui-form-item">
								    <label class="layui-form-label">原密码</label>
								    <div class="layui-input-inline">
								      <input type="password" id="pwd1" name="password1" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
								    </div>
								  </div>
								  <div class="layui-form-item">
								    <label class="layui-form-label">新密码</label>
								    <div class="layui-input-inline">
								      <input type="password" id="pwd2" name="password2" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
								    </div>
								  </div>
								   <div class="layui-form-item">
								    <button class="layui-btn layui-btn-danger" id="closeBtn" type="button" >取消</button>
								    <button class="layui-btn " id="editPwd" type="button" >修改密码</button>
								  </div>
		                        </form>
                            </div>
                            <div class="item weixin">
                                <div class="prop-info">
                                    <span class="icon"></span>
                                    <span class="status">未授权</span>
                                    <span class="name">昵称：--</span>
                                </div>
                                <div class="action action-weixin">
                                    <a class="btn-primary" href="">获取授权</a>
                                </div>
                            </div>
                            <div class="item qq">
                                <div class="prop-info">
                                    <span class="icon"></span>
                                    <span class="status">未授权</span>
                                    <span class="name">昵称：--</span>
                                </div>
                                <div class="action action-qq">
                                    <a class="btn-primary" href="">获取授权</a>
                                </div>
                            </div>
                            <div class="item weibo">
                                <div class="prop-info">
                                    <span class="icon"></span>
                                    <span class="status">未授权</span>
                                    <span class="name">昵称：--</span>
                                </div>
                                <div class="action action-weibo">
                                    <a class="btn-primary" href="">获取授权</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-aside">
                    <div class="o-personal-nav">
                        <ul>
                            <li><a href="per2"><em><i></i>基本资料</em></a></li>
                            <li><a href="per1"><em><i></i>身体素质</em></a></li>
                            <li class="cur"><a href="per3"><em><i></i>账号设置</em></a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="${path}/plugins/layui/layui.js"></script>
<script src="${path}/js/nav/nav.js"></script>
</body>
<script type="text/javascript">
	//获取用户信息
	$.post("getUserInfo",function(msg){
		console.log(msg)
		var isVerify = msg.verify == 0 ? "（未验证）" : "（已验证）";
		$(".showPhone").html(msg.phone +  isVerify);
		$(".verifyHdn").val(msg.verify);
	});
	//验证显示
	$(".verifyBtn").click(function(){
		if($(".verifyHdn").val() == 1){
    		alert("已通过验证，无需再次验证！")
    		return false;
    	}
		$("#showVerify").show();
	});
	//取消
	$("#closeBtn1").click(function(){
		$("#showVerify").hide();
	});
	$("#btn1").click(function () {
		var phone = $("#verifyPhone").val();
		if(phone != ""){
          $.get("${pageContext.request.contextPath}/sendMsg?phone=" + phone);
		}else{
			alert("手机号不能为空！");
		}
    })
    //立即验证
    $("#toVerify").click(function(){
    	var phone = $("#verifyPhone").val();
    	var code = $("#code").val();
    	if(phone == ""){
    		alert("手机号不能为空！")
    	}
    	if(code == ""){
    		alert("验证码不能为空！")
    	}
    	var params = {
    		phone:$("#verifyPhone").val(),
    		code:$("#code").val()
    	}
    	$.post("editVerify",params,function(msg){
    		if(msg == 1){
    			alert("恭喜你！验证成功！");
    			$("#showVerify").hide();
    		}else{
    			alert("验证码错误！");
    		}
    	});
    });
	
   	
	//--------------------------修改密码------------------------
	$(".editBtn").click(function(){
		$("#showEditPwd").show();
		$("#phoneEdit").val("");
    	$("#pwd1").val("");
    	$("#pwd2").val("");
	});
	//取消
	$("#closeBtn").click(function(){
		$("#showEditPwd").hide();
	});
	
	//修改密码
	$("#editPwd").click(function(){
    	var phone = $("#phoneEdit").val();
    	var p1 = $("#pwd1").val();
    	var p2 = $("#pwd2").val();
    	if(phone == ""){
    		alert("手机号不能为空！")
    	}
    	if(p1 == ""){
    		alert("原密码不能为空！")
    	}
    	if(p2 == ""){
    		alert("新密码不能为空！")
    	}
    	var params = {
    		phone:phone,
    		oldPwd:p1,
    		newPwd:p2
    	}
    	$.post("editPwd",params,function(msg){
    		if(msg == 1){
    			alert("恭喜你！修改成功！");
    			$("#showEditPwd").hide();
    		}else{
    			alert("原密码错误！");
    		}
    	});
    });
</script>
</html>
