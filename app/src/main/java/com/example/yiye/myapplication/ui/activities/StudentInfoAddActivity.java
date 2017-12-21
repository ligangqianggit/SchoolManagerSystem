package com.example.yiye.myapplication.ui.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.EditText;

import com.example.yiye.myapplication.R;
import com.example.yiye.myapplication.base.MyBaseActivity;
import com.example.yiye.myapplication.bean.StudentInfoBean;
import com.example.yiye.myapplication.db.DBManager;
import com.example.yiye.myapplication.util.ToastUtil;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by 崔琦 on 2017/12/20.
 * des: 学生信息录入页面
 */

public class StudentInfoAddActivity extends MyBaseActivity {

    @Bind(R.id.sex_edt)
    EditText sexEdt;
    @Bind(R.id.floors_edt)
    EditText floorsEdt;
    @Bind(R.id.grade_edt)
    EditText gradeEdt;
    @Bind(R.id.class_edt)
    EditText classEdt;
    @Bind(R.id.dormitory_edt)
    EditText dormitoryEdt;
    @Bind(R.id.bed_edt)
    EditText bedEdt;
    @Bind(R.id.name_edt)
    EditText nameEdt;
    @Bind(R.id.studyNumber_edt)
    EditText studyNumberEdt;

    private DBManager dbManager;
    private ArrayList<StudentInfoBean> studentInfo;
    private int sex = -1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_student_info_add;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        dbManager = new DBManager(this);
        studentInfo = new ArrayList<>();
    }

    @OnClick(R.id.commit_info)
    public void onViewClicked() {
        String mSex = sexEdt.getText().toString().trim();
        if (mSex.equals("男")){
            sex = 0;
        }else if (mSex.equals("女")){
            sex = 1;
        }else {
            sex = -1;
        }
        String mFloors = floorsEdt.getText().toString().trim();
        String mGrade = gradeEdt.getText().toString().trim();
        String mClass = classEdt.getText().toString().trim();
        String mDormitory = dormitoryEdt.getText().toString().trim();
        String mBed = bedEdt.getText().toString().trim();
        String mName = nameEdt.getText().toString().trim();
        String mStudyNumber = studyNumberEdt.getText().toString().trim();
        if (mSex.equals("")){
            ToastUtil.showToast("性别不能为空！");
        }else if (mFloors.equals("")){
            ToastUtil.showToast("楼层不能为空！");
            /** 可能还涉及到校验  格式为:1_2*/
        }else if (mGrade.equals("")){
            ToastUtil.showToast("年级不能为空！");
        }else if (mClass.equals("")){
            ToastUtil.showToast("班级不能为空！");
        }else if (mDormitory.equals("")){
            ToastUtil.showToast("宿舍不能为空！");
        }else if (mBed.equals("")){
            ToastUtil.showToast("床铺不能为空！");
        }else if (mName.equals("")){
            ToastUtil.showToast("姓名不能为空！");
        }else if (mStudyNumber.equals("")){
            ToastUtil.showToast("学号不能为空！");
        }else {
            StudentInfoBean student = new StudentInfoBean(sex,mFloors,mGrade,mClass,mDormitory,mBed,mName,mStudyNumber);
            studentInfo.add(student);
            dbManager.addStudentInfo(studentInfo);
            //将所有输入框清空
            sexEdt.setText("");
            floorsEdt.setText("");
            gradeEdt.setText("");
            classEdt.setText("");
            dormitoryEdt.setText("");
            bedEdt.setText("");
            nameEdt.setText("");
            studyNumberEdt.setText("");
            ToastUtil.showToast("录入学生信息成功！");
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dbManager.closeDB();
    }
}
