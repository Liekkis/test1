package com.example.yangli.test1;

import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

/**
 * Created by yangli on 2018/5/16.
 */

public class Fragment1 extends Fragment implements View.OnClickListener,RadioGroup.OnCheckedChangeListener{
    private RadioGroup radioGroup;
    private RadioButton r1;
    private RadioButton r2;
    private RadioButton r3;
    private RadioButton r4;
    private RadioButton r5;
    private RadioButton r6;
    private RadioButton r7;
    private RadioButton r8;
    private RadioButton r9;
    private Button button;
    private Submit submit;
    private String text = null;
    private SharedPreferences sp;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1, container, false);
        button = view.findViewById(R.id.f1_but1);
        button.setOnClickListener(this);
        radioGroup = view.findViewById(R.id.radiogroup);
        radioGroup.setOnCheckedChangeListener(this);
        r1 = view.findViewById(R.id.r1);
        r2 = view.findViewById(R.id.r2);
        r3 = view.findViewById(R.id.r3);
        r4 = view.findViewById(R.id.r4);
        r5 = view.findViewById(R.id.r5);
        r6 = view.findViewById(R.id.r6);
        r7 = view.findViewById(R.id.r7);
        r8 = view.findViewById(R.id.r8);
        r9 = view.findViewById(R.id.r9);
        sp = getContext().getSharedPreferences("User", Context.MODE_PRIVATE);
        setCheck();
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.f1_but1:
                submit = (Submit)getActivity();
                submit.submit(text);
                break;
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt("check",checkedId);
        editor.commit();
        switch (checkedId){
            case R.id.r1:
                text = "这是1";
                break;
            case R.id.r2:
                text = "这是2";
                break;
            case R.id.r3:
                text = "这是3";
                break;
            case R.id.r4:
                text = "这是4";
                break;
            case R.id.r5:
                text = "这是5";
                break;
            case R.id.r6:
                text = "这是6";
                break;
            case R.id.r7:
                text = "这是7";
                break;
            case R.id.r8:
                text = "这是8";
                break;
            case R.id.r9:
                text = "这是9";
                break;
        }
    }
    private void setCheck(){
       int id = sp.getInt("check",R.id.r1);
       radioGroup.check(id);
    }
}
