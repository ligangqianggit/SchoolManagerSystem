package com.example.yiye.myapplication.util;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yiye.myapplication.R;
import com.example.yiye.myapplication.constants.MyApplication;


/**
 * Created by 崔琦 on 2017/11/13 0013.
 * Describe : 吐司工具类
 */
public class ToastUtil {

    private static Toast toast;

    public static void showToast(String content){
        LayoutInflater inflater = LayoutInflater.from(MyApplication.getContext());
        View convertView = inflater.inflate(R.layout.toast_layout,null);
        TextView toastText = (TextView)convertView.findViewById(R.id.toast_text);
        toastText.setText(content);

        if (toast == null) {
            toast = Toast.makeText(MyApplication.getContext(),
                    content,
                    Toast.LENGTH_SHORT);
        } else {
            //toast.setText(content);
            toast.cancel();
        }
        toast = new Toast(MyApplication.getContext());
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(convertView);
        toast.setGravity(Gravity.CENTER,0,0);
        toast.show();
    }
}
