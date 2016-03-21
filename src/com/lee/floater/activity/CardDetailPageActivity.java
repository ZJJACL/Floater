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
 * ��Ƭ����ҳ
 */
public class CardDetailPageActivity extends Activity {
		
		//��Ƭ����ҳ����������View������
		ImageView card_detail_user_icon ;//�û�ͷ��
		TextView card_detail_user_name ; //�û��ǳ�
		TextView card_detail_user_university;//�û�ѧУ��רҵ
		TextView card_detail_post_time;//��Ƭ�ķ���ʱ��
	    ImageView card_detail_imgtext_picture;//ͼ�Ŀ�Ƭ�е�����_��ͼ
		TextView card_detail_text_content;//��Ƭ�е�����_����
		TextView card_detail_first_author;//��Ƭ��ԭ����
		TextView card_detail_from_topic;//��Ƭ�����Ļ���
	    ImageView card_detail_bottom_operate_chart;//��Ƭ�ײ�������������ͼƬ
	    ImageView card_detail_bottom_operate_delete;//��Ƭ�ײ���������ɾ��ͼƬ
	    ImageView card_detail_bottom_operate_comment;//��Ƭ�ײ�������������ͼƬ
	    ImageView card_detail_bottom_operate_forward;//��Ƭ�ײ���������ת��ͼƬ
	    ImageView card_detail_bottom_operate_praise;//��Ƭ�ײ�����������ͼƬ
	    ImageView card_detail_bottom_operate_praise_red;//��Ƭ�ײ�������������ͼƬ
		TextView card_detail_bottom_text_hello;//��Ƭ�ײ��������������ı�
		TextView card_detail_bottom_text_delete;//��Ƭ�ײ���������ɾ���ı�
		TextView card_detail_bottom_text_comment;//��Ƭ�ײ��������������ı�/����
		TextView card_detail_bottom_text_forward;//��Ƭ�ײ���������ת���ı�/����
		TextView card_detail_bottom_text_praise;//��Ƭ�ײ��������ĵ����ı�/����
	
		
		//������ǰActivity��������Card_Item����
		Card_Item top_card ;
	
		//��Ƭ����ҳ���������б��RecyclerView
		public RecyclerView comment_list_recyclerview;
		
		//��Ƭ����ҳ��ͷ������Ƭ���ޣ�
		public View card_detail_page_head;
		
		//��Ƭ����ҳ���������б��е�����List
	    public ArrayList<Comment_Item>comment_list_items = new ArrayList<Comment_Item>();
		
	    public LinearLayoutManager linearLayoutManager;//�����б��RecyclerView�Ĳ���
	    
		public CommentListAdapter adapter; //�����б��RecyclerView��Adapter
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
      //�趨״̬������ɫ�����汾����4.4ʱ������
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            SystemBarTintManager tintManager = new SystemBarTintManager(this);
            tintManager.setStatusBarTintEnabled(true);
            //�˴���������ָ��״̬����ɫ
            tintManager.setStatusBarTintResource(R.color.status);
        }
        //���汾����4.4֮��ǿ�����ر�����
        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT){
        	requestWindowFeature(Window.FEATURE_NO_TITLE);   
        }

        setContentView(R.layout.card_detail_page);
        
        //ͨ��ID������е�View
        FindAllViewById();
        
        //��ȡ������ǰActivity��������Card_Item����
        Intent intent = getIntent();
        top_card  = (Card_Item) intent.getSerializableExtra("card_item");

        //��ʼ������ҳ�����Ŀ�Ƭ
        loadTopCard();

        //���������б��ArrayList����
        loadCommentItems();
        
        //�������б��е�����װ�ص�RecyclerView�У�����ʾ����
        setCommentRecyclerView();
        
	}
	
	/**
	 * ͨ��ID������е�View
	 */
	public void FindAllViewById(){
		
		 comment_list_recyclerview = ( RecyclerView )findViewById(R.id.comment_list_recyclerview);
		 
		 //��ͷ��XMLװ��ΪView
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
	 * ��ʼ����Ƭ����ҳ�����Ŀ�Ƭ
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
	 * ���������б��е����ݣ����Ž�ArrayList��
	 */
	public void  loadCommentItems(){
		//Ԥ�����5��
    	for(int i=0 ; i<5; i++){
    		Comment_Item item = new Comment_Item();
    		item.setCommentUserIcon(R.drawable.card_user_icon);
    		item.setCommentUserName("����ҹ����̨ɹ����");
    		item.setCommentUserUniversity("�й�ҽ�ƴ�����ѧ");
    		item.setCommentPostTime("2015-03-02");
    		item.setCommentContent("�ҳ������˲�������¾Ͳ��ѧ�ˣ�ȥ�����򹤣������ǰѼ�����ɸ���ѧ���������±��˲�Ҫ�ң�����Ϊ��ִ�ţ�Ϊ��������̰�ڴ�ʮ�꣡����ʮ�꣬����һ���˹���ȥ�������߹������ഺ��");
    		comment_list_items.add(item);
    		}
		
	}
	
	/**
	 * �������б��е�����װ�ص�RecyclerView�У�����ʾ����
	 */
	public void  setCommentRecyclerView(){
		
		 //Ĭ�϶���Ч��
		comment_list_recyclerview.setItemAnimator(new DefaultItemAnimator());
        //���ò��ֹ�����������������Ϊ�Ƿ����򲼾�
		linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
		comment_list_recyclerview.setLayoutManager(linearLayoutManager);
        //�������Ч��
		comment_list_recyclerview.setHasFixedSize(true);
		
		//�½�������
        adapter = new CommentListAdapter(CardDetailPageActivity.this);
        adapter.addDatas(comment_list_items);
        //����ͷ��
        adapter.setHeaderView(card_detail_page_head); 
        
        //����������
        comment_list_recyclerview.setAdapter(adapter);

	}
	

}
