package com.xujun.fragmenttabhostdemo.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.xujun.fragmenttabhostdemo.fragment.ItemFragement;
import com.xujun.fragmenttabhostdemo.R;
import com.xujun.fragmenttabhostdemo.base.BaseFragmentAdapter;

import java.util.ArrayList;
import java.util.List;

public class SecondStyleActivity extends AppCompatActivity {

    public static final String[] mTiltles = new String[]{
            "首页", "课程", "直播", "个人"
    };
    private List<Fragment> mFragments;
    ViewPager mViewPager;
    RadioGroup mRg;
    private int position = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_style);
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        mRg = (RadioGroup) findViewById(R.id.rg);
        initListener();
        initData();


    }

    private void initData() {
        mFragments = new ArrayList<>();
        for (int i = 0; i < mTiltles.length; i++) {
            ItemFragement itemFragement = ItemFragement.newInstance(mTiltles[i]);
            mFragments.add(itemFragement);
        }
        BaseFragmentAdapter fragmentAdapter = new BaseFragmentAdapter
                (getSupportFragmentManager(), mFragments, mTiltles);

        mViewPager.setAdapter(fragmentAdapter);
        //  设置左右页面 能缓存的fragment 数量
        mViewPager.setOffscreenPageLimit(fragmentAdapter.getCount() - 1);
        mViewPager.setCurrentItem(position);
        ((RadioButton) mRg.getChildAt(position)).setChecked(true);
    }

    private void initListener() {
        mViewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                RadioButton radioButton = (RadioButton) mRg.getChildAt(position);
                radioButton.setChecked(true);
            }
        });

        mRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = (RadioButton) group.findViewById(checkedId);
                if (!rb.isChecked()) {
                    return;
                }
                switch (checkedId) {
                    case R.id.rb_home:
                        position = 0;
                        break;

                    case R.id.rb_course:
                        position = 1;
                        break;

                    case R.id.rb_direct_seeding:
                        position = 2;
                        break;

                    case R.id.rb_me:
                        position = 3;
                        break;
                    default:
                        position = 0;
                        break;

                }
                mViewPager.setCurrentItem(position);
            }
        });
    }
}
