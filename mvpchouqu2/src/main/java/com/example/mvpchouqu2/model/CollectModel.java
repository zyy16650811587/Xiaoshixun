package com.example.mvpchouqu2.model;

import com.example.mvpchouqu2.base.BaseModel;
import com.example.mvpchouqu2.net.CollectCallback;
import com.example.mvpchouqu2.presenter.CollectPresenter;

public class CollectModel extends BaseModel {
    public void getString(CollectCallback collectCallback) {
        try {
            String str="111111";
            collectCallback.onSuccess(str);
        } catch (Exception e) {
            e.printStackTrace();
            collectCallback.onFila(e.getMessage());
        }
    }
}
