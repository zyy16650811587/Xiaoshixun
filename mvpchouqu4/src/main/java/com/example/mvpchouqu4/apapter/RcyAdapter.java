package com.example.mvpchouqu4.apapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mvpchouqu4.R;
import com.example.mvpchouqu4.bean.Bean;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RcyAdapter extends RecyclerView.Adapter {
    private ArrayList<Bean.T1348647909107Bean> list;
    private Context context;
    public boolean isShow;

    public RcyAdapter(ArrayList<Bean.T1348647909107Bean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.itrm_rcy, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Bean.T1348647909107Bean bean = list.get(position);
        ViewHolder holder1= (ViewHolder) holder;
        if(isShow==true){
            holder1.cb.setVisibility(View.VISIBLE);
        }else{
            holder1.cb.setVisibility(View.INVISIBLE);
        }

        holder1.cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked==true){
                    list.get(position).setSetCkeck(true);
                }else{
                    list.get(position).setSetCkeck(false);
                }
            }
        });
        Log.i("12",bean.getTitle());
        holder1.tv.setText(bean.getTitle());
        Glide.with(context).load(bean.getImgsrc()).into(holder1.im);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static
    class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView im;
        public TextView tv;
        public CheckBox cb;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.im = (ImageView) rootView.findViewById(R.id.im);
            this.tv = (TextView) rootView.findViewById(R.id.tv);
            this.cb = (CheckBox) rootView.findViewById(R.id.cb);
        }

    }
}
