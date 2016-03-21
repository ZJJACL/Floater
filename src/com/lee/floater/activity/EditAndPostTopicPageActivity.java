package com.lee.floater.activity;

import com.lee.floater.R;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

public class EditAndPostTopicPageActivity extends Activity {

	TextView top_title_bar;
	Handler handler = new Handler();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.edit_post_topic);
		top_title_bar = (TextView) findViewById(R.id.edit_post_topic_page_title);

		Intent intent = getIntent();
		top_title_bar.setText("����" + intent.getStringExtra("topic_category")+ "����");

		// ��ʱִ�����𶯻�
		handler.postDelayed(new Runnable() {
			@Override
			public void run() {
				hideFullPage();
			}
		}, 200);
		
		

	}

	/**
	 * �����ⷢ��ҳ��
	 */
	public void hideFullPage() {
		int color = Color.parseColor("#00000000");
		Main.button_title_post.setOrientation(0, true);
		Main.revealColorView.hide(0, 0, color, 0, 300, null);
		Main.isFullScreen = false;
		Main.revealColorView.setClickable(false);
		Main.post_topic_page_main_layout.setVisibility(View.GONE);
	}

}
