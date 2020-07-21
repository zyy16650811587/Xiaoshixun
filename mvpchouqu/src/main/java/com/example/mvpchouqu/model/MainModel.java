package com.example.mvpchouqu.model;

import com.example.mvpchouqu.StrCallback;
import com.example.mvpchouqu.base.Basemodel;
import com.example.mvpchouqu.presenter.MainPresenter;

public class MainModel extends Basemodel {
    public void getString(StrCallback strCallback) {
        try {
            String str="1111";
            strCallback.onSuccess(str);
        } catch (Exception e) {
            e.printStackTrace();
            strCallback.onFie(e.getMessage());
        }
    }
}
