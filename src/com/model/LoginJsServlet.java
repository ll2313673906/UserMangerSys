package com.model;


import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@WebServlet(name = "LoginJsServlet",urlPatterns = {"/login"})
public class LoginJsServlet extends HttpServlet {

    @Override
    public void init() {
        try{
            FileReader fr = new FileReader("f:\\myContext.txt");
            BufferedReader br = new BufferedReader(fr);
            String numVal = br.readLine();
            br.close();
            this.getServletContext().setAttribute("visitTimes",numVal);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void destroy() {
        try{
            FileWriter fw = new FileWriter("f:\\myContext.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            //写入数据
            bw.write(this.getServletContext().getAttribute("visitTimes").toString());
            bw.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


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
         //取出init中的值
           String times = this.getServletContext().getAttribute("visitTimes").toString();
           //加1整数才能加1，所以转换类型，但是又写进去，所以+“又转换成字符串
           this.getServletContext().setAttribute("visitTimes",(Integer.parseInt(times)+1)+"");
            request.getRequestDispatcher("main.jsp").forward(request,response);
        }else {
            out.println("登入失败");
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

     doPost(request,response);
    }

}
