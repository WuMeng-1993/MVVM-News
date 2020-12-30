package com.wumeng.mvvm_news.http;

import com.wumeng.mvvm_news.bean.NewsBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @author WuMeng
 * @date 2020/12/29
 * desc:
 */
public interface ApiServices {

    /**
     * 获取新闻数据
     * @param type 类型
     * @param key
     * @return
     */
    @GET("toutiao/index")
    Observable<NewsBean> getNews(@Query("type") String type,@Query("key") String key);

}
