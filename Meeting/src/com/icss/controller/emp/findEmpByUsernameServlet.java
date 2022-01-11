package com.icss.controller.emp;

import com.icss.service.EmpService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/findEmpByUsernameServlet")
public class findEmpByUsernameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置响应的编码格式
        response.setContentType("text/html;charset=utf-8");
        //从前端中获取账户
        String username = request.getParameter("username");
        //通过账户获取姓名
        String ename = EmpService.getEnameByUsernameService(username);
        //把ename返回到index.html
        PrintWriter writer = response.getWriter();
        writer.print(ename);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
