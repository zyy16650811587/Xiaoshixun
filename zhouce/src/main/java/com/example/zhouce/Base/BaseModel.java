package com.example.zhouce.Base;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public abstract class BaseModel {
    public CompositeDisposable mdisposable=null;
    public void addDisposable(Disposable disposable){
        if(mdisposable==null){
            mdisposable.add(disposable);
            synchronized (BaseModel.class){
                if(mdisposable==null){

                }
            }
        }
    }
}
