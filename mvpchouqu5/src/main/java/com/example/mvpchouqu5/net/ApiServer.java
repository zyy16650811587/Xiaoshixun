package com.example.mvpchouqu5.net;

import com.example.mvpchouqu5.bean.Bean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiServer {
    String BASE_URL="https://www.wanandroid.com/";
    @GET("project/list/1/json?cid=294")
    Observable<Bean> getBean();
}
