package com.lee.floater.items;

/**
 * 
 * 每一个话题都包含着相同类别的元素
 *此处只列出了话题列表中的几个元素，其他元素可以后添加
 *
 */
public class Topic_Item {
	
	public  int topic_icon ;//话题icon
	public String topic_title;//话题名
	public int topic_content_number ;//卡片数
	public int topic_category;//话题类别
	public int update_number ;//仅仅针对于已经关注的话题
	
	
	//get和set方法
	public void setTopicIcon(int topic_icon){
		this.topic_icon = topic_icon;
	}
	public int getTopicIcon(){
		return this.topic_icon;
	}
	
	public void setTopicTitle(String topic_title){
		this.topic_title = topic_title;
	}
	public String getTopicTitle(){
		return this.topic_title;
	}
	
	public void setTopicContentNumber(int topic_content_number){
		this.topic_content_number = topic_content_number;
	}
	public int getTopicContentNumber(){
		return this.topic_content_number;
	}
	
	public void setTopicCategory(int topic_category){
		this.topic_category = topic_category ;
	}
	public int getTopicCategory(){
		return this.topic_category;
	}
	
	public void setTopicUpdateNumber(int update_number){
		this.update_number=update_number;
	}
	public String getTopicUpdateNumber(){
		if(this.update_number <=0 ) return "";
		else return "+"+this.update_number;
	}

}
