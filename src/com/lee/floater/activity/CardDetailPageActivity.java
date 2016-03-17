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
 * ��Ƭ����ҳ
 */
public class CardDetailPageActivity extends Activity {
	
		//��Ƭ����ҳ���������б��RecyclerView
		public RecyclerView comment_list_recyclerview;
		
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
   
        comment_list_recyclerview = ( RecyclerView )findViewById(R.id.comment_list_recyclerview);
        
        //���������б��ArrayList����
        loadCommentItems();
        
        //�������б��е�����װ�ص�RecyclerView�У�����ʾ����
        setCommentRecyclerView();
        
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
         
        //����������
        comment_list_recyclerview.setAdapter(adapter);

	}
	

}
