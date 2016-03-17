package com.lee.floater.listeners;

import com.lee.floater.activity.CardDetailPageActivity;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

public class CardListItemListener implements OnClickListener {
	
	Context context;
	
	public CardListItemListener(Context context){
		this.context= context;
	}

	@Override
	public void onClick(View v) {
		Intent intent = new Intent() ;
 	    intent.setClass(context, CardDetailPageActivity.class) ;
        context.startActivity(intent) ;
	}

}
