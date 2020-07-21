package com.example.mvpchouqu3.present;

import com.example.mvpchouqu3.FuliBean;
import com.example.mvpchouqu3.base.BasePresent;
import com.example.mvpchouqu3.model.CollextModel;
import com.example.mvpchouqu3.net.MainCallBack;
import com.example.mvpchouqu3.view.MainView;

import java.util.List;

public class CollectPresenter extends BasePresent implements MainCallBack {

    private CollextModel model;

    @Override
    public void initModel() {
        model = new CollextModel();
    }

    @Override
    public void onSuccess(List<FuliBean.ResultsBean> beans) {

    }

    @Override
    public void onFial(String str) {
        mview.showToast(str);
    }
}
