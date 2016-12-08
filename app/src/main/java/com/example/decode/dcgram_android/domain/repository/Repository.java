package com.example.decode.dcgram_android.domain.repository;

import rx.Observable;

/**
 * Created by root on 06.12.16..
 */

public interface Repository {

    Observable<String> getMessage();
}
