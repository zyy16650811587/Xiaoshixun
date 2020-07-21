package com.example.mvpchouqu3.base;

import android.net.ConnectivityManager;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public  abstract class BaseModel {
    public CompositeDisposable mdisposable=null;
    public void addDisposable(Disposable disposable){
        if(mdisposable==null){
            synchronized (BaseModel.class){
                if(mdisposable==null){
                    mdisposable=new CompositeDisposable();
                }
            }
        }
        mdisposable.add(disposable);
    }
    public void removeDisposable(Disposable disposable){
        if(mdisposable!=null){
            mdisposable.remove(disposable);
        }
    }
    public void dispose(){
        mdisposable.dispose();
    }
}
