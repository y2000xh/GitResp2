package com.icss.controller.meeting;

import com.icss.service.MeetingService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateMeetingByMidToStatusServlet")
public class updateMeetingByMidToStatusServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置响应的编码格式
        response.setContentType("text/html;charset=utf-8");
        //获取前端数据
        System.out.println("我是updateMeetingByMidToStatusServlet");
        int mid = Integer.parseInt(request.getParameter("mid"));
        System.out.println("mid" + mid);
        MeetingService.updateMeetingByMidToStatus(mid);
    }
}
