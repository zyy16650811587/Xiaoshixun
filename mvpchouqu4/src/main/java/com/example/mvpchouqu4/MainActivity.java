package com.example.mvpchouqu4;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.mvpchouqu4.apapter.RcyAdapter;
import com.example.mvpchouqu4.base.BaseActivity;
import com.example.mvpchouqu4.bean.Bean;
import com.example.mvpchouqu4.presenter.MainPresenter;
import com.example.mvpchouqu4.view.MainView;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity<MainPresenter> implements MainView {

    @BindView(R.id.rcy)
    RecyclerView rcy;
    @BindView(R.id.bnt1)
    Button bnt1;
    @BindView(R.id.bnt2)
    Button bnt2;
    @BindView(R.id.bnt3)
    Button bnt3;
    private ArrayList<Bean.T1348647909107Bean> list;
    private RcyAdapter rcyAdapter;



    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
        mPresent.jiexi();
    }

    @Override
    protected void initView() {
      list = new ArrayList<>();   rcy.setLayoutManager(new LinearLayoutManager(this));
        rcy.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        rcyAdapter = new RcyAdapter(list, this);
        rcy.setAdapter(rcyAdapter);

    }

    @Override
    protected int initLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initPresent() {
        mPresent = new MainPresenter();
    }

    @Override
    public void setData(List<Bean.T1348647909107Bean> beans) {

        if(beans !=null){ list.addAll(beans);
            rcyAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void showToast(String string) {
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show();
    }

    @OnClick({R.id.bnt1, R.id.bnt2, R.id.bnt3})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bnt1:
                rcyAdapter.isShow=true;
                rcyAdapter.notifyDataSetChanged();
                break;
            case R.id.bnt2:
            initRemove();
                break;
            case R.id.bnt3:
              initBack();
                break;
        }
    }

    private void initBack() {
       /* //清空数据的状态
        for (int i = 0; i < recentBeans.size(); i++) {
            NewsBean.RecentBean recentBean = recentBeans.get(i);
            //recentBean.setCheck(false);
            recentBean.setCheck(false);
        }
        rcyAdapter.isShow = false;
        rcyAdapter.notifyDataSetChanged();*/
        for (int i = 0; i < list.size(); i++) {
            Bean.T1348647909107Bean bean = list.get(i);
          bean.setSetCkeck(false);
        }
        rcyAdapter.isShow=false;
        rcyAdapter.notifyDataSetChanged();

    }

    private void initRemove() {
        //不删除的数据,收集到新集合中
        ArrayList<Bean.T1348647909107Bean> beans = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            Bean.T1348647909107Bean bean = list.get(i);
            if(!bean.isSetCkeck()){
                beans.add(bean);
            }
        }
        //清空旧集合
        list.clear();
        //添加剩下的数据
        list.addAll(beans);
        //删除后，还原到原始状态，调用 取消按钮的功能
        rcyAdapter.notifyDataSetChanged();


    }
}
