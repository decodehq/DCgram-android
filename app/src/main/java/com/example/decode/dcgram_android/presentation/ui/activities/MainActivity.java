package com.example.decode.dcgram_android.presentation.ui.activities;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

import com.example.decode.dcgram_android.AndroidApplication;
import com.example.decode.dcgram_android.R;
import com.example.decode.dcgram_android.dependecy_injection.components.ApplicationComponent;
import com.example.decode.dcgram_android.presentation.base.BaseActivity;

import butterknife.BindView;

public class MainActivity extends BaseActivity{

    @BindView(R.id.helloText)
    TextView helloText;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ApplicationComponent appComponent = ((AndroidApplication) getApplication()).getApplicationComponent();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public Context getContext() {
        return getApplicationContext();
    }
}
