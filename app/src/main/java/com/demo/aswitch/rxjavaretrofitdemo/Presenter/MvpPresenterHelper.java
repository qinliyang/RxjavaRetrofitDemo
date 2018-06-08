package com.demo.aswitch.rxjavaretrofitdemo.Presenter;


import com.demo.aswitch.rxjavaretrofitdemo.Molde.BaseBean;
import com.demo.aswitch.rxjavaretrofitdemo.Molde.BaseResponse;
import com.demo.aswitch.rxjavaretrofitdemo.ApiNet.RetrofitManager;
import com.demo.aswitch.rxjavaretrofitdemo.View.Mvp_View;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Qin_Li_Yang on 2016/8.
 */

public class MvpPresenterHelper implements Observer<BaseResponse<? extends BaseBean>> {
    Mvp_View mvp_view;
    RetrofitManager retrofitManager = RetrofitManager.getRetrofitManagerInstance();

    public MvpPresenterHelper(Mvp_View mvp_view) {
        this.mvp_view = mvp_view;
    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onNext(BaseResponse<? extends BaseBean> baseResponse) {

    }

    Observable setSchedulers(Observable observable) {
        return observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
