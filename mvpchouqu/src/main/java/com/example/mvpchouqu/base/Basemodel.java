package com.example.mvpchouqu.base;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public abstract class Basemodel {
    private CompositeDisposable mdisposable=null;
    public void adddisposable(Disposable disposable){
        if(mdisposable==null){
            synchronized (Basemodel.class){
                if(mdisposable==null){
                    mdisposable=new CompositeDisposable();
                }
            }
        }
        mdisposable.add(disposable);
    }
    public void dispose(){
        mdisposable.dispose();
    }
    public void remove(Disposable disposable){
        if(mdisposable==null){
            mdisposable.remove(disposable);
        }
    }
}
