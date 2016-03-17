package com.lee.floater.listeners;

import android.content.Context;
import android.content.Intent;

import com.lee.floater.activity.TopicMainPageActivity;
import com.lee.floater.adapters.BaseRecyclerAdapter;
import com.lee.floater.items.Topic_Item;

/**
 * 当话题列表中的某一项被单击的时候，调用这个监听器来处理，以启动对应的话题主页的Activity
 *
 */
public class TopicListItemListener  implements BaseRecyclerAdapter.OnItemClickListener<Topic_Item> {

	Context context ;
	
	public TopicListItemListener(Context context){
		this.context = context;
	}
	
	
	@Override
	public void onItemClick(int position, Topic_Item data) {
		
		Intent intent = new Intent() ;
 	    intent.setClass(context, TopicMainPageActivity.class) ;
        context.startActivity(intent) ;
		
	}


}
