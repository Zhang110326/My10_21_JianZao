package com.example.administrator.my10_21_jianzao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/10/21.
 * 观察者的管理类
 */

public class ObservableMagener  implements  Observable {
    //单例模式
    private  ObservableMagener (){}
    private static  ObservableMagener observableMagener=new ObservableMagener();
    public static ObservableMagener getInstance(){
        return observableMagener;

    }
    private List<Observer> arr=new ArrayList<>();
    @Override
    public void addwacher(Observer observer) {
    arr.add(observer);

    }

    @Override
    public void remover(Observer observer) {
        arr.remove(observer);

    }

    @Override
    public void notify(String content) {
   for (Observer observer:arr){
       observer.updata(content);
   }

    }
}
