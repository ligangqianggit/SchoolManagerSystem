package com.example.yiye.myapplication.ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yiye.myapplication.R;
import com.example.yiye.myapplication.ui.activities.StudentEmptyBedQueryActivity;
import com.example.yiye.myapplication.ui.activities.StudentInfoAddActivity;
import com.example.yiye.myapplication.ui.activities.StudentInfoListActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by 崔琦 on 2017/12/19.
 * des: 学生信息页
 */

public class StudentInfoFragment extends Fragment {

    private String schoolName;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_student_info, container, false);
        ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView(){
        if (getActivity().getIntent() != null){
            schoolName = getActivity().getIntent().getStringExtra("SchoolName");
        }
    }

    @OnClick({R.id.studentInfo_add, R.id.studentInfo_list, R.id.dormitory_query})
    public void onViewClicked(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.studentInfo_add:
                intent.setClass(getActivity(), StudentInfoAddActivity.class);
                break;
            case R.id.studentInfo_list:
                intent.setClass(getActivity(), StudentInfoListActivity.class);
                intent.putExtra("schoolName",schoolName);
                break;
            case R.id.dormitory_query:
                intent.setClass(getActivity(), StudentEmptyBedQueryActivity.class);
                intent.putExtra("schoolName",schoolName);
                break;
        }
        startActivity(intent);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
