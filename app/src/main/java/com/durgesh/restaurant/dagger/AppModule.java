package com.durgesh.restaurant.dagger;

import android.app.Application;
import android.content.Context;

import com.durgesh.restaurant.common.Router;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

/**
 * Created by durgeshtrivedi on 14/12/17.
 */

@Module
 public abstract class AppModule {

    @Provides
    @Singleton
    static Router provideRouter() {
        return new Router();
    }

    @Binds
    abstract Context provideContext(Application application);
}
