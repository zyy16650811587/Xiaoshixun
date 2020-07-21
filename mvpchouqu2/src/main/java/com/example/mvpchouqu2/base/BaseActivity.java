package com.example.mvpchouqu2.base;

import android.os.Bundle;

import com.example.mvpchouqu2.R;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;

public  abstract class BaseActivity <P extends BasePresenter> extends AppCompatActivity implements BaseView{
    public  P mpresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initLayout());
        ButterKnife.bind(this);
        mpresenter = initPresenter();
        if(mpresenter!=null){
            mpresenter.bingView(this);
        }
        initView();
        initData();
        initLister();
    }
    public abstract int initLayout();
    public abstract P initPresenter();
    public abstract void initData();
    public abstract void initView();
    public abstract void initLister();


}
