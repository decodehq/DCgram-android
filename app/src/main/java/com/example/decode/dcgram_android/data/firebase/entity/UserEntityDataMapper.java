package com.example.decode.dcgram_android.data.firebase.entity;

import com.example.decode.dcgram_android.dependecy_injection.scopes.PerActivity;
import com.example.decode.dcgram_android.domain.UserDTO;
import com.google.firebase.auth.FirebaseUser;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by goran on 13.12.16..
 */
@PerActivity
public class UserEntityDataMapper {

    @Inject
    public UserEntityDataMapper() {

    }

    public UserDTO transform(FirebaseUser firebaseUser) {
        UserDTO userDTO = null;
        if(firebaseUser != null) {
            userDTO = new UserDTO(firebaseUser.getProviderId());
            userDTO.setEmailAddress(firebaseUser.getEmail());
            userDTO.setDisplayName(firebaseUser.getDisplayName());
        }

        return userDTO;
    }
}
