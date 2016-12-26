package com.xujun.fragmenttabhostdemo.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.xujun.fragmenttabhostdemo.R;
import com.xujun.fragmenttabhostdemo.base.BasePageFragment;

/**
 * @ explain:
 * @ author：xujun on 2016/10/15 11:09
 * @ email：gdutxiaoxu@163.com
 */
public class ItemFragement extends BasePageFragment {

    public static final String tag="tag";
    private String mText="";
    protected TextView mTextView;

    public static ItemFragement newInstance(String text){
        ItemFragement itemFragement = new ItemFragement();
        Bundle bundle = new Bundle();
        if(text!=null){
            bundle.putString(tag,text);
            itemFragement.setArguments(bundle);
        }
        return itemFragement;
    }
    private static final String TAG = "xujun";

    @Override
    protected void initView(View view) {
        mTextView= (TextView) mView.findViewById(R.id.tv_content);
        Bundle arguments = getArguments();
        if(arguments!=null){
            mText = arguments.getString(tag);
            mTextView.setText(mText);
        }
    }

    @Override
    protected void initData() {
        mTextView.setText(mText);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_test;
    }

    @Override
    public void fetchData() {
        Log.i(TAG, "fetchData" );
    }
}
