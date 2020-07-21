package com.example.mvpchouqu5.view;

import com.example.mvpchouqu5.base.BaseView;
import com.example.mvpchouqu5.bean.Bean;

import java.util.List;

public interface MainView extends BaseView {
    void setData(List<Bean.DataBean.DatasBean> beans);
}
