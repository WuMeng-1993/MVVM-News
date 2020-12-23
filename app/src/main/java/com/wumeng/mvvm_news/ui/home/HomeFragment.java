package com.wumeng.mvvm_news.ui.home;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mHomeViewModel = new ViewModelProvider(this,new HomeViewModelFactory(appKey)).get(HomeViewModel.class);
        root = inflater.inflate(R.layout.fragment_home, container, false);
        initView();

        mHomeViewModel.getNews("top");
        mHomeViewModel.newsBean.observe(getActivity(), new Observer<NewsBean>() {
            @Override
            public void onChanged(NewsBean newsBean) {

            }
        });
        return root;
    }

    private void initView() {
    }

}