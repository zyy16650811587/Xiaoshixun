package com.example.mvpchouqu5;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.Toast;

import com.example.mvpchouqu5.adapter.RcyAdapter;
import com.example.mvpchouqu5.base.BaseActivi;
import com.example.mvpchouqu5.bean.Bean;
import com.example.mvpchouqu5.bean.EvntenMsg;
import com.example.mvpchouqu5.presenter.MainPresenter;
import com.example.mvpchouqu5.view.MainView;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivi<MainPresenter> implements MainView {

    @BindView(R.id.tb)
    Toolbar tb;
    @BindView(R.id.rcy)
    RecyclerView rcy;
    private ArrayList<Bean.DataBean.DatasBean> list;
    private RcyAdapter rcyAdapter;

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        ButterKnife.bind(this);
//    }

    @Override
    protected void initLiseener() {
        list = new ArrayList<>();
        rcyAdapter = new RcyAdapter(list, this);
        rcy.setAdapter(rcyAdapter);
        rcyAdapter.setOnItemlisten(new RcyAdapter.OnItemlisten() {
            @Override
            public void click(int position) {
                Bean.DataBean.DatasBean bean = list.get(position);
                String link = bean.getLink();
                EvntenMsg evntenMsg = new EvntenMsg();
                evntenMsg.setMsg(link);
                EventBus.getDefault().postSticky(evntenMsg);
                Intent intent = new Intent(MainActivity.this, WebActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void initData() {
        mPresenter.wanluo();
    }

    @Override
    protected void initView() {
            setSupportActionBar(tb);
            rcy.setLayoutManager(new LinearLayoutManager(this));
            rcy.addItemDecoration(new DividerItemDecoration(this,LinearLayoutManager.VERTICAL));


    }

    @Override
    protected void initPresent() {
        mPresenter = new MainPresenter();
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void setData(List<Bean.DataBean.DatasBean> beans) {
        list.addAll(beans);
        rcyAdapter.notifyDataSetChanged();
    }

    @Override
    public void showToast(String string) {
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show();
    }
}
