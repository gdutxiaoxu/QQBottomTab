package com.xujun.fragmenttabhostdemo.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.xujun.fragmenttabhostdemo.CourseFragment;
import com.xujun.fragmenttabhostdemo.LUtils;
import com.xujun.fragmenttabhostdemo.R;
import com.xujun.fragmenttabhostdemo.fragment.ItemFragement;

import java.util.ArrayList;
import java.util.List;

public class FourActivity extends AppCompatActivity {

    FrameLayout mFl;
    RadioGroup mRg;
    private FragmentManager mFragmentManager;

    private int position = 0;

    public static final String[] mTiltles = new String[]{
            "首页", "课程", "直播", "个人"
    };
    private List<Fragment> mFragments;
    private Fragment mCurFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);
        mFl = (FrameLayout) findViewById(R.id.fl);
        mRg = (RadioGroup) findViewById(R.id.rg);
        mFragments = new ArrayList<>();
        for (int i = 0; i < mTiltles.length; i++) {

            if(i==1){
                CourseFragment courseFragment = new CourseFragment();
                mFragments.add(courseFragment);
            }else{
                ItemFragement itemFragement = ItemFragement.newInstance(mTiltles[i]);
                mFragments.add(itemFragement);
            }

        }
        mCurFragment = mFragments.get(position);
        replaceFragment(mCurFragment);

        ((RadioButton)mRg.getChildAt(position)).setChecked(true);

        initListener();
    }

    private void initListener() {
        mRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                RadioButton radioButton = (RadioButton) group.findViewById(checkedId);

                if (false == radioButton.isChecked()) {
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
                LUtils.i("position==" + position);

                Fragment to = mFragments.get(position);
                showFragment(mCurFragment, to);
                mCurFragment = to;

            }

        });
    }

    private void showFragment(Fragment from, Fragment to) {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = supportFragmentManager.beginTransaction();
        if (!to.isAdded()) {    // 先判断是否被add过
            transaction.hide(from).add(R.id.fl, to).commit(); // 隐藏当前的fragment，add下一个到Activity中
        } else {
            transaction.hide(from).show(to).commit(); // 隐藏当前的fragment，显示下一个
        }

    }

    /**
     * 这个方法用老替换fragment
     * xujun
     * 2016/5/3 17:28.
     */

    private void replaceFragment(Fragment fragmeny) {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fl, fragmeny).commit();
    }

}
