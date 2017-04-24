package com.example.tabtest;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * @author meitu.xujun  on 2017/4/20 13:50
 * @version 0.1
 */

class TabItem {

    private final int mSelectTextcolor;
    private ImageView mIvTab;

    /**
     * 正常状态的图片
     */
    private int imageNormal;

    /**
     * 选中状态的图片
     */
    private int imageSelected;

    private TextView mTvTab;

    /**
     * 文字
     */
    private String tabText;

    /**
     * Fragment
     */
    private Class<? extends Fragment> fragmentClass;

    private View mTabView;

    /**
     * 新消息
     */
    private TextView mTvNewMsg;

    public TabItem(int imageNormal, int imageSelected, String text, Class<? extends Fragment> fragmentClass,int selectTextcolor) {
        this.imageNormal = imageNormal;
        this.imageSelected = imageSelected;
        this.tabText = text;
        this.fragmentClass = fragmentClass;
        mSelectTextcolor = selectTextcolor;
    }

    public Class<? extends Fragment> getFragmentClass() {
        return fragmentClass;
    }

    /**
     * 获取 tab 上的文字
     *
     * @return tab 上的文字
     */
    public String getTabText() {
        return tabText;
    }

    /**
     * 设置选中
     *
     * @param checked 是否选中
     */
    public void setChecked(boolean checked) {
        if (checked) {
            mTvTab.setTextColor(mSelectTextcolor);
            mIvTab.setImageResource(imageSelected);
        } else {
            mTvTab.setTextColor(Color.WHITE);
            mIvTab.setImageResource(imageNormal);
        }
    }

    public View getTabView(Context context) {
        mTabView = View.inflate(context, R.layout.view_tab, null);
        mIvTab = (ImageView) mTabView.findViewById(R.id.iv_tab);
        mTvTab = (TextView) mTabView.findViewById(R.id.tv_tab);
        mTvNewMsg = (TextView) mTabView.findViewById(R.id.tv_new_msg);
        mIvTab.setImageResource(imageNormal);
        mTvTab.setText(tabText);
        return mTabView;
    }

    /**
     * 设置新消息数量
     */
    public void setNewMsgCount(int count) {
        if (count > 0) {
            mTvNewMsg.setText(String.valueOf(count));
        }
        mTvNewMsg.setBackgroundResource(R.drawable.ic_new_msg);
    }
}