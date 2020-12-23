package com.wumeng.mvvm_news.ui.home;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.wumeng.mvvm_news.bean.NewsBean;
import com.wumeng.mvvm_news.repository.NewsRepository;

/**
 * @author WuMeng
 * @date 2020/12/22
 * desc:
 */
class HomeViewModel extends ViewModel {

    private String appKey;

    public HomeViewModel(String appKey) {
        this.appKey = appKey;
    }

    private MutableLiveData<String> newsType = new MutableLiveData<>();

    public void getNews(String type) {
        newsType.setValue(type);
    }

    public LiveData<NewsBean> newsBean = Transformations.switchMap(newsType, new Function<String, LiveData<NewsBean>>() {
        @Override
        public LiveData<NewsBean> apply(String input) {
            return new NewsRepository().getNews(input,appKey);
        }
    });

}
