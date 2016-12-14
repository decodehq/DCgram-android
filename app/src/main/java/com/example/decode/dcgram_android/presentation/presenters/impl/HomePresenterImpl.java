package com.example.decode.dcgram_android.presentation.presenters.impl;

import com.example.decode.dcgram_android.presentation.base.AbstractPresenter;
import com.example.decode.dcgram_android.presentation.presenters.HomePresenter;

import javax.inject.Inject;

/**
 * Created by goran on 14.12.16..
 */

public class HomePresenterImpl extends AbstractPresenter implements HomePresenter {

    private HomePresenter.View mView;

    @Inject
    public HomePresenterImpl(HomePresenter.View view) {
        super(view);
        mView = view;

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

    @Override
    public void destroy() {

    }
}
