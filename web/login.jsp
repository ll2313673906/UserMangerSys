<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2019/9/14
  Time: 10:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xml:base="login.jsp">
<head>
    <title>登录页面</title>
    <style>
        *{
            margin: 0;
            padding: 0;
        }
        body{
            background: url(images/bg1.jpg) 50% 0 repeat;
            text-align: center;


        }
        form{
            margin-top: 50px;
        }
        p{

            margin-top: 50px;
        }

    </style>
</head>
<body>
<div class="class">
<form action="login" method="post">
   <p><h2>用户登录</h2></p>
    <p>账号：<input type="text" name="username"></p>
    <p>密码：<input type="text" name="password"></p>
    <p><input type="submit" value="登录"  style="width: 100px" height="50px"></p>

</form>
</div>
</body>
</html>
