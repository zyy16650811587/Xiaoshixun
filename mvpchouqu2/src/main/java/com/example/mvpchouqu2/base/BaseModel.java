package com.example.mvpchouqu2.base;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public abstract class BaseModel {
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
   ;public  void dispose(){
       mdisposable.dispose();
    }
    public void removeDisposapable(Disposable disposable){
        if(mdisposable !=null){
            mdisposable.remove(disposable);
        }
    }

}
