package com.example.decode.dcgram_android.dependecy_injection.modules;

import android.app.Activity;
import android.content.Context;

import com.example.decode.dcgram_android.data.firebase.firebase_auth.FirebaseAuthInterface;
import com.example.decode.dcgram_android.data.firebase.firebase_auth.FirebaseAuthManager;
import com.example.decode.dcgram_android.data.repository.UserDataRepository;
import com.example.decode.dcgram_android.dependecy_injection.scopes.PerActivity;
import com.example.decode.dcgram_android.domain.repository.UserRepository;

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
    public Activity activity() {
        return activity;
    }

    @PerActivity
    @Provides
    public UserRepository provideRepository(UserDataRepository userDataRepository) {
        return userDataRepository;
    }

    @PerActivity
    @Provides
    public FirebaseAuthInterface provideFirebaseAuthInterface(FirebaseAuthManager firebaseAuthManager) {
        return firebaseAuthManager;
    }
}
