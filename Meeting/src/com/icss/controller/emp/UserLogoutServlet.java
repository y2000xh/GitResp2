package com.icss.controller.emp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/UserLogoutServlet")
public class UserLogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //使session立即失效
        HttpSession session = request.getSession();
        session.invalidate();
        //使Cookie立即失效
        Cookie[] cookies = request.getCookies();
        for (Cookie c : cookies) {
            //设置Cookie的时长为0 但是设置的只是Cookie数组中的时长
            //request中的Cookie还是没引发生变化
            c.setMaxAge(0);
            //Cookie重新存储到请求中
            //先读取Cookie的存储地址
            c.setPath(c.getPath());
            String path = c.getPath();
            c.setPath(path);
            response.addCookie(c);
        }
        //将页面响应重定向到Loging.html
        response.sendRedirect("login.html");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
