package com.example.decode.dcgram_android.presentation.presenters;

import com.example.decode.dcgram_android.presentation.base.BasePresenter;
import com.example.decode.dcgram_android.presentation.base.BaseView;

/**
 * Created by root on 06.12.16..
 */

public interface MainPresenter {

    interface View extends BaseView {

        void setHelloText(String text);
    }

    void getHelloText();
}
