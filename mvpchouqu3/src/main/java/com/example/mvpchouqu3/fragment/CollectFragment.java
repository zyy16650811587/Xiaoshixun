package com.example.mvpchouqu3.fragment;

import android.widget.Toast;

import com.example.mvpchouqu3.FuliBean;
import com.example.mvpchouqu3.R;
import com.example.mvpchouqu3.apapter.RcyAdapter;
import com.example.mvpchouqu3.base.BaseFragment;
import com.example.mvpchouqu3.present.CollectPresenter;
import com.example.mvpchouqu3.view.Collectview;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;

public  class CollectFragment extends BaseFragment<CollectPresenter> implements Collectview {
@BindView(R.id.rcy)
    RecyclerView rcy;
    private ArrayList<FuliBean.ResultsBean> list;
    private RcyAdapter rcyAdapter;

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        rcy.setLayoutManager(new LinearLayoutManager(getContext()));
        rcy.addItemDecoration(new DividerItemDecoration(getContext(),LinearLayoutManager.VERTICAL));
        list = new ArrayList<>();
        rcyAdapter = new RcyAdapter(list, getContext());
        rcy.setAdapter(rcyAdapter);
    }

    @Override
    protected void initPresent() {
    mPresenter=new CollectPresenter();
    }

    @Override
    protected int getlayout() {
        return R.layout.collect_fragment;
    }

    @Override
    public void setFuli(List<FuliBean.ResultsBean> beans) {
        list.addAll(beans);
        rcyAdapter.notifyDataSetChanged();
    }

    @Override
    public void showToast(String str) {
        Toast.makeText(getContext(), str, Toast.LENGTH_SHORT).show();
    }
}
