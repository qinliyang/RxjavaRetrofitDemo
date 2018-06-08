package com.demo.aswitch.rxjavaretrofitdemo.ApiNet;

import com.demo.aswitch.rxjavaretrofitdemo.Molde.BaseResponse;
import com.demo.aswitch.rxjavaretrofitdemo.Molde.LoginResponseBean;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by Qin_Li_Yang on 2018/6/8.
 */
public interface LoginService{
    @FormUrlEncoded
    @POST("api.php?m=users&a=login")
    Observable<BaseResponse<LoginResponseBean>>
    login(@Field("phone") String username, @Field("password") String password);
}
