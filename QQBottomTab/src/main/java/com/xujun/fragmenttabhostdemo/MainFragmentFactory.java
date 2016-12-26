package com.xujun.fragmenttabhostdemo;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

/**
 * @ explain:
 * @ author：xujun on 2016/10/12 09:45
 * @ email：gdutxiaoxu@163.com
 */
public class MainFragmentFactory {
    private static volatile MainFragmentFactory mInstace;
    List<FragmentInfo> mList;
    private FragmentInfo mPerson;

    String[] mTiltles=new String[]{
            "首页","课程","直播","个人"
    };


    int [] mColors=new int[]{
        R.color.bg_tab_unselect  ,R.color.bg_tab_select
    };
    private String  tag = "tag";;

    private MainFragmentFactory() {

    }

    public static MainFragmentFactory getInstance() {

        if (mInstace == null) {
            synchronized (MainFragmentFactory.class) {
                if (mInstace == null) {
                    mInstace = new MainFragmentFactory();
                }
            }

        }
        return mInstace;

    }

    public void add(FragmentInfo entity) {
        if (mList == null) {
            mList = new ArrayList<>();
        }
        mList.add(entity);
    }

    public List<FragmentInfo> getList() {
        if (mList == null) {
            mList = new ArrayList<>();


            Bundle bundle = new Bundle();
            bundle.putString(tag,mTiltles[0]);
            FragmentInfo home = new FragmentInfo(TestFragemnt.class, "首页",  bundle,new int[]{
                    R.drawable.icon_home,R.drawable.icon_home_pressed
            },mColors);
            Bundle bundle1 = new Bundle();
            bundle.putString(tag,mTiltles[1]);
            FragmentInfo course = new FragmentInfo(TestFragemnt.class, "课程",  bundle1,new int[]{
                    R.drawable.icon_course,R.drawable.icon_course_pressed
            },mColors);
            Bundle bundle2 = new Bundle();
            bundle.putString(tag,mTiltles[2]);
            FragmentInfo zhibo = new FragmentInfo(TestFragemnt.class, "直播",  bundle2,new int[]{
                    R.drawable.icon_direct_seeding,R.drawable.icon_direct_seeding_pressed
            },mColors);
            Bundle bundle3 = new Bundle();
            bundle.putString(tag,mTiltles[3]);
            FragmentInfo person = new FragmentInfo(TestFragemnt.class, "个人",  bundle3,new int[]{
                    R.drawable.icon_me,R.drawable.icon_me_green_presed
            },mColors);

            mList.add(home);
            mList.add(course);
            mList.add(zhibo);
            mList.add(person);


        }
        return mList;
    }
}
