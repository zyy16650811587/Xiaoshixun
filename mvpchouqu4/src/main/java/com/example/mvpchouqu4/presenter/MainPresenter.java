package com.example.mvpchouqu4.presenter;

import com.example.mvpchouqu4.base.Basepresenter;
import com.example.mvpchouqu4.bean.Bean;
import com.example.mvpchouqu4.model.MainModel;
import com.example.mvpchouqu4.net.MainCallback;
import com.example.mvpchouqu4.view.MainView;

import java.util.List;

public class MainPresenter extends Basepresenter<MainView> implements MainCallback {

    private MainModel mainModel;

    @Override
    public void initModel() {
        mainModel = new MainModel();addModel(mainModel);
    }

    @Override
    public void onSuccess(List<Bean.T1348647909107Bean> beans) {
        mview.setData(beans);
    }

    @Override
    public void onFial(String string) {
        mview.showToast(string);
    }

    public void jiexi() {
        mainModel.jiexi(this);
    }
}
