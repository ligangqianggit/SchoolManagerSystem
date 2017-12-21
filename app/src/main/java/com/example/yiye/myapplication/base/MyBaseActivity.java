package com.example.yiye.myapplication.base;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.yiye.myapplication.constants.AllActivitiesHolder;

import butterknife.ButterKnife;

/**
 * Created by 崔琦 on 2017/12/19.
 * des:公共基础activity
 */

public abstract class MyBaseActivity extends AppCompatActivity{
    private Context mContext;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AllActivitiesHolder.addAct(this);
        setContentView(getLayoutId());
        mContext = this;
        ButterKnife.bind(this);
        /** 禁止竖屏*/
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        /** 禁止横屏*/
        //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        init(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
        AllActivitiesHolder.removeAct(this);
    }

    public Context getContext(){
        return mContext;
    }
    protected abstract int getLayoutId();
    protected abstract void init(Bundle savedInstanceState);
}
