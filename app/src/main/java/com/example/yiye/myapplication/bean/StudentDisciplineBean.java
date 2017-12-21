package com.example.yiye.myapplication.bean;

/**
 * Created by 崔琦 on 2017/12/20.
 * des: 学生违纪信息实体
 */

public class StudentDisciplineBean {

    //性别 0：男 1：女
    private int sexState;
    //楼层
    private int floors;
    //房间号
    private int roomNumber;
    //值日生
    private String attendant;
    //姓名
    private String name;
    //违纪人员
    private String disciplinePersonal;
    //备注
    private String remark;
    //量化
    private String quantification;

    public StudentDisciplineBean(int sexState, int floors, int roomNumber, String attendant, String name, String disciplinePersonal, String remark, String quantification) {
        this.sexState = sexState;
        this.floors = floors;
        this.roomNumber = roomNumber;
        this.attendant = attendant;
        this.name = name;
        this.disciplinePersonal = disciplinePersonal;
        this.remark = remark;
        this.quantification = quantification;
    }

    public int getSexState() {
        return sexState;
    }

    public void setSexState(int sexState) {
        this.sexState = sexState;
    }

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getAttendant() {
        return attendant;
    }

    public void setAttendant(String attendant) {
        this.attendant = attendant;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisciplinePersonal() {
        return disciplinePersonal;
    }

    public void setDisciplinePersonal(String disciplinePersonal) {
        this.disciplinePersonal = disciplinePersonal;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getQuantification() {
        return quantification;
    }

    public void setQuantification(String quantification) {
        this.quantification = quantification;
    }
}
