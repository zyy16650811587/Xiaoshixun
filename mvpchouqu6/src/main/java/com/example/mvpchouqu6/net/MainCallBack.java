package com.example.mvpchouqu6.net;

import com.example.mvpchouqu6.bean.Bean;

import java.util.List;

public interface MainCallBack {
    void onSuccess(List<Bean.BodyBean.ResultBean> beans);
    void onFild(String string);
}
