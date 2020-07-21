package com.example.mvpchouqu6;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment1 extends Fragment {


    private TextView tv;

    public Fragment1() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //加载布局
        View view = inflater.inflate(R.layout.fragment_1, container, false);
        tv = view.findViewById(R.id.tv);
        tv.setText("北大纵横管理咨询集团管理");
        return view;
    }
}
