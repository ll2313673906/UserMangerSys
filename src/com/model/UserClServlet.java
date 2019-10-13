package com.model;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@WebServlet(name = "UserClServlet",urlPatterns = {"/UserClServlet"})
public class UserClServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charSet=utf-8");
        //分页
        String flag = request.getParameter("flag");
        if (flag.equals("fenye")){
            List<HashMap> list = new ArrayList<HashMap>();
           String s_pageNow = (String) request.getParameter("pageNow");
           int pageNow = Integer.parseInt(s_pageNow);
            UserDAOSqlServerImpl userDAO = new UserDAOSqlServerImpl();
          list= userDAO.search((pageNow-1)*3 , 3);
            int pageCount = userDAO.searchCount();
            request.setAttribute("result",list);
            request.setAttribute("pageCount",pageCount +"");
            request.setAttribute("pageNow",pageNow +"");
            System.out.println(list);
            request.getRequestDispatcher("Welcome.jsp").forward(request,response);
        }

        //删除用户

        if (flag.equals("delete")){
            //取得index的值
            int s_userId = Integer.parseInt(request.getParameter("userId"));
          UserDAOSqlServerImpl userDao = new UserDAOSqlServerImpl();
          int delete1 = userDao.delete(s_userId);
          if (userDao.delete(s_userId)==delete1){
              request.getRequestDispatcher("success.jsp").forward(request,response);
          }else {
              request.getRequestDispatcher("err.jsp").forward(request,response);
          }

        }

        //修改updateUser用户
        if (flag.equals("updateUser")){
            UserDAOSqlServerImpl userDAO = new UserDAOSqlServerImpl();
            String s_userId = request.getParameter("userId");
            int userId = Integer.parseInt(s_userId);
            String username = request.getParameter("userName");
            String password = request.getParameter("password");
            String email = request.getParameter("email");
            String grade = request.getParameter("grade");
                User user = new User();
            user.setUserId(userId);
            user.setUserName(username);
            user.setPassword(password);
            user.setEmail(email);
            user.setGrade(grade);
            //调用方法
              if (userDAO.update(user) == 1){
               request.getRequestDispatcher("success.jsp").forward(request,response);
           }else {
               request.getRequestDispatcher("err.jsp").forward(request,response);
           }
        }


        //添加用户
        if (flag.equals("addUser")){
            User user = new User();
            String userName = request.getParameter("userName");
            String password = request.getParameter("password");
            String email = request.getParameter("email");
            String grade = request.getParameter("grade");
            user.setUserName(userName);
            user.setPassword(password);
            user.setEmail(email);
            user.setGrade(grade);
            UserDAOSqlServerImpl userDAOSqlServer = new UserDAOSqlServerImpl();
            if (userDAOSqlServer.insertUser(user)==1){
                request.getRequestDispatcher("success.jsp").forward(request,response);
            }else {
                request.getRequestDispatcher("err.jsp").forward(request,response);
            }
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     doPost(request,response);
    }
}
