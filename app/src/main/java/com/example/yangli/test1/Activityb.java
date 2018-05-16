package com.example.yangli.test1;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.zip.Inflater;

/**
 * Created by yangli on 2018/5/16.
 */

public class Activityb extends AppCompatActivity implements Submit{
    private String text;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Log.d("yangli11","onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        initView();
    }

//    @Override
//    protected void onPause() {
//        //A的 onActivityResult() 需要在B的onPause之后，A的onRestart之前这中间调用，所以B中的setResult()函数应该放在B的onPause之前调用。
//        Intent intent = new Intent();
//        intent.putExtra("text",text);
//        setResult(0,intent);
//        super.onPause();
//    }

    private void initView() {
        Intent intent = getIntent();
        int i = intent.getIntExtra("button",1);
        switch (i){
            case 1:
                setFragment(new Fragment2());
                break;
            case 2:
                setFragment(new Fragment1());
                break;
        }
    }
    private void setFragment(Fragment fragment){
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.frame,fragment);
        fragmentTransaction.commit();
    }


    @Override
    public void submit(String text) {
        Intent intent = new Intent();
        intent.putExtra("text",text);
        setResult(0,intent);
        finish();
    }

    @Override
    public void onBackPressed() {
        return;
    }
}
