package com.example.mvpchouqu3.present;

import com.example.mvpchouqu3.FuliBean;
import com.example.mvpchouqu3.base.BasePresent;
import com.example.mvpchouqu3.model.MainModel;
import com.example.mvpchouqu3.net.MainCallBack;
import com.example.mvpchouqu3.view.MainView;

import java.security.PublicKey;
import java.util.List;

public class MainPresenter extends BasePresent<MainView> implements MainCallBack {

    private MainModel mainModel;

    @Override
    public void initModel() {
        mainModel = new MainModel();
        addModel(mainModel);
    }

    @Override
    public void onSuccess(List<FuliBean.ResultsBean> beans) {
        mview.setData(beans);
    }

    @Override
    public void onFial(String str) {
        mview.showToast(str);
    }

    public void jieXi() {
        mainModel.jiexi(this);
    }
}
