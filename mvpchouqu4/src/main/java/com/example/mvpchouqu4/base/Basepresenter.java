package com.example.mvpchouqu4.base;

import java.util.ArrayList;

import io.reactivex.disposables.Disposable;

public  abstract class Basepresenter<V extends BaseView> {
    public V mview;
    public ArrayList<BsaeModel> models=new ArrayList<>();
    public Basepresenter(){
        initModel();
    }
    public abstract void initModel();
    public void addModel(BsaeModel model){
        models.add(model);
    }
    public void dispose(){
        mview=null;
        for (int i = 0; i < models.size(); i++) {
            models.get(i).dispose();
        }
    }
    public void bingview(V view){
        this.mview=view;
    }




}
