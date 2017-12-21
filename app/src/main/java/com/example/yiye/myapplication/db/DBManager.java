package com.example.yiye.myapplication.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.yiye.myapplication.bean.StudentInfoBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 崔琦 on 2017/12/20.
 * des: 数据库管理类
 */

public class DBManager {
    private DBHelper dbHelper;
    private SQLiteDatabase db;

    public DBManager(Context context) {
        dbHelper = new DBHelper(context);
        //要确保context已初始化,我们可以把实例化DBManager的步骤放在Activity的onCreate里
        db = dbHelper.getWritableDatabase();
    }

    public void addStudentInfo(List<StudentInfoBean> studentInfoBeen){
        db.beginTransaction();//开启事务
        try {
            for (StudentInfoBean student : studentInfoBeen){
                db.execSQL("INSERT INTO ck_StudentInfo VALUES(null,?,?,?,?,?,?,?,?)",new Object[]{
                        student.getStudentSex(),student.getFloors(),student.getGrade(),student.getmClass(),
                        student.getDormitory(),student.getBed(),student.getName(),student.getStudyNumber()
                });
            }
            db.setTransactionSuccessful();
        }finally {
            db.endTransaction();
        }
    }

    public List<StudentInfoBean> queryStudentInfo() {
        ArrayList<StudentInfoBean> studentBean = new ArrayList<StudentInfoBean>();
        Cursor c = queryTheCursor();
        while (c.moveToNext()) {
            StudentInfoBean student = new StudentInfoBean();
            student.id = c.getInt(c.getColumnIndex("id"));
            student.StudentSex = c.getInt(c.getColumnIndex("sex"));
            student.floors = c.getString(c.getColumnIndex("floors"));
            student.grade = c.getString(c.getColumnIndex("grade"));
            student.mClass = c.getString(c.getColumnIndex("class"));
            student.dormitory = c.getString(c.getColumnIndex("dormitory"));
            student.bed = c.getString(c.getColumnIndex("bed"));
            student.name = c.getString(c.getColumnIndex("name"));
            student.studyNumber = c.getString(c.getColumnIndex("studyNumber"));
            studentBean.add(student);
        }
        c.close();
        return studentBean;
    }

    public Cursor queryTheCursor() {
        Cursor c = db.rawQuery("SELECT * FROM ck_StudentInfo", null);
        return c;
    }

    public void closeDB() {
        db.close();
    }
}
