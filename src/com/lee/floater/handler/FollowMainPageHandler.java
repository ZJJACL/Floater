package com.lee.floater.handler;

import java.util.ArrayList;
import com.lee.floater.R;
import com.lee.floater.adapters.CardListAdapter;
import com.lee.floater.items.Card_Item;
import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

public class FollowMainPageHandler {
	
	Context context ; //将Main传进来
	View follow_main_view ; // 关注页面的主View
	
	public RecyclerView follow_main_cards_recyclerview;//关注页面中卡片列表的RecyclerView
	
	//关注页面中卡片列表中的数据List
    public ArrayList<Card_Item>my_follow_cards_list_items = new ArrayList<Card_Item>();
	
	//底部刷新View索引
    public View refresh_footer_view;
    
    //下拉刷新条的索引
    SwipeRefreshLayout refresh_bar_for_follow_main_page;
	

	
	/**
	 * 构造方法中将关注页面View和Main传进来
	 */
	public FollowMainPageHandler(View follow_main_view, Context context){
		this.follow_main_view = follow_main_view ;
		this.context = context;
		findAllViewById();
	}
	
	/**
	 * 加载关注页中的所有的View索引
	 */
	public void findAllViewById(){
		
		LayoutInflater inflater = LayoutInflater.from(context);
		
		//加载关注页面中的卡片列表的RecyclerView
        follow_main_cards_recyclerview=
        		(RecyclerView)follow_main_view.findViewById(R.id.follow_main_cards_recyclerview);
		
      //将列表尾部的加载更多的XML装载为View
        refresh_footer_view = inflater.inflate(R.layout.refresh_footer_view,null);
        
      //加载关注页面的刷新条SwipeRefreshLayout
        refresh_bar_for_follow_main_page = 
        		(SwipeRefreshLayout)follow_main_view.findViewById(R.id.refresh_bar_for_follow_main_page);  
        //为这个刷新条添加滚动颜色
        refresh_bar_for_follow_main_page.setColorSchemeResources(R.color.color1, R.color.color2,R.color.color3, R.color.color4);
        //为关注页面中的刷新控件添加监听器
        refresh_bar_for_follow_main_page.setOnRefreshListener(new followMainPageRefreshListener());
        //为了实现下拉刷新，这里需要为关注页面的RecyclerView添加滚动事件监听器
        follow_main_cards_recyclerview.setOnScrollListener(new followMainPageOnScrollListener());
        
	}
	
	/**
	 * 推荐页面中的数据加载、显示、刷新等所有事务的中继器
	 */
	public void Handle (){
		
		 //加载关注页面中卡片列表中的数据
        loadMyFollowCardItems();
        
        //将关注页面中卡片列表中的数据装载到RecyclerView中
        setMyFollowCardRecyclerView();
        
	}
	
	 /**
     * 加载关注页面中卡片列表中的数据
     */
    public void loadMyFollowCardItems(){
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
    		my_follow_cards_list_items.add(item);
    	}    	
    }
    
    
    /**
     * 将关注页面中卡片列表中的数据装载到RecyclerView中
     */
    public void setMyFollowCardRecyclerView(){
    	//默认动画效果
    	follow_main_cards_recyclerview.setItemAnimator(new DefaultItemAnimator());
        //设置布局管理器，第三个参数为是否逆向布局
    	follow_main_cards_recyclerview.setLayoutManager(new LinearLayoutManager( context , LinearLayoutManager.VERTICAL, false));
        //可以提高效率
    	follow_main_cards_recyclerview.setHasFixedSize(true);
		//新建适配器
        CardListAdapter adapter = new CardListAdapter(context);
      	//设置适配器
        follow_main_cards_recyclerview.setAdapter(adapter);
        adapter.addDatas(my_follow_cards_list_items);
        
        adapter.setFooterView(refresh_footer_view);
        
    }
    
    /**
     * 关注页面中的下拉刷新监听器
     */
    class followMainPageRefreshListener implements OnRefreshListener{

    	@Override
    	public void onRefresh() {
    		
    		Card_Item item = new Card_Item();
    		item.setCardUserIcon(R.drawable.card_user_icon);
    		item.setCardUserName("黑袍妖怪");
    		item.setCardUserUniversity("沈阳音乐学院流行");
    		item.setCardPostTime("昨天 20：23");
    		item.setCardImgTextPicture(R.drawable.card_imgtext_picture);
    		item.setCardTextContent("这次终于成功了，这样就能够顺利的进入下一个阶段了，高兴，高兴！");
    		item.setCardFirstAuthor("原作者：鞠婧祎");
    		item.setCardFromTopic("# 五校校花大评选 #");
    		item.setCardBottomOperateChart(R.drawable.card_bottom_operate_chart);
    		item.setCardBottomOperatePraise(R.drawable.card_bottom_operate_praise);
    		item.setCardBottomTextHello("咳咳");
    		item.setCardBottomTextComment("32");
    		item.setCardBottomTextForward("转发");
    		item.setCardBottomTextPraise("Nice");
    		
    		ArrayList<Card_Item> newDatas = new ArrayList<Card_Item>();
    		newDatas.add(item);
    		
    		 CardListAdapter adapter = 
    				 (CardListAdapter)follow_main_cards_recyclerview.getAdapter();
    		
    		 adapter.refreshPullDown(newDatas);
    		 follow_main_cards_recyclerview.scrollToPosition(0);
    		 
    		refresh_bar_for_follow_main_page.setRefreshing(false);  
    	}
    }
    
    
    /**
     * 关注页面中的加载更多刷新监听器
     */
    class followMainPageOnScrollListener extends RecyclerView.OnScrollListener{
    	
    	LinearLayoutManager linearLayoutManager;
    	CardListAdapter adapter;
    	int lastVisibleItem;
    	
    	@Override  
    	public void onScrollStateChanged(RecyclerView recyclerView, int newState) {  
    		super.onScrollStateChanged(recyclerView, newState);  
    		
    		linearLayoutManager =  (LinearLayoutManager)recyclerView.getLayoutManager();
    		adapter = (CardListAdapter)recyclerView.getAdapter();
    		
    		if (newState ==RecyclerView.SCROLL_STATE_IDLE && lastVisibleItem + 1 == adapter.getItemCount()) {  
    
    			//做刷新处理和访问服务器进行数据的调取
    			TextView text = (TextView)refresh_footer_view.findViewById(R.id.fresh_footer_text);
    			text.setText("努力加载中...");
    			
    		}  
    	}
    	
    	@Override  
    	public void onScrolled(RecyclerView recyclerView, int dx, int dy) {  
    		super.onScrolled(recyclerView,dx, dy);  
    		lastVisibleItem =linearLayoutManager.findLastVisibleItemPosition();  
    	}	
    }

}
