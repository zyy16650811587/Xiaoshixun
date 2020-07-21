package com.example.mvpchouqu;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mvpchouqu.presenter.MainPresenter;
import com.example.mvpchouqu.view.MainView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity<MainPresenter> implements MainView {

    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.bnt)
    Button bnt;

  /*  @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }*/

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initPresenter() {
        mpresenter = new MainPresenter();

    }

    @Override
    public void initview() {
        name.setText("我是卡卡卡");
    }

    @Override
    public void initData() {

    }

    @Override
    public void initlister() {

    }

    @Override
    public void setData(String string) {
        name.setText(string);
    }

    @Override
    public void showToast(String string) {

    }

    @OnClick(R.id.bnt)
    public void onClick(View v) {
        switch (v.getId()){
            default:
                break;
            case R.id.bnt:
                mpresenter.getstring();
                break;
        }
    }
}
