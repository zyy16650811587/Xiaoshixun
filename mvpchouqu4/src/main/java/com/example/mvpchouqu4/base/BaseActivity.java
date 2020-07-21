package com.example.mvpchouqu4.base;

import android.os.Bundle;

import com.example.mvpchouqu4.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public abstract class BaseActivity<P extends Basepresenter> extends AppCompatActivity implements BaseView {
    public P mPresent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initLayout());
        ButterKnife.bind(this);
        initPresent();
        if(mPresent !=null){
            mPresent.bingview(this);
        }
        initView();
        initData();
        initListener();
    }

    protected abstract void initListener();

    protected abstract void initData();

    protected abstract void initView();

    protected abstract int initLayout();

    protected abstract void initPresent();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mPresent !=null){
            mPresent.dispose();
            mPresent=null;
        }
    }
}
