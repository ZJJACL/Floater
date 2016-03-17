package com.lee.floater.adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.lee.floater.R;
import com.lee.floater.items.Card_Item;
import com.lee.floater.listeners.CardListItemListener;

public class CardListAdapter extends BaseRecyclerAdapter<Card_Item> {
	
	    Context context;
	    
	    public CardListAdapter(Context context){
	    	this.context = context ;
	    }
	
	    //将写好的列表项布局进行绑定
		@Override
		public RecyclerView.ViewHolder onCreate(ViewGroup parent, int viewType) {
			View view = LayoutInflater.from(parent.getContext()).inflate(
					R.layout.card_item, parent, false);
			return new ItemViewHolder(view);
		}

		//将每个列表项中的实际数据进行绑定
		@Override
		public void onBind(ViewHolder viewHolder, int RealPosition, Card_Item data) {
			if(viewHolder instanceof ItemViewHolder) {
				
				ItemViewHolder mViewHolder = (ItemViewHolder)viewHolder;
				mViewHolder.card_user_icon.setImageResource(data.getCardUserIcon());
				mViewHolder.card_user_name.setText(data.getCardUserName());
				mViewHolder.card_user_university.setText(data.getCardUserUniversity());
				mViewHolder.card_post_time.setText(data.getCardPostTime());
				mViewHolder.card_imgtext_picture.setImageResource(data.getCardImgTextPicture());
				mViewHolder.card_text_content.setText(data.getCardTextContent());
				mViewHolder.card_first_author.setText(data.getCardFirstAuthor());
				mViewHolder.card_from_topic.setText(data.getCardFromTopic());
				mViewHolder.card_bottom_operate_chart.setImageResource(data.getCardBottomOperateChart());
				mViewHolder.card_bottom_operate_delete.setImageResource(data.getCardBottomOperateDelete());
				mViewHolder.card_bottom_operate_comment.setImageResource(data.getCardBottomOperateComment());
				mViewHolder.card_bottom_operate_forward.setImageResource(data.getCardBottomOperateForward());
				mViewHolder.card_bottom_operate_praise.setImageResource(data.getCardBottomOperatePraise());
				mViewHolder.card_bottom_operate_praise_red.setImageResource(data.getCardBottomOperatePraiseRed());
				mViewHolder.card_bottom_text_hello.setText(data.getCardBottomTextHello());
				mViewHolder.card_bottom_text_delete.setText(data.getCardBottomTextDelete());
				mViewHolder.card_bottom_text_comment.setText(data.getCardBottomTextComment());
				mViewHolder.card_bottom_text_forward.setText(data.getCardBottomTextForward());
				mViewHolder.card_bottom_text_praise.setText(data.getCardBottomTextPraise());
			    
				//为CardView绑定点击监听事件
				mViewHolder.card_item_view.setOnClickListener(new CardListItemListener(context));
				
				
			}
		}

		//创建一个ItemViewHoder,指明每个Item的View中包含的控件
	   class ItemViewHolder extends BaseRecyclerAdapter.Holder  {
		   
		    CardView card_item_view ; //当前卡片的CardView
		    ImageView card_user_icon ;//用户头像
			TextView card_user_name ; //用户昵称
			TextView card_user_university;//用户学校和专业
			TextView card_post_time;//卡片的发布时间
		    ImageView card_imgtext_picture;//图文卡片中的内容_大图
			TextView card_text_content;//卡片中的内容_文字
			TextView card_first_author;//卡片的原作者
			TextView card_from_topic;//卡片所属的话题
		    ImageView card_bottom_operate_chart;//卡片底部操作栏的聊天图片
		    ImageView card_bottom_operate_delete;//卡片底部操作栏的删除图片
		    ImageView card_bottom_operate_comment;//卡片底部操作栏的评论图片
		    ImageView card_bottom_operate_forward;//卡片底部操作栏的转发图片
		    ImageView card_bottom_operate_praise;//卡片底部操作栏的赞图片
		    ImageView card_bottom_operate_praise_red;//卡片底部操作栏的已赞图片
			TextView card_bottom_text_hello;//卡片底部操作栏的聊天文本
			TextView card_bottom_text_delete;//卡片底部操作栏的删除文本
			TextView card_bottom_text_comment;//卡片底部操作栏的评论文本/数字
			TextView card_bottom_text_forward;//卡片底部操作栏的转发文本/数字
			TextView card_bottom_text_praise;//卡片底部操作栏的点赞文本/数字
			TextView card_bottom_operate_separation; //格外添加的分割线

			public ItemViewHolder(View itemView) {
				super(itemView);
				card_item_view = (CardView) itemView.findViewById(R.id.card_item_view);
				card_user_icon =(ImageView) itemView.findViewById(R.id.card_user_icon);
				card_user_name =(TextView)itemView.findViewById(R.id.card_user_name);
				card_user_university = (TextView)itemView.findViewById(R.id.card_user_university);
				card_post_time = (TextView)itemView.findViewById(R.id.card_post_time);
				card_imgtext_picture = (ImageView) itemView.findViewById(R.id.card_imgtext_picture);
				card_text_content= (TextView)itemView.findViewById(R.id.card_text_content);
				card_first_author= (TextView)itemView.findViewById(R.id.card_first_author);
				card_from_topic= (TextView)itemView.findViewById(R.id.card_from_topic);
				card_bottom_operate_chart=(ImageView) itemView.findViewById(R.id.card_bottom_operate_chart);
				card_bottom_operate_delete=(ImageView) itemView.findViewById(R.id.card_bottom_operate_delete);
				card_bottom_operate_comment=(ImageView) itemView.findViewById(R.id.card_bottom_operate_comment);
				card_bottom_operate_forward=(ImageView) itemView.findViewById(R.id.card_bottom_operate_forward);
				card_bottom_operate_praise=(ImageView) itemView.findViewById(R.id.card_bottom_operate_praise);
				card_bottom_operate_praise_red=(ImageView) itemView.findViewById(R.id.card_bottom_operate_praise_red);
				card_bottom_text_hello=(TextView) itemView.findViewById(R.id.card_bottom_text_hello);
				card_bottom_text_delete=(TextView) itemView.findViewById(R.id.card_bottom_text_delete);
				card_bottom_text_comment=(TextView) itemView.findViewById(R.id.card_bottom_text_comment);
				card_bottom_text_forward=(TextView) itemView.findViewById(R.id.card_bottom_text_forward);
				card_bottom_text_praise=(TextView) itemView.findViewById(R.id.card_bottom_text_praise);
				card_bottom_operate_separation=(TextView) itemView.findViewById(R.id.card_bottom_operate_separation);
			}
		}

}
