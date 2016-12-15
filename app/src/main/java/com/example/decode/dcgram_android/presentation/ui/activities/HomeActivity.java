package com.example.decode.dcgram_android.presentation.ui.activities;

import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.decode.dcgram_android.R;
import com.example.decode.dcgram_android.presentation.presenters.HomePresenter;
import com.example.decode.dcgram_android.presentation.presenters.impl.HomePresenterImpl;

import javax.inject.Inject;

import timber.log.Timber;

/**
 * Created by goran on 14.12.16..
 */

public class HomeActivity extends ToolbarActivity implements HomePresenter.View {

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.messageIcon:
                Timber.d("Message icon pressed!");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected String getToolbarTitle() {
        return getString(R.string.home_title);
    }
}
