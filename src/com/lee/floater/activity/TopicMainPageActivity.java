package com.lee.floater.activity;

import java.util.ArrayList;
import com.lee.floater.R;
import com.lee.floater.adapters.CardListAdapter;
import com.lee.floater.items.Card_Item;
import com.lee.floater.support.FloatingButton;
import com.lee.floater.support.FloatingRelativeLayout;
import com.lee.floater.support.SystemBarTintManager;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Window;

public class TopicMainPageActivity extends Activity {
	
	//话题主页面中卡片列表的RecyclerView
	public RecyclerView topic_main_page_cards_recyclerview;
	
	//话题主页面中卡片列表中的数据List
    public ArrayList<Card_Item>topic_main_page_cards_list_items = new ArrayList<Card_Item>();
	
    public LinearLayoutManager linearLayoutManager;//话题主页RecyclerView的布局
    
	public CardListAdapter adapter; //话题主页的RecyclerView的Adapter
	
	FloatingButton floating_action_button ; //浮动的创建卡片按钮
	
	FloatingRelativeLayout topic_main_page_filter_layout ; //顶部的筛选条
	
    
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
        
        
        setContentView(R.layout.topic_main_page);
        
        topic_main_page_cards_recyclerview =
        		(RecyclerView) findViewById(R.id.topic_main_page_cards_recyclerview);
        
        floating_action_button = (FloatingButton)findViewById(R.id.post_card_button);
        
        topic_main_page_filter_layout = (FloatingRelativeLayout)findViewById(R.id.topic_main_page_filter_layout);
        

        //加载话题主页中的卡片ArrayList
        loadTopicMainPageCardItems();
        
        //将话题主页中卡片列表中的数据装载到RecyclerView中，并显示出来
        setTopicMainPageCardRecyclerView();
        
	}
	
	/**
	 * 加载话题主页中的卡片ArrayList
	 */
	public void loadTopicMainPageCardItems(){
		
		//预设加载10条
    	for(int i=0 ; i<10; i++){
    		Card_Item item = new Card_Item();
    		item.setCardUserIcon(R.drawable.card_user_icon);
    		item.setCardUserName("超级女飞侠");
    		item.setCardUserUniversity("鲁迅美术学院现代艺术");
    		item.setCardPostTime("昨天 20：23");
    		item.setCardImgTextPicture(R.drawable.card_imgtext_picture);
    		item.setCardTextContent("刚刚为一件非常重要的事情排完舞蹈，什么事儿等我晚上的微博公布，买了重庆小面");
    		item.setCardFirstAuthor("原作者：鞠婧祎");
    		item.setCardFromTopic("# 五校校花大评选 #");
    		item.setCardBottomOperateChart(R.drawable.card_bottom_operate_chart);
    		item.setCardBottomOperatePraise(R.drawable.card_bottom_operate_praise);
    		item.setCardBottomTextHello("咳咳");
    		item.setCardBottomTextComment("32");
    		item.setCardBottomTextForward("转发");
    		item.setCardBottomTextPraise("Nice");
    		topic_main_page_cards_list_items.add(item);
    	}
		
	}
	
	/**
	 * 将话题主页中卡片列表中的数据装载到RecyclerView中，并显示出来
	 */
	public void setTopicMainPageCardRecyclerView(){
		
		 //默认动画效果
		topic_main_page_cards_recyclerview.setItemAnimator(new DefaultItemAnimator());
        //设置布局管理器，第三个参数为是否逆向布局
		linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
		topic_main_page_cards_recyclerview.setLayoutManager(linearLayoutManager);
        //可以提高效率
		topic_main_page_cards_recyclerview.setHasFixedSize(true);
		
		//新建适配器
        adapter = new CardListAdapter(TopicMainPageActivity.this);
        adapter.addDatas(topic_main_page_cards_list_items);
        
        //添加一个空的头部
        LayoutInflater inflater = LayoutInflater.from(this);
        adapter.setHeaderView( inflater.inflate(R.layout.null_bar_for_list_head,null));
        
        //设置适配器
        topic_main_page_cards_recyclerview.setAdapter(adapter);
        
        topic_main_page_cards_recyclerview.setOnScrollListener(new TopicMainPageOnScrollListener());
       
	}
	
	//滚动事件监听器
	class TopicMainPageOnScrollListener extends  RecyclerView.OnScrollListener{
		@Override  
		    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {  
		        boolean isSignificantDelta = Math.abs(dy) > 4;  
		        if (isSignificantDelta) {  
		            if (dy > 0) {  
		            	floating_action_button.hide();
		            	topic_main_page_filter_layout.hide();
		            } else {  
		            	floating_action_button.show();
		            	topic_main_page_filter_layout.show();
		            }  
		        }  
		    }  
	}
	

}
