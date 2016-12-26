package com.xujun.fragmenttabhostdemo.adapter;

import android.content.Context;

import com.xujun.fragmenttabhostdemo.R;
import com.xujun.fragmenttabhostdemo.base.BaseRecyclerAdapter;
import com.xujun.fragmenttabhostdemo.base.BaseRecyclerHolder;

import java.util.List;

/**
 * @author xujun  on 2016/12/26.
 * @email gdutxiaoxu@163.com
 */

public class StringAdapter extends BaseRecyclerAdapter<String> {

    public StringAdapter(Context context, List<String> datas) {
        super(context, R.layout.item_string, datas);
    }

    @Override
    public void convert(BaseRecyclerHolder holder, String item, int position) {
        holder.setText(R.id.tv_content,item);

    }
}
