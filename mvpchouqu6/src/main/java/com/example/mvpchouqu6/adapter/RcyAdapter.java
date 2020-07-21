package com.example.mvpchouqu6.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.mvpchouqu6.R;
import com.example.mvpchouqu6.bean.Bean;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RcyAdapter extends RecyclerView.Adapter {
    private ArrayList<Bean.BodyBean.ResultBean> list;
    private Context context;

    public RcyAdapter(ArrayList<Bean.BodyBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_rcy, parent, false);
        ViewHolder holder = new ViewHolder(view);
        view.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if(onItem !=null){
                    onItem.click(holder.getLayoutPosition());
                }
                return false;
            }
        });
        return holder;
    }
public interface OnItem{
        void click(int position);
}
public  OnItem onItem;

    public void setOnItem(OnItem onItem) {
        this.onItem = onItem;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Bean.BodyBean.ResultBean resultBean = list.get(position);
        ViewHolder holder1= (ViewHolder) holder;
        holder1.tv_name.setText(resultBean.getTeacherName());
        holder1.tv_title.setText(resultBean.getTitle());
        Glide.with(context)
                .applyDefaultRequestOptions(new RequestOptions().circleCrop())
                .load(resultBean.getTeacherPic()).into(holder1.im);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static
    class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView im;
        public TextView tv_name;
        public TextView tv_title;
        public Button bnt;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.im = (ImageView) rootView.findViewById(R.id.im);
            this.tv_name = (TextView) rootView.findViewById(R.id.tv_name);
            this.tv_title = (TextView) rootView.findViewById(R.id.tv_title);
            this.bnt = (Button) rootView.findViewById(R.id.bnt);
        }

    }
}
