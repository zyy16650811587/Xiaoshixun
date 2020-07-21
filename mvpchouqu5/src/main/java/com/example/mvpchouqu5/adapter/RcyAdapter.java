package com.example.mvpchouqu5.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mvpchouqu5.R;
import com.example.mvpchouqu5.bean.Bean;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RcyAdapter extends RecyclerView.Adapter {
    private ArrayList<Bean.DataBean.DatasBean> list;
    private Context context;
    private OnItemlisten onItemlisten;
    private ViewHolder1 holder1;

    public void setOnItemlisten(OnItemlisten onItemlisten) {
        this.onItemlisten = onItemlisten;
    }
    public RcyAdapter(ArrayList<Bean.DataBean.DatasBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    int ITEM_1 = 1;
    int ITEM_2 = 2;

    @Override
    public int getItemViewType(int position) {
        if (position % 2 == 0) {
            return ITEM_1;
        } else {
            return ITEM_2;
        }

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == ITEM_1) {
            View view = LayoutInflater.from(context).inflate(R.layout.item_rcy, parent, false);
            ViewHolder1 holder1 = new ViewHolder1(view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(onItemlisten !=null){
                        onItemlisten.click(holder1.getLayoutPosition());
                    }
                }
            });

            return holder1;
        } else {
            View view = LayoutInflater.from(context).inflate(R.layout.item_rcy2, parent, false);
            ViewHolder2 holder2 = new ViewHolder2(view);
            view.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    if(onItemlisten !=null){
                        onItemlisten.click(holder2.getLayoutPosition());
                    }
                    return false;
                }
            });

            return holder2;
        }

    }
    public interface OnItemlisten{
        void click(int position);
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Bean.DataBean.DatasBean bean = list.get(position);
        if(getItemViewType(position)==ITEM_1){
            holder1 = (ViewHolder1) holder;
            holder1.tv_author.setText(bean.getChapterName());
            holder1.tv_time.setText(bean.getNiceDate());
            holder1.tv_title.setText(bean.getTitle());

        }else{
            ViewHolder2 holder2= (ViewHolder2) holder;
            holder2.tv_author.setText(bean.getChapterName());
            holder2.tv_time.setText(bean.getNiceDate());
            holder2.tv_title.setText(bean.getTitle());
            Glide.with(context).load(bean.getEnvelopePic()).into(holder2.im);
        }


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static
    class ViewHolder1 extends RecyclerView.ViewHolder {
        public View rootView;
        public TextView tv_author;
        public TextView tv_time;
        public TextView tv_title;

        public ViewHolder1(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.tv_author = (TextView) rootView.findViewById(R.id.tv_author);
            this.tv_time = (TextView) rootView.findViewById(R.id.tv_time);
            this.tv_title = (TextView) rootView.findViewById(R.id.tv_title);
        }

    }

    public static
    class ViewHolder2 extends RecyclerView.ViewHolder {
        public View rootView;
        public TextView tv_author;
        public TextView tv_time;
        public TextView tv_title;
        public ImageView im;

        public ViewHolder2(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.tv_author = (TextView) rootView.findViewById(R.id.tv_author);
            this.tv_time = (TextView) rootView.findViewById(R.id.tv_time);
            this.tv_title = (TextView) rootView.findViewById(R.id.tv_title);
            this.im = (ImageView) rootView.findViewById(R.id.im);
        }

    }
}
