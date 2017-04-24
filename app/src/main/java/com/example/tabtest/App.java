package com.example.tabtest;

import android.app.Application;

/**
 * @author meitu.xujun  on 2017/4/20 13:52
 * @version 0.1
 */

public class App extends Application {

    static App mApp;

    @Override
    public void onCreate() {
        super.onCreate();
        mApp=this;
    }

    public static App getInstance() {
        return mApp;
    }
}
