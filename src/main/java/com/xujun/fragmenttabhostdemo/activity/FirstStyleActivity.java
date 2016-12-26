package com.xujun.fragmenttabhostdemo.activity;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;

import com.xujun.fragmenttabhostdemo.FragmentInfo;
import com.xujun.fragmenttabhostdemo.MainFragmentFactory;
import com.xujun.fragmenttabhostdemo.R;

import java.util.List;

public class FirstStyleActivity extends AppCompatActivity {
    FragmentTabHost mTabHost;
    private TabWidget mTabWidget;
    private List<FragmentInfo> mFragmentEntities;
    private static final String TAG = "xujun";
    private static final String tag = "tag";
    public static final String[] mTiltles = new String[]{
            "首页", "课程", "直播", "个人"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_style);
        mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);

        mTabHost.setup(this, getSupportFragmentManager(), R.id.main_layout_content);
        mTabWidget = mTabHost.getTabWidget();
        //  去掉分割线
        mTabWidget.setDividerDrawable(null);
        mFragmentEntities = MainFragmentFactory.getInstance().getList();
        initListener();
        initData();


    }

    private void initData() {
        int size = mFragmentEntities.size();
        for (int i = 0; i < size; i++) {
            Log.i(TAG, "size:=" + size);
            FragmentInfo fragmentInfo = mFragmentEntities.get(i);
            String title = fragmentInfo.getTitle();
            TabHost.TabSpec tabSpec = mTabHost.newTabSpec(title).setIndicator(getTabView
                    (i));
            Bundle bundle = new Bundle();
            bundle.putString(tag, mTiltles[i]);

            mTabHost.addTab(tabSpec, fragmentInfo.getClz(), bundle);
        }
        updateTab(0);
    }

    private void initListener() {
        mTabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                int currentTab = mTabHost.getCurrentTab();
                Log.i(TAG, "onTabChanged：currentTab:=" + currentTab);
                updateTab(currentTab);
            }
        });
    }

    private View getTabView(int i) {
        View view = View.inflate(this, R.layout.tab_layout, null);
        int currentTab = mTabHost.getCurrentTab();
        Log.i(TAG, "currentTab:=" + currentTab);
        setSingleView(view, currentTab, i);
        return view;
    }

    private void setSingleView(View view, int currentTab, int index) {
        FragmentInfo fragmentInfo = mFragmentEntities.get(index);
        int[] imagIds = fragmentInfo.getImagIds();
        int[] colors = fragmentInfo.getColors();
        TextView tv = (TextView) view.findViewById(R.id.tab_tv);
        ImageView iv = (ImageView) view.findViewById(R.id.tab_icon);
        tv.setText(fragmentInfo.getTitle());
        Resources resources = getResources();
        if (index == currentTab) {

            tv.setTextColor(resources.getColor(colors[1]));
            iv.setImageDrawable(resources.getDrawable(imagIds[1]));
        } else {
            tv.setTextColor(getResources().getColor(colors[0]));
            iv.setImageDrawable(resources.getDrawable(imagIds[0]));
        }
    }

    private void updateTab(int currentTab) {

        int childCount = mTabWidget.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View view = mTabWidget.getChildTabViewAt(i);
            setSingleView(view, currentTab, i);

        }


    }
}
