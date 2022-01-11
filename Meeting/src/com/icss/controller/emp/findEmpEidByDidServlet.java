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

@WebServlet("/findEmpEidByDidServlet")
public class findEmpEidByDidServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置响应的编码格式
        response.setContentType("text/html;charset=utf-8");
        //获取前端数据
        int did = Integer.parseInt(request.getParameter("did"));
        List<Emp> emps = EmpService.findEmpEidByDid(did);
        //返回emp对象 主要使用eid ename
        Gson gson = new Gson();
        //通过PrintWiter 将数据返回给页面
        PrintWriter pw = response.getWriter();
        pw.print(gson.toJson(emps));
    }
}
