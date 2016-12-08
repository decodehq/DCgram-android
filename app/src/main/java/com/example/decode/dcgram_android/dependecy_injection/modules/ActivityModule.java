package com.example.decode.dcgram_android.dependecy_injection.modules;

import android.app.Activity;
import android.content.Context;

import com.example.decode.dcgram_android.dependecy_injection.scopes.PerActivity;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

    private final Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    @PerActivity
    public Context context() {
        return activity;
    }
}
