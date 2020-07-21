package com.example.mvpchouqu6;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mvpchouqu6.adapter.RcyAdapter;
import com.example.mvpchouqu6.base.BaseActivity;
import com.example.mvpchouqu6.bean.Bean;
import com.example.mvpchouqu6.bean.JavaBean;
import com.example.mvpchouqu6.presnent.MainPresent;
import com.example.mvpchouqu6.view.MainView;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
/*
* 2020.7.15
* 今天学习了自定义view
* */
public class MainActivity extends BaseActivity<MainPresent> implements MainView {

    @BindView(R.id.tv)
    TextView tv;
    @BindView(R.id.tb)
    Toolbar tb;
    @BindView(R.id.rcy)
    RecyclerView rcy;
    private ArrayList<Bean.BodyBean.ResultBean> list;
    private RcyAdapter rcyAdapter;

    /*  @Override
      protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
          setContentView(R.layout.activity_main);
          ButterKnife.bind(this);
      }
  */
    @Override
    protected void initListener() {
        rcyAdapter.setOnItem(new RcyAdapter.OnItem() {
            @Override
            public void click(int position) {
                Bean.BodyBean.ResultBean resultBean = list.get(position);
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("data",resultBean);
                startActivityForResult(intent,1);
            }
        });
    }

    @Override
    protected void initData() {
        mPresenter.wanluo();
    }

    @Override
    protected void initView() {
        //布局管理器
        rcy.setLayoutManager(new LinearLayoutManager(this));
       // 分割线
        rcy.addItemDecoration(new DividerItemDecoration(this,LinearLayoutManager.VERTICAL));
       // 创建集合
        list = new ArrayList<>();
        //创建适配器
        rcyAdapter = new RcyAdapter(list, this);
        //绑定适配器
        rcy.setAdapter(rcyAdapter);

    }

    @Override
    protected void initPresenter() {
        mPresenter = new MainPresent();
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void setData(List<Bean.BodyBean.ResultBean> beans) {
        //添加到集合
    list.addAll(beans);
   // 刷新适配器
    rcyAdapter.notifyDataSetChanged();
    }

    @Override
    public void setData2(List<JavaBean.BodyBean.ResultBean> beans) {

    }

    @Override
    public void showToast(String string) {
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show();
    }
}
