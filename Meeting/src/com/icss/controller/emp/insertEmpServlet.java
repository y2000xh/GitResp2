package com.icss.controller.emp;

import com.icss.service.EmpService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/insertEmpServlet")
public class insertEmpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置响应的编码格式
        response.setContentType("text/html;charset=utf-8");
        //获取Service返回的数据
        String username = request.getParameter("username");
        String ename = request.getParameter("ename");
        int password = Integer.parseInt(request.getParameter("password"));
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        int did = Integer.parseInt(request.getParameter("did"));
        EmpService.insertEmp(username,ename,password,phone,email,did);

    }
}
