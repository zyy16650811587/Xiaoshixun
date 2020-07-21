package com.example.mvpchouqu2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.example.mvpchouqu2.fragment.CollectFragment;

public class CollectFragmentActivity extends AppCompatActivity {

    private FragmentManager supportFragmentManager;
    private CollectFragment collectFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collect_fragment);
        supportFragmentManager = getSupportFragmentManager();
        collectFragment = new CollectFragment();
        supportFragmentManager.beginTransaction().add(R.id.rl,collectFragment).commit();

    }
}
