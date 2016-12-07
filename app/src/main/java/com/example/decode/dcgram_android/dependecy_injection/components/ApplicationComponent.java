package com.example.decode.dcgram_android.dependecy_injection.components;

import android.content.Context;

import com.example.decode.dcgram_android.dependecy_injection.modules.ApplicationModule;
import com.example.decode.dcgram_android.domain.executor.PostExecutionThread;
import com.example.decode.dcgram_android.domain.executor.ThreadExecutor;
import com.example.decode.dcgram_android.presentation.base.BaseActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * A component whose lifetime is the life of the application.
 */
@Singleton // Constraints this component to one-per-application or unscoped bindings.
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    void inject(BaseActivity baseActivity);

    //Exposed to sub-graphs.
    Context context();
    ThreadExecutor threadExecutor();
    PostExecutionThread postExecutionThread();
}
