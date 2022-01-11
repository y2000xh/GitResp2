package com.icss.service;

import com.icss.dao.MeetingDao;
import com.icss.pojo.Meeting;

import java.util.Date;
import java.util.List;

/**
 * @author: YXh
 * @create: 2021/12/2
 * @Description:
 * @FileName: EmpService
 * @History:
 */
public class MeetingService {
    static MeetingDao md = new MeetingDao();

    /**
     * 模糊查询
     *
     * @param sql 拼接好的SQL语句
     * @return Meeting对象的list集合
     */
    public static List<Meeting> findMeetingLike(String sql) {
        return md.findMeetingLike(sql);
    }

    /**
     * 根据会议id查找会议信息
     *
     * @param mid 会议id
     * @return Meeting对象的list集合  里面有mid mname mcount startime endtime booktime rname eid ename status mnotes
     */
    public static List<Meeting> findMeetingByMname(int mid) {
        return md.findMeetingByMname(mid);
    }

    /**
     * 根据员工id查找会议信息
     *
     * @param eid
     * @return
     */
    public static List<Meeting> findMeetingByEid(String eid) {
        return md.findMeetingByEid(eid);
    }

    /**
     * 根据会议编号修改会议状态
     *
     * @param mid 会议编号
     */
    public static void updateMeetingByMidToStatus(int mid) {
        md.updateMeetingByMidToStatus(mid);
    }

    /**
     * 查找7天被的会议
     *
     * @return
     */
    public static List<Meeting> findMeetingDay7(String username) {
        return md.findMeetingDay7(username);
    }

    /**
     * 查询自己已取消的会议
     *
     * @param username 账号名
     * @return
     */
    public static List<Meeting> findMeetingByStatus1(String username) {
        return md.findMeetingByStatus1(username);
    }

    /**
     * 查询mname是否重复
     *
     * @param mname
     * @return
     */
    public static List<List> findMeetingByMname(String mname) {
        return md.findMeetingByMname(mname);
    }

    /**
     * 预定会议 向会议表中插入信息
     *
     * @param mname     会议名称
     * @param mcount    最大人数
     * @param starttime 开始时间
     * @param endtime   结束时间
     * @param rid       会议室编号
     * @param eid       员工编号
     * @param mnotes    会议备注
     */
    public static void addMeetingByMid(String mname, Integer mcount, Date starttime, Date endtime, int rid, int eid, String mnotes) {
        md.addMeetingByMid(mname, mcount, starttime, endtime, rid, eid, mnotes);
    }

    /**
     * 查找最大mid
     *
     * @return MAxmid
     */
    public static int findMaxMidMeeting() {
        return md.findMaxMidMeeting();
    }

}
