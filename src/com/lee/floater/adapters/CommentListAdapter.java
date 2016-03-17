package com.lee.floater.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.lee.floater.R;
import com.lee.floater.items.Comment_Item;

public class CommentListAdapter extends BaseRecyclerAdapter<Comment_Item>{
	
	Context context;
	
	public CommentListAdapter(Context context){
		this.context = context;
	}

	//��д�õ��б���ֽ��а�
		@Override
		public RecyclerView.ViewHolder onCreate(ViewGroup parent, int viewType) {
			View view = LayoutInflater.from(parent.getContext()).inflate(
					R.layout.list_comment, parent, false);
			return new ItemViewHolder(view);
		}

		//��ÿ���������е�ʵ�����ݽ��а�
		@Override
		public void onBind(ViewHolder viewHolder, int RealPosition,Comment_Item data) {
			if(viewHolder instanceof ItemViewHolder) {
				ItemViewHolder mViewHolder = (ItemViewHolder)viewHolder;
				mViewHolder.commment_user_icon.setImageResource(data.getCommentUserIcon());
				mViewHolder.comment_user_name.setText(data.getCommentUserName());
				mViewHolder.comment_user_university.setText(data.getCommentUserUniversity());
				mViewHolder.comment_content.setText(data.getCommentContent());
				mViewHolder.comment_post_time.setText(data.getCommentPostTime());
			    }
		}

		//����һ��ItemViewHoder,ָ��ÿ��Item��View�а����Ŀؼ�
	   class ItemViewHolder extends BaseRecyclerAdapter.Holder  {
		   
			ImageView commment_user_icon;
			TextView comment_user_name;
			TextView comment_user_university;
			TextView comment_content;
			TextView comment_post_time;
			TextView comment_separation; //������ӵķָ���

			public ItemViewHolder(View itemView) {
				super(itemView);
				commment_user_icon = (ImageView) itemView.findViewById(R.id.commment_user_icon);
				comment_user_name = (TextView) itemView.findViewById(R.id.comment_user_name);
				comment_user_university = (TextView) itemView.findViewById(R.id.comment_user_university);
				comment_content = (TextView) itemView.findViewById(R.id.comment_content);
				comment_post_time=(TextView)itemView.findViewById(R.id.comment_post_time);
				comment_separation=(TextView)itemView.findViewById(R.id.comment_separation);
			}
		}
	   
}
