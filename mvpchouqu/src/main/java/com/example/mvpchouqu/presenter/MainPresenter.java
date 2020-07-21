package com.example.mvpchouqu.presenter;

import com.example.mvpchouqu.StrCallback;
import com.example.mvpchouqu.base.BasePresenter;
import com.example.mvpchouqu.model.MainModel;
import com.example.mvpchouqu.view.MainView;

public class MainPresenter extends BasePresenter<MainView> implements StrCallback {

    private MainModel mainModel;

    @Override
    public void initModel() {
        mainModel = new MainModel();
        addModel(mainModel);
    }

    @Override
    public void onSuccess(String str) {
        mview.setData(str);
    }

    @Override
    public void onFie(String str) {
        mview.showToast(str);
    }

    public void getstring() {
        mainModel.getString(this);
    }
}
