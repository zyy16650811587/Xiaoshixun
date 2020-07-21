package com.example.day09zuoye.model;

import android.util.Log;

import com.example.day09zuoye.base.BaseModel;
import com.example.day09zuoye.bean.JavaBean;
import com.example.day09zuoye.net.ApiServer;
import com.example.day09zuoye.net.MainCallBack;
import com.example.day09zuoye.presenter.MainPresent;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainModel extends BaseModel {

    private static final String TAG = "MainModel";
    public void wanluo(MainCallBack mainCallBack) {
        Log.i(TAG, "wanluo: mModel");
        Retrofit build = new Retrofit.Builder()
                .baseUrl(ApiServer.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        ApiServer apiServer = build.create(ApiServer.class);
        Observable<JavaBean> bean = apiServer.getBean();
        bean.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<JavaBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        addDisposable(d);
                    }

                    @Override
                    public void onNext(JavaBean javaBean) {
                         mainCallBack.onSuccess(javaBean.getData().getDatas());
                        Log.e("111",javaBean.getData().getDatas().toString());
                    }

                    @Override
                    public void onError(Throwable e) {
                        mainCallBack.onFile(e.getMessage());
                        Log.i("111","jjjjjjjjjjj");
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
