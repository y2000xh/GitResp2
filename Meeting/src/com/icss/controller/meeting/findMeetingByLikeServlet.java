package com.icss.controller.meeting;

import com.google.gson.Gson;
import com.icss.pojo.Meeting;
import com.icss.service.MeetingService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/findMeetingByLikeServlet")
public class findMeetingByLikeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置响应的编码格式
        response.setContentType("text/html;charset=utf-8");
        //获取前端数据
        String mname = request.getParameter("mname");
        String rname = request.getParameter("rname");
        String ename = request.getParameter("ename");
        String data11 = request.getParameter("data11");
        String data12 = request.getParameter("data12");
        String data21 = request.getParameter("data21");
        String data22 = request.getParameter("data22");
        System.out.println("mname=" + mname + ",rid=" + rname + ",eid=" + ename + ",data11=" + data11 + ",data12=" + data12 + ",data21=" + data21 + ",data22=" + data22);
        //定义一个sql语句
        String sql = "select mname,rname,starttime,endtime,booktime,ename,mid from meeting m " +
                "left JOIN room r on m.rid = r.rid " +
                "left join emp e on m.eid = e.eid where 1=1 ";
        //拼接sql
        if (!"".equals(mname) && !"null".equals(mname)) {
            sql += " and mname like '%" + mname + "%' ";
        }
        if (!"".equals(rname) && !"null".equals(rname)) {
            sql += " and rname like '%" + rname + "%' ";
        }
        if (!"".equals(ename) && !"null".equals(ename)) {
            sql += " and ename like '%" + ename + "%' ";
        }
        if (!"".equals(data11) && !"null".equals(data11)) {
            sql += " and booktime >='" + data11 + "' ";
        }
        if (data12 != null && data12 != "") {
            sql += " and  booktime <='" + data12 + "' ";
        }
        if (data21 != null && data21 != "") {
            sql += " and  starttime >='" + data21 + "' ";
        }
        if (data22 != null && data22 != "") {
            sql += " and  booktime <='" + data22 + "' ";
        }
        System.out.println(sql);
        //调用数据库 查询
        //获取Service返回的数据
        List<Meeting> ml = MeetingService.findMeetingLike(sql);
        //将java类型的al数据通过Gson转换为Json格式的数据
        //实例化Gson对象
        ArrayList<ArrayList> as = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for (int i = 0; i < ml.size(); i++) {
            ArrayList<Object> l = new ArrayList<>();
            l.add(ml.get(i).getMname().toString());
            l.add(ml.get(i).getRoom().getRname().toString());
            l.add(sdf.format(ml.get(i).getStarttime()));
            l.add(sdf.format(ml.get(i).getEndtime()));
            l.add(sdf.format(ml.get(i).getBooktime()));
            l.add(ml.get(i).getEmp().getEname().toString());
            l.add(Integer.parseInt(ml.get(i).getMid().toString()));
            as.add(l);
        }
        System.out.println(as);
        Gson gson = new Gson();
        //通过PrintWiter 将数据返回给页面
        PrintWriter pw = response.getWriter();
        pw.print(gson.toJson(as));
    }
}
