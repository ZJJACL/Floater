package com.lee.floater.activity;

import com.lee.floater.R;
import com.lee.floater.support.SystemBarTintManager;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;

public class CardDetailPageActivity extends Activity {
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
      //设定状态栏的颜色，当版本大于4.4时起作用
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            SystemBarTintManager tintManager = new SystemBarTintManager(this);
            tintManager.setStatusBarTintEnabled(true);
            //此处可以重新指定状态栏颜色
            tintManager.setStatusBarTintResource(R.color.status);
        }
        //当版本低于4.4之后，强制隐藏标题栏
        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT){
        	requestWindowFeature(Window.FEATURE_NO_TITLE);   
        }

        setContentView(R.layout.card_detail_page);
   

	}

}
