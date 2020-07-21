package com.example.mvpchouqu2.fragment;

import android.media.tv.TvView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mvpchouqu2.R;
import com.example.mvpchouqu2.base.BaseFragment;
import com.example.mvpchouqu2.presenter.CollectPresenter;
import com.example.mvpchouqu2.view.CollectView;

import java.util.jar.Attributes;

import butterknife.BindView;
import butterknife.OnClick;

public class CollectFragment extends BaseFragment<CollectPresenter> implements CollectView {
@BindView(R.id.tv)
    TextView tv;
@BindView(R.id.bnt)
    Button bnt;


    @Override
    public void initPresent() {
        mPresenter=new CollectPresenter();
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {


    }

    @Override
    public void initView() {
    tv.setText("蓝胖子");
    }
    @OnClick({R.id.bnt})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.bnt:
//                mTxtName.setText("22222222222222222222");
              mPresenter.getString();
                break;
        }
    }
    @Override
    public int getLayout() {
        return R.layout.fragment_collect;
    }

    @Override
    public void showToast(String string) {
        Toast.makeText(getActivity(), string, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setName(String string) {
        tv.setText(string);
    }
}
