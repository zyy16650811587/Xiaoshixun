package com.example.day06mainview;

import android.content.Context;
import android.text.Layout;
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

public class SpinnerView3 extends RelativeLayout {

    private ArrayList<String> strings;
    private EditText met;
    private ImageView iv;
    private PopupWindow popupWindow;

    public SpinnerView3(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        View.inflate(getContext(),R.layout.view_poinner3,this);

        initView();
        initData();
    }

    private void initData() {
        strings = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            strings.add("111"+i);
        }

    }

    private void initView() {
        met = findViewById(R.id.Met);
        iv = findViewById(R.id.iv);
        iv.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                dealPopu();
            }


        });
    }
    private void dealPopu() {
        ListView listView = new ListView(getContext());
        listView.setAdapter(new ArrayAdapter<String>(getContext(),android.R.layout.simple_expandable_list_item_1,strings));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String s = strings.get(position);
                met.setText(s);
                met.setSelection(s.length());
                popupWindow.dismiss();
            }
        });
        popupWindow = new PopupWindow(listView,met.getWidth(),600);
        popupWindow.setBackgroundDrawable(null);
        popupWindow.setOutsideTouchable(true);

        popupWindow.showAsDropDown(met);
    }
}
