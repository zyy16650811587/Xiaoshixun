package com.example.mvpchouqu5.model;

import com.example.mvpchouqu5.base.BaseModel;
import com.example.mvpchouqu5.bean.Bean;
import com.example.mvpchouqu5.net.ApiServer;
import com.example.mvpchouqu5.net.MainCallback;
import com.example.mvpchouqu5.presenter.MainPresenter;

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
                        addDispoable(d);
                    }

                    @Override
                    public void onNext(Bean bean) {
                        mainCallback.onSucess(bean.getData().getDatas());
                    }

                    @Override
                    public void onError(Throwable e) {
                    mainCallback.onFila(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
