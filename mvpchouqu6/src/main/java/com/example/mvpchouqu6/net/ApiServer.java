package com.example.mvpchouqu6.net;

import com.example.mvpchouqu6.bean.Bean;
import com.example.mvpchouqu6.bean.JavaBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiServer {
    String BASE_URL="https://api.yunxuekeji.cn/";
    String JAVABEAN_URL="https://api.yunxuekeji.cn/";
    @GET("yunxue_app_api/content/getData/30/66597/1/10")
    Observable<Bean> getBean();
    @GET("yunxue_app_api/teacher/getTeacherPower/{path}")
    Observable<JavaBean> getJavaBean(@Path("path") int id);

}
