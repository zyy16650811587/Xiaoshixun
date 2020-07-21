package com.example.mvpchouqu5;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;

import com.example.mvpchouqu5.bean.EvntenMsg;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class WebActivity extends AppCompatActivity {

    private Toolbar tb;
    private WebView web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        initView();
        EventBus.getDefault().register(this);

    }

    private void initView() {
        tb = (Toolbar) findViewById(R.id.tb);
        setSupportActionBar(tb);
        web = (WebView) findViewById(R.id.web);

    }

    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
        public void getMsg(EvntenMsg evntenMsg){
        String msg = evntenMsg.getMsg();
        web.loadUrl(msg);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
      EventBus.getDefault().unregister(this);
    }
}
