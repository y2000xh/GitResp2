package com.icss.service;

import com.icss.dao.DeptDao;
import com.icss.pojo.Dept;

import java.util.ArrayList;

/**
 * @author: YXh
 * @create: 2021/12/2
 * @Description:
 * @FileName: DeptService
 * @History:
 */
public class DeptService {
    static DeptDao dd = new DeptDao();

    /**
     * 查询所有的部门信息
     *
     * @return
     */
    public static ArrayList<Dept> showAllDeptService() {
        return dd.showAllDeptDao();
    }

    /**
     * 查询dname是否存在
     *
     * @param dname
     * @return
     */
    public static int findDeptByDeptno(String dname) {
        return dd.findDeptByDeptno(dname);
    }

    /**
     * 添加部门名称
     *
     * @param dname 部门名称
     */
    public static void addDeptDao(String dname) {
        dd.addDeptDao(dname);
    }

    /**
     * 通过编号删除部门
     *
     * @param did
     */
    public static void deleteDeptByidService(int did) {
        dd.deleteDeptDao(did);
    }
}
