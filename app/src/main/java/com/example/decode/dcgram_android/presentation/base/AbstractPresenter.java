package com.example.decode.dcgram_android.presentation.base;

import com.example.decode.dcgram_android.domain.exceptions.ErrorBundle;
import com.example.decode.dcgram_android.presentation.exceptions.ErrorMessageFactory;

/**
 * Created by root on 07.12.16..
 */

public abstract class AbstractPresenter implements BasePresenter {

    protected BaseView baseView;

    public AbstractPresenter(BaseView baseView) {
        this.baseView = baseView;
    }

    protected void showProgress() {
        baseView.showProgress();
    }

    protected void hideProgress() {
        baseView.hideProgress();
    }

    @Override
    public void showMessage(String message) { baseView.showToastMessage(message);}

    @Override
    public void showErrorMessage(ErrorBundle errorBundle) {
        String errorMessage = ErrorMessageFactory.create(this.baseView.getContext(),
                errorBundle.getException());
        this.baseView.showError(errorMessage);
    }
}
