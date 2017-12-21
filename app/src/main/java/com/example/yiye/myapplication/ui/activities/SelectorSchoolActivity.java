package com.example.yiye.myapplication.ui.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.TextView;

import com.example.yiye.myapplication.R;
import com.example.yiye.myapplication.base.MyBaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by 崔琦 on 2017/12/19.
 * des:...
 */

public class SelectorSchoolActivity extends MyBaseActivity {

    @Bind(R.id.text_selector_school)
    TextView textSelectorSchool;

    private List<String> schoolList;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_selector_school;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        schoolList = new ArrayList<>();
        schoolList.add("青岛五十八中");
        schoolList.add("石家庄六十二中");

    }

    @OnClick({R.id.back, R.id.text_selector_school, R.id.btn_commit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.text_selector_school:
                //弹出单选dialog
                showChooseDialog();
                break;
            case R.id.btn_commit:
                //跳转页面
                Intent intent = new Intent(SelectorSchoolActivity.this,SelectorSchoolAreaActivity.class);
                intent.putExtra("SchoolName",textSelectorSchool.getText().toString());
                startActivity(intent);
                break;
        }
    }

    private void showChooseDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setSingleChoiceItems(schoolList.toArray(new String[0]), 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                textSelectorSchool.setText(schoolList.get(i));
                dialog.dismiss();//随便点击一个item消失对话框，不用点击确认取消
            }
        });
        builder.show();
    }
}
