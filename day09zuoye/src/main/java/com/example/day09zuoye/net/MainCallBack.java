package com.example.day09zuoye.net;

import com.example.day09zuoye.bean.JavaBean;

import java.util.List;

public interface MainCallBack {
    void onSuccess(List<JavaBean.DataBean.DatasBean> beans);
    void onFile(String string);
}
