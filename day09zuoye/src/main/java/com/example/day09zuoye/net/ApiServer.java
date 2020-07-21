package com.example.day09zuoye.net;

import com.example.day09zuoye.bean.JavaBean;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiServer {
    String BASE_URL=" http://www.wanandroid.com/";
    String SERVER_BASE_URL="https://alissl.ucdl.pp.uc.cn/";


    @GET("project/list/1/json?cid=294")
    Observable<JavaBean> getBean();


    @GET("fs08/2019/07/05/1/110_17e4089aa3a4b819b08069681a9de74b.apk")
    Observable<ResponseBody> bean();

}
