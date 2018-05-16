package com.example.yangli.test1;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.zip.Inflater;

/**
 * Created by yangli on 2018/5/16.
 */

public class Fragment1 extends Fragment implements View.OnClickListener {
    private EditText editText;
    private Button button;
    private Submit submit;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1, container, false);
        editText = view.findViewById(R.id.f1_text_1);
        button = view.findViewById(R.id.f1_but1);
        button.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.f1_but1:
                submit = (Submit)getActivity();
                submit.submit(editText.getText().toString());
                break;
        }
    }

}
