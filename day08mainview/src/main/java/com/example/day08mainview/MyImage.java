package com.example.day08mainview;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class MyImage extends View {

    private final Paint paint;

    public MyImage(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
      //  paint.setColor(Color.RED);


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.gu),0,0,paint);
    }
}
