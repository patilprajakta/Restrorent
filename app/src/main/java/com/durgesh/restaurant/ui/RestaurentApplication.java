package com.durgesh.restaurant.ui;

import com.durgesh.restaurant.dagger.AppComponent;
import com.durgesh.restaurant.dagger.DaggerAppComponent;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

/**
 * Created by durgeshtrivedi on 14/12/17.
 */

public class RestaurentApplication extends DaggerApplication {

    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        AppComponent appComponent = DaggerAppComponent.builder().application(this).build();
        appComponent.inject(this);
        return appComponent;
    }
}

