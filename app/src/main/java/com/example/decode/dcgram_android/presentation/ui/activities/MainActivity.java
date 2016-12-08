package com.example.decode.dcgram_android.presentation.ui.activities;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

import com.example.decode.dcgram_android.AndroidApplication;
import com.example.decode.dcgram_android.R;
import com.example.decode.dcgram_android.dependecy_injection.components.ApplicationComponent;
import com.example.decode.dcgram_android.dependecy_injection.components.DaggerMessageComponent;
import com.example.decode.dcgram_android.dependecy_injection.components.MessageComponent;
import com.example.decode.dcgram_android.dependecy_injection.modules.MessageModule;
import com.example.decode.dcgram_android.presentation.base.BaseActivity;
import com.example.decode.dcgram_android.presentation.presenters.MainPresenter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements MainPresenter.View {

    @BindView(R.id.helloText)
    TextView helloText;

    @Inject
    MainPresenter mainPresenter;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        ApplicationComponent appComponent = ((AndroidApplication) getApplication()).getApplicationComponent();


        MessageComponent messageComponent = DaggerMessageComponent.builder()
                .messageModule(new MessageModule(this))
                .applicationComponent(appComponent)
                .build();
        messageComponent.inject(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mainPresenter.getHelloText();
    }

    @Override
    public void setHelloText(String text) {
        helloText.setText(text);
    }

    @OnClick(R.id.helloText)
    public void clickedOnText() {
        mainPresenter.getHelloText();
    }

    @Override
    public Context getContext() {
        return getApplicationContext();
    }
}
