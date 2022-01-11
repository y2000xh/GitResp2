package com.icss.service;

import com.icss.dao.EmpDao;
import com.icss.pojo.Emp;

import java.util.List;

/**
 * @author: YXh
 * @create: 2021/12/2
 * @Description:
 * @FileName: EmpService
 * @History:
 */
public class EmpService {
    //实例化dao层对象
    static EmpDao ed = new EmpDao();

    /**
     * 检测用户登录   业务逻辑
     *
     * @param username
     * @param password
     * @return 0账户正在审核 1审核成功   2审核失败   3密码错误   4账户不存在
     */
    public static int checkUserLoginService(String username, String password) {
        Emp emp = ed.checkUserLoginDao(username);
        int num = -1;
        if (emp.getUsername() == null) {
            num = 4;
        } else if (password.equals(emp.getPassword())) {
            //密码没问题 验证status的状态
            if ("0".equals(emp.getStatus())) {
                //账户正在审核中
                num = 0;
            } else if ("1".equals(emp.getStatus())) {
                //账户正在审核中
                num = 1;
            } else if ("2".equals(emp.getStatus())) {
                //账户正在审核中
                num = 2;
            }
        } else {
            //密码不正确
            num = 3;
        }
        return num;
    }

    /**
     * 通过账户查找员工姓名
     *
     * @param username
     * @return
     */
    public static String getEnameByUsernameService(String username) {
        return ed.getEnameByUserName(username);
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
    public static void insertEmp(String username, String ename, int password, String phone, String email, int did) {
        ed.insertEmp(username, ename, password, phone, email, did);
    }

    /**
     * 审核员工账号状态
     *
     * @return
     */
    public static List<Emp> findEmpBystatus() {
        return ed.findEmpBystatus();
    }

    /**
     * 修改员工审核状态
     *
     * @param username
     */
    public static void updateEmpByStatus(String status, String username) {
        ed.updateEmpByStatus(status, username);
    }

    /**
     * 模糊查询员工信息
     *
     * @param ename    员工姓名
     * @param username 员工账号
     * @param status   账号状态
     * @return
     */
    public static List<Emp> findEmpLikeStatusandEnameandusername(String ename, String username, String status) {
        return ed.findEmpLikeStatusandEnameandusername(ename, username, status);
    }

    /**
     * 根据部门名称查找部门员工
     *
     * @param did
     * @return
     */
    public static List<Emp> findEmpEidByDid(int did) {
        return ed.findEmpEidByDid(did);
    }

    /**
     * 根据账户查找姓名
     *
     * @param username 员工账户
     * @return 员工姓名
     */
    public static int getEidEmpByUserName(String username) {
        return ed.getEidEmpByUserName(username);
    }
}
