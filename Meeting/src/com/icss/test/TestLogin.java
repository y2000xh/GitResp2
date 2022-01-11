package com.icss.test;

import com.icss.dao.DeptDao;
import com.icss.dao.EmpDao;
import com.icss.dao.MeetingDao;
import com.icss.pojo.Dept;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author: YXh
 * @create: 2021/12/2
 * @Description:
 * @FileName: TestLogin
 * @History:
 */
public class TestLogin {
    public static void main(String[] args) {
        EmpDao empDap = new EmpDao();
        DeptDao deptDao = new DeptDao();
        /*int i = EmpService.checkUserLoginService("zhang1san", "123");
        System.out.println(i);*/
        /*System.out.println(empDap.getEnameByUserName("zhangsan"));
        ArrayList<Dept> depts = deptDao.showAllDeptDao();
        depts.forEach(System.out::println);*/

//        deptDao.addDeptDao("你好");
//        deptDao.deleteDeptDao(8);
        MeetingDao md = new MeetingDao();
    }
}
