package com.example.mvpchouqu3.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment<P extends BasePresent> extends Fragment implements BaseView {
    public P mPresenter;
    private Unbinder undind;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getlayout(), null);
        undind = ButterKnife.bind(this, view);
        initPresent();
        if(mPresenter !=null){
            mPresenter.bingView(this);
        }
        initView();
        initData();
        initListener();
        return view;
    }

    protected abstract void initListener();

    protected abstract void initData();

    protected abstract void initView();

    protected abstract void initPresent();

    protected abstract int getlayout();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if(mPresenter !=null){
            undind.unbind();
            mPresenter.remove();
            mPresenter=null;
        }
    }
}
