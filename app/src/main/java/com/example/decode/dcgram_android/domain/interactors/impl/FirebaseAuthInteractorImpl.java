package com.example.decode.dcgram_android.domain.interactors.impl;

import android.support.annotation.NonNull;

import com.example.decode.dcgram_android.domain.executor.PostExecutionThread;
import com.example.decode.dcgram_android.domain.executor.ThreadExecutor;
import com.example.decode.dcgram_android.domain.interactors.base.AbstractInteractor;
import com.example.decode.dcgram_android.domain.repository.UserRepository;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by goran on 09.12.16..
 */

public class FirebaseAuthInteractorImpl extends AbstractInteractor {

    private final UserRepository userRepository;
    private String googleId;

    @Inject
    public FirebaseAuthInteractorImpl(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread,
                                      UserRepository userRepository) {
        super(threadExecutor, postExecutionThread);
        this.userRepository = userRepository;
    }

    public FirebaseAuthInteractorImpl init(@NonNull String googleId) {
        this.googleId = googleId;
        return this;
    }

    @Override
    protected Observable buildUseCaseObservable() {
        return userRepository.firebaseAuthWithGoogle(googleId);
    }
}
