package com.example.mvpchouqu;

import android.os.Bundle;

import com.example.mvpchouqu.base.BasePresenter;
import com.example.mvpchouqu.base.BaseView;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements BaseView {
   public P mpresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        ButterKnife.bind(this);
        initPresenter();
        if(mpresenter==null){
            mpresenter.bindview(this);
        }
        initview();
        initData();
        initlister();
    }
    public abstract int getLayout();
    public abstract void initPresenter();
    public abstract void initview();
    public abstract void initData();
    public abstract  void  initlister();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mpresenter!=null){
            mpresenter.destroy();
            mpresenter=null;
        }
    }
}
