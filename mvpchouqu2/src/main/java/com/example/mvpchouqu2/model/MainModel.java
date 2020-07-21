package com.example.mvpchouqu2.model;

import android.util.Log;

import com.example.mvpchouqu2.Bean;
import com.example.mvpchouqu2.base.BaseModel;
import com.example.mvpchouqu2.net.ApiSercer;
import com.example.mvpchouqu2.net.BaseObserver;
import com.example.mvpchouqu2.net.HttpUtils;
import com.example.mvpchouqu2.net.MainCallback;
import com.example.mvpchouqu2.net.RxUtils;
import com.example.mvpchouqu2.presenter.MainPresenter;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainModel extends BaseModel {
    public void wanluo(MainCallback mainCallback) {
       /* ApiService apiserver = HttpUtils.getInstance().getApiserver(ApiService.BASE_URL, ApiService.class);
        Observable<FuliBean> observable = apiserver.getFuli();
//compose 简化线程切换
        observable.compose(RxUtils.rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<FuliBean>(this) {
                    @Override
                    protected void onSuccess(FuliBean fuliBean) {
                        mainCallBack.onSuccess(fuliBean);
                    }

                    @Override
                    protected void error(String err) {
                        mainCallBack.onFail(err);
                    }
                });*/
        ApiSercer apiserver = HttpUtils.getInstance().getApiserver(ApiSercer.BASE_URL, ApiSercer.class);
        Observable<Bean> getjson = apiserver.getjson();
        getjson.compose(RxUtils.rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<Bean>(this) {
                    @Override
                    protected void onSuccess(Bean bean) {
                        mainCallback.onSuccess(bean.getResults());
                    }

                    @Override
                    protected void error(String err) {
                        mainCallback.onFila(err);
                    }
                });


        /*Retrofit build = new Retrofit.Builder()
                .baseUrl(ApiSercer.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        ApiSercer apiSercer = build.create(ApiSercer.class);
        Observable<Bean> getjson = apiSercer.getjson();
        getjson.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Bean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.i("TAG", "onSubscribe: mModel");
                        addDisposable(d);
                    }

                    @Override
                    public void onNext(Bean bean) {
                        mainCallback.onSuccess(bean.getResults());
                    }

                    @Override
                    public void onError(Throwable e) {
                    mainCallback.onFila(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });*/

    }
}
