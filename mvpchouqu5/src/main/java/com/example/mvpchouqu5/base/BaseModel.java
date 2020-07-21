package com.example.mvpchouqu5.base;

import com.example.mvpchouqu5.presenter.MainPresenter;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public abstract class BaseModel {
    public CompositeDisposable mdisposable=null;
    public void addDispoable(Disposable disposable){
        if(mdisposable==null){
            synchronized (BaseModel.class){
                if(mdisposable==null){
                    mdisposable=new CompositeDisposable();
                }
            }
        }
        mdisposable.add(disposable);
    }
    public void removeDispoable(Disposable disposable){
        if(mdisposable!=null){
            mdisposable.remove(disposable);
        }
    }
    public void dispose(){
        mdisposable.dispose();
    }

}
