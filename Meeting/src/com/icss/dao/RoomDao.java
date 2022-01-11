package com.icss.dao;

import com.icss.pojo.Room;
import com.icss.util.BaseDao;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: YXh
 * @create: 2021/12/2
 * @Description:
 * @FileName: RoomDao
 * @History:
 */
public class RoomDao {
    /**
     * 插入会议室
     *
     * @param housenum 会议室门牌号
     * @param rname    会议室名称
     * @param maxnum   最大人数
     * @param status   状态(可用 不可用)
     * @param notes    备注
     */
    public void addRoom(String housenum, String rname, int maxnum, String status, String notes) {
        String sql = "insert into room values(null,?,?,?,?,?)";
        int num = BaseDao.exeDml(sql, housenum, rname, maxnum, status, notes);
        System.out.println("有" + num + "条数据插入room表中");
    }

    /**
     * 查询会议室门牌号是否存在
     *
     * @param housenum 会议室门牌号
     * @return -1不存在   0存在
     */
    public int findRoomByHousenum(String housenum) {
        String sql = "select housenum from room where housenum = ?";
        List<List> ll = BaseDao.exeDQL(sql, housenum);
        int num = -1;
        if (ll.size() != 0) {
            num = 0;
        }
        return num;
    }

    /**
     * 查询会议室名称是否为空
     *
     * @param rname 会议室名称
     * @return -1不存在   0存在
     */
    public int findRoomByRname(String rname) {
        String sql = "select rname from room where rname = ?";
        List<List> ll = BaseDao.exeDQL(sql, rname);
        int num = -1;
        if (ll.size() != 0) {
            num = 0;
        }
        return num;
    }

    /**
     * 查询所有会议表信息
     *
     * @return List<Room>集合对象
     */
    public List<Room> findRoom() {
        String sql = "select * from room";
        ArrayList<Room> rooms = new ArrayList<>();
        List<List> ls = BaseDao.exeDQL(sql);
        for (List l : ls) {
            Room room = new Room();
            room.setRid(Integer.parseInt(l.get(0).toString()));
            room.setHousenum(l.get(1).toString());
            room.setRname(l.get(2).toString());
            room.setMaxnum(Integer.parseInt(l.get(3).toString()));
            room.setStatus(Integer.parseInt(l.get(4).toString()));
            room.setNotes(l.get(5).toString());
            rooms.add(room);
        }
        return rooms;
    }

    /**
     * 根据会议室编号查询会议室信息
     *
     * @param rid 会议室编号
     * @return room会议室对象
     */
    public Room findRoomByRid(int rid) {
        String sql = "select * from room where rid = ?";
        List<List> lists = BaseDao.exeDQL(sql, rid);
        Room room = new Room();
        room.setRid(rid);
        room.setHousenum(lists.get(0).get(1).toString());
        room.setRname(lists.get(0).get(2).toString());
        room.setMaxnum(Integer.parseInt(lists.get(0).get(3).toString()));
        room.setStatus(Integer.parseInt(lists.get(0).get(4).toString()));
        room.setNotes(lists.get(0).get(5).toString());
        return room;
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
    public void updateRoom(int rid, String housenum, String rname, int maxnum, String status, String notes) {
        String sql = "update room set housenum=?,rname=?,maxnum=?,status=?,notes=? where rid = ?";
        int i = BaseDao.exeDml(sql, housenum, rname, maxnum, status, notes, rid);
        System.out.println("有" + i + "条数据在Room表中被修改");
    }


}
