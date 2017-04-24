package com.example.tabtest;

import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.widget.TabHost;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final int TAB_WECHAT = 0;
    public static final int TAB_FRIEND = 1;
    public static final int TAB_CONTACTS = 2;
    public static final int TAB_SETTING = 3;

    private List<TabItem> mFragmentList;

    private FragmentTabHost mFragmentTabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initTabItemData();
    }

    /**
     * 更新新消息数量
     *
     * @param tabIndex tab 的索引
     * @param msgCount 消息数量
     */
    public void updateMsgCount(int tabIndex, int msgCount) {
        mFragmentList.get(tabIndex).setNewMsgCount(msgCount);
    }

    /**
     * 初始化 Tab 数据
     */
    private void initTabItemData() {
        mFragmentList = new ArrayList<>();
        mFragmentList.add(new TabItem(
                R.drawable.tab_wechat_normal,
                R.drawable.tab_wechat_selected,
                "微信",
                WeChatFragment.class, R.color.colorTabText
        ));

        mFragmentList.add(new TabItem(
                R.drawable.tab_friend_normal,
                R.drawable.tab_friend_selected,
                "朋友",
                FriendFragment.class, R.color.colorTabText
        ));

        mFragmentList.add(new TabItem(
                R.drawable.tab_contacts_normal,
                R.drawable.tab_contacts_selected,
                "联系人",
                ContactsFragment.class, R.color.colorTabText
        ));

        mFragmentList.add(new TabItem(
                R.drawable.tab_settings_normal,
                R.drawable.tab_settings_selected, "设置",
                SettingFragment.class, R.color.colorTabText
        ));

        mFragmentTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        // 绑定 FragmentManager
        mFragmentTabHost.setup(this, getSupportFragmentManager(), android.R.id.tabcontent);
        // 删除分割线
//        mFragmentTabHost.getTabWidget().setDividerDrawable(null);

        for (int i = 0; i < mFragmentList.size(); i++) {
            TabItem tabItem = mFragmentList.get(i);
            // 创建 tab
            TabHost.TabSpec tabSpec = mFragmentTabHost.newTabSpec(
                    tabItem.getTabText()).
                    setIndicator(tabItem.getTabView(MainActivity.this));
            // 将创建的 tab 添加到底部 tab 栏中（ @android:id/tabs ）
            // 将 Fragment 添加到页面中（ @android:id/tabcontent ）
            mFragmentTabHost.addTab(tabSpec, tabItem.getFragmentClass(), null);
            // 底部 tab 栏设置背景图片
            mFragmentTabHost.getTabWidget().setBackgroundResource(R.drawable.bottom_bar);

            // 默认选中第一个 tab
            if (i == 0) {
                tabItem.setChecked(true);
            } else {
                tabItem.setChecked(false);
            }
        }

        // 切换 tab 时，回调此方法
        mFragmentTabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                for (int i = 0; i < mFragmentList.size(); i++) {
                    TabItem tabItem = mFragmentList.get(i);
                    // 通过 tag 检查用户点击的是哪个 tab
                    if (tabId.equals(tabItem.getTabText())) {
                        tabItem.setChecked(true);
                    } else {
                        tabItem.setChecked(false);
                    }
                }
            }
        });
    }


}
