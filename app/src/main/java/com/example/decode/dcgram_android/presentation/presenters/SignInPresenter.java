package com.example.decode.dcgram_android.presentation.presenters;

import com.example.decode.dcgram_android.presentation.base.BaseView;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

/**
 * Created by goran on 09.12.16..
 */

public interface SignInPresenter {

    interface View extends BaseView {
        void successfulSignIn();

        void goToHomeScreen();

        void failedSignIn();
    }

    //GoogleSignInAccount googleSignInAccount
    void firebaseAuthWithGoogle(String googleId);

    void checkUserExists();

}
