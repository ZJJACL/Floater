package com.lee.floater.listeners;

import com.lee.floater.support.RotateImageView;

import android.content.Context;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 控制Banner_Picker的滚动和监听幻灯的监听事件
 */
public class BannerListener implements OnPageChangeListener,OnClickListener {
	
	int view_id ; //第几张幻灯
	RotateImageView banner_picker ;
	TextView number;
	Context context;
	
	public BannerListener(RotateImageView banner_picker , TextView number){
		this.banner_picker = banner_picker;
		this.number=number;
	}
	
	public BannerListener(int view_id,Context context){
		this.view_id=view_id;
		this.context=context;
	}

	//点击某张幻灯片，初设为弹出一个toast
	@Override
	public void onClick(View v) {
		int id= view_id+1;
		Toast.makeText(context, "第"+id+"张Banner被点击了", Toast.LENGTH_SHORT).show();
		
	}

	@Override
	public void onPageScrollStateChanged(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPageSelected(int arg0) {
		if(arg0 == 0){
			banner_picker.setOrientation(0,true);
			number.setText("1/3");
		}
		if(arg0 == 1){
			banner_picker.setOrientation(45,true);
			number.setText("2/3");
		}
		if(arg0 == 2){
			banner_picker.setOrientation(90,true);
			number.setText("3/3");
		}
	}

}
