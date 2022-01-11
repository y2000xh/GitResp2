package com.icss.controller.room;

import com.icss.service.RoomService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateRoomByRidServlet")
public class updateRoomByRidServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置响应的编码格式
        response.setContentType("text/html;charset=utf-8");
        //获取Service返回的数据
        int rid = Integer.parseInt(request.getParameter("rid"));
        String housenum = request.getParameter("housenum");
        String rname = request.getParameter("rname");
        int maxnum = Integer.parseInt(request.getParameter("maxnum"));
        String status = request.getParameter("status");
        String notes = request.getParameter("notes");
        System.out.println(notes);
        RoomService.updateRoom(rid, housenum, rname, maxnum, status, notes);
    }
}
