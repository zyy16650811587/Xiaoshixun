package com.example.mvpchouqu4.base;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public  abstract class BsaeModel {
    public CompositeDisposable mdisposable=null;
    public void addDisposable(Disposable disposable){
        if(mdisposable==null){
            synchronized (BsaeModel.class){
                if(mdisposable==null){
                    mdisposable=new CompositeDisposable();
                }
            }
        }
        mdisposable.add(disposable);
    }
    public void removeDisposable(Disposable disposable){
        if(mdisposable !=null){
            mdisposable.remove(disposable);
        }
    }
    public void dispose(){
        mdisposable.dispose();
    }
}
