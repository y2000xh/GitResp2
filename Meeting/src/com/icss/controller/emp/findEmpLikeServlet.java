package com.icss.controller.emp;

import com.google.gson.Gson;
import com.icss.pojo.Emp;
import com.icss.service.EmpService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/findEmpLikeServlet")
public class findEmpLikeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置响应的编码格式
        response.setContentType("text/html;charset=utf-8");
        //获取Service返回的数据
        String ename = request.getParameter("ename");
        String username = request.getParameter("username");
        String status = request.getParameter("status");
        List<Emp> al = EmpService.findEmpLikeStatusandEnameandusername(ename, username, status);
        //通过PrintWiter 将数据返回给页面
        Gson gson = new Gson();
        PrintWriter pw = response.getWriter();
        pw.print(gson.toJson(al));
    }
}
