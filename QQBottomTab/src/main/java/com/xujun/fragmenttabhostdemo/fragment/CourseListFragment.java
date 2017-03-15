package com.xujun.fragmenttabhostdemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xujun.fragmenttabhostdemo.LUtils;
import com.xujun.fragmenttabhostdemo.R;
import com.xujun.fragmenttabhostdemo.adapter.StringAdapter;
import com.xujun.fragmenttabhostdemo.base.BasePageFragment;
import com.xujun.fragmenttabhostdemo.base.EndlessRecyclerOnScrollListener;

import java.util.ArrayList;

/**
 * @author xujun  on 2016/12/26.
 * @email gdutxiaoxu@163.com
 */

public class CourseListFragment extends BasePageFragment {

    public static final String KEY_TITLE="key_title";
    public static final String KEY_POSITION="key_position";
    private String mTitle="";
    private int mPosition=-1;

    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView mRecyclerView;

    TextView tvContent;
    private ArrayList<String> mList;
    private StringAdapter mAdapter;
    private EndlessRecyclerOnScrollListener mListener;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        mTitle = arguments.getString(KEY_TITLE);
        mPosition = arguments.getInt(KEY_POSITION);
        LUtils.i(getClass().getSimpleName() + ">>>>>>>>>>>　　onCreate   mPosition="  +mPosition);
    }

    public static CourseListFragment newInstance(String title, int position){
        CourseListFragment courseListFragment = new CourseListFragment();
        Bundle bundle = new Bundle();
        bundle.putString(KEY_TITLE,title);
        bundle.putInt(KEY_POSITION,position);
        courseListFragment.setArguments(bundle);
        return courseListFragment;
    }
    @Override
    protected void initView(View view) {

        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipeRefreshLayout);
        mRecyclerView =(RecyclerView) view.findViewById(R.id.recyclerView);
    }

    @Override
    protected void initData() {
        LinearLayoutManager layout = new LinearLayoutManager(mContext);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshData();
            }


        });
        mListener = new EndlessRecyclerOnScrollListener(layout) {
            @Override
            public void onLoadMore(int current_page) {
                Log.i(TAG, "onLoadMore: current_page=" + current_page);
                loadMore();
            }
        };
        mRecyclerView.addOnScrollListener(mListener);
        super.initData();
        mList = new ArrayList<>();

        for(int i = 0; i< 20; i++){
            mList.add("I am  "+i+" Item");
        }
        mAdapter = new StringAdapter(mContext, mList);

        mRecyclerView.setLayoutManager(layout);
        mRecyclerView.setAdapter(mAdapter);


    }

    private void refreshData() {
        Runnable runnable = new Runnable() {

            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(mList==null){
                    mList=new ArrayList<String>();
                }
                mList.clear();
                int start=mList.size();
                int end=start+20;
                for(int i=start;i<end;i++){
                    mList.add("I am  "+i+" Item");
                }
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mAdapter.notifyDataSetChanged();
                        swipeRefreshLayout.setRefreshing(false);
                        mListener.reset();
                    }
                });

            }
        };
        new Thread(runnable).start();
    }

    private void loadMore() {

        Runnable runnable = new Runnable() {



            @Override
            public void run() {
                try {
                    Thread.sleep(1200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(mList==null){
                    mList=new ArrayList<String>();
                }
                int start=mList.size();
                int end=start+20;
                for(int i=start;i<end;i++){
                    mList.add("I am  "+i+" Item");
                }
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mAdapter.notifyDataSetChanged();
                    }
                });

            }
        };
        new Thread(runnable).start();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_course_list;
    }

    @Override
    public void fetchData() {

    }



}
