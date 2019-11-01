<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/10/11
  Time: 14:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>拦截后跳转的页面</title>
</head>
<body>
    <h3 style="color: red">${msg}</h3>
    <form method="post" action="shiroLogin">
        用户名:<input type="text" name="phone"><br>
        密码:<input type="text" name="password">
        <input type="submit" value="登录">
    </form>
</body>
</html>
