package com.lee.floater.adapters;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by lee on 2016/3/1.
 */
public abstract class BaseRecyclerAdapter<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
	
    public static final int TYPE_HEADER = 0;
    public static final int TYPE_NORMAL = 1; //顶部HeaderView
    private static final int TYPE_FOOTER = 2;  //底部FooterView

    private ArrayList<T> mDatas = new ArrayList<>();

    private View mHeaderView;
    private View mFooterView;

    private OnItemClickListener mListener;

    public void setOnItemClickListener(OnItemClickListener li) {
        mListener = li;
    }

    public void setHeaderView(View headerView) {
        mHeaderView = headerView;
        notifyItemInserted(0);
    }
    public void setFooterView(View footerView){
    	mFooterView = footerView;
    	notifyItemInserted(mDatas.size()-1);
    }

    public View getHeaderView() {
        return mHeaderView;
    }
    
    public View getFooterView(){
    	return mFooterView;
    }

    public void addDatas(ArrayList<T> datas) {
        mDatas.addAll(datas);
        notifyDataSetChanged();
    }
    
    //下拉刷新的时候调用这个方法
    public void refreshPullDown(ArrayList<T> newDatas){
    	if(mHeaderView == null){
    		notifyItemRangeInserted(0, newDatas.size());
    		mDatas.addAll(0, newDatas);
    		notifyItemRangeChanged(0, mDatas.size());
    	}
    	
    	if(mHeaderView != null){
    		notifyItemRangeInserted(1, newDatas.size());
    		mDatas.addAll(0, newDatas);
    		notifyItemRangeChanged(1, mDatas.size());
    	}
    	
    }
    
    //上拉加载更多的时候调用这个方法
    public void refreshPushUp(ArrayList<T> newDatas){
    	int currentLastPosition = mDatas.size()+1;
    	notifyItemRangeInserted(currentLastPosition, newDatas.size());
		mDatas.addAll(newDatas);
		notifyItemRangeChanged(currentLastPosition, newDatas.size());
    }

    @Override
    public int getItemViewType(int position) {
        if((mHeaderView == null)&&(mFooterView == null)) return TYPE_NORMAL;
        if((mHeaderView != null)&&(position == 0)) return TYPE_HEADER;
        if((mFooterView != null)&&(position + 1 == getItemCount()) )
        	return TYPE_FOOTER;
        return TYPE_NORMAL;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, final int viewType) {
        if(mHeaderView != null && viewType == TYPE_HEADER) return new Holder(mHeaderView);
        if(mFooterView !=null && viewType==TYPE_FOOTER)  return new Holder(mFooterView);
        return onCreate(parent, viewType);
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        if(getItemViewType(position) == TYPE_HEADER) return;
        if(getItemViewType(position) == TYPE_FOOTER) return;

        final int pos = getRealPosition(viewHolder);
        final T data = mDatas.get(pos);
        onBind(viewHolder, pos, data);

        if(mListener != null) {
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onItemClick(pos, data);
                }
            });
        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);

        RecyclerView.LayoutManager manager = recyclerView.getLayoutManager();
        if(manager instanceof GridLayoutManager) {
            final GridLayoutManager gridManager = ((GridLayoutManager) manager);
            gridManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    return getItemViewType(position) == TYPE_HEADER
                            ? gridManager.getSpanCount() : 1;
                }
            });
        }
    }

    @Override
    public void onViewAttachedToWindow(RecyclerView.ViewHolder holder) {
        super.onViewAttachedToWindow(holder);
        ViewGroup.LayoutParams lp = holder.itemView.getLayoutParams();
        if(lp != null
                && lp instanceof StaggeredGridLayoutManager.LayoutParams
                && holder.getLayoutPosition() == 0) {
            StaggeredGridLayoutManager.LayoutParams p = (StaggeredGridLayoutManager.LayoutParams) lp;
            p.setFullSpan(true);
        }
    }

    public int getRealPosition(RecyclerView.ViewHolder holder) {
        int position = holder.getLayoutPosition();
        return mHeaderView == null ? position : position - 1;
    }

    @Override
    public int getItemCount() {
    	if((mHeaderView==null) && (mFooterView==null)) 
    		return mDatas.size();
    	else if((mHeaderView != null ) && (mFooterView != null)) 
    		return mDatas.size()+2;
    	else return mDatas.size()+1;
    }
    

    public abstract RecyclerView.ViewHolder onCreate(ViewGroup parent, final int viewType);
    public abstract void onBind(RecyclerView.ViewHolder viewHolder, int RealPosition, T data);

    public class Holder extends RecyclerView.ViewHolder {
        public Holder(View itemView) {
            super(itemView);
        }
    }

    public interface OnItemClickListener<T> {
        void onItemClick(int position, T data);
    }
}
