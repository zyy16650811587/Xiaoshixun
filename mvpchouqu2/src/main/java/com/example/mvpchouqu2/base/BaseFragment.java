package com.example.mvpchouqu2.base;

import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment<P extends BasePresenter> extends Fragment implements BaseView {
    public P mPresenter;
    private View view;
    private Unbinder undinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(getLayout(), null);
        undinder = ButterKnife.bind(this, view);
        initPresent();
        if(mPresenter !=null){
            mPresenter.bingView(this);
        }
        initView();
        initData();
        initListener();
        return view;
    }

    public abstract void initPresent();

    public abstract void initListener();

    public abstract void initData();

    public abstract void initView();

    public abstract int getLayout();
}
