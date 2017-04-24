package star.yx.tabview;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by yx on 16/4/3.
 */

public class TabView extends RelativeLayout implements View.OnClickListener{

    private ImageView mTabImage;
    private TextView mTabLable;
    private View mUnderLine;
    private View mLl;
    private TextView mTvMsgCount;

    private static final String TAG = "TabView";

    public TabView(Context context) {
        super(context);
        initView(context);
    }

    public TabView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public TabView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initView(context);
    }

    private void initView(Context context){
        setGravity(Gravity.CENTER);
        LayoutInflater.from(context).inflate(R.layout.tab_view,this,true);
        mTabImage=(ImageView)findViewById(R.id.tab_image);
        mTabLable=(TextView)findViewById(R.id.tab_lable);
        mUnderLine=findViewById(R.id.under_line);
        mUnderLine.setVisibility(View.GONE);
//        mLl=findViewById(R.id.ll);
        mTvMsgCount =(TextView)findViewById(R.id.tv_new_msg);

    }

    public void initData(TabItem tabItem){
        mTabImage.setImageResource(tabItem.imageResId);
        mTabLable.setText(tabItem.lableResId);
        String count = tabItem.count;
        mTvMsgCount.setText(TextUtils.isEmpty(count)?"" + "":count);
        setHintVisibility(View.GONE);
    }

    public void setUnderViewVisibility(int visibility){
        mUnderLine.setVisibility(visibility);
    }

    public void setHintVisibility(int visibility){
        mTvMsgCount.setVisibility(visibility);
    }


    private int getChildMode(int widthMode) {
        int childWidthMode;
        if (widthMode == MeasureSpec.EXACTLY) {
            childWidthMode = MeasureSpec.AT_MOST;
        } else {
            childWidthMode = widthMode;
        }
        return childWidthMode;
    }

    @Override
    public void onClick(View v) {

    }
    public void onDataChanged(int badgeCount) {
        //  TODO notify new message, change the badgeView
    }
}
