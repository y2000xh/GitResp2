package com.icss.pojo;

import java.util.List;

/**
 * @author: YXh
 * @create: 2021/12/2
 * @Description: 参会人员表
 * @FileName: Emp_metting
 * @History:
 */
public class Emp_meeting {
    //1:n   一个会议 对应多个参会人员
    private Meeting meeting;
    private List<Emp> list;

    /**
     * 员工会议
     *
     * @param meeting 会议编号
     * @param list    员工编号
     */
    public Emp_meeting(Meeting meeting, List<Emp> list) {
        this.meeting = meeting;
        this.list = list;
    }

    public Emp_meeting() {
    }

    public Meeting getMeeting() {
        return meeting;
    }

    public void setMeeting(Meeting meeting) {
        this.meeting = meeting;
    }

    public List<Emp> getList() {
        return list;
    }

    public void setList(List<Emp> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Emp_metting{" +
                "meeting=" + meeting +
                ", list=" + list +
                '}';
    }
}
