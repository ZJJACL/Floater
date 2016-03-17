package com.lee.floater.items;


/**
 * 每个卡片中包含的内容，由于应用中的卡片类型有很多种
 * 现在的处理方法是，将所有类型的卡片内容的并集都放到
 * 这个类中，在显示的时候有选择的进行显示
 *
 */
public class Card_Item {
	
	int card_user_icon ;//用户头像
	String card_user_name ; //用户昵称
	String card_user_university;//用户学校和专业
	String card_post_time;//卡片的发布时间
	int card_imgtext_picture;//图文卡片中的内容_大图
	String card_text_content;//卡片中的内容_文字
	String card_first_author;//卡片的原作者
	String card_from_topic;//卡片所属的话题
	int card_bottom_operate_chart;//卡片底部操作栏的聊天图片
	int card_bottom_operate_delete;//卡片底部操作栏的删除图片
	int card_bottom_operate_comment;//卡片底部操作栏的评论图片
	int card_bottom_operate_forward;//卡片底部操作栏的转发图片
	int card_bottom_operate_praise;//卡片底部操作栏的赞图片
	int card_bottom_operate_praise_red;//卡片底部操作栏的已赞图片
	String card_bottom_text_hello;//卡片底部操作栏的聊天文本
	String card_bottom_text_delete;//卡片底部操作栏的删除文本
	String card_bottom_text_comment;//卡片底部操作栏的评论文本/数字
	String card_bottom_text_forward;//卡片底部操作栏的转发文本/数字
	String card_bottom_text_praise;//卡片底部操作栏的点赞文本/数字
	
	//get和set方法
	public int getCardUserIcon() {
		return card_user_icon;
	}
	public void setCardUserIcon(int card_user_icon) {
		this.card_user_icon = card_user_icon;
	}
	public String getCardUserName() {
		return card_user_name;
	}
	public void setCardUserName(String card_user_name) {
		this.card_user_name = card_user_name;
	}
	public String getCardUserUniversity() {
		return card_user_university;
	}
	public void setCardUserUniversity(String card_user_university) {
		this.card_user_university = card_user_university;
	}
	public String getCardPostTime() {
		return card_post_time;
	}
	public void setCardPostTime(String card_post_time) {
		this.card_post_time = card_post_time;
	}
	public int getCardImgTextPicture() {
		return card_imgtext_picture;
	}
	public void setCardImgTextPicture(int card_imgtext_picture) {
		this.card_imgtext_picture = card_imgtext_picture;
	}
	public String getCardTextContent() {
		return card_text_content;
	}
	public void setCardTextContent(String card_text_content) {
		this.card_text_content = card_text_content;
	}
	public String getCardFirstAuthor() {
		return card_first_author;
	}
	public void setCardFirstAuthor(String card_first_author) {
		this.card_first_author = card_first_author;
	}
	public String getCardFromTopic() {
		return card_from_topic;
	}
	public void setCardFromTopic(String card_from_topic) {
		this.card_from_topic = card_from_topic;
	}
	public int getCardBottomOperateChart() {
		return card_bottom_operate_chart;
	}
	public void setCardBottomOperateChart(int card_bottom_operate_chart) {
		this.card_bottom_operate_chart = card_bottom_operate_chart;
	}
	public int getCardBottomOperateDelete() {
		return card_bottom_operate_delete;
	}
	public void setCardBottomOperateDelete(int card_bottom_operate_delete) {
		this.card_bottom_operate_delete = card_bottom_operate_delete;
	}
	public int getCardBottomOperateComment() {
		return card_bottom_operate_comment;
	}
	public void setCardBottomOperateComment(int card_bottom_operate_comment) {
		this.card_bottom_operate_comment = card_bottom_operate_comment;
	}
	public int getCardBottomOperateForward() {
		return card_bottom_operate_forward;
	}
	public void setCardBottomOperateForward(int card_bottom_operate_forward) {
		this.card_bottom_operate_forward = card_bottom_operate_forward;
	}
	public int getCardBottomOperatePraise() {
		return card_bottom_operate_praise;
	}
	public void setCardBottomOperatePraise(int card_bottom_operate_praise) {
		this.card_bottom_operate_praise = card_bottom_operate_praise;
	}
	public int getCardBottomOperatePraiseRed() {
		return card_bottom_operate_praise_red;
	}
	public void setCardBottomOperatePraiseRed(int card_bottom_operate_praise_red) {
		this.card_bottom_operate_praise_red = card_bottom_operate_praise_red;
	}
	public String getCardBottomTextHello() {
		return card_bottom_text_hello;
	}
	public void setCardBottomTextHello(String card_bottom_text_hello) {
		this.card_bottom_text_hello = card_bottom_text_hello;
	}
	public String getCardBottomTextDelete() {
		return card_bottom_text_delete;
	}
	public void setCardBottomTextDelete(String card_bottom_text_delete) {
		this.card_bottom_text_delete = card_bottom_text_delete;
	}
	public String getCardBottomTextComment() {
		return card_bottom_text_comment;
	}
	public void setCardBottomTextComment(String card_bottom_text_comment) {
		this.card_bottom_text_comment = card_bottom_text_comment;
	}
	public String getCardBottomTextForward() {
		return card_bottom_text_forward;
	}
	public void setCardBottomTextForward(String card_bottom_text_forward) {
		this.card_bottom_text_forward = card_bottom_text_forward;
	}
	public String getCardBottomTextPraise() {
		return card_bottom_text_praise;
	}
	public void setCardBottomTextPraise(String card_bottom_text_praise) {
		this.card_bottom_text_praise = card_bottom_text_praise;
	}

}
