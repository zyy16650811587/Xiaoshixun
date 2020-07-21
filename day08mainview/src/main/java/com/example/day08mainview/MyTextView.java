package com.example.day08mainview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.TextView;

import androidx.annotation.Nullable;

@SuppressLint("AppCompatCustomView")
public class MyTextView extends TextView {
    public MyTextView(Context context) {
        super(context);
    }

    public MyTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
//重写draw
    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.BLUE);//设置画布颜色
      //  canvas.drawColor(getResources().getColor(R.layout.BLUE));
        canvas.rotate(45,getMeasuredWidth()/15,getMeasuredHeight()/15);//设置旋转角度
        super.onDraw(canvas);
    }
}
