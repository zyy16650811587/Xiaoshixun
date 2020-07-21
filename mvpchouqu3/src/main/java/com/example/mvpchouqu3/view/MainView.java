package com.example.mvpchouqu3.view;

import com.example.mvpchouqu3.FuliBean;
import com.example.mvpchouqu3.base.BaseView;

import java.util.List;

public interface MainView extends BaseView {
    void setData(List<FuliBean.ResultsBean> beans);
}
