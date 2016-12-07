package com.example.decode.dcgram_android.domain.exceptions;

/**
 * Created by root on 06.12.16..
 */

public interface ErrorBundle {
    Exception getException();

    String getErrorMessage();
}
