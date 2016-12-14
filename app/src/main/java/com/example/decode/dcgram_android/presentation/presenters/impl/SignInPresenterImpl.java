package com.example.decode.dcgram_android.presentation.presenters.impl;

import com.example.decode.dcgram_android.data.exceptions.NoUserException;
import com.example.decode.dcgram_android.domain.UserDTO;
import com.example.decode.dcgram_android.domain.exceptions.DefaultErrorBundle;
import com.example.decode.dcgram_android.domain.interactors.base.AbstractInteractor;
import com.example.decode.dcgram_android.domain.interactors.base.DefaultSubscriber;
import com.example.decode.dcgram_android.domain.interactors.base.Interactor;
import com.example.decode.dcgram_android.domain.interactors.impl.FirebaseAuthInteractorImpl;
import com.example.decode.dcgram_android.domain.interactors.impl.UserExistsInteractor;
import com.example.decode.dcgram_android.presentation.base.AbstractPresenter;
import com.example.decode.dcgram_android.presentation.models.UserModel;
import com.example.decode.dcgram_android.presentation.presenters.SignInPresenter;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

import javax.inject.Inject;

import timber.log.Timber;

/**
 * Created by goran on 09.12.16..
 */

public class SignInPresenterImpl extends AbstractPresenter implements SignInPresenter {

    private SignInPresenter.View mView;
    private FirebaseAuthInteractorImpl firebaseAuthInteractor;
    private UserExistsInteractor userExistsInteractor;

    @Inject
    public SignInPresenterImpl(View view,
                               FirebaseAuthInteractorImpl firebaseAuthInteractor,
                               UserExistsInteractor userExistsInteractor) {
        super(view);
        mView = view;
        this.firebaseAuthInteractor = firebaseAuthInteractor;
        this.userExistsInteractor = userExistsInteractor;
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void destroy() {
        this.firebaseAuthInteractor.unsubscribe();
        this.mView = null;
    }

    @Override
    public void firebaseAuthWithGoogle(String googleId) {
        firebaseAuthInteractor.init(googleId).execute(new UserSubscriber(firebaseAuthInteractor));
    }

    @Override
    public void checkUserExists() {
        userExistsInteractor.execute(new DefaultSubscriber<String>(userExistsInteractor) {
            @Override
            public void onCompleted() {
                super.onCompleted();
                SignInPresenterImpl.this.hideProgress();
            }

            @Override
            public void onError(Throwable e) {
                super.onError(e);
                SignInPresenterImpl.this.hideProgress();
                SignInPresenterImpl.this.showErrorMessage(new DefaultErrorBundle((Exception) e));
            }

            @Override
            public void onNext(String s) {
                super.onNext(s);
                Timber.d("User: " + s);
                SignInPresenterImpl.this.hideProgress();
                SignInPresenterImpl.this.goToHomeScreen();
            }
        });

    }

    public void successfullGoogleLogin() {
        mView.successfulSignIn();
    }

    public void goToSignUp() {
        mView.showSignUpScreen();
    }

    public void goToHomeScreen() {
        mView.goToHomeScreen();
    }

    private final class UserSubscriber extends DefaultSubscriber<UserDTO> {

        public UserSubscriber(Interactor interactor) {
            super(interactor);
        }

        @Override public void onCompleted() {
            super.onCompleted();
            Timber.d("onCompleted");
            SignInPresenterImpl.this.hideProgress();
        }

        @Override public void onError(Throwable e) {
            super.onError(e);
            SignInPresenterImpl.this.hideProgress();
            SignInPresenterImpl.this.showErrorMessage(new DefaultErrorBundle((Exception) e));
            if(e instanceof NoUserException) {
                SignInPresenterImpl.this.goToSignUp();
            }
        }

        @Override public void onNext(UserDTO userModel) {
            Timber.d("onNext, message: " + userModel);
            SignInPresenterImpl.this.successfullGoogleLogin();
        }
    }
}
