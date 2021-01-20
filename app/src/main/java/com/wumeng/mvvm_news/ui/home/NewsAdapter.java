package com.wumeng.mvvm_news.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.wumeng.mvvm_news.R;
import com.wumeng.mvvm_news.bean.NewsBean;
import com.wumeng.mvvm_news.databinding.ItemNewsBinding;

import java.util.List;

/**
 * @author WuMeng
 * @date 2021/1/4
 * desc:
 */
public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolderItemNews> {

    private Context mContext;

    private List<NewsBean.ResultBean.DataBean> dataBeans;

    public NewsAdapter(Context mContext, List<NewsBean.ResultBean.DataBean> dataBeans) {
        this.mContext = mContext;
        this.dataBeans = dataBeans;
    }

    @NonNull
    @Override
    public ViewHolderItemNews onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemNewsBinding itemNewsBinding = DataBindingUtil.inflate(LayoutInflater.from(mContext),R.layout.item_news,
                parent,false);
        ViewHolderItemNews viewHolderItemNews = new ViewHolderItemNews(itemNewsBinding);
        return viewHolderItemNews;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderItemNews holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    static class ViewHolderItemNews extends RecyclerView.ViewHolder {

        private ItemNewsBinding itemNewsBinding;

        public ViewHolderItemNews(ItemNewsBinding itemNewsBinding) {
            super(itemNewsBinding.getRoot());
            this.itemNewsBinding = itemNewsBinding;
        }
        
    }

}
