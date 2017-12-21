package com.example.yiye.myapplication.bean;

/**
 * Created by 崔琦 on 2017/12/20.
 * des: 学生信息录入实体
 */

public class StudentInfoBean {
    public int id;
    //学生性别 0：男 1：女 -1:未知
    public int StudentSex;
    //楼层
    public String floors;
    //年级
    public String grade;
    //班级
    public String mClass;
    //宿舍
    public String dormitory;
    //床铺
    public String bed;
    //姓名
    public String name;
    //学号
    public String studyNumber;

    public StudentInfoBean() {
    }

    public StudentInfoBean(int studentSex, String floors, String grade, String mClass, String dormitory, String bed, String name, String studyNumber) {
        this.StudentSex = studentSex;
        this.floors = floors;
        this.grade = grade;
        this.mClass = mClass;
        this.dormitory = dormitory;
        this.bed = bed;
        this.name = name;
        this.studyNumber = studyNumber;
    }

    public int getStudentSex() {
        return StudentSex;
    }

    public void setStudentSex(int studentSex) {
        StudentSex = studentSex;
    }

    public String getFloors() {
        return floors;
    }

    public void setFloors(String floors) {
        this.floors = floors;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getmClass() {
        return mClass;
    }

    public void setmClass(String mClass) {
        this.mClass = mClass;
    }

    public String getDormitory() {
        return dormitory;
    }

    public void setDormitory(String dormitory) {
        this.dormitory = dormitory;
    }

    public String getBed() {
        return bed;
    }

    public void setBed(String bed) {
        this.bed = bed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudyNumber() {
        return studyNumber;
    }

    public void setStudyNumber(String studyNumber) {
        this.studyNumber = studyNumber;
    }
}
