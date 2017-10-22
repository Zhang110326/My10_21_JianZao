package com.example.a10_21_mvc.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Administrator on 2017/10/21.
 */

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        init();
        loadData();
    }

    //用于加载activity布局
    protected  abstract  int getLayoutId();
    //统一的数据化操作
    protected abstract void init();
    //统一的数据加载
    protected abstract  void loadData();

}
