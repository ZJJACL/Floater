package com.lee.floater.listeners;

import com.lee.floater.activity.CardDetailPageActivity;
import com.lee.floater.items.Card_Item;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class CardListItemListener implements OnClickListener {
	
	Context context;
	Card_Item data ;
	
	public CardListItemListener(Context context ,Card_Item data  ){
		this.context= context;
		this.data = data ;
	}

	@Override
	public void onClick(View v) {
		
		//这里需要将这个Card_Item对象传给卡片详情页的Activity
		Bundle bundle = new Bundle();
		bundle.putSerializable("card_item", data);
		
		Intent intent = new Intent() ;
 	    intent.setClass(context, CardDetailPageActivity.class) ;
 	    
 	    intent.putExtras(bundle);

        context.startActivity(intent) ;
	}

}
