package com.icss.dao;

import com.icss.pojo.Emp;
import com.icss.util.BaseDao;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: YXh
 * @create: 2021/12/2
 * @Description:
 * @FileName: EmpDap
 * @History:
 */
public class EmpDao {
    /**
     * 根据账户名查找用户信息
     *
     * @param username 账户名
     * @return Emp 账户信息
     */
    public Emp checkUserLoginDao(String username) {
        String sql = "select eid,ename,password,status from emp where username = ?";
        List<List> lists = BaseDao.exeDQL(sql, username);
        Emp emp = new Emp();
        //判断lists是否为空
        if (lists.size() != 0) {
            emp.setEid(Integer.parseInt(lists.get(0).get(0).toString()));
            emp.setUsername(username);
            emp.setEname(lists.get(0).get(1).toString());
            emp.setPassword(lists.get(0).get(2).toString());
            emp.setStatus(lists.get(0).get(3).toString());
        }
        return emp;
    }

    /**
     * 根据账户查找姓名
     *
     * @param username 员工账户
     * @return 员工姓名
     */
    public String getEnameByUserName(String username) {
        String sql = "select ename from emp where username = ?";
        List<List> al = BaseDao.exeDQL(sql, username);
        return al.get(0).get(0).toString();
    }

    /**
     * 插入一条信息
     *
     * @param username 账户名
     * @param ename    姓名
     * @param password 密码
     * @param phone    电话
     * @param email    邮箱
     * @param did      部门id
     */
    public void insertEmp(String username, String ename, int password, String phone, String email, int did) {
        String sql = "insert into emp values(null,?,?,?,?,?,?,0)";
        int i = BaseDao.exeDml(sql, username, ename, password, phone, email, did);
        System.out.println("有" + i + "条数据被插入");
    }

    /**
     * 审核员工账号状态
     *
     * @return
     */
    public List<Emp> findEmpBystatus() {
        String sql = "select  ename,username,phone,email from emp where status = 0 ";
        List<List> ls = BaseDao.exeDQL(sql);
        ArrayList<Emp> al = new ArrayList<>();
        for (List l : ls) {
            Emp e = new Emp();
            e.setEname(l.get(0).toString());
            e.setUsername(l.get(1).toString());
            e.setPhone(l.get(2).toString());
            e.setEmail(l.get(3).toString());
            al.add(e);
        }
        System.out.println("Dao:findEmpBystatus" + ls);
        return al;
    }

    /**
     * 修改员工审核状态
     *
     * @param username
     */
    public void updateEmpByStatus(String status, String username) {
        String sql = "update emp set status = ? where username = ? ";
        int i = BaseDao.exeDml(sql, status, username);
        System.out.println("Emp中有" + i + "条数据被修改成功了");
    }

    /**
     * 模糊查询员工信息
     *
     * @param ename    员工姓名
     * @param username 员工账号
     * @param status   账号状态
     * @return
     */
    public List<Emp> findEmpLikeStatusandEnameandusername(String ename, String username, String status) {
        String sql = "";
        if ("0".equals(status)) {
            sql = "select ename,username,phone,email  from emp where ename like ? and username like ? and status = 0";
        } else if ("1".equals(status)) {
            sql = "select ename,username,phone,email  from emp where ename like ? and username like ? and (status = 1 or status = 2)";

        } else if ("2".equals(status)) {
            sql = "select ename,username,phone,email  from emp where ename like ? and username like ? and status = 2";

        } else if ("3".equals(status)) {
            sql = "select ename,username,phone,email  from emp where ename like ? and username like ? and (status = 0 or status = 1 or status = 2)";
        }
        List<List> ls = BaseDao.exeDQL(sql, "%" + ename + "%", "%" + username + "%");
        ArrayList<Emp> al = new ArrayList<>();
        for (List l : ls) {
            Emp e = new Emp();
            e.setEname(l.get(0).toString());
            e.setUsername(l.get(1).toString());
            e.setPhone(l.get(2).toString());
            e.setEmail(l.get(3).toString());
            al.add(e);
        }
        return al;
    }

    /**
     * 根据部门名称查找部门员工
     *
     * @param did
     * @return
     */
    public List<Emp> findEmpEidByDid(int did) {
        String sql = "select * from emp where did = ? ";
        List<List> ls = BaseDao.exeDQL(sql, did);
        ArrayList<Emp> al = new ArrayList<>();
        for (List l : ls) {
            Emp e = new Emp();
            e.setEid(Integer.parseInt(l.get(0).toString()));
            e.setEname(l.get(2).toString());
            al.add(e);
        }
        return al;
    }

    /**
     * 根据账户查找eid
     *
     * @param username 员工账户
     * @return 员工姓名
     */
    public int getEidEmpByUserName(String username) {
        String sql = "select eid from emp where username = ?";
        List<List> al = BaseDao.exeDQL(sql, username);
        return Integer.parseInt(al.get(0).get(0).toString());
    }


}
