package com.wumeng.mvvm_news.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.wumeng.mvvm_news.bean.NewsBean;
import com.wumeng.mvvm_news.http.ApiServices;
import com.wumeng.mvvm_news.http.RetrofitServiceBuilder;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * @author WuMeng
 * @date 2020/12/24
 * desc:
 */
public class NewsRepository {

    public MutableLiveData<NewsBean> getNews(String type,String appKey) {

        MutableLiveData<NewsBean> mutableLiveData = new MutableLiveData<>();

        ApiServices apiServices = RetrofitServiceBuilder.createService(ApiServices.class);
        apiServices.getNews(type, appKey)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<NewsBean>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull NewsBean newsBean) {
                        Log.d("HomeFragment","onNext");
                        mutableLiveData.setValue(newsBean);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.d("HomeFragment","onError");
                    }

                    @Override
                    public void onComplete() {

                    }
                });

        return mutableLiveData;
    }

}
