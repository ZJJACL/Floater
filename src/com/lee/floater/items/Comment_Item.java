package com.lee.floater.items;

/**
 *ÿһ���������а����ĳ�Ա���� 
 *
 */
public class Comment_Item {

	public int commment_user_icon; //�������е��û�ͷ��
	public String comment_user_name;//�������е��û��ǳ�
	public String comment_user_university;//�������е��û�ѧУ
	public String comment_content;//�������е���������
	public String comment_post_time;//�������е������ύʱ��
	
	//get��set����
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
