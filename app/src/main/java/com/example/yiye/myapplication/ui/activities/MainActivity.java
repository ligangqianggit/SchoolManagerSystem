package com.example.yiye.myapplication.ui.activities;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.util.DisplayMetrics;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.yiye.myapplication.R;
import com.example.yiye.myapplication.base.MyBaseActivity;
import com.example.yiye.myapplication.constants.MyApplication;
import com.example.yiye.myapplication.ui.fragments.DormitoryRegisterFragment;
import com.example.yiye.myapplication.ui.fragments.ReferToFragment;
import com.example.yiye.myapplication.ui.fragments.StudentInfoFragment;

import butterknife.Bind;

public class MainActivity extends MyBaseActivity implements RadioGroup.OnCheckedChangeListener {


    @Bind(R.id.radio_bottom_one)
    RadioButton radioBottomOne;
    @Bind(R.id.radio_bottom_two)
    RadioButton radioBottomTwo;
    @Bind(R.id.radio_bottom_three)
    RadioButton radioBottomThree;
    @Bind(R.id.radio_group)
    RadioGroup radioGroup;
    @Bind(R.id.title_main)
    TextView titleMain;

    private ReferToFragment referToFragment;
    private DormitoryRegisterFragment dormitoryRegisterFragment;
    private StudentInfoFragment studentInfoFragment;

    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE};

    //传过来的学校名称
    private String schoolName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        schoolName = getIntent().getStringExtra("SchoolName");
        titleMain.setText(schoolName);
        /** 获取屏幕宽高*/
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        MyApplication.screenWidth = displayMetrics.widthPixels;
        MyApplication.screenHeight = displayMetrics.heightPixels;

        radioGroup.setOnCheckedChangeListener(this);
        /** 设置默认选项 */
        setDefaultFragment();
        /** 添加6.0以上读写权限 */
        verifyStoragePermissions(this);
    }

    public static void verifyStoragePermissions(Activity activity) {
        int permission = ActivityCompat.checkSelfPermission(activity,
                Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if (permission != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(activity, PERMISSIONS_STORAGE, REQUEST_EXTERNAL_STORAGE);
        }
    }

    /**
     * 进应用默认Tab
     */
    private void setDefaultFragment() {
        FragmentManager fm = getSupportFragmentManager();
        radioBottomOne.setChecked(true);
        FragmentTransaction transaction = fm.beginTransaction();
        hideFragments(transaction);
        referToFragment = new ReferToFragment();
        transaction.add(R.id.mFragment, referToFragment);
        transaction.commit();
    }

    /**
     * 隐藏fragment
     */
    private void hideFragments(FragmentTransaction transaction) {
        if (referToFragment != null) {
            transaction.hide(referToFragment);
        }
        if (dormitoryRegisterFragment != null) {
            transaction.hide(dormitoryRegisterFragment);
        }

        if (studentInfoFragment != null) {
            transaction.hide(studentInfoFragment);
        }

    }


    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        hideFragments(transaction);
        switch (checkedId) {
            case R.id.radio_bottom_one:
                if (referToFragment == null) {
                    referToFragment = new ReferToFragment();
                    transaction.add(R.id.mFragment, referToFragment);
                } else {
                    transaction.show(referToFragment);
                }
                setTabState();
                break;
            case R.id.radio_bottom_two:
                if (dormitoryRegisterFragment == null) {
                    dormitoryRegisterFragment = new DormitoryRegisterFragment();
                    transaction.add(R.id.mFragment, dormitoryRegisterFragment);
                } else {
                    transaction.show(dormitoryRegisterFragment);
                }
                setTabState();
                break;
            case R.id.radio_bottom_three:
                if (studentInfoFragment == null) {
                    studentInfoFragment = new StudentInfoFragment();
                    transaction.add(R.id.mFragment, studentInfoFragment);
                } else {
                    transaction.show(studentInfoFragment);
                }
                setTabState();
                break;
        }
        transaction.commit();
    }

    //设置选中和未选择的状态
    private void setTabState() {
        setReferToState();
        setDormitoryState();
        setStudentInfoState();
    }

    private void setReferToState() {
        if (radioBottomOne.isChecked()) {
            radioBottomOne.setTextColor(ContextCompat.getColor(this, R.color.colorAccent));
        } else {
            radioBottomOne.setTextColor(ContextCompat.getColor(this, R.color.textColor));
        }
    }

    private void setDormitoryState() {
        if (radioBottomTwo.isChecked()) {
            radioBottomTwo.setTextColor(ContextCompat.getColor(this, R.color.colorAccent));
        } else {
            radioBottomTwo.setTextColor(ContextCompat.getColor(this, R.color.textColor));
        }
    }

    private void setStudentInfoState() {
        if (radioBottomThree.isChecked()) {
            radioBottomThree.setTextColor(ContextCompat.getColor(this, R.color.colorAccent));
        } else {
            radioBottomThree.setTextColor(ContextCompat.getColor(this, R.color.textColor));
        }
    }
}
