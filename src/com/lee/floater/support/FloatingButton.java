package com.lee.floater.support;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageButton;

public class FloatingButton extends ImageButton {
    private Boolean isShow = false;
     private static final int TRANSLATE_DURATION_MILLIS = 150;
    private final Interpolator mInterpolator = new AccelerateDecelerateInterpolator();
    public FloatingButton(Context context) {
        super(context);
    }
    public FloatingButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }
    public FloatingButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context, attrs);
    }
    public void init(Context context, AttributeSet attrs) {
        show();
    }
    public void show() {
        if (!isShow) {
            isShow = true;
            toggle();
        }
         
    }
    public void hide() {
        if (isShow) {
            isShow = false;
            toggle();
        }
         
    }
    private void toggle() {
          int height = getHeight();
          int translationY = isShow ? 0 : height + getMarginBottom();
          animate().setInterpolator(mInterpolator)
          .setDuration(TRANSLATE_DURATION_MILLIS)
          .translationY(translationY);
    }
    private int getMarginBottom() {
        int marginBottom = 0;
        final ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            marginBottom = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        }
        return marginBottom;
    }
}

