package com.wumeng.mvvm_news.repository;

import androidx.lifecycle.MutableLiveData;

import com.wumeng.mvvm_news.bean.NewsBean;

/**
 * @author WuMeng
 * @date 2020/12/24
 * desc:
 */
public class NewsRepository {

    public MutableLiveData<NewsBean> getNews(String type,String appKey) {
        MutableLiveData<NewsBean> mutableLiveData = new MutableLiveData<>();
        return mutableLiveData;
    }

}
