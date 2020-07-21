package com.example.mvpchouqu6;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.mvpchouqu6.adapter.MyAdapter;
import com.example.mvpchouqu6.adapter.RcyAdapter;
import com.example.mvpchouqu6.bean.Bean;
import com.example.mvpchouqu6.bean.JavaBean;
import com.example.mvpchouqu6.net.ApiServer;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    private TextView tv;
    private Toolbar tb;
    private ImageView im;
    private TextView tv_name;
    private TextView tv_title;
    private Button bnt;
    private TabLayout tlb;
    private String url;
    private RcyAdapter rcyAdapter;
    private Bean.BodyBean.ResultBean data;

    private ArrayList<JavaBean.BodyBean.ResultBean> resultBeans;

    public int id;
    private FrameLayout fl;
    private List<JavaBean.BodyBean.ResultBean> result;
    private ViewPager vp;
    private ArrayList<Fragment> fragments;
    private ArrayList<String> titles;
    private MyAdapter adapter;
    private Fragment1 fragment;
    private Fragment2 fragment2;
    private Fragment3 fragment3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent = getIntent();
        data = (Bean.BodyBean.ResultBean) intent.getSerializableExtra("data");
        // url = "https://api.yunxuekeji.cn/yunxue_app_api/teacher/getTeacherPower/" + data.getID();
        initView();
        initData();
        initVaper();

    }

    private void initVaper() {
//赋值
        tv_name.setText(data.getTeacherName());
        tv_title.setText(data.getTitle());
        Glide.with(this).load(data.getTeacherPic()).into(im);
//创建集合
        fragments = new ArrayList<>();

//创建fragment
        fragment = new Fragment1();
        fragment2 = new Fragment2();
        fragment3 = new Fragment3();
//添加到集合
        fragments.add(fragment);
        fragments.add(fragment2);
        fragments.add(fragment3);
        adapter = new MyAdapter(getSupportFragmentManager(), fragments, titles);

    }
//网络请求
    private void initData() {
        titles = new ArrayList<>();

        Retrofit build = new Retrofit.Builder()
                .baseUrl(ApiServer.JAVABEAN_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        ApiServer apiServer = build.create(ApiServer.class);
        Observable<JavaBean> javaBean = apiServer.getJavaBean(id);
        javaBean.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<JavaBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(JavaBean javaBean) {
                        result = javaBean.getBody().getResult();
                        Log.i("1111",result.toString());
                        for (int i = 0; i < result.size(); i++) {
                            JavaBean.BodyBean.ResultBean resultBean = result.get(i);
                           /* if(i==0){
                                fragments.add(fragment);
                            } else if(i==1){
                                fragments.add(fragment2);
                            }else if(i==2){
                                fragments.add(fragment3);
                            }*/
                            titles.add(result.get(i).getDescription());
                         //   String teacherpowerid = resultBean.getTeacherpowerid();
                            titles.add("课程");
                           titles.add("专题");
                        }
                        adapter.notifyDataSetChanged();
                        vp.setAdapter(adapter);
                        tlb.setupWithViewPager(vp);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }

    private void initView() {
        //找到控件
        tv = (TextView) findViewById(R.id.tv);
        tb = (Toolbar) findViewById(R.id.tb);
        setSupportActionBar(tb);
        im = (ImageView) findViewById(R.id.im);
        tv_name = (TextView) findViewById(R.id.tv_name);
        tv_title = (TextView) findViewById(R.id.tv_title);
        bnt = (Button) findViewById(R.id.bnt);
        tlb = (TabLayout) findViewById(R.id.tlb);


        fl = (FrameLayout) findViewById(R.id.fl);
        fl.setOnClickListener(this);
        vp = (ViewPager) findViewById(R.id.vp);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bnt:
                Toast.makeText(this, "关注成功", Toast.LENGTH_SHORT).show();

                break;
        }
    }


}
