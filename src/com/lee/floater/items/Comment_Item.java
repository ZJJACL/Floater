package com.lee.floater.items;

/**
 *每一个评论项中包含的成员变量 
 *
 */
public class Comment_Item {

	public int commment_user_icon; //评论项中的用户头像
	public String comment_user_name;//评论项中的用户昵称
	public String comment_user_university;//评论项中的用户学校
	public String comment_content;//评论项中的评论内容
	public String comment_post_time;//评论项中的评论提交时间
	
	//get和set方法
		public void setCommentUserIcon(int commment_user_icon){
			this.commment_user_icon = commment_user_icon;
		}
		public int getCommentUserIcon(){
			return this.commment_user_icon;
		}
		
		public void setCommentUserName(String comment_user_name){
			this.comment_user_name = comment_user_name;
		}
		public String getCommentUserName(){
			return this.comment_user_name;
		}
		
		public void setCommentUserUniversity(String comment_user_university){
			this.comment_user_university = comment_user_university;
		}
		public String getCommentUserUniversity(){
			return this.comment_user_university;
		}
		
		public void setCommentContent(String comment_content){
			this.comment_content = comment_content;
		}
		public String getCommentContent(){
			return this.comment_content;
		}
		
		public void setCommentPostTime(String comment_post_time){
			this.comment_post_time = comment_post_time;
		}
		public String getCommentPostTime(){
			return this.comment_post_time;
		}
		
		
}
