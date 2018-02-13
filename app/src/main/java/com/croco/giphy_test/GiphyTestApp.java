package com.croco.giphy_test;

import android.app.Application;

import timber.log.Timber;

public class GiphyTestApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Timber.plant(new Timber.DebugTree());
    }
}
