package com.example.mvpchouqu3.view;

import com.example.mvpchouqu3.FuliBean;
import com.example.mvpchouqu3.base.BaseView;

import java.util.List;

public interface Collectview extends BaseView {
    void setFuli(List<FuliBean.ResultsBean> beans);
}
