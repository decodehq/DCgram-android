package com.example.decode.dcgram_android;

import android.app.Application;

import com.example.decode.dcgram_android.dependecy_injection.components.ApplicationComponent;
import com.example.decode.dcgram_android.dependecy_injection.components.DaggerApplicationComponent;
import com.example.decode.dcgram_android.dependecy_injection.modules.ApplicationModule;
import com.example.decode.dcgram_android.presentation.navigation.ActivityNavigator;

import javax.inject.Inject;

import timber.log.Timber;

/**
 * Created by goran on 05.12.16..
 */
public class AndroidApplication extends Application {

    private ApplicationComponent applicationComponent;

    @Inject
    ActivityNavigator navigator;

    @Override
    public void onCreate() {
        super.onCreate();
        setupInjector();

        Timber.plant(new Timber.DebugTree());
    }

    private void setupInjector() {
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        applicationComponent.inject(this);
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

    public ActivityNavigator getActivityNavigator() {
        return navigator;
    }

}

