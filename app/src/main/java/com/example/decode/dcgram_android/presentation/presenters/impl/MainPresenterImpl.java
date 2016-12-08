package com.example.decode.dcgram_android.presentation.presenters.impl;

import com.example.decode.dcgram_android.domain.exceptions.DefaultErrorBundle;
import com.example.decode.dcgram_android.domain.interactors.base.DefaultSubscriber;
import com.example.decode.dcgram_android.domain.interactors.base.Interactor;
import com.example.decode.dcgram_android.presentation.base.AbstractPresenter;
import com.example.decode.dcgram_android.presentation.presenters.MainPresenter;

import javax.inject.Inject;

import timber.log.Timber;

/**
 * Created by root on 06.12.16..
 */

public class MainPresenterImpl extends AbstractPresenter implements MainPresenter {

    private View view;

    //message interactor
    private Interactor getMessageInteractor;
    private boolean isMessageInteractorRunning;

    @Inject
    public MainPresenterImpl(View mainPresenterView, Interactor getMessageInteractor) {
        super(mainPresenterView);
        this.view = mainPresenterView;
        this.getMessageInteractor = getMessageInteractor;
    }

    @Override
    public void getHelloText() {
        if( ! isMessageInteractorRunning) {
            isMessageInteractorRunning = true;
            getMessageInteractor.execute(new MessageSubscriber());
        }
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

    @Override public void destroy() {
        this.getMessageInteractor.unsubscribe();
        this.view = null;
    }

    public void showMessage(String message) {
        view.setHelloText(message);
    }

    private final class MessageSubscriber extends DefaultSubscriber<String> {

        @Override public void onCompleted() {
            Timber.d("onCompleted");
            isMessageInteractorRunning = false;
            MainPresenterImpl.this.hideProgress();
        }

        @Override public void onError(Throwable e) {
            Timber.d("onError: " + e);
            isMessageInteractorRunning = false;
            MainPresenterImpl.this.hideProgress();
            MainPresenterImpl.this.showErrorMessage(new DefaultErrorBundle((Exception) e));
        }

        @Override public void onNext(String message) {
            Timber.d("onNext, message: " + message);
            MainPresenterImpl.this.showMessage(message);
        }
    }
}
