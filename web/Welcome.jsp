<%@ page import="java.util.List" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.io.*" %><%--
  Created by IntelliJ IDEA.
  User:
  Date: 2019/9/23
  Time: 9:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>欢迎界面</title>
    <style>
       body{
           margin: 0;
           padding: 0;
           text-align: center;
       }

    </style>
<%--    <script>--%>
<%--        window.onload = function () {--%>
<%--            var deleteBtn = document.getElementById("btn");--%>
<%--            deleteBtn.onclick = function (){--%>
<%--                alert("确定删除么？");--%>
<%--            }--%>
<%--        }--%>
<%--    </script>--%>
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
        <hr>
<%--        <%--%>
<%--//            FileReader fr = new FileReader("f:\\myContext.txt");--%>
<%--//            BufferedReader br = new BufferedReader(fr);--%>
<%--//            String numVal = br.readLine();--%>
<%--//            br.close();--%>
<%--//            int times = Integer.parseInt(numVal);--%>
<%--//            //增加一次--%>
<%--//            times++;--%>
<%--////            out.println("读出来的数据是"+numVal);--%>

<%--//            //创建一个File文件--%>
<%--//            FileWriter f = new FileWriter("f:\\myContext.txt");--%>
<%--//            BufferedWriter bw = new BufferedWriter(f);--%>
<%--//            bw.write("我是文件");--%>
<%--//            //关闭文件--%>
<%--//            bw.close();--%>
<%--//            out.println("我在文件中已经写入了数据");--%>


<%--        %>--%>

        <center>
<table border="1px">
    <tr>
        <td>用户的Id</td>
        <td>用户名</td>
        <td>用户密码</td>
        <td>邮箱地址</td>
        <td>用户等级</td>
        <td>修改用户</td>
        <td>删除用户</td>
    </tr>
    <%
        for (int i = 0; i < list.size(); i++) {

    %>
    <%int index = (Integer) list.get(i).get("userId");%>
    <tr>
        <td><%=list.get(i).get("userId")%></td>
        <td><%=list.get(i).get("userName")%></td>
        <td><%=list.get(i).get("password")%></td>
        <td><%=list.get(i).get("email")%></td>
        <td><%=list.get(i).get("grade")%></td>
<%--        获取table中的值传入到updateUser.jsp里的table中--%>
        <td><a href="updateUser.jsp?userId=<%=list.get(i).get("userId")%>&userName=<%=list.get(i).get("userName")%>
        &password=<%=list.get(i).get("password")%>
        &email=<%=list.get(i).get("email")%>
        &grade=<%=list.get(i).get("grade")%>
        ">修改用户</a></td>
        <td><a href="delete.jsp?userName="<%=list.get(i).get("userName")%>>删除用户</a></td>

    </tr>
    <%
        }
    %>
</table>
        </center>
        <hr>
<%--        //实现网页点击率的功能计数器--%>
        <%out.print("该网页被访问了：" +this.getServletConfig().getServletContext().getAttribute("visitTimes")+"次");%>


        <br>
<%
    //接收用户需要显示的页面，显示第几页
    //上一页
    String s_pageNow = (String) request.getAttribute("pageNow");
   int pageNow = Integer.parseInt(s_pageNow);
   if (pageNow != 1){
       out.println("<a href=UserClServlet?flag=fenye&pageNow="+(pageNow-1) +">上一页</a>");
   }




     //下一页
    String s_pageCount = (String) request.getAttribute("pageCount");
    int pageCount = Integer.parseInt(s_pageCount);


    for (int i = 1; i < pageCount; i++) {
        out.println("<a href=UserClServlet?flag=fenye&pageNow="+i+">["+i+"]</a>");
    }

    if (pageNow != pageCount){
        out.println("<a href=UserClServlet?flag=fenye&pageNow="+(pageNow + 1)+">下一页</a>");
    }
%>
</body>
</html>
