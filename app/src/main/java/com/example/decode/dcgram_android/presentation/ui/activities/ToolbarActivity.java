package com.example.decode.dcgram_android.presentation.ui.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.example.decode.dcgram_android.R;
import com.example.decode.dcgram_android.presentation.base.BaseActivity;

import butterknife.BindView;

/**
 * Created by goran on 15.12.16..
 */

public abstract class ToolbarActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    public Toolbar toolbar;
    @BindView(R.id.title)
    public TextView title;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        title.setText(getToolbarTitle());

    }

    protected abstract String getToolbarTitle();
}
