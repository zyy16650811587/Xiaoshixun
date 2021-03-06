package com.example.mvpchouqu3.base;

import java.util.ArrayList;

public abstract class BasePresent<V extends BaseView> {
    public V mview;
    public ArrayList<BaseModel> models=new ArrayList<>();
    public BasePresent(){
        initModel();
    }

    public  abstract void initModel();
    public void addModel(BaseModel model){
        models.add(model);
    }
    public void remove(){
        mview=null;
        for (int i = 0; i < models.size(); i++) {
            models.get(i).dispose();
        }
    }
    public void bingView(V view){
        this.mview=view;
    }

}
