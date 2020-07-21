package com.example.mvpchouqu3.model;

import com.example.mvpchouqu3.FuliBean;
import com.example.mvpchouqu3.base.BaseModel;
import com.example.mvpchouqu3.net.ApiServer;
import com.example.mvpchouqu3.net.BaseObserver;
import com.example.mvpchouqu3.net.HttpUtils;
import com.example.mvpchouqu3.net.MainCallBack;
import com.example.mvpchouqu3.net.RxUtils;
import com.example.mvpchouqu3.present.MainPresenter;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainModel extends BaseModel {

    public void jiexi(MainCallBack mainCallBack) {
        ApiServer apiserver = HttpUtils.getInstance().getApiserver(ApiServer.BASE_URL, ApiServer.class);
        apiserver.getjson().compose(RxUtils.rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<FuliBean>(this) {
                    @Override
                    protected void onSuccess(FuliBean fuliBean) {
                        mainCallBack.onSuccess(fuliBean.getResults());
                    }

                    @Override
                    protected void error(String err) {
                        mainCallBack.onFial(err);
                    }
                });
       /* Retrofit build = new Retrofit.Builder()
                .baseUrl(ApiServer.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        ApiServer apiServer = build.create(ApiServer.class);
        Observable<FuliBean> getjson = apiServer.getjson();
        getjson.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<FuliBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        addDisposable(d);
                    }

                    @Override
                    public void onNext(FuliBean fuliBean) {
                        mainCallBack.onSuccess(fuliBean.getResults());
                    }

                    @Override
                    public void onError(Throwable e) {
                        mainCallBack.onFial(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
*/
    }
}
