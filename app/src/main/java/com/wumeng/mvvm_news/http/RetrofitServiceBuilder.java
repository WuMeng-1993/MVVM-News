package com.wumeng.mvvm_news.http;

import com.wumeng.mvvm_news.config.HttpConfig;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author WuMeng
 * @date 2020/12/28
 * desc:
 */
public class RetrofitServiceBuilder {

    public static <T> T createService(final Class<T> clazz) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(HttpConfig.BASE_API)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return (T) retrofit.create(clazz);

    }

}
