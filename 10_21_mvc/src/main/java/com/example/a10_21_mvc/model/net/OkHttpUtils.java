package com.example.a10_21_mvc.model.net;

import android.widget.ImageView;

import com.example.a10_21_mvc.model.net.callback.INetworkCallback;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2017/10/22.
 */

public class OkHttpUtils implements Ihttp {
    private OkHttpClient okHttpClient;
    //第一步提供私有化构造方法
    private OkHttpUtils(){
        okHttpClient=new OkHttpClient.Builder().build();

    }
    //第二步提供 静态的，私有的，对象的变量
    private static OkHttpUtils okHttpUtils;
     //第三步提供 公共的静态方法 返回值是当前的类对象
    public static OkHttpUtils getInstance(){
        if (okHttpUtils==null) {
            synchronized (OkHttpUtils.class) {
                if (okHttpUtils == null)
                    okHttpUtils = new OkHttpUtils();
            }
        }
        return okHttpUtils;
    }
    @Override
    public void get(String url, Map<String, String> parmes, final INetworkCallback callback) {
//        //第一步创建okHttpClient对象
//        OkHttpClient  okHttpClient=new OkHttpClient.Builder().build();
        if (parmes!=null&&parmes.size()>0){
            //得到所有key
            Set<String> strings = parmes.keySet();
            StringBuffer sb=new StringBuffer(url);
            sb.append("?");
            //便利所有key
             for (String s:strings){
                 //获取value值
                 String value = parmes.get(s);
                 sb.append(s).append("=").append(value).append("&");
             }
                 url=sb.substring(0,sb.length()-1);
        }
        //第二步创建Request对象
        final Request request=new Request.Builder().url(url).build();
        //第三步发送网络请求 同步或者异步
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                 callback.onerr(e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
               callback.success(string);
            }
        });

    }

    @Override
    public void get(String url, INetworkCallback callback) {

    }

    @Override
    public void post(String url, Map<String, String> parmes, INetworkCallback callback) {

    }

    @Override
    public void post(String url, INetworkCallback callback) {

    }

    @Override
    public void upLoadFile(String url, INetworkCallback callback, File... files) {

    }

    @Override
    public void upLoadFile(String url, INetworkCallback callback, Map<String, String> parmes, File... files) {

    }

    @Override
    public void downloadFile(String url, String savePath, INetworkCallback callback) {

    }

    @Override
    public void loadImage(String imgurl, ImageView imageView) {

    }
}
