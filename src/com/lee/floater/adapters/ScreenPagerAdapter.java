package com.lee.floater.adapters;

import java.util.List;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;  
import android.support.v4.view.ViewPager ;
import android.view.View;

/**
 *为主页的ViewPager设置适配器
 */
public class ScreenPagerAdapter extends PagerAdapter{
    
    private List<View> screenViews ;
    
    public ScreenPagerAdapter(List<View> list){
        this.screenViews = list ;
    }

     //销毁position位置的界面  
        @Override  
        public void destroyItem(View container, int position, Object object) {  
            ((ViewPager) container ).removeView(screenViews.get(position)); 
        }  
      
        @Override  
        public void finishUpdate(View container) {  
            // TODO Auto-generated method stub         
        }  
      
        //获得当前界面数  
        @Override  
        public int getCount() {  
            if (screenViews != null)  
            {  
                return screenViews.size();  
            }  
            return 0;  
        }  
          
      
        //初始化position位置的界面  
        @Override  
        public Object instantiateItem(View container, int position) {  
              
            ((ViewPager) container ).addView(screenViews.get(position), 0);  
            return screenViews.get(position);  
        }  
      
        //判断是否由对象生成界面  
        @Override  
        public boolean isViewFromObject(View arg0, Object arg1) {  
            return (arg0 == arg1);  
        }  
      
        @Override  
        public void restoreState(Parcelable arg0, ClassLoader arg1) {  
            // TODO Auto-generated method stub  
              
        }  
      
        @Override  
        public Parcelable saveState() {  
            // TODO Auto-generated method stub  
            return null;  
        }  
      
        @Override  
        public void startUpdate(View arg0) {  
            // TODO Auto-generated method stub  
              
        }  


}