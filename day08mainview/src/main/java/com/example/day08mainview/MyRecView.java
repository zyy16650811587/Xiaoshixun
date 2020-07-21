package com.example.day08mainview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class MyRecView extends View {

    private final Paint paint;

    public MyRecView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        paint.setColor(Color.BLUE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        RectF rectF = new RectF(5, 5, 180, 190);
       canvas.drawArc(rectF,-90,60,true,paint);
        super.onDraw(canvas);
    }
}
