package com.example.yiye.myapplication.ui.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import com.example.yiye.myapplication.R;
import com.example.yiye.myapplication.constants.MyApplication;
import com.example.yiye.myapplication.ui.adapters.UltraPagerAdapter;
import com.tmall.ultraviewpager.UltraViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by 崔琦 on 2017/12/19.
 * des: 第一次启动引导页 和 开屏页
 */

public class SplashActivity extends AppCompatActivity{

    /**
     * 保存一个flag 判断是不是第一次进入App，第一次有引导页
     */
    SharedPreferences sharedPreferences;
    @Bind(R.id.ultra_viewpager_welcome)
    UltraViewPager ultraViewpagerWelcome;
    @Bind(R.id.welcome_to_app)
    Button welcomeToApp;
    @Bind(R.id.launch_img)
    ImageView launchImg;
    /**
     * 引导页要加载的图片集合
     */
    private List<String> mImgList;
    private UltraPagerAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window = getWindow();
        //隐藏标题栏
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //隐藏状态栏
        //定义全屏参数
        int flag = WindowManager.LayoutParams.FLAG_FULLSCREEN;
        //设置当前窗体为全屏显示
        window.setFlags(flag, flag);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        mImgList = new ArrayList<>();
        sharedPreferences = MyApplication.getSharedPreferences();
        //boolean isWelcomeFlag = sharedPreferences.getBoolean("welcomeFlagOne", false);
        boolean isWelcomeFlag = true;
        if (!isWelcomeFlag) {
            ultraViewpagerWelcome.setVisibility(View.VISIBLE);
            launchImg.setVisibility(View.GONE);
        } else {
            ultraViewpagerWelcome.setVisibility(View.GONE);
            welcomeToApp.setVisibility(View.GONE);
            launchImg.setVisibility(View.VISIBLE);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(2500);
                        Intent intent = new Intent(SplashActivity.this, SelectorSchoolActivity.class);
                        startActivity(intent);
                        finish();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
        mImgList.add(0, "https://ws1.sinaimg.cn/large/610dc034ly1ffla9ostxuj20ku0q2abt.jpg");
        mImgList.add(1, "https://ws1.sinaimg.cn/large/610dc034ly1fh8ox6bmjlj20u00u0mz7.jpg");
        mImgList.add(2, "https://ws1.sinaimg.cn/large/610dc034ly1fhegpeu0h5j20u011iae5.jpg");
        mImgList.add(3, "http://ww4.sinaimg.cn/large/0060lm7Tgw1fbmfo9is9hj30u00u0ai3.jpg");
        mImgList.add(4, "http://ww3.sinaimg.cn/large/610dc034gw1fbldexdog4j20u011h41b.jpg");
        defaultUltraViewPager();

        /** 用户滑动到最后一页才显示进入App的按钮 */
        ultraViewpagerWelcome.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (position == mImgList.size() - 1){
                    welcomeToApp.setVisibility(View.VISIBLE);
                }
                if (position != mImgList.size() - 1 && welcomeToApp.getVisibility()==View.VISIBLE){
                    welcomeToApp.setVisibility(View.GONE);
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void defaultUltraViewPager() {
        ultraViewpagerWelcome.setScrollMode(UltraViewPager.ScrollMode.HORIZONTAL);
        //initialize UltraPagerAdapter，and add child view to UltraViewPager
        adapter = new UltraPagerAdapter(false,mImgList);
        ultraViewpagerWelcome.setAdapter(adapter);

        //initialize built-in indicator
        ultraViewpagerWelcome.initIndicator();
        //set style of indicators
        ultraViewpagerWelcome.getIndicator()
                .setOrientation(UltraViewPager.Orientation.HORIZONTAL)
                .setFocusColor(Color.GREEN)
                .setNormalColor(Color.WHITE)
                .setRadius(15);
        //set the alignment
        ultraViewpagerWelcome.getIndicator().setGravity(Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM);
        //construct built-in indicator, and add it to  UltraViewPager
        ultraViewpagerWelcome.getIndicator().build();
        // set the current position item
    }

    @OnClick(R.id.welcome_to_app)
    public void onClick() {
        SharedPreferences.Editor editor = MyApplication.getSharedPreferences().edit();
        editor.putBoolean("welcomeFlagOne", true);
        editor.commit();
        Intent intent = new Intent(SplashActivity.this, SelectorSchoolActivity.class);
        startActivity(intent);
        finish();
    }
}
