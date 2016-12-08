package com.example.decode.dcgram_android.dependecy_injection.components;

import com.example.decode.dcgram_android.dependecy_injection.modules.ActivityModule;
import com.example.decode.dcgram_android.dependecy_injection.modules.MessageModule;
import com.example.decode.dcgram_android.dependecy_injection.scopes.PerActivity;
import com.example.decode.dcgram_android.presentation.ui.activities.MainActivity;

import dagger.Component;


@PerActivity
@Component (dependencies = ApplicationComponent.class,
        modules = {
                ActivityModule.class,
                   MessageModule.class
        })
public interface MessageComponent {

    void inject(MainActivity activity);
}
