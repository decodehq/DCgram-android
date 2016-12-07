package com.example.decode.dcgram_android.presentation.base;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.decode.dcgram_android.presentation.base.BaseView;
import com.example.decode.dcgram_android.presentation.navigation.ActivityNavigator;

import javax.inject.Inject;

import butterknife.ButterKnife;


public abstract class BaseActivity extends AppCompatActivity implements BaseView {

    public ProgressDialog progressDialog;

    @Inject ActivityNavigator navigator;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());
        ButterKnife.bind(this);
    }

    protected abstract int getLayoutResId();

    public void showProgressDialog() {
        if (progressDialog == null || !progressDialog.isShowing()) {
            progressDialog = new ProgressDialog(this);
            progressDialog.setCanceledOnTouchOutside(false);
            if (!isFinishing()) {
                progressDialog.show();
            }
        }
    }

    public void hideProgressDialog() {
        if (progressDialog != null && progressDialog.isShowing()) {
            if (!isFinishing()) {
                progressDialog.dismiss();
            }
        }
    }

    public void showProgressDialog(String title, String message) {
        if (progressDialog == null || !progressDialog.isShowing()) {
            progressDialog = new ProgressDialog(this);
            progressDialog.setTitle(title);
            progressDialog.setMessage(message);
            progressDialog.setCanceledOnTouchOutside(false);
            if (!isFinishing()) {
                progressDialog.show();
            }
        }
    }

    public void showToastMessage(String message) {
        Toast.makeText(getBaseContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgress() {
        showProgressDialog();
    }

    @Override
    public void hideProgress() {
        hideProgressDialog();
    }

    @Override
    public void showError(String message) {
        showToastMessage(message);
    }

}
