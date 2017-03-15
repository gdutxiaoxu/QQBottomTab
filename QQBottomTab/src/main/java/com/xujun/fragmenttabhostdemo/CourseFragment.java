package com.xujun.fragmenttabhostdemo;

import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;

import com.xujun.fragmenttabhostdemo.base.BaseFragmentAdapter;
import com.xujun.fragmenttabhostdemo.base.BaseViewPagerFragment;
import com.xujun.fragmenttabhostdemo.fragment.CourseListFragment;
import com.xujun.fragmenttabhostdemo.fragment.CourseListFragmentWithHeadView;

import java.util.ArrayList;

/**
 * @author xujun  on 2016/12/26.
 * @email gdutxiaoxu@163.com
 */

public class CourseFragment extends BaseViewPagerFragment {

    String[] mTitles=new String[]{
        "语文","数学","英语","化学","物理","生物","政治"
    };
    private ArrayList<Fragment> mFragments;

    @Override
    protected PagerAdapter getViewPagerAdapter() {
        mFragments = new ArrayList<>();
        for(int i=0;i<mTitles.length;i++){
            String title=mTitles[i];
            if(i%2==0){
                CourseListFragment courseListFragment = CourseListFragment.newInstance(title, i);
                mFragments.add(courseListFragment);
            }else{
                CourseListFragmentWithHeadView courseListFragmentWithHeadView =
                        CourseListFragmentWithHeadView.newInstance(title, i);
                mFragments.add(courseListFragmentWithHeadView);
            }


        }

        BaseFragmentAdapter adapter = new BaseFragmentAdapter(getChildFragmentManager
                (), mFragments, mTitles);


        return adapter;
    }
}
