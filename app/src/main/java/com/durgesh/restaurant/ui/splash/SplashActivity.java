package com.durgesh.restaurant.ui.splash;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

import com.durgesh.restaurant.R;
import com.durgesh.restaurant.ui.camera.CameraActivity;

import butterknife.ButterKnife;


/**
 * Created by Snehal Tembare on 24/8/17.

 */

public class SplashActivity extends AppCompatActivity {
    private static final int TIME_OUT = 1500;
    private static final int REQUEST_CODE = 1;
    private boolean isPermissionGranted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
        checkPermissions();
    }

    public void checkPermissions() {
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED
                && ContextCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED
                && ContextCompat.checkSelfPermission(this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(new Intent(SplashActivity.this, CameraActivity.class));
                    finish();
                }
            }, TIME_OUT);
        } else {
            ActivityCompat.requestPermissions(this,
                    new String[]{android.Manifest.permission.READ_EXTERNAL_STORAGE,
                            android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
                            android.Manifest.permission.CAMERA},
                    REQUEST_CODE);
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CODE) {
            for (int i = 0; i < (grantResults.length - 1); i++) {
                if (grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                    isPermissionGranted = true;
                } else {
                    return;
                }
            }

            if (isPermissionGranted) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(SplashActivity.this, CameraActivity.class));
                        finish();
                    }
                }, TIME_OUT);
            }

        } else {
            return;
        }
    }
}
