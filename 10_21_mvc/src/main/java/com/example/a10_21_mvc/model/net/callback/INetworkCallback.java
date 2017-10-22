package com.example.a10_21_mvc.model.net.callback;

/**
 * Created by Administrator on 2017/10/22.
 */

public interface INetworkCallback {
    //网络请求的回调方法
    //jsondata服务器返回的数据
    void success(String jsonData);
    //网络请求失败的回调方法
    //err返回错误信息
    void onerr(String err);
}
