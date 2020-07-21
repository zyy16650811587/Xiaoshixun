package com.example.mvpchouqu2.view;

import com.example.mvpchouqu2.Bean;
import com.example.mvpchouqu2.base.BaseView;

import java.util.List;

public interface MainView extends BaseView {
    void setData(List<Bean.ResultsBean> beans);
}
