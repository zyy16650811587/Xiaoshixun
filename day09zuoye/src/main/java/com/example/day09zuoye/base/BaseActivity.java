package com.example.day09zuoye.base;

import android.os.Bundle;

import com.example.day09zuoye.R;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements BaseView{
public P mPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initLayout());
        initPresenter();
        ButterKnife.bind(this);
        if(mPresenter !=null){
            mPresenter.bindView(this);
        }
        initView();
        initData();
        initListener();
    }

    protected abstract void initListener();

    protected abstract void initData();

    protected abstract int initLayout();

    protected abstract void initView();

    protected abstract void initPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mPresenter !=null){
            mPresenter.dispose();
            mPresenter=null;
        }
    }
}
