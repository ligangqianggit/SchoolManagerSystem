package com.example.yiye.myapplication.ui.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.yiye.myapplication.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 崔琦 on 2017/12/19.
 * des: 查阅页面
 */

public class ReferToFragment extends Fragment implements RadioGroup.OnCheckedChangeListener{

    @Bind(R.id.past_info)
    RadioButton pastInfo;
    @Bind(R.id.info_overview)
    RadioButton infoOverview;
    @Bind(R.id.refer_to_group)
    RadioGroup referToGroup;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_refer_to, container, false);
        ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView(){
        pastInfo.setChecked(true);
        referToGroup.setOnCheckedChangeListener(this);
    }

  /*  @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        if (savedInstanceState != null){
            boolean isPast = savedInstanceState.getBoolean("pastInfo",false);
            boolean isInfo = savedInstanceState.getBoolean("infoOverView",false);
            pastInfo.setChecked(isPast);
            infoOverview.setChecked(isInfo);
        }
    }*/

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int id) {
        if (pastInfo.getId() == id){
            pastInfo.setTextColor(Color.parseColor("#ffffff"));
            pastInfo.setBackgroundResource(R.drawable.school_area_shape);
            infoOverview.setTextColor(Color.parseColor("#2c2c2c"));
            infoOverview.setBackground(null);
        }else if (infoOverview.getId() == id){
            infoOverview.setTextColor(Color.parseColor("#ffffff"));
            infoOverview.setBackgroundResource(R.drawable.school_area_shape);
            pastInfo.setTextColor(Color.parseColor("#2c2c2c"));
            pastInfo.setBackground(null);
        }
    }

   /* @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean("pastInfo",pastInfo.isChecked());
        outState.putBoolean("infoOverView",infoOverview.isChecked());
    }*/

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
