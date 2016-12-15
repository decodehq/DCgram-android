package com.example.decode.dcgram_android.presentation.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.decode.dcgram_android.AndroidApplication;
import com.example.decode.dcgram_android.R;
import com.example.decode.dcgram_android.data.google_signin.AuthInterface;
import com.example.decode.dcgram_android.data.google_signin.GoogleAuthManager;
import com.example.decode.dcgram_android.dependecy_injection.components.ApplicationComponent;
import com.example.decode.dcgram_android.dependecy_injection.components.DaggerSignUpComponent;
import com.example.decode.dcgram_android.dependecy_injection.components.SignUpComponent;
import com.example.decode.dcgram_android.dependecy_injection.modules.ActivityModule;
import com.example.decode.dcgram_android.dependecy_injection.modules.SignUpModule;
import com.example.decode.dcgram_android.presentation.base.BaseActivity;
import com.example.decode.dcgram_android.presentation.presenters.SignInPresenter;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.SignInButton;

import javax.inject.Inject;

import butterknife.BindView;
import timber.log.Timber;

public class SignInActivity extends ToolbarActivity implements SignInPresenter.View, View.OnClickListener {

    @BindView(R.id.sign_in_button)
    public SignInButton signInButton;

    @Inject
    AuthInterface authInterface;
    @Inject
    SignInPresenter signInPresenter;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_sign_in;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        injectSignInComponent();

        signInButton.setOnClickListener(this);

        signInPresenter.checkUserExists();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Timber.d("onResume");
    }

    @Override
    public Context getContext() {
        return getApplicationContext();
    }

    public void googleSignInClicked() {
        authInterface.googleLogin();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        hideProgress();
        if (requestCode == GoogleAuthManager.RC_SIGN_IN) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            if (result.isSuccess()) {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = result.getSignInAccount();
                injectSignInComponent();
                Timber.d("account.getIdToken(): " + account.getIdToken());
                Timber.d("account.getId(): " + account.getId());
                signInPresenter.firebaseAuthWithGoogle(account.getIdToken());
//                firebaseAuthWithGoogle(account);
            } else {
                showToastMessage(getString(R.string.google_login_failed));
            }
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.sign_in_button:
                showProgress();
                googleSignInClicked();
                break;
        }
    }

    @Override
    public void successfulSignIn() {
        Timber.d("getNavigator(): " + getNavigator());
        showToastMessage("Success");
    }

    @Override
    public void failedSignIn() {
        showToastMessage("Failed");
    }

    @Override
    public void goToHomeScreen() {
        Timber.d("goToHomeScreen");
        Timber.d("getNavigator(): " + getNavigator());
        getNavigator().goToHomeScreen(this);
    }

    public void injectSignInComponent() {
        ApplicationComponent appComponent = ((AndroidApplication) getApplication()).getApplicationComponent();

        SignUpComponent signUpComponent = DaggerSignUpComponent.builder()
                .activityModule(new ActivityModule(this))
                .signUpModule(new SignUpModule(this))
                .applicationComponent(appComponent)
                .build();
        signUpComponent.inject(this);
    }

    @Override
    protected String getToolbarTitle() {
        return getString(R.string.login_title);
    }
}
