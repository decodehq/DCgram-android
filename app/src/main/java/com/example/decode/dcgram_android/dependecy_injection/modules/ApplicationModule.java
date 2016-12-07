package com.example.decode.dcgram_android.dependecy_injection.modules;

import android.content.Context;

import com.example.decode.dcgram_android.AndroidApplication;
import com.example.decode.dcgram_android.domain.executor.PostExecutionThread;
import com.example.decode.dcgram_android.domain.executor.ThreadExecutor;
import com.example.decode.dcgram_android.domain.executor.impl.JobExecutor;
import com.example.decode.dcgram_android.threading.UIThread;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Dagger module that provides objects which will live during the application lifecycle.
 */
@Module
public class ApplicationModule {
    private final AndroidApplication application;

    public ApplicationModule(AndroidApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return this.application;
    }

    @Provides @Singleton
    ThreadExecutor provideThreadExecutor(JobExecutor jobExecutor) {
        return jobExecutor;
    }

    @Provides @Singleton
    PostExecutionThread providePostExecutionThread(UIThread uiThread) {
        return uiThread;
    }
}
