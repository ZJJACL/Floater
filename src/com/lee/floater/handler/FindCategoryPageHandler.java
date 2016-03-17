package com.lee.floater.handler;

import java.util.ArrayList;

import com.lee.floater.R;
import com.lee.floater.adapters.TopicListAdapter;
import com.lee.floater.items.Topic_Item;
import com.lee.floater.listeners.TopicListItemListener;

import android.content.Context;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;


/**
 * 集中处理发现_分类页面中的事物
 */
public class FindCategoryPageHandler {

	Context context;  //将Main传进来
	public View find_category_view;  //分类页面中的主View
    public View find_category_page_head ;//分类页面的头部View索引(搜索框/分类大按钮/全部话题卡条)
    
	public RecyclerView total_topic_list_recyclerView;//全部话题列表的RecyclerView
	
	//全部话题列表中的数据List
    public ArrayList<Topic_Item>total_topic_list_items = new ArrayList<Topic_Item>();
    
    //分类页面中三个筛选按钮以及热区的索引
    ImageView sign_new ;
    ImageView sign_new_notice;
    ImageView sign_hot;
    ImageView sign_hot_notice;
    ImageView sign_update;
    ImageView sign_update_notice;
    
    Button button_sign_new;
    Button button_sign_hot;
    Button button_sign_update;
    
    
    /**
	 * 构造方法中将分类页面View和Main传进来
	 */
	public FindCategoryPageHandler (View find_category_view, Context context){
		this.find_category_view = find_category_view ;
		this.context = context;
		findAllViewById();
	}
	
	/**
	 * 加载分类页中的所有的View索引
	 */
	public void findAllViewById(){
		
		LayoutInflater inflater = LayoutInflater.from(context);
		
		//将分类页面中的头部View装载为View
        find_category_page_head = inflater.inflate(R.layout.find_category_page_head,null);
        
      //加载为全部话题列表编写的RecyclerView
        total_topic_list_recyclerView = 
        		(RecyclerView)find_category_view.findViewById(R.id.total_topic_list_recyclerview);
        
        //加载分类页面中的三个筛选的静态图片和热区按钮
        sign_new = (ImageView)find_category_page_head.findViewById(R.id.sign_new);
        sign_new_notice = (ImageView)find_category_page_head.findViewById(R.id.sign_new_notice);
        sign_hot = (ImageView)find_category_page_head.findViewById(R.id.sign_hot);
        sign_hot_notice = (ImageView)find_category_page_head.findViewById(R.id.sign_hot_notice);
        sign_update = (ImageView)find_category_page_head.findViewById(R.id.sign_update);
        sign_update_notice = (ImageView)find_category_page_head.findViewById(R.id.sign_update_notice);
        
        button_sign_new = (Button)find_category_page_head.findViewById(R.id.button_sign_new);
        button_sign_hot =(Button)find_category_page_head.findViewById(R.id.button_sign_hot);
        button_sign_update =(Button)find_category_page_head.findViewById(R.id.button_sign_update);
        
        //为分类页面中的三个过滤按钮添加点击监听器
        TotalTopicFilterListener filterListener = new TotalTopicFilterListener();
        button_sign_new.setOnClickListener(filterListener);
        button_sign_hot.setOnClickListener(filterListener);
        button_sign_update.setOnClickListener(filterListener);
        
	}
	
	/**
	 * 一下几个方法是当点击三个话题过滤按钮的时候，更改对应的视图，
	 * 暂时没有涉及到全部话题的列表的对应的更新
	 */
	public void setFilterView_New(){
		sign_new.setVisibility(View.INVISIBLE);
	    sign_new_notice.setVisibility(View.VISIBLE);
	    sign_hot.setVisibility(View.VISIBLE);
	    sign_hot_notice.setVisibility(View.INVISIBLE);
	    sign_update.setVisibility(View.VISIBLE);
	    sign_update_notice.setVisibility(View.INVISIBLE);
	}
	public void setFilterView_Hot(){
		sign_new.setVisibility(View.VISIBLE);
	    sign_new_notice.setVisibility(View.INVISIBLE);
	    sign_hot.setVisibility(View.INVISIBLE);
	    sign_hot_notice.setVisibility(View.VISIBLE);
	    sign_update.setVisibility(View.VISIBLE);
	    sign_update_notice.setVisibility(View.INVISIBLE);
	}
	public void setFilterView_Update(){
		sign_new.setVisibility(View.VISIBLE);
	    sign_new_notice.setVisibility(View.INVISIBLE);
	    sign_hot.setVisibility(View.VISIBLE);
	    sign_hot_notice.setVisibility(View.INVISIBLE);
	    sign_update.setVisibility(View.INVISIBLE);
	    sign_update_notice.setVisibility(View.VISIBLE);
	}
	
	
	/**
	 *创建分类页面中的三个过滤按钮的点击监听器
	 */
	class TotalTopicFilterListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			if(v.getId()==R.id.button_sign_new) setFilterView_New();
			if(v.getId()==R.id.button_sign_hot) setFilterView_Hot();
			if(v.getId()==R.id.button_sign_update) setFilterView_Update();
		}
	}
	
	/**
	 * 推荐页面中的数据加载、显示、刷新等所有事务的中继器
	 */
	public void Handle (){
		
		//对分类页面进行初始化，也就是开始默认选中的是最新
        setFilterView_New();
        
        //加载全部话题列表中的数据
        loadTotalTopicItems();
        
        //将全部话题话题中的数据装载到RecyclerView中
        setTotalTopicRecyclerView();
	}
	
	/**
	  * 加载全部话题列表中的数据
	  * 实际中应该新开辟一条线程进行数据的加载
	  */
   public void loadTotalTopicItems(){
   	//预设加载10条
   	for(int i=0 ; i<10; i++){
   		Topic_Item item = new Topic_Item();
   		item.setTopicIcon(R.drawable.list_topic_icon);
   		item.setTopicTitle("校园中那些自带技能的B");
   		item.setTopicContentNumber(1024);
   		item.setTopicCategory(R.drawable.list_topic_category_picture);
		    total_topic_list_items.add(item);
   	}    	
   	
   }
   
   
   /**
    * 将全部话题话题中的数据装载到RecyclerView中
    */
   public void setTotalTopicRecyclerView(){

       //默认动画效果
   	total_topic_list_recyclerView.setItemAnimator(new DefaultItemAnimator());
       //设置布局管理器，第三个参数为是否逆向布局
   	total_topic_list_recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
       //可以提高效率
   	total_topic_list_recyclerView.setHasFixedSize(true);
		//新建适配器
       TopicListAdapter adapter = new TopicListAdapter();
     //设置适配器
       total_topic_list_recyclerView.setAdapter(adapter);
       adapter.addDatas(total_topic_list_items);
       
       //加载头部
       adapter.setHeaderView(find_category_page_head);
       
       //设置监听器,当点击话题列表中的某一项的时候回调
       adapter.setOnItemClickListener(new TopicListItemListener(context));
   }
	

}
