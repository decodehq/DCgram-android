package com.example.decode.dcgram_android.domain.interactors.base;

import timber.log.Timber;

/**
 * Default subscriber base class to be used whenever you want default error handling.
 */
public class DefaultSubscriber<T> extends rx.Subscriber<T> {

    private Interactor interactor;

    public DefaultSubscriber(Interactor interactor) {
        this.interactor = interactor;
    }

    /**
     * ALWAYS IMPLEMENT SUPER IN CHILD CLASS!!!!
     */
    @Override public void onCompleted() {
        if(interactor != null) {
            interactor.onFinished();
        }
        // no-op by default.
    }

    /**
     * ALWAYS IMPLEMENT SUPER IN CHILD CLASS!!!!
     */
    @Override public void onError(Throwable e) {
        Timber.d("onError: " + e);
        if(interactor != null) {
            interactor.onFinished();
        }
        // no-op by default.
    }

    @Override public void onNext(T t) {
        // no-op by default.
    }
}
