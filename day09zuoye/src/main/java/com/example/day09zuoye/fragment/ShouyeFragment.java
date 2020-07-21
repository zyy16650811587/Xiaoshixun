package com.example.day09zuoye.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.day09zuoye.R;
import com.example.day09zuoye.adapter.RcyAdapter;
import com.example.day09zuoye.base.BaseFragment;
import com.example.day09zuoye.bean.JavaBean;
import com.example.day09zuoye.presenter.MainPresent;
import com.example.day09zuoye.view.MainView;

import java.util.ArrayList;
import java.util.List;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShouyeFragment extends BaseFragment<MainPresent> implements MainView {

    @BindView(R.id.rcy)
    RecyclerView rcy;
//    @BindView(R.id.cv)
//    CardView cv;
    private ArrayList<JavaBean.DataBean.DatasBean> datasBeans;
    private RcyAdapter rcyAdapter;

    @Override
    public MainPresent initPresent() {
        return new MainPresent();
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {
        mPresenter.wanluo();
    }

    @Override
    public void initView() {
    rcy.setLayoutManager(new LinearLayoutManager(getActivity()));
    rcy.addItemDecoration(new DividerItemDecoration(getContext(),LinearLayoutManager.VERTICAL));
        datasBeans = new ArrayList<>();
        rcyAdapter = new RcyAdapter(datasBeans, getActivity());
        rcy.setAdapter(rcyAdapter);
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_shouye;
    }

    private static final String TAG = "ShouyeFragment";
    @Override
    public void initData(List<JavaBean.DataBean.DatasBean> beans) {
        datasBeans.addAll(beans);
        Log.i(TAG, "initData: " + datasBeans.toString());
        rcyAdapter.notifyDataSetChanged();
    }

    @Override
    public void showTaost(String string) {
        Toast.makeText(getContext(), string, Toast.LENGTH_SHORT).show();
    }
}
