package com.example.decode.dcgram_android.dependecy_injection.modules;

import com.example.decode.dcgram_android.data.firebase.firebase_auth.FirebaseAuthInterface;
import com.example.decode.dcgram_android.data.firebase.firebase_auth.FirebaseAuthManager;
import com.example.decode.dcgram_android.data.google_signin.AuthInterface;
import com.example.decode.dcgram_android.data.google_signin.GoogleAuthManager;
import com.example.decode.dcgram_android.dependecy_injection.scopes.PerActivity;
import com.example.decode.dcgram_android.domain.interactors.base.AbstractInteractor;
import com.example.decode.dcgram_android.domain.interactors.impl.FirebaseAuthInteractorImpl;
import com.example.decode.dcgram_android.domain.interactors.impl.UserExistsInteractor;
import com.example.decode.dcgram_android.presentation.base.BaseView;
import com.example.decode.dcgram_android.presentation.presenters.HomePresenter;
import com.example.decode.dcgram_android.presentation.presenters.SignInPresenter;
import com.example.decode.dcgram_android.presentation.presenters.impl.HomePresenterImpl;
import com.example.decode.dcgram_android.presentation.presenters.impl.SignInPresenterImpl;
import com.example.decode.dcgram_android.presentation.ui.activities.HomeActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by goran on 14.12.16..
 */
@Module
public class HomeModule {

    private HomePresenter.View view;

    public HomeModule(HomePresenter.View view) {
        this.view = view;
    }

    @PerActivity
    @Provides
    public HomePresenter.View provideView() {
        return view;
    }

    @PerActivity
    @Provides
    public AbstractInteractor provideUserExistsInteractor(UserExistsInteractor interactor) {
        return interactor;
    }

    @PerActivity
    @Provides
    public HomePresenter provideHomePresenter(HomePresenterImpl presenter) {
        return presenter;
    }

//    @PerActivity
//    @Provides
//    public UserRepository provideRepository(UserDataRepository userDataRepository) {
//        return userDataRepository;
//    }

//    @PerActivity
//    @Provides
//    public AuthInterface provideGoogleAuth(GoogleAuthManager googleAuthManager) {
//        return googleAuthManager;
//    }
//
//    @PerActivity
//    @Provides
//    public FirebaseAuthInterface provideFirebaseAuthInterface(FirebaseAuthManager firebaseAuthManager) {
//        return firebaseAuthManager;
//    }
}
