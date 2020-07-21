package com.example.day09zuoye.net;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.example.day09zuoye.MyMassage;

import org.greenrobot.eventbus.EventBus;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import androidx.annotation.Nullable;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

public class MyServer extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        new Thread(){
            @Override
            public void run() {
                super.run();
                String path="/storage/sdcard0/aa.apk";
                Retrofit build = new Retrofit.Builder()
                        .baseUrl(ApiServer.SERVER_BASE_URL)
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .build();
                ApiServer apiServer = build.create(ApiServer.class);
                Observable<ResponseBody> bean = apiServer.bean();
                bean.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<ResponseBody>() {
                            @Override
                            public void onSubscribe(Disposable d) {

                            }

                            @Override
                            public void onNext(ResponseBody responseBody) {
                                long length = responseBody.contentLength();
                                InputStream inputStream = responseBody.byteStream();
                                saveFile(path,inputStream,length);
                            }



                            @Override
                            public void onError(Throwable e) {

                            }

                            @Override
                            public void onComplete() {

                            }
                        });
            }
        }.start();

        return super.onStartCommand(intent, flags, startId);
    }
    private void saveFile(String path, InputStream inputStream, long length) {
        EventBus.getDefault().post(new MyMassage(0, (int) length,0));
        FileOutputStream stream=null;
        try {
            stream=new FileOutputStream(path);
            byte[] arr=new byte[1024];
            int len=0;
            int count=0;
            while ((len=inputStream.read(arr))!=-1){
                stream.write(arr,0,len);
                count+=len;
                Thread.sleep(1);
                EventBus.getDefault().post(new MyMassage(1, (int) length,count));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(inputStream !=null){
                    inputStream.close();
                }
                if(stream !=null){
                    stream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



    }
}
