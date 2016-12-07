package com.example.decode.dcgram_android;

import android.app.Application;

import timber.log.Timber;

/**
 * Created by goran on 05.12.16..
 */
public class AndroidApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Timber.plant(new Timber.DebugTree());
    }
}

