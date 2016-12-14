package com.example.decode.dcgram_android.data.google_signin;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;

import com.example.decode.dcgram_android.dependecy_injection.scopes.PerActivity;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;

import javax.inject.Inject;

/**
 * Created by goran on 12.12.16..
 */
@PerActivity
public class GoogleAuthManager implements AuthInterface, GoogleApiClient.OnConnectionFailedListener {

    public static final int RC_SIGN_IN = 9001;

    private GoogleApiClient googleApiClient;
    private Activity activity;

    @Inject
    public GoogleAuthManager(Activity activity, GoogleApiClient googleApiClient) {
        this.activity = activity;

        this.googleApiClient = googleApiClient;
    }

    @Override
    public void googleLogin() {
        Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(googleApiClient);
        activity.startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
}
