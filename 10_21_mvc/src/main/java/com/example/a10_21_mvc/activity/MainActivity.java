package com.example.a10_21_mvc.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.a10_21_mvc.R;
import com.example.a10_21_mvc.adapter.HomeAdapter;
import com.example.a10_21_mvc.base.BaseActivity;
import com.example.a10_21_mvc.model.biz.HomeModel;
import com.example.a10_21_mvc.model.biz.IHomemodel;
import com.example.a10_21_mvc.model.entiy.HomeData;
import com.example.a10_21_mvc.model.net.callback.INetworkCallback;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

   private List<HomeData.ResultBean.ListBean> arr;
    private ListView listview;
    private HomeAdapter homeAdapter;
    private IHomemodel iHomemodel;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void init() {
        iHomemodel=new HomeModel();
        arr=new ArrayList<>();
        homeAdapter=new HomeAdapter(this,arr);
        listview= (ListView) findViewById(R.id.listview);
        listview.setAdapter(homeAdapter);

    }

    @Override
    protected void loadData() {
        //http://v.juhe.cn/weixin/query?key=a332c6b34264527ac142764eaed9364d&pno=1
        iHomemodel.loadHomeList("a332c6b34264527ac142764eaed9364d", 1, new INetworkCallback() {
            @Override
            public void success(String jsonData) {
                Log.e("MainActivity",jsonData);
                Gson gson=new Gson();
                HomeData homeData = gson.fromJson(jsonData, HomeData.class);
                arr.addAll(homeData.getResult().getList());
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                     homeAdapter.notifyDataSetChanged();
                    }
                });

            }

            @Override
            public void onerr(String err) {

            }
        });

    }

}
