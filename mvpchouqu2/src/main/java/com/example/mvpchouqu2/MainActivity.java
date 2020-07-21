package com.example.mvpchouqu2;

import android.os.Bundle;
import android.widget.Toast;

import com.example.mvpchouqu2.base.BaseActivity;
import com.example.mvpchouqu2.presenter.MainPresenter;
import com.example.mvpchouqu2.view.MainView;

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
    private ArrayList<Bean.ResultsBean> list;
    private RcyAdapter rcyAdapter;

  /*  @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }*/

    @Override
    public int initLayout() {
        return R.layout.activity_main;
    }

    @Override
    public MainPresenter initPresenter() {
        return new MainPresenter();
    }

    @Override
    public void initData() {
        mpresenter.wanluo();
    }

    @Override
    public void initView() {
        rcy.setLayoutManager(new LinearLayoutManager(this));
        rcy.addItemDecoration(new DividerItemDecoration(this,LinearLayoutManager.VERTICAL));
        list = new ArrayList<>();
        rcyAdapter = new RcyAdapter(list, this);
        rcy.setAdapter(rcyAdapter);


    }

    @Override
    public void initLister() {

    }

    @Override
    public void setData(List<Bean.ResultsBean> beans) {
        list.addAll(beans);
        if(list !=null){
            rcyAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void showToast(String string) {
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show();
    }
}
