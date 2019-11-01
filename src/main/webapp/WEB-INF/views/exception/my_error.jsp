<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/10/9
  Time: 10:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>全局异常处理页面</title>
</head>
<body>
<input type="hidden" value="${map.code}" id="input_code">
<input type="hidden" value="${map.msg}" id="input_msg">

<h2>服务器正在升级.....</h2>

<script src="${pageContext.request.contextPath}/plugins/jquery/jquery.min.js"></script>
<script>
    console.log($("#input_code").val());
    console.log($("#input_msg").val());
</script>
</body>
</html>
