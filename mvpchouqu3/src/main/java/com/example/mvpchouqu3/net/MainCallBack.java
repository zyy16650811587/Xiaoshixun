package com.example.mvpchouqu3.net;

import com.example.mvpchouqu3.FuliBean;

import java.util.List;

public interface MainCallBack {
    void onSuccess(List<FuliBean.ResultsBean> beans);
    void onFial(String str);
}
