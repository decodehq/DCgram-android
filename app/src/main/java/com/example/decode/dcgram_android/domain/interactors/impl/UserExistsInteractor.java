package com.example.decode.dcgram_android.domain.interactors.impl;

import android.support.annotation.NonNull;

import com.example.decode.dcgram_android.domain.executor.PostExecutionThread;
import com.example.decode.dcgram_android.domain.executor.ThreadExecutor;
import com.example.decode.dcgram_android.domain.interactors.base.AbstractInteractor;
import com.example.decode.dcgram_android.domain.repository.UserRepository;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by goran on 14.12.16..
 */

public class UserExistsInteractor extends AbstractInteractor {

    private final UserRepository userRepository;

    @Inject
    public UserExistsInteractor(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread,
                                      UserRepository userRepository) {
        super(threadExecutor, postExecutionThread);
        this.userRepository = userRepository;
    }

    @Override
    protected Observable buildUseCaseObservable() {
        return userRepository.checkUserExists();
    }
}
