package com.example.decode.dcgram_android.presentation.navigation;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.example.decode.dcgram_android.dependecy_injection.scopes.PerActivity;
import com.example.decode.dcgram_android.presentation.ui.activities.HomeActivity;
import com.example.decode.dcgram_android.presentation.ui.activities.SignInActivity;

import javax.inject.Inject;
import javax.inject.Singleton;

import timber.log.Timber;

/**
 * Class used to navigate through the application.
 */
@Singleton
public class ActivityNavigator {

    @Inject
    public ActivityNavigator() {
        //empty
    }

    public void goToSignUp(Activity context) {
        Intent intent = new Intent(context, SignInActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
        context.finish();
    }


    public void goToHomeScreen(Activity context) {
        Intent intent = new Intent(context, HomeActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
        context.finish();
    }
}
