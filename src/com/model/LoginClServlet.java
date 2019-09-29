package com.model;

//import model.User;
//import model.UserDAOSqlServerImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginClServlet",urlPatterns = {"/LoginClServlet"})
public class LoginClServlet extends HttpServlet {
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
        UserDAOSqlServerImpl userDAOSqlServer = new UserDAOSqlServerImpl();
        if (userDAOSqlServer.findUser(user)) {
            hs.setAttribute("username",username);
            request.getRequestDispatcher("/UMS/Welcome.jsp").forward(request,response);
        }else {
            out.println("登入失败");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
