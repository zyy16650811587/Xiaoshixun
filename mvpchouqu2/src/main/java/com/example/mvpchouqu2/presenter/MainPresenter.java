package com.example.mvpchouqu2.presenter;

import com.example.mvpchouqu2.Bean;
import com.example.mvpchouqu2.base.BasePresenter;
import com.example.mvpchouqu2.model.MainModel;
import com.example.mvpchouqu2.net.MainCallback;
import com.example.mvpchouqu2.view.MainView;

import java.util.List;

public class MainPresenter extends BasePresenter<MainView> implements MainCallback {

    private MainModel mainModel;

    @Override
    public void initModel() {
        mainModel = new MainModel();
    }


    @Override
    public void onSuccess(List<Bean.ResultsBean> beans) {
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
