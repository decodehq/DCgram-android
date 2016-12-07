package com.example.decode.dcgram_android.presentation.base;

import android.support.v4.app.Fragment;

import timber.log.Timber;

/**
 * Created by goran on 05.12.16..
 */
public class BaseFragment extends Fragment {

    protected void showProgressDialog() {
        Timber.v("showProgressDialog");
        if(getActivity() instanceof BaseActivity) {
            ((BaseActivity) getActivity()).showProgressDialog();
        }
//        if (progressDialog == null || !progressDialog.isShowing()) {
//            progressDialog = new ProgressDialog(getActivity());
//            progressDialog.setCanceledOnTouchOutside(false);
//            if (!getActivity().isFinishing()) {
//                progressDialog.show();
//            }
//        }
    }

    protected void showProgressDialog(String title, String message) {
        Timber.v("showProgressDialog custom message");
        if(getActivity() instanceof BaseActivity) {
            ((BaseActivity) getActivity()).showProgressDialog(title, message);

        }
    }

    protected void hideProgressDialog() {
        Timber.v("hideProgressDialog");
        if(getActivity() instanceof BaseActivity) {
            ((BaseActivity) getActivity()).hideProgressDialog();
        }
    }


}
