<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2019/9/30
  Time: 10:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>添加用户界面</title>
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
<h2>添加用户</h2>
<hr>
<center>
<form action="UserClServlet?flag=addUser" method="post">

    <table border="1" style="border-spacing: 0">
<%--        <tr>--%>
<%--            <td>用户Id</td>--%>
<%--            <td><input type="text" name="userId" readonly="readonly" value="<%=request.getParameter("userId")%>"></td>--%>
<%--        </tr>--%>
        <tr>
            <td>用户名：</td>
            <td><input type="text" name="userName"  value="<%=request.getParameter("userName")%>"></td>
        </tr>
        <tr>
            <td>用户密码：</td>
            <td><input type="text" name="password"  value="<%=request.getParameter("password")%>"></td>
        </tr>
        <tr>
            <td>Email：</td>
            <td><input type="text" name="email"  value="<%=request.getParameter("email")%>"></td>
        </tr>
        <tr>
            <td>grade：</td>
            <td><input type="text" name="grade"  value="<%=request.getParameter("grade")%>"></td>
        </tr>
        <tr>
            <td><input type="submit" value="添加"></td>
            <td><input type="reset" value="重置"></td>
        </tr>

    </table>
</form>
</center>
</body>
</html>
