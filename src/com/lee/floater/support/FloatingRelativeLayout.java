package com.lee.floater.support;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.RelativeLayout;

public class FloatingRelativeLayout extends RelativeLayout {

	private Boolean isShow = false;
    private static final int TRANSLATE_DURATION_MILLIS = 150;
   private final Interpolator mInterpolator = new AccelerateDecelerateInterpolator();
   public FloatingRelativeLayout(Context context) {
       super(context);
   }
   public FloatingRelativeLayout(Context context, AttributeSet attrs) {
       super(context, attrs);
       init(context, attrs);
   }
   public FloatingRelativeLayout(Context context, AttributeSet attrs, int defStyle) {
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
         int translationY = isShow ? 0 : height +48;
         animate().setInterpolator(mInterpolator)
         .setDuration(TRANSLATE_DURATION_MILLIS)
         .translationY(-translationY);
   }

}
