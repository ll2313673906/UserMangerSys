<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2019/9/30
  Time: 10:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主界面</title>
    <style>
        body{
            margin: 0;
            padding: 0;
            text-align: center;
            line-height: 50px;
        }

    </style>
</head>
<body>
<h2>请选择操作</h2>
<a href="UserClServlet?pageNow=1&flag=fenye">管理用户</a><br>
<a href="addUser.jsp">添加用户</a><br>
<a href="#">查找用户</a><br>
<a href="#">安全退出</a><br>
</body>
</html>
