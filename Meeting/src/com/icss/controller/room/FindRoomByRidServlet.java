package com.icss.controller.room;

import com.google.gson.Gson;
import com.icss.pojo.Room;
import com.icss.service.RoomService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/FindRoomByRidServlet")
public class FindRoomByRidServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置响应的编码格式
        response.setContentType("text/html;charset=utf-8");
        //获取Service返回的数据
        int rid = Integer.parseInt(request.getParameter("rid"));
        Room roomByRid = RoomService.findRoomByRid(rid);
        //将java类型的al数据通过Gson转换为Json格式的数据
        //实例化Gson对象
        Gson gson = new Gson();
        //将num再响应回login.html中
        PrintWriter pw = response.getWriter();
        pw.print(gson.toJson(roomByRid));
    }
}
