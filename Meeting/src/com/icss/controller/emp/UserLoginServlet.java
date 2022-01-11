package com.icss.controller.emp;

import com.icss.service.EmpService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求中的Cookie数组
        Cookie[] cookies = request.getCookies();
        String username = null;
        String password = null;
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("username")) {
                    username = c.getValue();
                }
                if (c.getName().equals("password")) {
                    password = c.getValue();
                }
            }
        }
        if (username != null && password != null) {
            int num = EmpService.checkUserLoginService(username, password);
            if (num == 1) {
                HttpSession session = request.getSession();
                session.setAttribute("username", username);
                session.setMaxInactiveInterval(60 * 60);
            }
            //将num再响应回login.html中
            PrintWriter writer = response.getWriter();
            writer.print(num);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取页面传递过来的数据
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        int num = EmpService.checkUserLoginService(username, password);
        if (num == 1) {
            //这个账户名和密码和状态没有问题
            //存储cookie和Session
            //cookie
            //先获取Cookie的有效期
            String timelength = request.getParameter("timelength");
            int time = Integer.parseInt(timelength);
            //声明两个Cookie将用户名和密码都保存到Cookie中
            Cookie cusername = new Cookie("username", username);
            Cookie cpassword = new Cookie("password", password);
            cpassword.setMaxAge(60 * 60 * time);
            cusername.setMaxAge(60 * 60 * time);
            //将Cookie储存到响应中
            response.addCookie(cusername);
            response.addCookie(cpassword);
            //session
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            session.setMaxInactiveInterval(60 * 60);
        }
        //将num再响应回login.html中
        PrintWriter pw = response.getWriter();
        pw.print(num);

    }
}
