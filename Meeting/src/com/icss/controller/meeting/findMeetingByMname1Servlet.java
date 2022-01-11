package com.icss.controller.meeting;

import com.google.gson.Gson;
import com.icss.service.MeetingService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/findMeetingByMname1Servlet")
public class findMeetingByMname1Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置响应的编码格式
        response.setContentType("text/html;charset=utf-8");
        //获取前端数据
        String mname = request.getParameter("mname");
        System.out.println("findMeetingByMname1Servlet" + mname);
        List<List> l = MeetingService.findMeetingByMname(mname);
        int opt = -1;
        if (l.size() == 0) {
            opt = 1;
        }
        Gson gson = new Gson();
        //通过PrintWiter 将数据返回给页面
        PrintWriter pw = response.getWriter();
        pw.print(gson.toJson(opt));
    }
}
