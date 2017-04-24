package star.yx.tabview;

import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;

import java.util.ArrayList;

/**
 * Created by yx on 16/4/3.
 */
public class TabLayout extends LinearLayout implements View.OnClickListener{

    private ArrayList<TabItem> tabs;
    private OnTabClickListener listener;
    private View selectView;
    private int tabCount;
    private Context mContext;


    public TabLayout(Context context) {
        this(context,null);

    }

    public TabLayout(Context context, AttributeSet attrs) {
        this(context, attrs,0);

    }

    public TabLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        mContext = context;
        initView();
    }

    private void initView(){
        setOrientation(HORIZONTAL);
    }

    public void setCurrentTab(int i) {
        if (i < tabCount && i >= 0) {
            View view = getChildAt(i);
        if (selectView != view) {
            view.setSelected(true);
            if (selectView != null) {
                selectView.setSelected(false);

            }
            selectView = view;
        }
        }
    }

    public void onDataChanged(int i, int badgeCount) {
        if (i < tabCount && i >= 0) {
            TabView view = (TabView) getChildAt(i);
            view.onDataChanged(badgeCount);
        }
    }

    public void initData(ArrayList<TabItem> tabs,OnTabClickListener listener){
        this.tabs=tabs;
        int size = tabs.size();
        this.listener=listener;
        LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT);
        params.weight=1;
        Point point = get(mContext);

        if(tabs!=null&&tabs.size()>0){
            tabCount=tabs.size();
            TabView mTabView=null;
            for(int i=0;i< tabs.size();i++){
                mTabView=new TabView(getContext());
                mTabView.setTag(tabs.get(i));
                mTabView.initData(tabs.get(i));
                mTabView.setOnClickListener(this);
                mTabView.setUnderViewVisibility(View.INVISIBLE);
                addView(mTabView,params);
            }
            setCurrentTab(0);
        }else{
            throw new IllegalArgumentException("tabs can not be empty");
        }


    }

    public Point get(Context context){
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        int width = wm.getDefaultDisplay().getWidth();
        int height = wm.getDefaultDisplay().getHeight();
        return new Point(width,height);
    }


    @Override
    public void onClick(View v) {
        listener.onTabClick((TabItem) v.getTag());

    }
    public interface OnTabClickListener{
        void onTabClick(TabItem tabItem);
    }
}
