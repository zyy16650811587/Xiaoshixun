package com.example.day09zuoye.base;

import java.util.ArrayList;

public abstract class BasePresenter<V extends BaseView> {
    public V mview;
    public   ArrayList<BaseModel> models=new ArrayList<>();
    public BasePresenter(){
        initModel();
    }
public abstract void initModel();
    public void addModel(BaseModel model){
        models.add(model);
    }
    public void bindView(V view){
        this.mview=view;
    }
    public void dispose(){
        mview=null;
        for (int i = 0; i < models.size(); i++) {
            models.get(i).dispose();
        }
    }
}
