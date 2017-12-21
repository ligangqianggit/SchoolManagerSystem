package com.example.yiye.myapplication.ui.adapters;

import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.yiye.myapplication.R;
import com.example.yiye.myapplication.util.GlideUtil;

import java.util.List;

/**
 * Created by 崔琦 on 2017/12/19.
 * des:...
 */

public class UltraPagerAdapter extends PagerAdapter{
    private boolean isMultiScr;
    private List<String> mData;
    GlideUtil glideUtil;
    public UltraPagerAdapter(boolean isMultiScr, List<String> mData){
        this.isMultiScr = isMultiScr;
        this.mData = mData;
        glideUtil = new GlideUtil();

    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup parent, int position) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.
                from(parent.getContext()).inflate(R.layout.layout_child,null);
        ImageView viewPageImg = (ImageView)linearLayout.findViewById(R.id.viewPage_img);
        glideUtil.attach(viewPageImg).injectImageWithNull(mData.get(position));
        parent.addView(linearLayout);
        return linearLayout;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        LinearLayout view = (LinearLayout) object;
        container.removeView(view);
    }
}
