package com.demo.aswitch.rxjavaretrofitdemo.ApiNet;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Qin_Li_Yang on 2018/6/8.
 */

public class RetrofitManager {

    public Retrofit getmRetrofit() {
        return mRetrofit;
    }

    public Retrofit mRetrofit;

    private RetrofitManager() {
        initRetrofit();
    }

    private void initRetrofit() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder okhttpBuild = new OkHttpClient.Builder();
        okhttpBuild.addInterceptor(httpLoggingInterceptor);
        okhttpBuild.connectTimeout(10000, TimeUnit.MILLISECONDS);
        okhttpBuild.readTimeout(10000, TimeUnit.MILLISECONDS);
        okhttpBuild.writeTimeout(10000, TimeUnit.MILLISECONDS);
        mRetrofit = new Retrofit.Builder()
                .baseUrl("http://114.215.25.65/gywl/")
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .callFactory(okhttpBuild.build())
                .build();

    }

    public <T> T getRetrofitService(Class<T> service) {
        return mRetrofit.create(service);
    }

    private static RetrofitManager retrofitManager = null;

    public static RetrofitManager getRetrofitManagerInstance() {
        if (retrofitManager == null) {
            synchronized (RetrofitManager.class) {
                if (retrofitManager == null)
                    retrofitManager = new RetrofitManager();
            }
        }
        return retrofitManager;
    }


}
