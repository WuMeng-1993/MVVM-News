package com.wumeng.mvvm_news.ui.home;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wumeng.mvvm_news.R;
import com.wumeng.mvvm_news.bean.NewsBean;

/**
 * @author WuMeng
 */
public class HomeFragment extends Fragment {

    private HomeViewModel mHomeViewModel;

    private View root;

    private String appKey = "04ea095cbea56775e2d1669713f34cc2";

    private RecyclerView mRecyclerView;

    private RecyclerView.LayoutManager mLayoutManager;

    private NewsAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mHomeViewModel = new ViewModelProvider(this, new HomeViewModelFactory(appKey)).get(HomeViewModel.class);
        root = inflater.inflate(R.layout.fragment_home, container, false);
        initView();

        mHomeViewModel.getNews("top");
        if (getActivity() != null) {
            mHomeViewModel.newsBean.observe(getActivity(), new Observer<NewsBean>() {
                @Override
                public void onChanged(NewsBean newsBean) {
                    if (newsBean != null && newsBean.getError_code() == 0) {
                        mAdapter = new NewsAdapter(getContext(),newsBean.getResult().getData());
                        mRecyclerView.setAdapter(mAdapter);
                    }
                }
            });
        }
        return root;
    }

    /**
     * 初始化视图
     */
    private void initView() {
        mRecyclerView = root.findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);
    }

}