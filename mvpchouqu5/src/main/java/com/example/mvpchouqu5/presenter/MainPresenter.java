package com.example.mvpchouqu5.presenter;

import com.example.mvpchouqu5.base.BasePresent;
import com.example.mvpchouqu5.bean.Bean;
import com.example.mvpchouqu5.model.MainModel;
import com.example.mvpchouqu5.net.MainCallback;
import com.example.mvpchouqu5.view.MainView;

import java.util.List;

public class MainPresenter extends BasePresent<MainView> implements MainCallback {

    private MainModel mainModel;

    @Override
    public void initModel() {
        mainModel = new MainModel();
        models.add(mainModel);
    }

    @Override
    public void onSucess(List<Bean.DataBean.DatasBean> beans) {
        mview.setData(beans);
    }

    @Override
    public void onFila(String string) {
        mview.showToast(string);
    }

    public void wanluo() {
        mainModel.wanluo(this);
    }
}
