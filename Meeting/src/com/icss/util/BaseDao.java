package com.icss.util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BaseDao {
    /*增删改封装方法*/
    /**
     * 当形参为Object[]数组时，调用该方法必须传入一个数组
     * 当形参为Object。。。args时，调用就比较灵活了，可以传各个类型不同参数
     * */

    /**
     * 修改
     */
    public static int exeDml(String sql, Object... args) {
        //获取数据库连接对象
        Connection con = DBConn.getCon();
        PreparedStatement ps = null;
        //定义一个变量用来存储有多少条数据被修改
        int res = 0;
        //获取PreparedStatement对象
        try {
            ps = con.prepareStatement(sql);
            //获取参数的元数据对象
            ParameterMetaData pmd = ps.getParameterMetaData();
            //获取占位符？的个数
            int count = pmd.getParameterCount();
            //增加健壮性
            if (count > 0) {
                if (args.length != count) {
                    throw new RuntimeException("传递的参数个数和占位符不一样");
                }
                //将参数遍历到SQL的占位符中
                for (int i = 0; i < args.length; i++) {
                    ps.setObject(i + 1, args[i]);
                }

            }
            res = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            //设置不自动提交
            try {
                con.setAutoCommit(false);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            //关闭资源
            try {
                if (null != ps) {
                    ps.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                if (null != con) {
                    con.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return res;
    }

    /**
     * 查询
     */
    public static List<List> exeDQL(String sql, Object... args) {
        //获取数据库连接对象
        Connection con = DBConn.getCon();
        PreparedStatement ps = null;
        ResultSet rs = null;
        //定义一个二维集合，来存储结果集中的数据
        ArrayList<List> al = new ArrayList<>();
        //获取Statement对象
        try {
            ps = con.prepareStatement(sql);
            //获取参数的元数据对象
            ParameterMetaData pmd = ps.getParameterMetaData();
            //获取占位符？的个数
            int count = pmd.getParameterCount();
            //增加健壮性
            if (count > 0) {
                if (args.length != count) {
                    throw new RuntimeException("传递的参数个数和占位符不一样");
                }
                //将参数遍历到SQL的占位符中
                for (int i = 0; i < args.length; i++) {
                    ps.setObject(i + 1, args[i]);
                }
            }
            //执行SQL语句
            rs = ps.executeQuery();
            //获取每条数据有多少字段
            int num = rs.getMetaData().getColumnCount();
            while (rs.next()) {
                //因为不确定列的类型，数量，所以用集合来存放、
                ArrayList a = new ArrayList();
                for (int i = 1; i <= num; i++) {
                    a.add(rs.getObject(i));
                }
                al.add(a);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            //设置不自动提交
            try {
                con.setAutoCommit(false);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            //关闭资源
            try {
                if (null != rs) {
                    rs.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                if (null != ps) {
                    ps.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                if (null != con) {
                    con.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return al;
    }

}
