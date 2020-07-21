package com.example.day06touchevent;

import android.os.Bundle;
import android.text.LoginFilter;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button bnt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        bnt = (Button) findViewById(R.id.bnt);

        bnt.setOnClickListener(this);
        bnt.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                if(action==MotionEvent.ACTION_DOWN){
                    Log.i("111", "onTouch: 按下按钮");
                }else if(action==MotionEvent.ACTION_MOVE){
                    Log.i("111", "onTouch: 移动按钮");
                }else if(action==MotionEvent.ACTION_UP){
                    Log.i("111", "onTouch: 在按钮上抬起手");
                }else{
                    Log.i("111", "onTouch: 结束");
                }
                return false;
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bnt:
                Log.i("111", "onClick: 点击了  此按钮");
                Toast.makeText(this, "点击了  此按钮", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        boolean b = super.dispatchTouchEvent(ev);
        return b;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        boolean b = super.onTouchEvent(event);
        return b;
    }
}
