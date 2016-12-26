package com.xujun.fragmenttabhostdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * @ explain:
 * @ author：xujun on 2016/10/11 23:47
 * @ email：gdutxiaoxu@163.com
 */
public class TestFragemnt extends Fragment {

    TextView tvContent;
    String  tag="tag";
    private static final String TAG = "xujun";
    private View mView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView");


       if(mView==null){
           Log.i(TAG, "实例化View");
           mView = View.inflate(getContext(), R.layout.fragment_test, null);
           tvContent= (TextView) mView.findViewById(R.id.tv_content);

           Bundle arguments = getArguments();
           if(arguments!=null){
               String string = arguments.getString(tag);
               Log.i(TAG, "onCreateView:=string" +string);
               tvContent.setText(string);
           }
       }

        // 缓存的rootView需要判断是否已经被加过parent，如果有parent需要从parent删除，
        // 要不然会发生这个rootview已经有parent的错误。
        ViewGroup parent = (ViewGroup) mView.getParent();
        if (parent != null)
        {
            parent.removeView(mView);
        }


        return mView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
