package com.example.mvpchouqu6.base;

import java.util.ArrayList;

public  abstract class Baseprosenter<V extends BaseView> {
    public V mview;
    public ArrayList<BaseModel> models=new ArrayList<>();
    public Baseprosenter(){
        initModel();
    }
    public abstract void initModel();
    public void addModel(BaseModel model){
        models.add(model);

    }
    public void dispose(){
        mview=null;
        for (int i = 0; i < models.size(); i++) {
            models.get(i).dispose();
        }

    }
    public void BingView(V view){
        this.mview=view;
    }
}
