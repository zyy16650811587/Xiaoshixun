package com.example.mvpchouqu3;

import android.os.Bundle;
import android.widget.Toast;

import com.example.mvpchouqu3.apapter.RcyAdapter;
import com.example.mvpchouqu3.base.BaseActivity;
import com.example.mvpchouqu3.present.MainPresenter;
import com.example.mvpchouqu3.view.MainView;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity<MainPresenter> implements MainView {

    @BindView(R.id.rcy)
    RecyclerView rcy;
    private ArrayList<FuliBean.ResultsBean> resultsBeans;
    private RcyAdapter rcyAdapter;

   /* @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }*/

    @Override
    protected int initLatout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
       mPresenter.jieXi();
    }

    @Override
    protected void initView() {
        rcy.setLayoutManager(new LinearLayoutManager(this));
        rcy.addItemDecoration(new DividerItemDecoration(this,LinearLayoutManager.VERTICAL));
        resultsBeans = new ArrayList<>();
        rcyAdapter = new RcyAdapter(resultsBeans, this);
        rcy.setAdapter(rcyAdapter);
    }

    @Override
    protected void initPrssent() {
    mPresenter= new MainPresenter();
    }

    @Override
    public void setData(List<FuliBean.ResultsBean> beans) {
        resultsBeans.addAll(beans);
        if(resultsBeans !=null)
        rcyAdapter.notifyDataSetChanged();
    }

    @Override
    public void showToast(String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }
}
