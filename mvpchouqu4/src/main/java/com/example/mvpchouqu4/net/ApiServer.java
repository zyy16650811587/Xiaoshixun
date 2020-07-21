package com.example.mvpchouqu4.net;

import com.example.mvpchouqu4.base.BaseActivity;
import com.example.mvpchouqu4.bean.Bean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiServer {
    String BASE_URL="http://c.m.163.com/";
    @GET("nc/article/headline/T1348647909107/0-20.html")
    Observable<Bean> getBean();
}
