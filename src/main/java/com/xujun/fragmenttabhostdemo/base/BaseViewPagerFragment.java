package com.xujun.fragmenttabhostdemo.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xujun.fragmenttabhostdemo.R;

/**
 * @author xujun  on 2016/12/26.
 * @email gdutxiaoxu@163.com
 */

public abstract class BaseViewPagerFragment extends Fragment {

    private View mView;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private PagerAdapter mViewPagerAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
            Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_base_view_pager, container, false);
        mView.findViewById(R.id.tabLayout);
        initView();
        return mView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewPagerAdapter = getViewPagerAdapter();
        mViewPager.setAdapter(mViewPagerAdapter);
        mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    protected abstract PagerAdapter getViewPagerAdapter();

    private void initView() {
        mTabLayout = (TabLayout) mView.findViewById(R.id.tabLayout);
        mViewPager = (ViewPager) mView.findViewById(R.id.view_pager);
    }
}
