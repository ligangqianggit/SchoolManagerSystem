package com.example.yiye.myapplication.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.example.yiye.myapplication.R;
import com.example.yiye.myapplication.base.MyBaseActivity;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by 崔琦 on 2017/12/19.
 * des:选择学校区域页面
 */

public class SelectorSchoolAreaActivity extends MyBaseActivity {

    @Bind(R.id.school_name)
    TextView schoolName;

    private String mSchoolName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_selector_school_area;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        if (getIntent() != null){
            mSchoolName = getIntent().getStringExtra("SchoolName");
        }
        schoolName.setText(mSchoolName);
    }

    @OnClick({R.id.back, R.id.dormitory_area, R.id.teaching_area})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.dormitory_area:
                Intent intent = new Intent(SelectorSchoolAreaActivity.this,MainActivity.class);
                intent.putExtra("SchoolName",mSchoolName);
                startActivity(intent);
                break;
            case R.id.teaching_area:
                break;
        }
    }
}
