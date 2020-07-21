package com.example.mvpchouqu6.base;

import android.os.Bundle;

import com.example.mvpchouqu6.R;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;

public abstract class BaseActivity<P extends Baseprosenter>  extends AppCompatActivity implements BaseView{
    public P mPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initLayout());
        ButterKnife.bind(this);
        initPresenter();
        if(mPresenter !=null){
            mPresenter.BingView(this);
        }
        initView();
        initData();
        initListener();
    }

    protected abstract void initListener();

    protected abstract void initData();

    protected abstract void initView();

    protected abstract void initPresenter();

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
