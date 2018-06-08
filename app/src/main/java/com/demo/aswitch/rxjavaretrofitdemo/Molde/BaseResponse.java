package com.demo.aswitch.rxjavaretrofitdemo.Molde;

/**
 * Created by Qin_Li_Yang on 2018/6/8.
 */

public class BaseResponse<T> {
    public int status;
    public String msg;
    public T data;
}
