package com.icss.service;

import com.icss.dao.RoomDao;
import com.icss.pojo.Room;

import java.util.List;

/**
 * @author: YXh
 * @create: 2021/12/2
 * @Description:
 * @FileName: EmpService
 * @History:
 */
public class RoomService {
    static RoomDao rd = new RoomDao();

    /**
     * 添加会议室信息
     *
     * @param housenum 会议室门牌号
     * @param rname    会议室名称
     * @param maxnum   最大人数
     * @param status   状态(0可用 1不可用)
     * @param notes    备注
     */
    public static void addRoom(String housenum, String rname, int maxnum, String status, String notes) {
        rd.addRoom(housenum, rname, maxnum, status, notes);
    }

    /**
     * 查询会议室门牌号是否为空
     *
     * @param housenum
     * @return
     */
    public static int findRoomByHousenum(String housenum) {
        return rd.findRoomByHousenum(housenum);
    }

    /**
     * 查询会议室名称是否为空
     *
     * @param rname 会议室名称
     * @return -1不存在   0存在
     */
    public static int findRoomByRname(String rname) {
        return rd.findRoomByRname(rname);
    }

    /**
     * 查询所有会议表信息
     *
     * @return List<Room>集合对象
     */
    public static List<Room> findRoom() {
        return rd.findRoom();
    }

    /**
     * 根据会议室编号查询会议室信息
     *
     * @param rid 会议室编号
     * @return room会议室对象
     */
    public static Room findRoomByRid(int rid) {
        return rd.findRoomByRid(rid);
    }

    /**
     * 根据rid修改会议室信息
     *
     * @param housenum 会议室门牌号
     * @param rname    会议室名称
     * @param maxnum   最大人数
     * @param status   状态(可用 不可用)
     * @param notes    备注
     */
    public static void updateRoom(int rid, String housenum, String rname, int maxnum, String status, String notes) {
        rd.updateRoom(rid, housenum, rname, maxnum, status, notes);
    }
}
