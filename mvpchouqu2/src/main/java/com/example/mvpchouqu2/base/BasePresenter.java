package com.example.mvpchouqu2.base;

import java.util.ArrayList;

public abstract class BasePresenter<V extends BaseView> {
    public V mview;
    public ArrayList<BaseModel> models=new ArrayList<>();
    public BasePresenter(){
        initModel();
    }
    public abstract void initModel();
    public  void  addModel(BaseModel baseModel){
        models.add(baseModel);

    }
    public  void  bingView(V view){
        this.mview=view;

    }
    public  void  removeModel(BaseModel baseModel){
        mview=null;
        for (int i = 0; i <models.size() ; i++) {
            models.get(i).dispose();
        }
    }
}
