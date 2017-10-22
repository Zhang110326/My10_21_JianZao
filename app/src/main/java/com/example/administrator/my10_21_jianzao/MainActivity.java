package com.example.administrator.my10_21_jianzao;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.example.administrator.my10_21_jianzao.fragment.HomeFragment;
import com.example.administrator.my10_21_jianzao.fragment.MyFragment;
import com.example.administrator.my10_21_jianzao.fragment.VedioFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private Button button_tongzhi;
    private FrameLayout flayout;
    private Button shouye;
    private Button shipin;
    private Button my;
    private LinearLayout linLayout;
    private HomeFragment homeFragment;
    private MyFragment myFragment;
    private VedioFragment vedioFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initFragment();

    }

    private void initFragment() {
        homeFragment = new HomeFragment();
        myFragment = new MyFragment();
        vedioFragment = new VedioFragment();
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.flayout,homeFragment);
        fragmentTransaction.add(R.id.flayout,myFragment);
        fragmentTransaction.add(R.id.flayout,vedioFragment);
        fragmentTransaction.show(homeFragment);
        fragmentTransaction.hide(myFragment);
        fragmentTransaction.hide(vedioFragment);
        fragmentTransaction.commit();
    }

    private void initView() {
        button_tongzhi = (Button) findViewById(R.id.button_tongzhi);
        flayout = (FrameLayout) findViewById(R.id.flayout);
        shouye = (Button) findViewById(R.id.shouye);
        shipin = (Button) findViewById(R.id.shipin);
        my = (Button) findViewById(R.id.my);
        linLayout = (LinearLayout) findViewById(R.id.linLayout);

        button_tongzhi.setOnClickListener(this);
        shouye.setOnClickListener(this);
        shipin.setOnClickListener(this);
        my.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = supportFragmentManager.beginTransaction();
        switch (v.getId()) {
            case R.id.button_tongzhi:
                ObservableMagener.getInstance().notify("哥们，我通知新内容了");
                break;
            case R.id.shouye:
                 transaction.hide(myFragment);
                transaction.hide(vedioFragment);
                transaction.show(homeFragment);

                break;
            case R.id.shipin:
                transaction.hide(myFragment);
                transaction.show(vedioFragment);
                transaction.hide(homeFragment);
                break;
            case R.id.my:
                transaction.show(myFragment);
                transaction.hide(vedioFragment);
                transaction.hide(homeFragment);
                break;
        }
        transaction.commit();
    }
}
