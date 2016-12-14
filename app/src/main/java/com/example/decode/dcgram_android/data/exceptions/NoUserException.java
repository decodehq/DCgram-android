package com.example.decode.dcgram_android.data.exceptions;

/**
 * Created by goran on 14.12.16..
 */

public class NoUserException extends Exception {

    public NoUserException() {
        super();
    }

    public NoUserException(final String message) {
        super(message);
    }

    public NoUserException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public NoUserException(final Throwable cause) {
        super(cause);
    }
}
