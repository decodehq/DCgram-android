package com.example.decode.dcgram_android.presentation.ui.activities;

import android.os.Bundle;

import com.example.decode.dcgram_android.R;
import com.example.decode.dcgram_android.presentation.base.BaseActivity;
import com.example.decode.dcgram_android.presentation.presenters.MainPresenter;

public class MainActivity extends BaseActivity implements MainPresenter.View {


    @Override
    protected int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }



}
