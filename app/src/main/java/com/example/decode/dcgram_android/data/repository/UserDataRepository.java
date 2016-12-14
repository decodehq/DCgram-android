package com.example.decode.dcgram_android.data.repository;

import com.example.decode.dcgram_android.data.firebase.entity.UserEntityDataMapper;
import com.example.decode.dcgram_android.data.firebase.firebase_auth.FirebaseAuthInterface;
import com.example.decode.dcgram_android.dependecy_injection.scopes.PerActivity;
import com.example.decode.dcgram_android.domain.UserDTO;
import com.example.decode.dcgram_android.domain.repository.UserRepository;

import javax.inject.Inject;

import rx.Observable;
import timber.log.Timber;

/**
 * Created by goran on 09.12.16..
 */
public class UserDataRepository implements UserRepository {

    private FirebaseAuthInterface firebaseAuthInterface;
    private UserEntityDataMapper userEntityDataMapper;

    @Inject
    public UserDataRepository(FirebaseAuthInterface firebaseAuthInterface, UserEntityDataMapper userEntityDataMapper) {
        this.firebaseAuthInterface = firebaseAuthInterface;
        this.userEntityDataMapper = userEntityDataMapper;
    }

    @Override
    public Observable<UserDTO> firebaseAuthWithGoogle(String googleId) {
        return firebaseAuthInterface.firebaseAuthWithGoogle(googleId)
                .map(firebaseUser -> userEntityDataMapper.transform(firebaseUser));
    }

    @Override
    public Observable<String> checkUserExists() {
        return firebaseAuthInterface.checkUserExists()
                .map(s -> s);
    }
}
