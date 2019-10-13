<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2019/10/7
  Time: 16:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>修改用户界面</title>
    <style>
        body{
            text-align: center;
        }
     table{
         margin-left: 45%;

     }
    </style>
</head>
<body>
<h3>修改用户</h3>

<hr>
<h1>请输入用户信息</h1>

<form action="UserClServlet?flag=updateUser" method="post">

<table border="1px">
    <tr>
        <td>用户Id：</td>
<%--        readonly表示不能被修改的属性值--%>
        <td><input type="text" readonly="readonly" name="userId" value="<%=request.getParameter("userId")%>"></td>
    </tr>
    <tr>
        <td>用户名：</td>
        <td><input type="text" name="userName" value="<%=request.getParameter("userName")%>"></td>
    </tr>
    <tr>
        <td>密码：</td>
        <td><input type="text" name="password" value="<%=request.getParameter("password")%>"></td>
    </tr>
    <tr>
        <td>Email：</td>
        <td><input type="text" name="email" value="<%=request.getParameter("email")%>"></td>
    </tr>
    <tr>
        <td>grade</td>
        <td><input type="text" name="grade" value="<%=request.getParameter("grade")%>"></td>
    </tr>
    <tr>
        <td><input type="submit" value="修改用户"></td>
        <td><input type="reset" value="重置"></td>
    </tr>
</table>
    <hr>
</form>
</body>

</html>
