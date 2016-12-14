package com.example.decode.dcgram_android.data.firebase.firebase_auth;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.decode.dcgram_android.data.exceptions.NoUserException;
import com.example.decode.dcgram_android.dependecy_injection.scopes.PerActivity;
import com.example.decode.dcgram_android.domain.executor.ThreadExecutor;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

import javax.inject.Inject;

import rx.Observable;
import timber.log.Timber;

/**
 * Created by goran on 09.12.16..
 */
@PerActivity
public class FirebaseAuthManager implements FirebaseAuth.AuthStateListener, FirebaseAuthInterface {

    public static final String TAG = "FirebaseAuthUtil";

    private FirebaseAuth mAuth;
    private GoogleSignInAccount googleSignInAccount;
    private ThreadExecutor threadExecutor;

//    GoogleSignInAccount googleSignInAccount

    @Inject
    public FirebaseAuthManager(ThreadExecutor threadExecutor) {
        mAuth = FirebaseAuth.getInstance();
        this.threadExecutor = threadExecutor;
    }

    public FirebaseAuthManager(GoogleSignInAccount googleSignInAccount) {
        this.googleSignInAccount = googleSignInAccount;
        mAuth = FirebaseAuth.getInstance();
    }

    public void onStart() {
        mAuth.addAuthStateListener(this);

    }

    public void onStop() {
        if (mAuth != null) {
            mAuth.removeAuthStateListener(this);
        }

    }

    @Override
    public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

    }

    public void createUserWithEmailAndPass(String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(task -> {
                Log.d(TAG, "createUserWithEmail:onComplete:" + task.isSuccessful());

                // If sign in fails, display a message to the user. If sign in succeeds
                // the auth state listener will be notified and logic to handle the
                // signed in user can be handled in the listener.
                if (!task.isSuccessful()) {

                }
            });
    }

    @Override
    public Observable<FirebaseUser> firebaseAuthWithGoogle(String googleId) {
        Timber.d("googleId: " + googleId);

        AuthCredential credential = GoogleAuthProvider.getCredential(googleId, null);

        return Observable.create(subscriber -> {
            mAuth.signInWithCredential(credential)
                    .addOnCompleteListener(threadExecutor, task -> {
                        Log.d(TAG, "signInWithCredential:onComplete:" + task.isSuccessful());

                        if (task.isSuccessful()) {
                            Timber.d("task.getResult().getUser(): " + task.getResult().getUser());
                            subscriber.onNext(task.getResult().getUser());
                        } else {
                            Timber.d("task exception: " + task.getResult());
                            Timber.d("task exception: " + task.getException());
                            Timber.d("task exception to string: " + task.getException().toString());
                            if(task.getException() instanceof FirebaseAuthUserCollisionException) {
                                Timber.d("User with Email id already exists");
                            }
                            subscriber.onError(new Exception("User failed to create!"));
                        }
                    });
        });
    }

    @Override
    public Observable<String> getCurrentUserToken() {
        return Observable.create(subscriber -> {
            if(checkIfUserIsNotNull()) {
                mAuth.getCurrentUser().getUid();
            } else {
                subscriber.onError(new NoUserException("User doesn't existc"));
            }
        });
    }

    @Override
    public Observable<String> checkUserExists() {
        return Observable.create(subscriber -> {
            if(checkIfUserIsNotNull()) {
                Timber.d("mAuth.getCurrentUser(): " + mAuth.getCurrentUser());
                if(mAuth.getCurrentUser() != null) {
                    Timber.d("mAuth.getCurrentUser().getDisplayName(): " + mAuth.getCurrentUser().getDisplayName());
                    subscriber.onNext(mAuth.getCurrentUser().getDisplayName());
                } else {
                    subscriber.onError(new NoUserException("User doesn't existc"));
                }
            } else {
                subscriber.onError(new NoUserException("User doesn't existc"));
            }
        });
    }

    private boolean checkIfUserIsNotNull() {
        if(mAuth.getCurrentUser() != null) {
            return true;
        } else {
            return false;
        }
    }

    public void setGoogleSignInAccount(GoogleSignInAccount googleSignInAccount) {
        this.googleSignInAccount = googleSignInAccount;
    }
}
