package com.example.day06mainview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class SpinnerView extends RelativeLayout {

    private EditText et;
    private ImageView img;
    private ArrayList<String> mData;
    private PopupWindow popupWindow;

    public SpinnerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }
    private void init(){
        View.inflate(getContext(),R.layout.view_spinner,this);
    initView();//加载组件
    initData();//初始化数据

    }

    private void initData() {
        mData = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            mData.add("班级"+i);

        }
    }

    private void initView() {
        et = findViewById(R.id.et_key);
        img = findViewById(R.id.img_down);
        img.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //弹出popuwindow
                dealPppup();

            }
        });
    }

    private void dealPppup() {

        ListView listView = new ListView(getContext());
        listView.setAdapter(new ArrayAdapter<String>(getContext(),android.R.layout.simple_expandable_list_item_1,mData));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String s = mData.get(position);
                et.setText(s);
                et.setSelection(s.length());
                popupWindow.dismiss();
            }
        });
        popupWindow = new PopupWindow(listView,et.getWidth(), GridView.LayoutParams.WRAP_CONTENT);
        popupWindow.setBackgroundDrawable(null);
        popupWindow.setOutsideTouchable(true);
        popupWindow.showAsDropDown(et);

    }
}
