package com.example.mvpchouqu.base;

import com.example.mvpchouqu.StrCallback;

import java.util.ArrayList;

public abstract class BasePresenter<V extends BaseView>  {
    public V mview;
    public ArrayList<Basemodel> basemodels =new ArrayList<>();
    public BasePresenter(){
    initModel();
    }
    public abstract void initModel();
    public void addModel(Basemodel basemodel){
            basemodels.add(basemodel);
    }
    public  void bindview(V view){
        this.mview=view;
    }
    public void destroy(){
        mview=null;
        for (int i = 0; i < basemodels.size(); i++) {
            Basemodel basemodel = basemodels.get(i);
            basemodel.dispose();

        }
    }


}
