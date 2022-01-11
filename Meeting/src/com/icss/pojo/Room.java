package com.icss.pojo;

/**
 * @author: YXh
 * @create: 2021/12/2
 * @Description:
 * @FileName: Room
 * @History:
 */


public class Room {

    private Integer rid;
    private String housenum;
    private String rname;
    private Integer maxnum;
    private Integer status;
    private String notes;

    public Room() {
    }

    /**
     * 会议室表
     *
     * @param rid      会议室编号
     * @param housenum 会议室门牌号
     * @param rname    会议室名称
     * @param maxnum   最大人数
     * @param status   状态(可用  不可用)
     * @param notes    备注
     */
    public Room(Integer rid, String housenum, String rname, Integer maxnum, Integer status, String notes) {
        this.rid = rid;
        this.housenum = housenum;
        this.rname = rname;
        this.maxnum = maxnum;
        this.status = status;
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "Room{" +
                "rid=" + rid +
                ", housenum='" + housenum + '\'' +
                ", rname='" + rname + '\'' +
                ", maxnum=" + maxnum +
                ", status=" + status +
                ", notes='" + notes + '\'' +
                '}';
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getHousenum() {
        return housenum;
    }

    public void setHousenum(String housenum) {
        this.housenum = housenum;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public Integer getMaxnum() {
        return maxnum;
    }

    public void setMaxnum(Integer maxnum) {
        this.maxnum = maxnum;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
