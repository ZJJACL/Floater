package com.lee.floater.handler;

import java.util.ArrayList;

import com.lee.floater.R;
import com.lee.floater.adapters.CardListAdapter;
import com.lee.floater.items.Card_Item;

import android.content.Context;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

/**
 * 集中处理我的页面中的所有事务
 */
public class MineMainPageHandler {
	
		public Context context;  //将Main传进来
		public View mine_main_view ; //我的页面的主View
		
		//个人主页中的头部View索引(头像/昵称/学校/关注/操作条)
	    public View personal_homepage_head;
	    
		public RecyclerView personal_homepage_mine_cards_recyclerview;//我的页面中卡片列表的RecyclerView
	
		//我的个人主页中的卡片列表中的数据
	    public ArrayList<Card_Item>personal_mine_cards_list_items=new ArrayList<Card_Item>();
	
	 	/**
		 * 构造方法中将分类页面View和Main传进来
		 */
		public MineMainPageHandler (View mine_main_view, Context context){
			this.mine_main_view = mine_main_view ;
			this.context = context;
			findAllViewById();
		}
		
		/**
		 * 加载我的页中的所有的View索引
		 */
		public void findAllViewById(){
			
			LayoutInflater inflater = LayoutInflater.from(context);
			
			 //将个人主页中的头部View装载为View
	        personal_homepage_head=inflater.inflate(R.layout.personal_homepage_head,null);
	        
	        //加载我的页面中的卡片列表的RecyclerView
	        personal_homepage_mine_cards_recyclerview=
	        		(RecyclerView)mine_main_view.findViewById(R.id.personal_homepage_mine_cards_recyclerview);
		
		}
		
		/**
		 * 我的页面中的事务处理中继器
		 */
		public void Handle (){
			
			//加载我的页面中的卡片列表中的数据
	        loadPersonalPageMineCardItems();
	        
	        //将我的页面中卡片列表中的数据装载到RecyclerView中
	        setPersonalPageMineCardRecyclerView();
			
		}
		
		/**
	     * 加载我的页面中的卡片列表中的数据
	     */
	    public void loadPersonalPageMineCardItems(){
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
	    		personal_mine_cards_list_items.add(item);
	    	}    	
	    }
	    
	    /**
	     * 将我的页面中卡片列表中的数据装载到RecyclerView中
	     */
	    public  void setPersonalPageMineCardRecyclerView(){
	    	//默认动画效果
	    	personal_homepage_mine_cards_recyclerview.setItemAnimator(new DefaultItemAnimator());
	        //设置布局管理器，第三个参数为是否逆向布局
	    	personal_homepage_mine_cards_recyclerview.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
	    	
	        //可以提高效率
	    	personal_homepage_mine_cards_recyclerview.setHasFixedSize(true);
			//新建适配器
	        CardListAdapter adapter = new CardListAdapter(context);
	      //设置适配器
	        personal_homepage_mine_cards_recyclerview.setAdapter(adapter);
	        adapter.addDatas(personal_mine_cards_list_items);
	        
	        //加载头部
	        adapter.setHeaderView(personal_homepage_head);
	    }

}
