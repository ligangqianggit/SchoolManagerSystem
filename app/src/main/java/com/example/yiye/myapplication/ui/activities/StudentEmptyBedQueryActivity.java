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
 * des: 学生空铺查询页面
 */

public class StudentEmptyBedQueryActivity extends MyBaseActivity {

    @Bind(R.id.school_nameBed)
    TextView schoolNameBed;
    @Bind(R.id.studentEmptyBed_list)
    ListView studentEmptyBedList;

    private String schoolName;
    private MyEmptyBedAdapter bedAdapter;
    private DBManager dbManager;
    private ArrayList<StudentInfoBean> mData;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_bed_query;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        schoolName = getIntent().getStringExtra("schoolName");
        schoolNameBed.setText(schoolName);
        dbManager = new DBManager(this);
        mData = (ArrayList<StudentInfoBean>) dbManager.queryStudentInfo();
        bedAdapter = new MyEmptyBedAdapter();
        studentEmptyBedList.setAdapter(bedAdapter);
    }

    @OnClick(R.id.back)
    public void onViewClicked() {
        finish();
    }

    private class MyEmptyBedAdapter extends BaseAdapter{
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
            ViewHolder holder;
            if (convertView == null){
                convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_bed,null);
                holder = new ViewHolder();
                holder.itemFloor = (TextView)convertView.findViewById(R.id.item_floor);
                holder.itemDormitory = (TextView)convertView.findViewById(R.id.item_dormitory);
                holder.itemEmptyBedOrNot = (TextView)convertView.findViewById(R.id.item_emptyBed_orNot);
                holder.itemEmptyBedLocation = (TextView)convertView.findViewById(R.id.item_emptyBed_location);
                convertView.setTag(holder);
            }else {
                holder = (ViewHolder)convertView.getTag();
            }
            holder.itemFloor.setText(mData.get(position).getFloors());
            holder.itemDormitory.setText(mData.get(position).getDormitory());
            holder.itemEmptyBedOrNot.setText("无");
            holder.itemEmptyBedLocation.setText(mData.get(position).getBed());
            return convertView;
        }

        class ViewHolder{
            TextView itemFloor;
            TextView itemDormitory;
            TextView itemEmptyBedOrNot;
            TextView itemEmptyBedLocation;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dbManager.closeDB();
    }
}
