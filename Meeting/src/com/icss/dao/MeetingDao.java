package com.icss.dao;

import com.icss.pojo.Emp;
import com.icss.pojo.Meeting;
import com.icss.pojo.Room;
import com.icss.util.BaseDao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author: YXh
 * @create: 2021/12/2
 * @Description:
 * @FileName: MeetingDao
 * @History:
 */
public class MeetingDao {
    /**
     * 查询所有会议信息
     *
     * @return
     */
    public List<Meeting> findMeeting() {
        String sql = "select * from meeting";
        List<List> ls = BaseDao.exeDQL(sql);
        ArrayList<Meeting> meetings = new ArrayList<>();
        Meeting m = new Meeting();
        Room room = new Room();
        Emp emp = new Emp();
        for (List l : ls) {
            m.setMid(Integer.parseInt(l.get(0).toString()));
            m.setMname(l.get(1).toString());
            m.setMcount(Integer.parseInt(l.get(2).toString()));
            m.setStarttime(new Date(l.get(3).toString()));
            m.setEndtime(new Date(l.get(4).toString()));
            m.setBooktime(new Date(l.get(5).toString()));
            room.setRid(Integer.parseInt(l.get(6).toString()));
            m.setRoom(room);
            emp.setEid(Integer.parseInt(l.get(7).toString()));
            m.setEmp(emp);
            m.setStatus(l.get(8).toString());
            m.setMnotes(l.get(9).toString());
            meetings.add(m);
        }
        return meetings;
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
    public void addMeetingByMid(String mname, Integer mcount, Date starttime, Date endtime, int rid, int eid, String mnotes) {
        String sql = "insert into meeting values(null,?,?,?,?,now(),?,?,0,?)";
        int i = BaseDao.exeDml(sql, mname, mcount, starttime, endtime, rid, eid, mnotes);
        System.out.println("有" + i + "条数据被插入metting表中");
    }

    /**
     * 查找最大mid
     *
     * @return MAxmid
     */
    public int findMaxMidMeeting() {
        String sql = "select Max(mid) from meeting";
        List<List> ls = BaseDao.exeDQL(sql);
        return Integer.parseInt(ls.get(0).get(0).toString());
    }

    /**
     * 模糊查询
     *
     * @param sql 拼接好的SQL语句
     * @return Meeting对象的list集合
     */
    public List<Meeting> findMeetingLike(String sql) {
        List<List> ls = BaseDao.exeDQL(sql);
        ArrayList<Meeting> ms = new ArrayList<>();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        for (List l : ls) {
            Meeting m = new Meeting();
            Room r = new Room();
            Emp e = new Emp();
            m.setMname(l.get(0).toString());
            r.setRname(l.get(1).toString());
            m.setRoom(r);
            try {
                m.setStarttime(sf.parse(l.get(2).toString()));
                m.setEndtime(sf.parse(l.get(3).toString()));
                m.setBooktime(sf.parse(l.get(4).toString()));
            } catch (ParseException parseException) {
                parseException.printStackTrace();
            }
            e.setEname(l.get(5).toString());
            m.setEmp(e);
            m.setMid(Integer.parseInt(l.get(6).toString()));
            ms.add(m);
        }
        return ms;
    }

    /**
     * 根据会议id查找会议信息
     *
     * @param mid 会议id
     * @return Meeting对象的list集合  里面有mid mname mcount startime endtime booktime rname eid ename status mnotes
     */
    public List<Meeting> findMeetingByMname(int mid) {
        String sql = "select mid,mname,mcount,starttime,endtime,booktime,rname,m.eid,ename,m.status,m.mnotes from meeting m " +
                " left JOIN room r on m.rid = r.rid left join emp e on m.eid = e.eid " +
                " where mid = ? ";
        List<List> ls = BaseDao.exeDQL(sql, mid);
        ArrayList<Meeting> ms = new ArrayList<>();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        for (List l : ls) {
            Meeting m = new Meeting();
            Room r = new Room();
            Emp e = new Emp();
            m.setMid(Integer.parseInt(l.get(0).toString()));
            m.setMname(l.get(1).toString());
            m.setMcount(Integer.parseInt(l.get(2).toString()));
            try {
                m.setStarttime(sf.parse(l.get(3).toString()));
                m.setEndtime(sf.parse(l.get(4).toString()));
                m.setBooktime(sf.parse(l.get(5).toString()));
            } catch (ParseException parseException) {
                parseException.printStackTrace();
            }
            r.setRname(l.get(6).toString());
            m.setRoom(r);
            e.setEid(Integer.parseInt(l.get(7).toString()));
            e.setEname(l.get(8).toString());
            m.setEmp(e);
            m.setStatus(l.get(9).toString());
            m.setMnotes(l.get(10).toString());
            ms.add(m);
        }
        return ms;
    }

    /**
     * 根据员工id查找会议信息
     *
     * @param username
     * @return
     */
    public List<Meeting> findMeetingByEid(String username) {
        String sql = "select mname,rname,starttime,endtime,booktime,m.mid,m.status from meeting m left JOIN room r on m.rid = r.rid left join emp e on m.eid = e.eid where e.username = ? ;";
        List<List> ls = BaseDao.exeDQL(sql, username);
        ArrayList<Meeting> al = new ArrayList<>();
        for (List l : ls) {
            Meeting meeting = new Meeting();
            meeting.setMname(l.get(0).toString());
            Room r = new Room();
            r.setRname(l.get(1).toString());
            meeting.setRoom(r);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                meeting.setStarttime(sdf.parse(l.get(2).toString()));
                meeting.setEndtime(sdf.parse(l.get(3).toString()));
                meeting.setBooktime(sdf.parse(l.get(4).toString()));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            meeting.setMid(Integer.parseInt(l.get(5).toString()));
            meeting.setStatus(l.get(6).toString());
            al.add(meeting);
        }
//        System.out.println("MeetingDaoal" + al);
        return al;
    }

    /**
     * 根据会议编号修改会议状态
     *
     * @param mid 会议编号
     */
    public void updateMeetingByMidToStatus(int mid) {
        String sql = "update meeting set status = 1 where mid = ? ";
        int i = BaseDao.exeDml(sql, mid);
        System.out.println("有" + i + "条数据再Meeting中被修改");
    }

    /**
     * 查找7天被的会议
     *
     * @return
     */
    public List<Meeting> findMeetingDay7(String username) {
        String sql = "select mname,rname,starttime,endtime,m.mid from meeting m left join room r on r.rid = m.rid left join emp e on e.eid = m.eid where starttime BETWEEN NOW() AND DATE_FORMAT(DATE_SUB(NOW(), INTERVAL -7 DAY),'%Y-%m-%d') and e.username = ?  ";
        List<List> ls = BaseDao.exeDQL(sql, username);
        ArrayList<Meeting> al = new ArrayList<>();
        for (List l : ls) {
            Meeting meeting = new Meeting();
            meeting.setMname(l.get(0).toString());
            Room r = new Room();
            r.setRname(l.get(1).toString());
            meeting.setRoom(r);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                meeting.setStarttime(sdf.parse(l.get(2).toString()));
                meeting.setEndtime(sdf.parse(l.get(3).toString()));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            meeting.setMid(Integer.parseInt(l.get(4).toString()));
            al.add(meeting);
        }
        System.out.println("findMeetingDay7=====" + al);
        return al;
    }

    /**
     * 查询自己已取消的会议
     *
     * @param username 账号名
     * @return
     */
    public List<Meeting> findMeetingByStatus1(String username) {
        String sql = "select m.mname,r.rname,m.starttime,m.endtime,m.mid from meeting m left join emp e on e.eid = m.eid left join room r on r.rid = m.rid where m.status = 1 and e.username = ? ";
        List<List> ls = BaseDao.exeDQL(sql, username);
        ArrayList<Meeting> al = new ArrayList<>();
        for (List l : ls) {
            Meeting meeting = new Meeting();
            meeting.setMname(l.get(0).toString());
            Room r = new Room();
            r.setRname(l.get(1).toString());
            meeting.setRoom(r);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                meeting.setStarttime(sdf.parse(l.get(2).toString()));
                meeting.setEndtime(sdf.parse(l.get(3).toString()));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            meeting.setMid(Integer.parseInt(l.get(4).toString()));
            al.add(meeting);
        }
        System.out.println("findMeetingByStatus1=====" + al);
        return al;
    }

    /**
     * 查询mname是否重复
     *
     * @param mname
     * @return
     */
    public List<List> findMeetingByMname(String mname) {
        String sql = "select mname from meeting where mname = ?";
        List<List> ls = BaseDao.exeDQL(sql, mname);
        return ls;
    }


}
