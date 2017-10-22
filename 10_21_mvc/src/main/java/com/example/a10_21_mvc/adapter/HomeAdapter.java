package com.example.a10_21_mvc.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.a10_21_mvc.R;
import com.example.a10_21_mvc.model.entiy.HomeData;

import java.util.List;

/**
 * Created by Administrator on 2017/10/22.
 */


public class HomeAdapter extends BaseAdapter {
    private List<HomeData.ResultBean.ListBean> arr;
    private  Context content;

    public HomeAdapter(Context context, List<HomeData.ResultBean.ListBean> arr) {
        this.arr = arr;
          this.content=context;

    }

    @Override
    public int getCount() {
        return arr.size();
    }

    @Override
    public Object getItem(int i) {
        return arr.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
      ViewHolder holder;
        if (view == null) {
             view = LayoutInflater.from(content).inflate(R.layout.home_list_item, null);
            holder=new ViewHolder(view);
            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }
        holder.textview.setText(arr.get(i).getTitle());
//        Glide.with(content).load(i).placeholder(R.mipmap.ic_launcher).into(holder.img);
        Glide.with(content).load(arr.get(i).getFirstImg()).into(holder.img);


        return view;
    }

    public static class ViewHolder {
        public View rootView;
        public ImageView img;
        public TextView textview;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.img = (ImageView) rootView.findViewById(R.id.img);
            this.textview = (TextView) rootView.findViewById(R.id.textview);
        }

    }
}
