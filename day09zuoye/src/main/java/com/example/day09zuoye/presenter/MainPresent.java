package com.example.day09zuoye.presenter;

import android.util.Log;

import com.example.day09zuoye.base.BasePresenter;
import com.example.day09zuoye.bean.JavaBean;
import com.example.day09zuoye.model.MainModel;
import com.example.day09zuoye.net.MainCallBack;
import com.example.day09zuoye.view.MainView;

import java.util.List;

public class MainPresent extends BasePresenter<MainView> implements MainCallBack {

    private MainModel mainModel;

    @Override
    public void initModel() {
        mainModel = new MainModel();
        models.add(mainModel);
    }

    @Override
    public void onSuccess(List<JavaBean.DataBean.DatasBean> beans) {
        mview.initData(beans);
    }

    @Override
    public void onFile(String string) {
        mview.showTaost(string);
    }

    private static final String TAG = "MainPresent";
    public void wanluo() {
        Log.i(TAG, "wanluo: mPresenter");
        mainModel.wanluo(this);
    }
}
