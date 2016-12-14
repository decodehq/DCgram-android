package com.example.decode.dcgram_android.dependecy_injection.components;

import com.example.decode.dcgram_android.dependecy_injection.modules.ActivityModule;
import com.example.decode.dcgram_android.dependecy_injection.modules.HomeModule;
import com.example.decode.dcgram_android.dependecy_injection.scopes.PerActivity;
import com.example.decode.dcgram_android.presentation.ui.activities.HomeActivity;

import dagger.Component;

/**
 * Created by goran on 14.12.16..
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class,
        modules = { HomeModule.class, ActivityModule.class })
public interface HomeComponent {

    void inject(HomeActivity homeActivity);

}
