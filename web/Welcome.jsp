<%@ page import="java.util.List" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User:
  Date: 2019/9/23
  Time: 9:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>欢迎界面</title>
</head>
<body>
        <%
            HttpSession hs = request.getSession(true);
            String username1 = (String) hs.getAttribute("username");
            if (username1 == null) {
                out.println("非法登录<a href=/login.jsp>请登录</a>");
            } else {
                out.print("登入成功  欢迎"+hs.getAttribute("username"));
            }
        %>
<%--接收数据--%>
<%
    List<HashMap> list = new ArrayList<HashMap>();
    list = (ArrayList) request.getAttribute("result");
%>

<table border="1px">
    <tr>
        <td>用户的Id</td>
        <td>用户名</td>
        <td>用户密码</td>
        <td>用户等级</td>
        <td>修改用户</td>
        <td>删除用户</td>
    </tr>
    <%
        for (int i = 0; i < list.size(); i++) {

    %>
    <tr>
        <td><%=list.get(i).get("userId")%></td>
        <td><%=list.get(i).get("userName")%></td>
        <td><%=list.get(i).get("password")%></td>
        <td><%=list.get(i).get("grade")%></td>
    </tr>
    <%
        }
    %>
</table>
        <br>
<%
    //接收用户需要显示的页面，显示第几页
    String s_pageNow = (String) request.getAttribute("pageNow");
   int pageNow = Integer.parseInt(s_pageNow);
   if (pageNow != 1){
       out.println("<a href=UserClServlet？flag = fenye&pageNow=" + (pageNow - 1) + ">上一页</a>");
   }
%>
</body>
</html>
