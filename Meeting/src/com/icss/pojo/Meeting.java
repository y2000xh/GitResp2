package com.icss.pojo;

import java.util.Date;

/**
 * @author: YXh
 * @create: 2021/12/2
 * @Description:
 * @FileName: meeting
 * @History:
 */
public class Meeting {
    private Integer mid;
    private String mname;
    private Integer mcount;
    private Date starttime;
    private Date endtime;
    private Date booktime;
    private Room room;
    private Emp emp;
    private String status;
    private String mnotes;

    /**
     * 会议表
     *
     * @param mid       会议编号
     * @param mname     会议名称
     * @param mcount    参会人数
     * @param starttime 开始时间
     * @param endtime   结束时间
     * @param booktime  会议预定时间
     * @param room      会议室编号   会议表
     * @param emp       预定者编号   员工表
     * @param status    会议状态 0启用  1取消  已经完成2
     * @param mnotes    会议说明
     */
    public Meeting(Integer mid, String mname, Integer mcount, Date starttime, Date endtime, Date booktime, Room room, Emp emp, String status, String mnotes) {
        this.mid = mid;
        this.mname = mname;
        this.mcount = mcount;
        this.starttime = starttime;
        this.endtime = endtime;
        this.booktime = booktime;
        this.room = room;
        this.emp = emp;
        this.status = status;
        this.mnotes = mnotes;
    }

    public Meeting() {
    }

    @Override
    public String toString() {
        return "Meeting{" +
                "mid=" + mid +
                ", mname='" + mname + '\'' +
                ", mcount=" + mcount +
                ", starttime=" + starttime +
                ", endtime=" + endtime +
                ", booktime=" + booktime +
                ", room=" + room +
                ", emp=" + emp +
                ", status='" + status + '\'' +
                ", mnotes='" + mnotes + '\'' +
                '}';
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public Integer getMcount() {
        return mcount;
    }

    public void setMcount(Integer mcount) {
        this.mcount = mcount;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public Date getBooktime() {
        return booktime;
    }

    public void setBooktime(Date booktime) {
        this.booktime = booktime;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Emp getEmp() {
        return emp;
    }

    public void setEmp(Emp emp) {
        this.emp = emp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMnotes() {
        return mnotes;
    }

    public void setMnotes(String mnotes) {
        this.mnotes = mnotes;
    }
}
