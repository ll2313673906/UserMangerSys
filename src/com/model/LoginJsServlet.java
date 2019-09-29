package com.model;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@WebServlet(name = "LoginJsServlet",urlPatterns = {"/login"})
public class LoginJsServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //解决乱码问题
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charSet=utf-8");
        //向浏览器输出信息
        PrintWriter out = response.getWriter();
        //接受用户名和密码 在Login里面的用户信息
        String username =  request.getParameter("username");
        String password  = request.getParameter("password");
        HttpSession hs = request.getSession(true);
        User user = new User();
        user.setUserName(username);
        user.setPassword(password);
        UserDAOSqlServerImpl userDAO = new UserDAOSqlServerImpl();
        List<HashMap> list = new ArrayList<>();
        if (userDAO.findUser(user)) {
           list =  userDAO.search(0,3);
           //计算页数
            int pageCount = userDAO.searchCount();

           //吧list中的数据代入Welcome页面中
            request.setAttribute("result",list);
            request.setAttribute("pageCount",pageCount + "") ;
            request.setAttribute("pageNow","1");

            hs.setAttribute("username",username);
            request.getRequestDispatcher("Welcome.jsp").forward(request,response);
        }else {
            out.println("登入失败");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     doPost(request,response);
    }
}
