package com.example.yiye.myapplication.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by 崔琦 on 2017/12/20.
 * des:...
 */

public class DBHelper extends SQLiteOpenHelper{

    private static final String DATABASE_NAME = "manager.db";
    private static final int DATABASE_VERSION = 1;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String addonsSQL = "CREATE TABLE IF NOT EXISTS ck_addons(id int(11) primary key , " +
                "sex int(1),floors int(11),roomNumber int(11),";
        String studentInfoSQL = "CREATE TABLE IF NOT EXISTS ck_StudentInfo(id int(11) primary key," +
                "sex int(1),floors varchar(100),grade varchar(100),class varchar(100),dormitory varchar(100)," +
                "bed varchar(100), name varchar(100),studyNumber varchar(100))";
        db.execSQL(studentInfoSQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("ALTER TABLE ck_StudentInfo ADD COLUMN other STRING");
    }
}
