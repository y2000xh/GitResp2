package com.icss.controller.dept;

import com.icss.service.DeptService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/FindDeptByDeptnoServlet")
public class FindDeptByDeptnoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置响应的编码格式
        response.setContentType("text/html;charset=utf-8");
        //获取页面传输过来的数据
        String bname = request.getParameter("bname");
        int num = DeptService.findDeptByDeptno(bname);

        //将num再响应回login.html中
        PrintWriter pw = response.getWriter();
        pw.print(num);
    }
}
