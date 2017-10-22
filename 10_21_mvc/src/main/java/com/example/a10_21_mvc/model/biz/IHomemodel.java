package com.example.a10_21_mvc.model.biz;

import com.example.a10_21_mvc.model.net.callback.INetworkCallback;

/**
 * Created by Administrator on 2017/10/22.
 */

public interface IHomemodel {
    //获取首页的数据
    void loadHomeList(String key, int pno, INetworkCallback callback);
}
