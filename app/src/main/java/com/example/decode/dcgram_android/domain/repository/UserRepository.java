package com.example.decode.dcgram_android.domain.repository;

import com.example.decode.dcgram_android.domain.UserDTO;

import rx.Observable;

/**
 * Created by root on 06.12.16..
 */

public interface UserRepository {

    Observable<UserDTO> firebaseAuthWithGoogle(String googleId);

    Observable<String> checkUserExists();

}
