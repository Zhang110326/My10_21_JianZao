package com.example.a10_21_mvc.model.net;

import android.widget.ImageView;

import com.example.a10_21_mvc.model.net.callback.INetworkCallback;

import java.io.File;
import java.util.Map;

/**
 * Created by Administrator on 2017/10/22.
 */

public interface Ihttp {
    /**
     * 发送get请求
     * @param url   接口地址
     * @param parmes   传递的参数
     * @param callback  接口回调
     */
    void get(String url, Map<String,String>parmes, INetworkCallback callback);

    /**
     * 发送get无参请求
     * @param url   接口地址
     * @param callback   接口回调
     */
    void get(String url,INetworkCallback callback);

    /**
     * 发送post请求
     * @param url  接口地址
     * @param parmes  传递的参数
     * @param callback 接口回调
     */
    void post(String url,Map<String,String>parmes,INetworkCallback callback);

    /**
     * 发送post无参请求
     * @param url  接口地址
     * @param callback  接口回调
     */
    void post(String url,INetworkCallback callback);

    /**
     * 文件上传的无参方法
     * @param url  上传的接口地址
     * @param callback  回调方法
     * @param files  要上传的文件
     */
    void upLoadFile(String url, INetworkCallback callback, File... files);

    /**
     * 文件上传的方法
     * @param url  上传的接口地址
     * @param callback 回调放法
     * @param parmes  参数类型
     * @param files  要上传的文件
     */
    void upLoadFile(String url,INetworkCallback callback,Map<String,String>parmes,File... files);

    /**
     * 文件下载的方法
     * @param url  接口地址
     * @param savePath  保存路径
     * @param callback 接口回调
     */
    void downloadFile(String url,String savePath,INetworkCallback callback);

    /**
     * 加载图片的方法
     * @param imgurl   图片接口地址
     * @param imageView 加载图片
     */
    void loadImage(String imgurl, ImageView imageView);

}
