package com.example.mvpchouqu3.base;

import android.os.Bundle;

import com.example.mvpchouqu3.R;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;

public abstract class BaseActivity <P extends BasePresent> extends AppCompatActivity implements BaseView{
    public P mPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initLatout());
        ButterKnife.bind(this);
        initPrssent();
        if(mPresenter !=null){
            mPresenter.bingView(this);
        }
        initLatout();
        initView();
        initData();
        initListener();

    }

    protected abstract int initLatout();

    protected abstract void initListener();

    protected abstract void initData();

    protected abstract void initView();

    protected abstract void initPrssent();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mPresenter !=null){
        mPresenter.remove();
        mPresenter=null;
        }
    }
}
