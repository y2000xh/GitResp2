package com.icss.pojo;

/**
 * @author: YXh
 * @create: 2021/12/2
 * @Description:
 * @FileName: Dept
 * @History:
 */
public class Dept {

    private Integer did;
    private String dname;

    /**
     * 部门表
     *
     * @param did   部门编号
     * @param dname 部门名称
     */
    public Dept(Integer did, String dname) {
        this.did = did;
        this.dname = dname;
    }

    public Dept() {
    }

    @Override
    public String toString() {
        return "Dept{" +
                "did=" + did +
                ", dname='" + dname + '\'' +
                '}';
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }
}
