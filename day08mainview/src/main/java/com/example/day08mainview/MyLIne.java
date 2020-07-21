package com.example.day08mainview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;
/*
1 准备画笔
*/
public class MyLIne extends View {

    private final Paint paint;

    public MyLIne(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        paint.setColor(Color.YELLOW);
        paint.setStrokeWidth(15);
        paint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int firstX=50;
        int firstY=100;
        int secondX=300;
        int secondY=150;
        canvas.drawLine(firstX,firstY,secondX,secondY,paint);

        super.onDraw(canvas);
    }
}
