package com.example.administrator.testapplication;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.util.AttributeSet;
import android.view.View;

/**
 *
 * @author Zyc
 * @date 2018/3/5
 */

public class rippleView extends View {

    ObjectAnimator mObjectAnimator = ObjectAnimator.ofArgb(this, "color", 0xff232322, 0xff666666);
    int drawColor;
    public rippleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public rippleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        mObjectAnimator.setDuration(5000);
        mObjectAnimator.setInterpolator(new LinearOutSlowInInterpolator());
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    public void setColor(int color){
        drawColor = color;
        postInvalidate();
    }

    public void startAni(){
        mObjectAnimator.start();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(drawColor);
    }
}
