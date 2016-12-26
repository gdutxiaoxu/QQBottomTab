package com.xujun.fragmenttabhostdemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * @ explain:
 * @ author：xujun on 2016/10/12 09:42
 * @ email：gdutxiaoxu@163.com
 */
public class FragmentInfo {

    private Class<? extends Fragment> clz;
    private String title="";
    private Bundle arugment;

//    mImagIds[0] 未选中的图片资源，mImagIds[1] 选中的图片资源，
    private int[] mImagIds=new int[2];
//    mColors【0】 未选中字体的显示颜色， mColors【1】 未选中字体的显示颜色
    private int [] mColors=new int[2];

    public FragmentInfo(Class<? extends Fragment> clz, String title, Bundle arugment, int[]
            imagIds, int[] colors) {
        this.clz = clz;
        this.title = title;
        this.arugment = arugment;
        mImagIds = imagIds;
        mColors = colors;
    }

    public Class<? extends Fragment> getClz() {
        return clz;
    }

    public void setClz(Class<? extends Fragment> clz) {
        this.clz = clz;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Bundle getArugment() {
        return arugment;
    }

    public void setArugment(Bundle arugment) {
        this.arugment = arugment;
    }

    public int[] getImagIds() {
        return mImagIds;
    }

    public void setImagIds(int[] imagIds) {
        mImagIds = imagIds;
    }

    public int[] getColors() {
        return mColors;
    }

    public void setColors(int[] colors) {
        mColors = colors;
    }
}
