package com.icss.controller.meeting;

import com.icss.service.EmpService;
import com.icss.service.Emp_mettingService;
import com.icss.service.MeetingService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/addMeetingByMidServlet")
public class addMeetingByMidServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置响应的编码格式
        response.setContentType("text/html;charset=utf-8");
        //获取前端页面的属性
        Date startTime = null;
        Date endTime = null;
        String mname = request.getParameter("mname");
        int mcount = Integer.parseInt(request.getParameter("mcount"));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            startTime = sdf.parse(request.getParameter("startTime"));
            endTime = sdf.parse(request.getParameter("endTime"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int rid = Integer.parseInt(request.getParameter("rid"));
        //获取session 获取username
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        //通过username获取eid
        int eid = EmpService.getEidEmpByUserName(username);
        String mnotes = request.getParameter("mnotes");
        //调用sql语句 添加到meeting中
        MeetingService.addMeetingByMid(mname, mcount, startTime, endTime, rid, eid, mnotes);
        //添加到emp_meeting中
        String[] a = request.getParameterValues("a[]");

        for (int i = 0; i < a.length; i++) {
            int mid = MeetingService.findMaxMidMeeting();
            Emp_mettingService.addEmp_meeting(mid, Integer.parseInt(a[i]));
        }

    }
}
