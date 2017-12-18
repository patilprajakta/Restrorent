package com.durgesh.restaurant.ui.facebook;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.durgesh.restaurant.R;
import com.durgesh.restaurant.ui.main.MainActivity;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Prajakta Patil on 24/8/17.

 */

public class FacebookLoginActivity extends AppCompatActivity {

    private static final String TAG = "facebookLogin";

    @BindView(R.id.btnFbLogin)
    protected LoginButton mLoginButton;

   /* @BindView(R.id.btnFbLogin)
    protected Button mBtnFbLogin;*/

    @BindView(R.id.progress_bar)
    protected ProgressBar mProgressBar;

    private CallbackManager mCallbackManager;
    private FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mFirebaseAuthListener;
    private FirebaseUser user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_log_in);
        ButterKnife.bind(this);

//        getSupportActionBar().hide();

        mCallbackManager = CallbackManager.Factory.create();
        mFirebaseAuth = FirebaseAuth.getInstance();

        mLoginButton.setReadPermissions("email","public_profile");

        mLoginButton.registerCallback(mCallbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                handleFacebookAccessToken(loginResult.getAccessToken());
            }

            @Override
            public void onCancel() {
                mProgressBar.setVisibility(View.GONE);
                Toast.makeText(FacebookLoginActivity.this, getString(R.string.login_cancelled), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(FacebookException error) {
                mProgressBar.setVisibility(View.GONE);
                Toast.makeText(FacebookLoginActivity.this, getString(R.string.login_error), Toast.LENGTH_SHORT).show();
            }
        });

        try {
            PackageInfo info = getPackageManager().getPackageInfo("com.example.synerzip.snapandroid", PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.v("MY KEY HASH:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException e) {

        } catch (NoSuchAlgorithmException e) {

        }

       /* mFirebaseAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (user != null) {
                    goMainScreen();
                }
            }
        };*/
    }

   /* @OnClick(R.id.btnFbLogin)
    public void btnLogin(View view) {
        if (view == mBtnFbLogin) {
            mProgressBar.setVisibility(View.VISIBLE);
            mLoginButton.performClick();
        }
    }*/


    private void handleFacebookAccessToken(AccessToken accessToken) {
        AuthCredential credential = FacebookAuthProvider.getCredential(accessToken.getToken());
        Log.v(TAG, accessToken.getToken());

        mFirebaseAuth.signInWithCredential(credential).addOnCompleteListener(this,
                new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            mProgressBar.setVisibility(View.GONE);
                            user=mFirebaseAuth.getCurrentUser();
                            if (user!=null){
                                goMainScreen();
                            }
                        } else {
                            mProgressBar.setVisibility(View.GONE);
                            Toast.makeText(FacebookLoginActivity.this, getString(R.string.login_error), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private void goMainScreen() {
        Intent intent = new Intent(FacebookLoginActivity.this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK
                | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mCallbackManager.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onStart() {
        super.onStart();
//        mFirebaseAuth.addAuthStateListener(mFirebaseAuthListener);
           }

    @Override
    protected void onStop() {
        super.onStop();
//        mFirebaseAuth.removeAuthStateListener(mFirebaseAuthListener);
    }
}
