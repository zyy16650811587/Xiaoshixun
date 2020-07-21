package com.example.mvpchouqu5.net;

import com.example.mvpchouqu5.bean.Bean;

import java.util.List;

public interface MainCallback {
    void onSucess(List<Bean.DataBean.DatasBean> beans);
    void onFila(String string);
}
