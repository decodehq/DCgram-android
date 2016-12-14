package com.example.decode.dcgram_android.dependecy_injection.modules;

import android.content.Context;

import com.example.decode.dcgram_android.AndroidApplication;
import com.example.decode.dcgram_android.R;
import com.example.decode.dcgram_android.data.firebase.firebase_auth.FirebaseAuthInterface;
import com.example.decode.dcgram_android.data.firebase.firebase_auth.FirebaseAuthManager;
import com.example.decode.dcgram_android.dependecy_injection.scopes.PerActivity;
import com.example.decode.dcgram_android.domain.executor.PostExecutionThread;
import com.example.decode.dcgram_android.domain.executor.ThreadExecutor;
import com.example.decode.dcgram_android.domain.executor.impl.JobExecutor;
import com.example.decode.dcgram_android.presentation.navigation.ActivityNavigator;
import com.example.decode.dcgram_android.threading.UIThread;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.GoogleApiClient;

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

    @Provides @Singleton
    GoogleApiClient providesGoogleApiClient() {
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(application.getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        return new GoogleApiClient.Builder(application)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();
    }
}
