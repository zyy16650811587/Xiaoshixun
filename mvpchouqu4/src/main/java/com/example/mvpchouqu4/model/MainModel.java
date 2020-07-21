package com.example.mvpchouqu4.model;

import android.util.Log;

import com.example.mvpchouqu4.base.BsaeModel;
import com.example.mvpchouqu4.bean.Bean;
import com.example.mvpchouqu4.net.ApiServer;
import com.example.mvpchouqu4.net.MainCallback;
import com.example.mvpchouqu4.presenter.MainPresenter;

import javax.security.auth.login.LoginException;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainModel extends BsaeModel {

    public void jiexi(MainCallback mainCallback) {
        Retrofit build = new Retrofit.Builder()
                .baseUrl(ApiServer.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        ApiServer apiServer = build.create(ApiServer.class);
        Observable<Bean> bean = apiServer.getBean();
        bean.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Bean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        addDisposable(d);
                    }

                    @Override
                    public void onNext(Bean bean) {
                        mainCallback.onSuccess(bean.getT1348647909107());
                        Log.e("111",bean.getT1348647909107().get(0).getCid().toString());      }

                    @Override
                    public void onError(Throwable e) {
                    mainCallback.onFial(e.getMessage());

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
