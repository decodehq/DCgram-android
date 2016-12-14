package com.example.decode.dcgram_android.presentation.ui.activities;

import android.content.Context;
import android.os.Bundle;

import com.example.decode.dcgram_android.R;
import com.example.decode.dcgram_android.presentation.base.BaseActivity;
import com.example.decode.dcgram_android.presentation.presenters.HomePresenter;
import com.example.decode.dcgram_android.presentation.presenters.impl.HomePresenterImpl;

import javax.inject.Inject;

import timber.log.Timber;

/**
 * Created by goran on 14.12.16..
 */

public class HomeActivity extends BaseActivity implements HomePresenter.View {

    @Inject
    HomePresenterImpl homePresenter;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_home;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void onResume() {
        super.onResume();
        Timber.d("onResume");
    }

    @Override
    public Context getContext() {
        return getApplicationContext();
    }
}
