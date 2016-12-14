package com.example.decode.dcgram_android.data.firebase.firebase_auth;

import com.google.firebase.auth.FirebaseUser;

import rx.Observable;

/**
 * Created by goran on 12.12.16..
 */

public interface FirebaseAuthInterface {

    Observable<FirebaseUser> firebaseAuthWithGoogle(String googleId);

    Observable<String> getCurrentUserToken();

    Observable<String> checkUserExists();

}
