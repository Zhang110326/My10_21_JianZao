package com.example.administrator.my10_21_jianzao.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.my10_21_jianzao.ObservableMagener;
import com.example.administrator.my10_21_jianzao.Observer;
import com.example.administrator.my10_21_jianzao.R;

/**
 * Created by Administrator on 2017/10/21.
 */

public class HomeFragment extends Fragment implements Observer {
    private TextView view_shou;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.shouye_item, container, false);
        initView(view);
        ObservableMagener.getInstance().addwacher(this);
        return view;
    }

    @Override
    public void updata(String content) {
        view_shou.setText(content);

    }

    private void initView(View view) {
        view_shou = (TextView) view.findViewById(R.id.view_shou);
    }
}
