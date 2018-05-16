package com.example.yangli.test1;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by yangli on 2018/5/16.
 */

public class Fragment2 extends Fragment implements View.OnClickListener{
    private EditText editText;
    private Button button;
    private Submit submit;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        //动态加载必须要设置第三个属性为false
        View view = inflater.inflate(R.layout.fragment2,container,false);
        editText = view.findViewById(R.id.f2_text_1);
        button = view.findViewById(R.id.f2_but1);
        button.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.f2_but1:
                submit = (Submit)getActivity();
                submit.submit(editText.getText().toString());
                break;
        }
    }
}
