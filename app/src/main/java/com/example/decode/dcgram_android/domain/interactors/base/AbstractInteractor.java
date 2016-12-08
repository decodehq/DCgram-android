package com.example.decode.dcgram_android.domain.interactors.base;


import com.example.decode.dcgram_android.domain.executor.PostExecutionThread;
import com.example.decode.dcgram_android.domain.executor.ThreadExecutor;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.schedulers.Schedulers;
import rx.subscriptions.Subscriptions;

/**
 * <p/>
 * This abstract class implements some common methods for all interactors. Cancelling an interactor, check if its running
 * and finishing an interactor has mostly the same code throughout so that is why this class was created. Field methods
 * are declared volatile as we might use these methods from different threads (mainly from UI).
 * <p/>
 * For example, when an activity is getting destroyed then we should probably cancel an interactor
 * but the request will come from the UI thread unless the request was specifically assigned to a background thread.
 */
public abstract class AbstractInteractor implements Interactor {

    private final ThreadExecutor threadExecutor;
    private final PostExecutionThread postExecutionThread;

    protected volatile boolean mIsCanceled;
    protected volatile boolean mIsRunning;

    private Subscription subscription = Subscriptions.empty();

    protected AbstractInteractor(ThreadExecutor threadExecutor,
                      PostExecutionThread postExecutionThread) {
        this.threadExecutor = threadExecutor;
        this.postExecutionThread = postExecutionThread;
    }

    /**
     * Builds an {@link rx.Observable} which will be used when executing the current {@link Interactor}.
     */
    protected abstract Observable buildUseCaseObservable();

    /**
     * Executes the current use case.
     *
     * @param UseCaseSubscriber The guy who will be listen to the observable build
     * with {@link #buildUseCaseObservable()}.
     */
    @SuppressWarnings("unchecked")
    @Override
    public void execute(Subscriber UseCaseSubscriber) {
        this.mIsRunning = true;

        this.subscription = Observable.defer(this::buildUseCaseObservable) //this.buildUseCaseObservable()
                .subscribeOn(Schedulers.from(threadExecutor))
                .observeOn(postExecutionThread.getScheduler())
                .subscribe(UseCaseSubscriber);
    }

    /**
     * Unsubscribes from current {@link rx.Subscription}.
     */
    @Override
    public void unsubscribe() {
        if (!subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }

    public void cancel() {
        mIsCanceled = true;
        mIsRunning = false;
    }

    @Override
    public boolean isRunning() {
        return mIsRunning;
    }

    @Override
    public void onFinished() {
        mIsRunning = false;
        mIsCanceled = false;
    }
}
