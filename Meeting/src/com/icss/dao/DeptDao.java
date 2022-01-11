package com.icss.dao;

import com.icss.pojo.Dept;
import com.icss.util.BaseDao;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: YXh
 * @create: 2021/12/2
 * @Description:
 * @FileName: DeptDao
 * @History:
 */
public class DeptDao {
    /**
     * 根据查询部门名称
     *
     * @return ArrayList<Dept>
     */
    public ArrayList<Dept> showAllDeptDao() {
        String sql = "select * from dept order by did";
        List<List> ll = BaseDao.exeDQL(sql);
        ArrayList<Dept> al = new ArrayList<>();
        for (List l : ll) {
            Dept dept = new Dept();
            dept.setDid(Integer.parseInt(l.get(0).toString()));
            dept.setDname(l.get(1).toString());
            al.add(dept);
        }
        return al;
    }

    /**
     * 查询部门名称是否已存在
     *
     * @param dname 部门名称
     * @return 存在返回0    不存在返回-1
     */
    public int findDeptByDeptno(String dname) {
        String sql = "select * from dept where dname = ?";
        List<List> ll = BaseDao.exeDQL(sql, dname);
        int msg = -1;
        System.out.println(ll);
        if (ll.size() != 0) {
            msg = 0;
        }
        return msg;
    }

    /**
     * 添加部门名称
     *
     * @param dname
     */
    public void addDeptDao(String dname) {
        String sql = "insert into dept(dname) values(?)";
        int i = BaseDao.exeDml(sql, dname);
        System.out.println("有 " + i + " 条数据添加到 dept 中");
    }

    /**
     * 通过编号删除部门
     *
     * @param did
     */
    public void deleteDeptDao(int did) {
        String sql = "delete from dept where did=?";
        int i = BaseDao.exeDml(sql, did);
        System.out.println("你有 " + i + " 条数据被删除了 id为" + did);
    }

}
