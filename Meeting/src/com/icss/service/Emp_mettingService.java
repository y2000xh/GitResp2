package com.icss.service;

import com.icss.dao.Emp_meetingDao;

import java.util.List;

/**
 * @author: YXh
 * @create: 2021/12/2
 * @Description:
 * @FileName: EmpService
 * @History:
 */
public class Emp_mettingService {

    static Emp_meetingDao em = new Emp_meetingDao();

    /**
     * 根据账户姓名查找信息
     *
     * @param username
     * @return
     */
    public static List<List> findEmp_meeting(String username) {
        return em.findEmp_meeting(username);
    }

    /**
     * 插入数据
     *
     * @param mid
     * @param eid
     */
    public static void addEmp_meeting(int mid, int eid) {
        em.addEmp_meeting(mid, eid);
    }
}
