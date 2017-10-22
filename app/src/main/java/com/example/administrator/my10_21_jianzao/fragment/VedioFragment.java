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

public class VedioFragment extends Fragment implements Observer {


    private TextView vedio_view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.vedio_item, container, false);
        initView(inflate);
        ObservableMagener.getInstance().addwacher(this);
        return inflate;
    }

    @Override
    public void updata(String content) {
         vedio_view.setText(content);
    }

    private void initView(View inflate) {
        vedio_view = (TextView) inflate.findViewById(R.id.vedio_view);
    }
}
