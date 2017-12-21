package com.example.yiye.myapplication.ui.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.yiye.myapplication.R;
import com.example.yiye.myapplication.base.MyBaseActivity;
import com.example.yiye.myapplication.bean.StudentInfoBean;
import com.example.yiye.myapplication.db.DBManager;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by 崔琦 on 2017/12/20.
 * des: 学生信息列表页
 */

public class StudentInfoListActivity extends MyBaseActivity {

    @Bind(R.id.studentInfo_list)
    ListView studentInfoList;
    @Bind(R.id.school_nameList)
    TextView schoolNameList;

    private MyStudentInfoAdapter myInfoAdapter;
    private ArrayList<StudentInfoBean> mData;
    private DBManager dbManager;
    private String schoolName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_student_info_list;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        schoolName = getIntent().getStringExtra("schoolName");
        schoolNameList.setText(schoolName);
        dbManager = new DBManager(this);
        mData = (ArrayList<StudentInfoBean>) dbManager.queryStudentInfo();
        myInfoAdapter = new MyStudentInfoAdapter();
        studentInfoList.setAdapter(myInfoAdapter);
    }

    @OnClick(R.id.back)
    public void onViewClicked() {
        finish();
    }

    private class MyStudentInfoAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return mData.size();
        }

        @Override
        public Object getItem(int position) {
            return mData.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder = null;
            if (convertView == null) {
                convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_student_list, null);
                holder = new ViewHolder();
                holder.itemSex = (TextView) convertView.findViewById(R.id.item_sex);
                holder.itemFloor = (TextView) convertView.findViewById(R.id.item_floor);
                holder.itemDormitory = (TextView) convertView.findViewById(R.id.item_dormitory);
                holder.itemGrade = (TextView) convertView.findViewById(R.id.item_grade);
                holder.itemName = (TextView) convertView.findViewById(R.id.item_name);
                holder.itemNumber = (TextView) convertView.findViewById(R.id.item_number);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            if (mData.get(position).getStudentSex() == 0) {
                holder.itemSex.setText("男");
            } else if (mData.get(position).getStudentSex() == 1) {
                holder.itemSex.setText("女");
            } else {
                holder.itemSex.setText("未知");
            }
            holder.itemFloor.setText(mData.get(position).getFloors());
            holder.itemDormitory.setText(mData.get(position).getDormitory());
            holder.itemGrade.setText(mData.get(position).getGrade());
            holder.itemName.setText(mData.get(position).getName());
            holder.itemNumber.setText(mData.get(position).getStudyNumber());
            return convertView;
        }

        class ViewHolder {
            TextView itemSex;
            TextView itemFloor;
            TextView itemDormitory;
            TextView itemGrade;
            TextView itemName;
            TextView itemNumber;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dbManager.closeDB();
    }
}
