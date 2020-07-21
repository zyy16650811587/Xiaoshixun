package com.example.mvpchouqu3.net;

import com.example.mvpchouqu3.FuliBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiServer {
    String BASE_URL="https://gank.io/api/";
    @GET("data/%E7%A6%8F%E5%88%A9/20/2")
    Observable<FuliBean> getjson();
}
