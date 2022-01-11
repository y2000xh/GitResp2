package com.icss.controller.mep_meeting;

import com.google.gson.Gson;
import com.icss.service.Emp_mettingService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.List;

@WebServlet("/findEmp_meetingServlet")
public class findEmp_meetingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//设置响应的编码格式
        response.setContentType("text/html;charset=utf-8");
        //获取前端数据
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        System.out.println("username" + username);
        //调用数据库 查询
        //获取Service返回的数据
        List<List> em = Emp_mettingService.findEmp_meeting(username);
        //将java类型的al数据通过Gson转换为Json格式的数据
        //实例化Gson对象

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for (int i = 0; i < em.size(); i++) {
            em.get(i).set(2, sdf.format(em.get(i).get(2)));
            em.get(i).set(3, sdf.format(em.get(i).get(3)));
            em.get(i).set(4, sdf.format(em.get(i).get(4)));
        }
        Gson gson = new Gson();
        //通过PrintWiter 将数据返回给页面
        PrintWriter pw = response.getWriter();
        pw.print(gson.toJson(em));
    }
}
