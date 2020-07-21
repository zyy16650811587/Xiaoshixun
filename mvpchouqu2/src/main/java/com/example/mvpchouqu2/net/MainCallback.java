package com.example.mvpchouqu2.net;

import com.example.mvpchouqu2.Bean;

import java.util.List;

public interface MainCallback {
    void onSuccess(List<Bean.ResultsBean> beans);
    void onFila(String string);
}
