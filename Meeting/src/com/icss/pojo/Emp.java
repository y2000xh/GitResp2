package com.icss.pojo;

/**
 * @author: YXh
 * @create: 2021/12/2
 * @Description:
 * @FileName: Emp
 * @History:
 */
public class Emp {
    private Integer eid;
    private String username;
    private String ename;
    private String password;
    private String phone;
    private String email;
    //组件bean的形式进行存储
    private Dept dept;
    private String status;

    /**
     * 员工表
     *
     * @param eid      员工编号
     * @param username 员工账号
     * @param ename    员工姓名
     * @param password 员工密码
     * @param phone    联系电话
     * @param email    邮箱
     * @param dept     部门信息
     * @param status   员工状态 0正在审核  1审核成功   2审核失败
     */

    public Emp(Integer eid, String username, String ename, String password, String phone, String email, Dept dept, String status) {
        this.eid = eid;
        this.username = username;
        this.ename = ename;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.dept = dept;
        this.status = status;
    }

    public Emp() {
    }

    @Override
    public String toString() {
        return "Emp{" +
                "eid=" + eid +
                ", username='" + username + '\'' +
                ", ename='" + ename + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", dept=" + dept +
                ", status='" + status + '\'' +
                '}';
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
