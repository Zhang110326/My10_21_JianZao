package com.example.a10_21_mvc.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2017/10/21.
 */

public  abstract class BaseFragment extends Fragment  {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        init();
        loadData();
    }
    //用于加载activity布局
    protected  abstract  int getLayoutId();

    //统一的数据化操作
    protected abstract void init();
    //统一的数据加载
    protected abstract  void loadData();

    @Override
    public void onResume() {
        super.onResume();
    }

    //当fragment显示，隐藏时会被调用
    //hidden当fragment隐藏时为true
    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (hidden){

        }else {

        }

    }
    //当fragment显示时调用
    protected abstract void show();
    //当fragment不可见时调用
    protected  abstract void hidden();
}
