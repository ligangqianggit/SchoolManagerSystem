package com.example.yiye.myapplication.constants;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 崔琦 on 2017/8/29 0029.
 * Describe : 持有所有的Activity
 */
public class AllActivitiesHolder {
    //存储activity对象的集合
    private static List<Activity> allActivities = new ArrayList<>();

    //添加Activity对象
    public static void addAct(Activity activity){
        allActivities.add(activity);
    }
    //移除掉Activity对象
    public static void removeAct(Activity activity){
        allActivities.remove(activity);
    }
    //销毁所有的activity对象（关闭程序时调用）
    public static void finishAllAct(){
        for (int i = 0; i < allActivities.size(); i++) {
            allActivities.get(i).finish();
        }
        allActivities.clear();
    }
}
