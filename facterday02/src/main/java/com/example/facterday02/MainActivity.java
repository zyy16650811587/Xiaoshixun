package com.example.facterday02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TrueFacttory trueFacttory = new TrueFacttory();
        ProductA product = trueFacttory.createProduct(ProductA.class);
        product.scy();


    }
}
