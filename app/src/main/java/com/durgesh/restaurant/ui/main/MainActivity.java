package com.durgesh.restaurant.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.durgesh.restaurant.R;
import com.durgesh.restaurant.ui.direction.DirectionsActivity;
import com.durgesh.restaurant.ui.facebook.FacebookLoginActivity;
import com.durgesh.restaurant.ui.map.MapsActivity;
import com.facebook.login.LoginManager;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Prajakta Patil on 24/8/17.

 */

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.txtName)
    protected TextView mTxtUserName;

    @BindView(R.id.txtEmail)
    protected TextView mTxtUserEmail;

    @BindView(R.id.txtUid)
    protected TextView mTxtUserId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {

            String name = user.getDisplayName();
            String email = user.getEmail();
            String uid = user.getUid();

            mTxtUserName.setText(name);
            mTxtUserEmail.setText(email);
            mTxtUserId.setText(uid);

        } else {
            goLoginScreen();
        }
    }

    private void goLoginScreen() {
        Intent intent = new Intent(this, FacebookLoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK
                | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    @OnClick(R.id.btnLogout)
    public void logout(View view) {
        FirebaseAuth.getInstance().signOut();
        LoginManager.getInstance().logOut();
        goLoginScreen();
    }

    @OnClick(R.id.btnMaps)
    public void maps(View view) {
        startActivity(new Intent(MainActivity.this, MapsActivity.class));
    }

    @OnClick(R.id.btnDirections)
    public void directions(View view) {
        startActivity(new Intent(MainActivity.this, DirectionsActivity.class));
    }

}
