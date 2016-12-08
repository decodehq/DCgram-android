package com.example.decode.dcgram_android.domain.interactors;

import com.example.decode.dcgram_android.domain.executor.PostExecutionThread;
import com.example.decode.dcgram_android.domain.executor.ThreadExecutor;
import com.example.decode.dcgram_android.domain.interactors.base.AbstractInteractor;
import com.example.decode.dcgram_android.domain.interactors.base.Interactor;
import com.example.decode.dcgram_android.domain.repository.Repository;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by root on 07.12.16..
 */

public class MessageInteractor extends AbstractInteractor implements Interactor {

    private final Repository repository;

    @Inject
    public MessageInteractor(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread,
                             Repository repository) {
        super(threadExecutor, postExecutionThread);
        this.repository = repository;
    }

    @Override
    protected Observable buildUseCaseObservable() {
        return repository.getMessage();
    }

}
