package com.example.mvpchouqu6.view;

import com.example.mvpchouqu6.base.BaseView;
import com.example.mvpchouqu6.bean.Bean;
import com.example.mvpchouqu6.bean.JavaBean;

import java.util.List;

public interface MainView extends BaseView {
    void setData(List<Bean.BodyBean.ResultBean> beans);
    void setData2(List<JavaBean.BodyBean.ResultBean> beans);
}
