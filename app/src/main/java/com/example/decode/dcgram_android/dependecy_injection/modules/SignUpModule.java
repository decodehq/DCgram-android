package com.example.decode.dcgram_android.dependecy_injection.modules;

import com.example.decode.dcgram_android.data.google_signin.AuthInterface;
import com.example.decode.dcgram_android.data.google_signin.GoogleAuthManager;
import com.example.decode.dcgram_android.dependecy_injection.scopes.PerActivity;
import com.example.decode.dcgram_android.domain.interactors.base.AbstractInteractor;
import com.example.decode.dcgram_android.domain.interactors.impl.FirebaseAuthInteractorImpl;
import com.example.decode.dcgram_android.domain.interactors.impl.UserExistsInteractor;
import com.example.decode.dcgram_android.presentation.presenters.SignInPresenter;
import com.example.decode.dcgram_android.presentation.presenters.impl.SignInPresenterImpl;

import dagger.Module;
import dagger.Provides;

/**
 * Created by goran on 14.12.16..
 */
@Module
public class SignUpModule {

    private SignInPresenter.View  view;

    public SignUpModule(SignInPresenter.View  view) {
        this.view = view;
    }

    @PerActivity
    @Provides
    public SignInPresenter.View provideView() {
        return view;
    }

    @PerActivity
    @Provides
    public AbstractInteractor provideAuthInteractor(FirebaseAuthInteractorImpl interactor) {
        return interactor;
    }

    @PerActivity
    @Provides
    public AbstractInteractor provideUserExistsInteractor(UserExistsInteractor interactor) {
        return interactor;
    }

    @PerActivity
    @Provides
    public SignInPresenter provideSignInPresenter(SignInPresenterImpl presenter) {
        return presenter;
    }

//    @PerActivity
//    @Provides
//    public UserRepository provideRepository(UserDataRepository userDataRepository) {
//        return userDataRepository;
//    }

    @PerActivity
    @Provides
    public AuthInterface provideGoogleAuth(GoogleAuthManager googleAuthManager) {
        return googleAuthManager;
    }
//
//    @PerActivity
//    @Provides
//    public FirebaseAuthInterface provideFirebaseAuthInterface(FirebaseAuthManager firebaseAuthManager) {
//        return firebaseAuthManager;
//    }

}
