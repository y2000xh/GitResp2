package com.icss.dao;

import com.icss.util.BaseDao;

import java.util.List;

/**
 * @author: YXh
 * @create: 2021/12/2
 * @Description:
 * @FileName: Emp_mettingDao
 * @History:
 */
public class Emp_meetingDao {
    /**
     * 根据账户姓名查找信息
     *
     * @param username
     * @return
     */
    public List<List> findEmp_meeting(String username) {
        String sql = "select m.mname,r.RNAME,m.starttime,m.endtime,m.booktime,e1.ename,m.mid from emp_meeting em left join emp e on em.eid = e.eid left join meeting m on m.mid = em.mid left join room r on m.rid = r.rid left join emp e1 on e1.eid = m.eid where e.username = ? ORDER BY m.starttime ";
        List<List> ls = BaseDao.exeDQL(sql, username);
        return ls;
    }

    /**
     * 插入数据
     *
     * @param mid
     * @param eid
     */
    public void addEmp_meeting(int mid, int eid) {
        String sql = "insert into emp_meeting values(?,?) ";
        int i = BaseDao.exeDml(sql, mid, eid);
        System.out.println("有" + i + "条数据被插入emp_meeting中");
    }

}
