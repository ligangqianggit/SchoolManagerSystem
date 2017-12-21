package com.example.yiye.myapplication.constants;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.TypedValue;

/**
 * Created by 崔琦 on 2017/12/19.
 * des: 作用于整个应用程序的类
 */

public class MyApplication extends Application{

    public static Context mContext;
    /** 屏幕宽度 */
    public static int screenWidth;
    /** 屏幕高度 */
    public static int screenHeight;
    /** SharedPreference 保存一些简单的信息 */
    private static SharedPreferences sharedPreferences;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        sharedPreferences = mContext.getSharedPreferences("baseInfo",MODE_PRIVATE);
    }

    public static Context getContext(){
        return mContext;
    }

    public static SharedPreferences getSharedPreferences(){
        return sharedPreferences;
    }

    /**
     * 得到dp转化成的px
     * */
    public static int getPxFromDp(float dip) {
        float dd = dip;
        float result = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dip, mContext.getResources().getDisplayMetrics());
        return (int) result;
    }
}
