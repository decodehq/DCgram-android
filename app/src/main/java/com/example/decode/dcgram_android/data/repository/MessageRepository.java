package com.example.decode.dcgram_android.data.repository;

import com.example.decode.dcgram_android.dependecy_injection.scopes.PerActivity;
import com.example.decode.dcgram_android.domain.repository.Repository;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;
import timber.log.Timber;


@PerActivity
public class MessageRepository implements Repository {

    private static int counterToError = 0;

    @Inject
    public MessageRepository() {
    }

    @Override
    public Observable<String> getMessage() {

        String helloText = "Hello world!!!!!";

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        counterToError++;

        Timber.d("counterToError: " + counterToError);
        if(counterToError >= 5) {
            counterToError = 0;
            return Observable.error(new Exception("Error retrieving message!"));
        }

        return Observable.just(helloText);
    }
}
