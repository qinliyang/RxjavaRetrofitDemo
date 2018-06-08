package com.demo.aswitch.rxjavaretrofitdemo.Presenter;

import android.util.Log;

import com.demo.aswitch.rxjavaretrofitdemo.Molde.BaseBean;
import com.demo.aswitch.rxjavaretrofitdemo.Molde.BaseResponse;
import com.demo.aswitch.rxjavaretrofitdemo.Molde.LoginResponseBean;
import com.demo.aswitch.rxjavaretrofitdemo.ApiNet.LoginService;
import com.demo.aswitch.rxjavaretrofitdemo.View.LoginView;

/**
 * Created by Qin_Li_Yang on 2018/6/8.
 */

public class LoginHelper extends MvpPresenterHelper {
    LoginView mloginView = null;

    public LoginHelper(LoginView loginView) {
        super(loginView);
        this.mloginView = loginView;
    }

    public void requestLogin(String username, String password) {
        LoginService retrofitService = retrofitManager.getRetrofitService(LoginService.class);
        setSchedulers(retrofitService.login(username, password)).subscribe(this);
    }

    @Override
    public void onNext(BaseResponse<? extends BaseBean> baseResponse) {

        Log.e("LOG", baseResponse.msg);
        if (baseResponse.status == 1) {
            LoginResponseBean loginResponseBean = (LoginResponseBean) baseResponse.data;
            mloginView.onSuccess(loginResponseBean);
        }
    }

    @Override
    public void onCompleted() {
        super.onCompleted();
    }

    @Override
    public void onError(Throwable e) {
        mloginView.onFailed();
    }
}
