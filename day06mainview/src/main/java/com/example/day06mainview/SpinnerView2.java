package com.example.day06mainview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class SpinnerView2 extends RelativeLayout {

    private EditText mEt;
    private ImageView im;
    private ArrayList<String> strings;
    private PopupWindow popupWindow;

    public SpinnerView2(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();

    }

    private void initView() {
        mEt = findViewById(R.id.met);
        im = findViewById(R.id.im);
        im.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                dealPopup();

            }
        });
    }


    private void init() {
       View.inflate(getContext(),R.layout.view_spinner2,this);
        initView();
        initData();
    }

    private void initData() {
        strings = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
         strings.add("蓝胖子"+i);
        }
    }

    private void dealPopup() {
        ListView listView = new ListView(getContext());
        listView.setAdapter(new ArrayAdapter<String>(getContext(),android.R.layout.simple_expandable_list_item_1,strings));
       listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               String s = strings.get(position);
               mEt.setText(s);
               mEt.setSelection(s.length());
               popupWindow.dismiss();
           }
       });
        popupWindow = new PopupWindow(listView, mEt.getWidth(), 600);
        popupWindow.setBackgroundDrawable(null);
        popupWindow.setOutsideTouchable(true);
        popupWindow.showAsDropDown(mEt);

    }
}
