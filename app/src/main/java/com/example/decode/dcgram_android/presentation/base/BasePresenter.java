package com.example.decode.dcgram_android.presentation.base;

import com.example.decode.dcgram_android.domain.exceptions.ErrorBundle;

/**
 * Created by goran on 05.12.16..
 *
 * Put UI callbacks in concrete implementations of {@link BasePresenter}
 */
public interface BasePresenter {

    /**
     * Method that control the lifecycle of the view. It should be called in the view's
     * (Activity or Fragment) onResume() method.
     */
    void resume();

    /**
     * Method that controls the lifecycle of the view. It should be called in the view's
     * (Activity or Fragment) onPause() method.
     */
    void pause();

    /**
     * Method that controls the lifecycle of the view. It should be called in the view's
     * (Activity or Fragment) onStop() method.
     */
    void stop();

    /**
     * Method that control the lifecycle of the view. It should be called in the view's
     * (Activity or Fragment) onDestroy() method.
     */
    void destroy();


    /**
     * Method that should signal the appropriate view to show the appropriate message.
     */
    void showMessage(String message);

    /**
     * Method that should signal the appropriate view to show the appropriate error with the provided message.
     */
    void showErrorMessage(ErrorBundle errorBundle);
}
