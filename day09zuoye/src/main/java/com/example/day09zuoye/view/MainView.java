package com.example.day09zuoye.view;

import com.example.day09zuoye.base.BaseView;
import com.example.day09zuoye.bean.JavaBean;

import java.util.List;

public interface MainView extends BaseView {
    void initData(List<JavaBean.DataBean.DatasBean> beans);
}
