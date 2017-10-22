package com.example.administrator.my10_21_jianzao;

/**
 * Created by Administrator on 2017/10/21.
 * 被观察者
 */

public interface Observable {
    //添加
    void  addwacher(Observer observer);
    //移除
    void  remover(Observer observer);
    //更新信息
    void  notify(String content);
}
