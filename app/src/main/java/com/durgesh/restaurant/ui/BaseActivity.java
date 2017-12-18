package com.durgesh.restaurant.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.durgesh.restaurant.common.Router;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

/**
 * This is a base Activity class, which abstracts away the boilerplate code
 * related to creating a Dagger scoped object graph and performing the injection
 * of dependencies.
 * <p/>
 * Created by durgeshtrivedi on 15/12/17.
 */
public abstract class BaseActivity extends DaggerAppCompatActivity {

    /**
     * The singleton Navigator object of the application
     */
    @Inject
    Router router;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Make sure to update the router's current activity
        router.setActivity(this);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        // Any other call to this method is due to configuration change or low memory.
        // We want to release the stored object  only when the activity is truly
        // finishing.
        if (isFinishing()) {

        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        // Make sure to update the navigator's current activity
        router.setActivity(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Make sure to update the navigator's current activity
        router.setActivity(this);
    }

}