package com.example.mvpchouqu6.presnent;

import com.example.mvpchouqu6.base.Baseprosenter;
import com.example.mvpchouqu6.bean.Bean;
import com.example.mvpchouqu6.model.MainModel;
import com.example.mvpchouqu6.net.MainCallBack;
import com.example.mvpchouqu6.view.MainView;

import java.util.List;

public class MainPresent extends Baseprosenter<MainView> implements MainCallBack {

    private MainModel mainModel;

    @Override
    public void initModel() {
        mainModel = new MainModel();
        models.add(mainModel);
    }

    public void wanluo() {
    mainModel.wanluo(this);
    }

    @Override
    public void onSuccess(List<Bean.BodyBean.ResultBean> beans) {
        mview.setData(beans);
    }

    @Override
    public void onFild(String string) {
        mview.showToast(string);
    }
}
