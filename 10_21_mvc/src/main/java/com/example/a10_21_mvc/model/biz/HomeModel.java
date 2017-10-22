package com.example.a10_21_mvc.model.biz;

import com.example.a10_21_mvc.config.Urls;
import com.example.a10_21_mvc.model.net.OkHttpUtils;
import com.example.a10_21_mvc.model.net.callback.INetworkCallback;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/10/22.
 */

public class HomeModel implements  IHomemodel {
    @Override
    public void loadHomeList(String key, int pno, INetworkCallback callback) {
        Map<String,String> params=new HashMap<>();
        params.put("key",key);
        params.put("pno",pno+"");
        OkHttpUtils.getInstance().get(Urls.HOMELIST,params,callback);
    }
}
