package com.lee.floater.activity;

import java.util.ArrayList;

import com.lee.floater.R;
import com.lee.floater.activity.TopicMainPageActivity.TopicMainPageOnScrollListener;
import com.lee.floater.adapters.CardListAdapter;
import com.lee.floater.adapters.CommentListAdapter;
import com.lee.floater.items.Card_Item;
import com.lee.floater.items.Comment_Item;
import com.lee.floater.support.SystemBarTintManager;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Window;

/**
 * 卡片详情页
 */
public class CardDetailPageActivity extends Activity {
	
		//卡片详情页面中评论列表的RecyclerView
		public RecyclerView comment_list_recyclerview;
		
		//卡片详情页面中评论列表中的数据List
	    public ArrayList<Comment_Item>comment_list_items = new ArrayList<Comment_Item>();
		
	    public LinearLayoutManager linearLayoutManager;//评论列表的RecyclerView的布局
	    
		public CommentListAdapter adapter; //评论列表的RecyclerView的Adapter
	
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

        setContentView(R.layout.card_detail_page);
   
        comment_list_recyclerview = ( RecyclerView )findViewById(R.id.comment_list_recyclerview);
        
        //加载评论列表的ArrayList数据
        loadCommentItems();
        
        //将评论列表中的数据装载到RecyclerView中，并显示出来
        setCommentRecyclerView();
        
	}
	
	/**
	 * 加载评论列表中的数据，并放进ArrayList中
	 */
	public void  loadCommentItems(){
		//预设加载5条
    	for(int i=0 ; i<5; i++){
    		Comment_Item item = new Comment_Item();
    		item.setCommentUserIcon(R.drawable.card_user_icon);
    		item.setCommentUserName("在深夜的阳台晒月亮");
    		item.setCommentUserUniversity("中国医科大心理学");
    		item.setCommentPostTime("2015-03-02");
    		item.setCommentContent("我初二上了不到半个月就不辍学了，去工厂打工，我总是把简历填成高中学历，就是怕别人不要我，曾经为爱执着，为工作起早贪黑打工十年！闯了十年，我想一个人过下去，就像走过来的青春。");
    		comment_list_items.add(item);
    		}
		
	}
	
	/**
	 * 将评论列表中的数据装载到RecyclerView中，并显示出来
	 */
	public void  setCommentRecyclerView(){
		
		 //默认动画效果
		comment_list_recyclerview.setItemAnimator(new DefaultItemAnimator());
        //设置布局管理器，第三个参数为是否逆向布局
		linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
		comment_list_recyclerview.setLayoutManager(linearLayoutManager);
        //可以提高效率
		comment_list_recyclerview.setHasFixedSize(true);
		
		//新建适配器
        adapter = new CommentListAdapter(CardDetailPageActivity.this);
        adapter.addDatas(comment_list_items);
         
        //设置适配器
        comment_list_recyclerview.setAdapter(adapter);

	}
	

}
