package com.example.yangli.test1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button but1;
    private Button but2;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        but1 = findViewById(R.id.but1);
        but2 = findViewById(R.id.but2);
        but1.setOnClickListener(this);
        but2.setOnClickListener(this);
        textView =findViewById(R.id.text_1);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.but1:
                startB(1);
                break;
            case R.id.but2:
                startB(2);
                break;
        }
    }

    private void startB(int i) {
        Intent intent = new Intent(getBaseContext(), Activityb.class);
        intent.putExtra("button",i);
        startActivityForResult(intent,0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        String text = data.getStringExtra("text");
        textView.setText(text);
    }
}

