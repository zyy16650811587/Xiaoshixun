package com.example.mvpchouqu2.presenter;

import com.example.mvpchouqu2.base.BasePresenter;
import com.example.mvpchouqu2.model.CollectModel;
import com.example.mvpchouqu2.net.CollectCallback;
import com.example.mvpchouqu2.view.CollectView;

public class CollectPresenter extends BasePresenter<CollectView> implements CollectCallback {

    private CollectModel model;

    @Override
    public void initModel() {
        model = new CollectModel();
        addModel(model);
    }

    public void getString() {
        model.getString(this);
    }

    @Override
    public void onSuccess(String str) {
        mview.setName(str);
    }

    @Override
    public void onFila(String string) {
        mview.showToast(string);
    }
}
