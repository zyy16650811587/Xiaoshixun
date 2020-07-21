package com.example.day09zuoye;

import android.widget.TextView;
import android.widget.Toast;

import com.example.day09zuoye.adapter.VpAdapter;
import com.example.day09zuoye.base.BaseActivity;
import com.example.day09zuoye.bean.JavaBean;
import com.example.day09zuoye.fragment.ShouFragment;
import com.example.day09zuoye.fragment.ShouyeFragment;
import com.example.day09zuoye.presenter.MainPresent;
import com.example.day09zuoye.view.MainView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;

public class MainActivity extends BaseActivity<MainPresent> implements MainView {

    @BindView(R.id.tv)
    TextView tv;
    @BindView(R.id.tb)
    Toolbar tb;
    @BindView(R.id.vp)
    ViewPager vp;
    @BindView(R.id.tlb)
    TabLayout tlb;
    private ArrayList<Fragment> list;
    private VpAdapter vpAdapter;

    /* @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);
         ButterKnife.bind(this);
     }
 */
    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected int initLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
         setSupportActionBar(tb);
         list = new ArrayList<>();
        ShouyeFragment shouyeFragment = new ShouyeFragment();
        ShouFragment shouFragment = new ShouFragment();
        list.add(shouyeFragment);
        list.add(shouFragment);
        vpAdapter = new VpAdapter(getSupportFragmentManager(), list);
        vp.setAdapter(vpAdapter);
        tlb.setupWithViewPager(vp);
       tlb.getTabAt(0).setText("首页");
       tlb.getTabAt(1).setText("下载");



    }

    @Override
    protected void initPresenter() {
        mPresenter = new MainPresent();
    }

    @Override
    public void initData(List<JavaBean.DataBean.DatasBean> beans) {

    }

    @Override
    public void showTaost(String string) {
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show();
    }
}
