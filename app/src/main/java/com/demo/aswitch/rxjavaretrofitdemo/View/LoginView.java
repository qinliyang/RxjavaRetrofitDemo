package com.demo.aswitch.rxjavaretrofitdemo.View;

import com.demo.aswitch.rxjavaretrofitdemo.Molde.LoginResponseBean;

/**
 * Created by Qin_Li_Yang on 2018/6/8.
 */

public interface LoginView extends Mvp_View {
    void onSuccess(LoginResponseBean loginResponseBean);
    void onFailed();
}
