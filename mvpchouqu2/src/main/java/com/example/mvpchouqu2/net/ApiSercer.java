package com.example.mvpchouqu2.net;

import com.example.mvpchouqu2.Bean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiSercer {
    String BASE_URL="https://gank.io/api/";
    @GET("data/%E7%A6%8F%E5%88%A9/20/2")
    Observable<Bean> getjson();
}
