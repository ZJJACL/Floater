package com.lee.floater.adapters;

import com.lee.floater.R;
import com.lee.floater.items.Topic_Item;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * 
 * 编写话题列表的适配器接口
 *
 */
public class TopicListAdapter extends BaseRecyclerAdapter<Topic_Item>{
	
	//将写好的列表项布局进行绑定
	@Override
	public RecyclerView.ViewHolder onCreate(ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(parent.getContext()).inflate(
				R.layout.list_topic, parent, false);
		return new ItemViewHolder(view);
	}

	//将每个列表项中的实际数据进行绑定
	//在运行实际的数据的时候，topic_icon 和 topic_category_icon肯定需要转换一下
	@Override
	public void onBind(ViewHolder viewHolder, int RealPosition, Topic_Item data) {
		if(viewHolder instanceof ItemViewHolder) {
			((ItemViewHolder)viewHolder).topic_icon.setImageResource(data.getTopicIcon());
			((ItemViewHolder)viewHolder).topic_title.setText(data.getTopicTitle());
			((ItemViewHolder)viewHolder).topic_content_number.setText("已制造"+data.getTopicContentNumber()+"个卡片");
			((ItemViewHolder)viewHolder).topic_category_icon.setImageResource(data.getTopicCategory());
			((ItemViewHolder)viewHolder).topic_update_number.setText(""+data.getTopicUpdateNumber());
		    }
	}

	//创建一个ItemViewHoder,指明每个Item的View中包含的控件
   class ItemViewHolder extends BaseRecyclerAdapter.Holder  {
	   
		ImageView topic_icon;
		TextView topic_title;
		TextView topic_content_number;
		ImageView topic_category_icon;
		TextView topic_update_number;//仅仅针对于当前用户已经关注的话题
		TextView list_topic_separation; //格外添加的分割线

		public ItemViewHolder(View itemView) {
			super(itemView);
			topic_icon = (ImageView) itemView.findViewById(R.id.list_topic_icon);
			topic_title = (TextView) itemView.findViewById(R.id.list_topic_title);
			topic_content_number = (TextView) itemView.findViewById(R.id.list_topic_content_number);
			topic_category_icon = (ImageView) itemView.findViewById(R.id.list_topic_category_icon);
			list_topic_separation=(TextView)itemView.findViewById(R.id.list_topic_separation);
			topic_update_number=(TextView)itemView.findViewById(R.id.list_topic_update_number);
		}
	}
}
