package com.example.mvpchouqu5.base;

import android.os.Bundle;

import com.example.mvpchouqu5.R;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;

public  abstract class BaseActivi<P extends BasePresent> extends AppCompatActivity implements BaseView{
    public P mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initLayout());
        ButterKnife.bind(this);
        initPresent();
        if(mPresenter !=null){
           mPresenter.bingView(this);
        }
        initView();
        initData();
        initLiseener();
    }

    protected abstract void initLiseener();

    protected abstract void initData();

    protected abstract void initView();

    protected abstract void initPresent();

    protected abstract int initLayout();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mPresenter !=null){
            mPresenter.dispose();
            mPresenter=null;
        }
    }
}
