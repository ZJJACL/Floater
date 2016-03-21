package com.lee.floater.activity;

import java.util.ArrayList;

import com.lee.floater.R;
import com.lee.floater.adapters.CommentListAdapter;
import com.lee.floater.items.Card_Item;
import com.lee.floater.items.Comment_Item;
import com.lee.floater.support.SystemBarTintManager;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * 卡片详情页
 */
public class CardDetailPageActivity extends Activity {
		
		//卡片详情页布局中所有View的索引
		ImageView card_detail_user_icon ;//用户头像
		TextView card_detail_user_name ; //用户昵称
		TextView card_detail_user_university;//用户学校和专业
		TextView card_detail_post_time;//卡片的发布时间
	    ImageView card_detail_imgtext_picture;//图文卡片中的内容_大图
		TextView card_detail_text_content;//卡片中的内容_文字
		TextView card_detail_first_author;//卡片的原作者
		TextView card_detail_from_topic;//卡片所属的话题
	    ImageView card_detail_bottom_operate_chart;//卡片底部操作栏的聊天图片
	    ImageView card_detail_bottom_operate_delete;//卡片底部操作栏的删除图片
	    ImageView card_detail_bottom_operate_comment;//卡片底部操作栏的评论图片
	    ImageView card_detail_bottom_operate_forward;//卡片底部操作栏的转发图片
	    ImageView card_detail_bottom_operate_praise;//卡片底部操作栏的赞图片
	    ImageView card_detail_bottom_operate_praise_red;//卡片底部操作栏的已赞图片
		TextView card_detail_bottom_text_hello;//卡片底部操作栏的聊天文本
		TextView card_detail_bottom_text_delete;//卡片底部操作栏的删除文本
		TextView card_detail_bottom_text_comment;//卡片底部操作栏的评论文本/数字
		TextView card_detail_bottom_text_forward;//卡片底部操作栏的转发文本/数字
		TextView card_detail_bottom_text_praise;//卡片底部操作栏的点赞文本/数字
	
		
		//启动当前Activity传过来的Card_Item对象
		Card_Item top_card ;
	
		//卡片详情页面中评论列表的RecyclerView
		public RecyclerView comment_list_recyclerview;
		
		//卡片详情页的头部（卡片、赞）
		public View card_detail_page_head;
		
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
        
        //通过ID获得所有的View
        FindAllViewById();
        
        //获取启动当前Activity传过来的Card_Item对象
        Intent intent = getIntent();
        top_card  = (Card_Item) intent.getSerializableExtra("card_item");

        //初始化详情页顶部的卡片
        loadTopCard();

        //加载评论列表的ArrayList数据
        loadCommentItems();
        
        //将评论列表中的数据装载到RecyclerView中，并显示出来
        setCommentRecyclerView();
        
	}
	
	/**
	 * 通过ID获得所有的View
	 */
	public void FindAllViewById(){
		
		 comment_list_recyclerview = ( RecyclerView )findViewById(R.id.comment_list_recyclerview);
		 
		 //将头部XML装载为View
		 LayoutInflater inflater = LayoutInflater.from(CardDetailPageActivity.this);
		 card_detail_page_head =inflater.inflate(R.layout.card_detail_page_head,null);
		 
		 card_detail_user_icon = (ImageView)card_detail_page_head.findViewById(R.id.card_detail_user_icon);
		 card_detail_user_name = (TextView)card_detail_page_head.findViewById(R.id.card_detail_user_name);
		 card_detail_user_university= (TextView)card_detail_page_head.findViewById(R.id.card_detail_user_university);
		 card_detail_post_time= (TextView)card_detail_page_head.findViewById(R.id.card_detail_post_time);
		 card_detail_imgtext_picture= (ImageView)card_detail_page_head.findViewById(R.id.card_detail_imgtext_picture);
		 card_detail_text_content= (TextView)card_detail_page_head.findViewById(R.id.card_detail_text_content);
		 card_detail_first_author= (TextView)card_detail_page_head.findViewById(R.id.card_detail_first_author);
		 card_detail_from_topic= (TextView)card_detail_page_head.findViewById(R.id.card_detail_from_topic);
		 card_detail_bottom_operate_chart= (ImageView)card_detail_page_head.findViewById(R.id.card_detail_bottom_operate_chart);
		 card_detail_bottom_operate_delete= (ImageView)card_detail_page_head.findViewById(R.id.card_detail_bottom_operate_delete);
		 card_detail_bottom_operate_comment= (ImageView)card_detail_page_head.findViewById(R.id.card_detail_bottom_operate_comment);
		 card_detail_bottom_operate_forward= (ImageView)card_detail_page_head.findViewById(R.id.card_detail_bottom_operate_forward);
		 card_detail_bottom_operate_praise= (ImageView)card_detail_page_head.findViewById(R.id.card_detail_bottom_operate_praise);
		 card_detail_bottom_operate_praise_red= (ImageView)card_detail_page_head.findViewById(R.id.card_detail_bottom_operate_praise_red);
		 card_detail_bottom_text_hello= (TextView)card_detail_page_head.findViewById(R.id.card_detail_bottom_text_hello);
		 card_detail_bottom_text_delete= (TextView)card_detail_page_head.findViewById(R.id.card_detail_bottom_text_delete);
		 card_detail_bottom_text_comment= (TextView)card_detail_page_head.findViewById(R.id.card_detail_bottom_text_comment);
		 card_detail_bottom_text_forward= (TextView)card_detail_page_head.findViewById(R.id.card_detail_bottom_text_forward);
		 card_detail_bottom_text_praise= (TextView)card_detail_page_head.findViewById(R.id.card_detail_bottom_text_praise);
		 
	}
	
	
	/**
	 * 初始化卡片详情页顶部的卡片
	 */
	public void loadTopCard(){
		
		card_detail_user_icon.setImageResource(top_card.getCardUserIcon());
		card_detail_user_name.setText(top_card.getCardUserName());
		card_detail_user_university.setText(top_card.getCardUserUniversity());
		card_detail_post_time.setText(top_card.getCardPostTime());
		card_detail_imgtext_picture.setImageResource(top_card.getCardImgTextPicture());
		card_detail_text_content.setText(top_card.getCardTextContent());
		card_detail_first_author.setText(top_card.getCardFirstAuthor());
		card_detail_from_topic.setText(top_card.getCardFromTopic());
		card_detail_bottom_operate_chart.setImageResource(top_card.getCardBottomOperateChart());
		card_detail_bottom_operate_delete.setImageResource(top_card.getCardBottomOperateDelete());
		card_detail_bottom_operate_comment.setImageResource(top_card.getCardBottomOperateComment());
		card_detail_bottom_operate_forward.setImageResource(top_card.getCardBottomOperateForward());
		card_detail_bottom_operate_praise.setImageResource(top_card.getCardBottomOperatePraise());
		card_detail_bottom_operate_praise_red.setImageResource(top_card.getCardBottomOperatePraiseRed());
		card_detail_bottom_text_hello.setText(top_card.getCardBottomTextHello());
		card_detail_bottom_text_delete.setText(top_card.getCardBottomTextDelete());
		card_detail_bottom_text_comment.setText(top_card.getCardBottomTextComment());
		card_detail_bottom_text_forward.setText(top_card.getCardBottomTextForward());
		card_detail_bottom_text_praise.setText(top_card.getCardBottomTextPraise());
		

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
        //加载头部
        adapter.setHeaderView(card_detail_page_head); 
        
        //设置适配器
        comment_list_recyclerview.setAdapter(adapter);

	}
	

}
