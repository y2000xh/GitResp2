package com.icss.controller.meeting;

import com.google.gson.Gson;
import com.icss.pojo.Meeting;
import com.icss.service.MeetingService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/findMeetingByEidServlet")
public class findMeetingByEidServlet extends HttpServlet {
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
        List<Meeting> ml = MeetingService.findMeetingByEid(username);
        //将java类型的al数据通过Gson转换为Json格式的数据
        //实例化Gson对象
        ArrayList<ArrayList> as = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for (int i = 0; i < ml.size(); i++) {
            ArrayList<Object> l = new ArrayList<>();
            l.add(ml.get(i).getMname().toString());
            l.add(ml.get(i).getRoom().getRname());
            l.add(sdf.format(ml.get(i).getStarttime()));
            l.add(sdf.format(ml.get(i).getEndtime()));
            l.add(sdf.format(ml.get(i).getBooktime()));
            l.add(ml.get(i).getMid());
            l.add(ml.get(i).getStatus());
            as.add(l);
        }
        System.out.println("as" + as);
        Gson gson = new Gson();
        //通过PrintWiter 将数据返回给页面
        PrintWriter pw = response.getWriter();
        pw.print(gson.toJson(as));
    }
}
