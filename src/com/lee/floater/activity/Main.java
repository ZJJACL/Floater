package com.lee.floater.activity;

import java.util.ArrayList;
import java.util.List;
import com.lee.floater.R;
import com.lee.floater.adapters.ScreenPagerAdapter;
import com.lee.floater.handler.FindCategoryPageHandler;
import com.lee.floater.handler.FollowMainPageHandler;
import com.lee.floater.handler.MineMainPageHandler;
import com.lee.floater.handler.RecommendPageHandler;
import com.lee.floater.support.SystemBarTintManager;
import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class Main extends Activity implements OnPageChangeListener,OnClickListener  {
	
	public ViewPager viewPager ;//5个主页的ViewPager
    public int currentPage = 0; //记录5个页面中谁处于活动状态
	
	public RecommendPageHandler recommendPageHandler ; //推荐页面的处理器
	public FindCategoryPageHandler findCategoryPageHandler ; //分类页面的处理器
	public FollowMainPageHandler followMainPageHandler ; //关注页面的处理器
	public MineMainPageHandler mineMainPageHandler ; //我的页面的处理器
	
    //5个主页面的索引
    public View find_recommend_view;
    public View find_category_view;
    public View follow_main_view;
    public View message_main_view;
    public View mine_main_view;
    
    //顶部标题栏各静态元素索引
    TextView title_recommend ;
    TextView title_category;
    TextView title_follow;
    TextView title_message;
    TextView title_mine;

    //底部导航栏各静态元素索引
    ImageView find_nav_icon_notice;
    ImageView find_nav_icon;
    TextView nav_find;
    
    ImageView follow_nav_icon_notice;
    ImageView follow_nav_icon;
    TextView nav_follow;
    
    ImageView message_nav_icon_notice;
    ImageView message_nav_icon;
    TextView nav_message;
    
    ImageView mine_nav_icon_notice;
    ImageView mine_nav_icon;
    TextView nav_mine;
    
    //顶部和底部各个可点击热区的索引
    Button button_title_post;
    Button button_title_audio;
    Button button_title_recommend;
    Button button_title_category;
    Button button_nav_find;
    Button button_nav_follow;
    Button button_nav_message;
    Button button_nav_mine;


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
        
        setContentView(R.layout.main_slide_page);
        findAllViewById();

       //装载ViewPager中的5个View页面
        setViewPager();
      //对顶部标题栏、底部导航栏中图标的亮暗进行初始化
        initNavIcon();
        
        //处理推荐页面的事务
        recommendPageHandler = new RecommendPageHandler(find_recommend_view, Main.this);
        recommendPageHandler.Handle();
        
        //处理首页_分类页面的事务
        findCategoryPageHandler = new FindCategoryPageHandler(find_category_view,Main.this);
        findCategoryPageHandler.Handle();
        
        //处理关注页面的事务
        followMainPageHandler = new FollowMainPageHandler(follow_main_view, Main.this );
        followMainPageHandler.Handle();
        
        //处理我的页面的事务
        mineMainPageHandler = new MineMainPageHandler( mine_main_view,Main.this);
        mineMainPageHandler.Handle();
        
    }
    
    /**
     * 统一通过findViewById()对布局中的各个组件进行加载
     */
    public void findAllViewById(){

        //将5个页面的XML文件装载为View
        LayoutInflater inflater = LayoutInflater.from(this);
        find_recommend_view = inflater.inflate(R.layout.find_recommend_page,null);
        find_category_view = inflater.inflate(R.layout.find_category_page, null);
        follow_main_view = inflater.inflate(R.layout.follow_main_page, null);
        message_main_view = inflater.inflate(R.layout.message_main_page, null);
        mine_main_view = inflater.inflate(R.layout.mine_main_page, null);
        
        //加载顶部标题栏和底部导航栏各元素
        title_recommend = (TextView)findViewById(R.id.title_recommend);
        title_category=(TextView)findViewById(R.id.title_category);
        title_follow = (TextView)findViewById(R.id.title_follow);
        title_message=(TextView)findViewById(R.id.title_message);
        title_mine=(TextView)findViewById(R.id.title_mine);
        find_nav_icon_notice=(ImageView)findViewById(R.id.find_nav_icon_notice);
        find_nav_icon=(ImageView)findViewById(R.id.find_nav_icon);
        nav_find = (TextView)findViewById(R.id.nav_find);
        follow_nav_icon_notice=(ImageView)findViewById(R.id.follow_nav_icon_notice);
        follow_nav_icon =(ImageView)findViewById(R.id.follow_nav_icon);
        nav_follow = (TextView)findViewById(R.id.nav_follow);
        message_nav_icon_notice =(ImageView)findViewById(R.id.message_nav_icon_notice);
        message_nav_icon=(ImageView)findViewById(R.id.message_nav_icon);
        nav_message = (TextView)findViewById(R.id.nav_message);
        mine_nav_icon_notice = (ImageView)findViewById(R.id.mine_nav_icon_notice);
        mine_nav_icon =(ImageView)findViewById(R.id.mine_nav_icon);
        nav_mine = (TextView)findViewById(R.id.nav_mine);
        
        button_title_post = (Button)findViewById(R.id.button_title_post);
        button_title_audio = (Button)findViewById(R.id.button_title_audio);
        button_title_recommend= (Button)findViewById(R.id.button_title_recommend);
        button_title_category= (Button)findViewById(R.id.button_title_category);
        button_nav_find= (Button)findViewById(R.id.button_nav_find);
        button_nav_follow= (Button)findViewById(R.id.button_nav_follow);
        button_nav_message= (Button)findViewById(R.id.button_nav_message);
        button_nav_mine= (Button)findViewById(R.id.button_nav_mine);
        
        //为顶部标题栏和底部导航栏中的Button注册监听器
        button_title_post.setOnClickListener(Main.this);
        button_title_audio.setOnClickListener(Main.this);
        button_title_recommend.setOnClickListener(Main.this);
        button_title_category.setOnClickListener(Main.this);
        button_nav_find.setOnClickListener(Main.this);
        button_nav_follow.setOnClickListener(Main.this);
        button_nav_message.setOnClickListener(Main.this);
        button_nav_mine.setOnClickListener(Main.this);

      //加载5个主要页面的ViewPage
        viewPager = (ViewPager)findViewById(R.id.viewPaper);
        
    }
    
    
    /**
     *为ViewPager侧滑创建Adapter，首先将5个XML页面的View对象装入List中
     **/
    public void setViewPager(){
    	List<View> list_for_five_mainView = new ArrayList<View>() ;
        
        list_for_five_mainView.add(find_recommend_view);
        list_for_five_mainView.add(find_category_view);
        list_for_five_mainView.add(follow_main_view);
        list_for_five_mainView.add(message_main_view);
        list_for_five_mainView.add(mine_main_view);
        
        ScreenPagerAdapter sPagerAdapter = new ScreenPagerAdapter
        		                                                                               (list_for_five_mainView);
      //为5个主页的ViewPager设置Adapter
      viewPager.setAdapter(sPagerAdapter);
      //并为ViewPager载入监听器
      viewPager.setOnPageChangeListener(this);
    	
    }
    
    /**
     * 对顶部标题栏、底部导航栏中图标的亮暗进行初始化，也是当前页面为0时
     **/
    public void initNavIcon(){
    	currentPage = 0 ;
    	title_recommend.setVisibility(View.VISIBLE);
        title_category.setVisibility(View.VISIBLE);
    	title_recommend.setTextColor(Color.parseColor("#ffffff"));     
        title_category.setTextColor(Color.parseColor("#66d7e5"));
        title_follow.setVisibility(View.GONE);
        title_message.setVisibility(View.GONE);
        title_mine.setVisibility(View.GONE);
        find_nav_icon_notice.setVisibility(View.VISIBLE);
        find_nav_icon.setVisibility(View.GONE);
        nav_find.setTextColor(Color.parseColor("#2fb9c3"));   
        follow_nav_icon_notice.setVisibility(View.GONE);
        follow_nav_icon.setVisibility(View.VISIBLE);
        nav_follow.setTextColor(Color.parseColor("#333333")); 
        message_nav_icon_notice.setVisibility(View.GONE); 
        message_nav_icon.setVisibility(View.VISIBLE);
        nav_message.setTextColor(Color.parseColor("#333333"));
        mine_nav_icon_notice.setVisibility(View.GONE); 
        mine_nav_icon.setVisibility(View.VISIBLE);
        nav_mine.setTextColor(Color.parseColor("#333333")); 
    }
    
    /**
     * 以下几个方法分别是页面滑动的时候顶部标题和底部导航元素的变化控制
     **/
    public void changeNavForSlide_1(){
    	title_recommend.setVisibility(View.VISIBLE);
        title_category.setVisibility(View.VISIBLE);
    	title_recommend.setTextColor(Color.parseColor("#66d7e5"));     
        title_category.setTextColor(Color.parseColor("#ffffff"));
        title_follow.setVisibility(View.GONE);
        title_message.setVisibility(View.GONE);
        title_mine.setVisibility(View.GONE);
        find_nav_icon_notice.setVisibility(View.VISIBLE);
        find_nav_icon.setVisibility(View.GONE);
        nav_find.setTextColor(Color.parseColor("#2fb9c3"));   
        follow_nav_icon_notice.setVisibility(View.GONE);
        follow_nav_icon.setVisibility(View.VISIBLE);
        nav_follow.setTextColor(Color.parseColor("#333333")); 
        message_nav_icon_notice.setVisibility(View.GONE); 
        message_nav_icon.setVisibility(View.VISIBLE);
        nav_message.setTextColor(Color.parseColor("#333333"));
        mine_nav_icon_notice.setVisibility(View.GONE); 
        mine_nav_icon.setVisibility(View.VISIBLE);
        nav_mine.setTextColor(Color.parseColor("#333333")); 
    }
    public void changeNavForSlide_2(){
    	title_recommend.setVisibility(View.GONE);
        title_category.setVisibility(View.GONE);
		title_follow.setVisibility(View.VISIBLE);
        title_message.setVisibility(View.GONE);
        title_mine.setVisibility(View.GONE);
        find_nav_icon_notice.setVisibility(View.GONE);
        find_nav_icon.setVisibility(View.VISIBLE);
        nav_find.setTextColor(Color.parseColor("#333333"));   
        follow_nav_icon_notice.setVisibility(View.VISIBLE);
        follow_nav_icon.setVisibility(View.GONE);
        nav_follow.setTextColor(Color.parseColor("#2fb9c3")); 
        message_nav_icon_notice.setVisibility(View.GONE); 
        message_nav_icon.setVisibility(View.VISIBLE);
        nav_message.setTextColor(Color.parseColor("#333333"));
        mine_nav_icon_notice.setVisibility(View.GONE); 
        mine_nav_icon.setVisibility(View.VISIBLE);
        nav_mine.setTextColor(Color.parseColor("#333333"));
    }
    public void changeNavForSlide_3(){
    	title_recommend.setVisibility(View.GONE);
        title_category.setVisibility(View.GONE);
		title_follow.setVisibility(View.GONE);
        title_message.setVisibility(View.VISIBLE);
        title_mine.setVisibility(View.GONE);
        find_nav_icon_notice.setVisibility(View.GONE);
        find_nav_icon.setVisibility(View.VISIBLE);
        nav_find.setTextColor(Color.parseColor("#333333"));   
        follow_nav_icon_notice.setVisibility(View.GONE);
        follow_nav_icon.setVisibility(View.VISIBLE);
        nav_follow.setTextColor(Color.parseColor("#333333")); 
        message_nav_icon_notice.setVisibility(View.VISIBLE); 
        message_nav_icon.setVisibility(View.GONE);
        nav_message.setTextColor(Color.parseColor("#2fb9c3"));
        mine_nav_icon_notice.setVisibility(View.GONE); 
        mine_nav_icon.setVisibility(View.VISIBLE);
        nav_mine.setTextColor(Color.parseColor("#333333")); 
    }
    public void changeNavForSlide_4(){
    	title_recommend.setVisibility(View.GONE);
        title_category.setVisibility(View.GONE);
		title_follow.setVisibility(View.GONE);
        title_message.setVisibility(View.GONE);
        title_mine.setVisibility(View.VISIBLE);
        find_nav_icon_notice.setVisibility(View.GONE);
        find_nav_icon.setVisibility(View.VISIBLE);
        nav_find.setTextColor(Color.parseColor("#333333"));   
        follow_nav_icon_notice.setVisibility(View.GONE);
        follow_nav_icon.setVisibility(View.VISIBLE);
        nav_follow.setTextColor(Color.parseColor("#333333")); 
        message_nav_icon_notice.setVisibility(View.GONE); 
        message_nav_icon.setVisibility(View.VISIBLE);
        nav_message.setTextColor(Color.parseColor("#333333"));
        mine_nav_icon_notice.setVisibility(View.VISIBLE); 
        mine_nav_icon.setVisibility(View.GONE);
        nav_mine.setTextColor(Color.parseColor("#2fb9c3"));
    }
    
    /**
     * 用于设置当前的Screen视图
     * */
    public void setCurrentPage(int position){
        if(position< 0 || position >= 5){
            return ;
        }
        viewPager.setCurrentItem(position);
    }

	@Override
	public void onPageScrollStateChanged(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * 当ViewPager滑动的时候，该方法被调用
	 */
	@Override
	public void onPageSelected(int arg0) {
		currentPage = arg0 ;
		if(arg0 == 0)initNavIcon();
		if(arg0 == 1)changeNavForSlide_1();
		if(arg0 == 2)changeNavForSlide_2();
		if(arg0 == 3)changeNavForSlide_3();
		if(arg0 == 4)changeNavForSlide_4();
		}

	/**
	 * 处理顶部标题栏和底部导航栏中Button的点击事件
	 */
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
        	case R.id.button_title_post:
        		//TODO
        		break;

        	case R.id.button_title_audio:
        		//TODO
        		break;
        		
        	case R.id.button_title_recommend:
        		setCurrentPage(0);
        		initNavIcon();
        		break;
        		
        	case R.id.button_title_category:
        		setCurrentPage(1);
        		changeNavForSlide_1();
        		break;
        		
        	case R.id.button_nav_find:
        		if(title_recommend.getCurrentTextColor() == 0xffffffff){
        			setCurrentPage(0);
        			initNavIcon();
        		}
        		else{
        			setCurrentPage(1);
            		changeNavForSlide_1();
        		}
        		break;
        		
        	case R.id.button_nav_follow:
        		setCurrentPage(2);
        		changeNavForSlide_2();
        		break;
        		
        	case R.id.button_nav_message:
        		setCurrentPage(3);
        		changeNavForSlide_3();
        		break;
        	
        	case R.id.button_nav_mine:
        		setCurrentPage(4);
        		changeNavForSlide_4();
        		break;
        	}

     }
	
}







