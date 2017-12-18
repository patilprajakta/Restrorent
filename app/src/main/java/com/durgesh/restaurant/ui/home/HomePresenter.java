package com.durgesh.restaurant.ui.home;

/**
 * Created by durgeshtrivedi on 15/12/17.
 */

import android.support.annotation.Nullable;

import com.durgesh.restaurant.dagger.ActivityScoped;
import com.durgesh.restaurant.ui.home.fragments.HomeListFragment;

import javax.inject.Inject;

/**
 * Listens to user actions from the UI ({@link HomeListFragment , ProfileFragment , etc}), retrieves the data and updates the
 * UI as required.
 * <p/>
 * By marking the constructor with {@code @Inject}, Dagger injects the dependencies required to
 * create an instance of the HomePresenter (if it fails, it emits a compiler error).  It uses
 * {@link HomeModule} to do so.
 * <p/>
 * Dagger generated code doesn't require public access to the constructor or class, and
 * therefore, to ensure the developer doesn't instantiate the class manually and bypasses Dagger,
 * it's good practice minimise the visibility of the class/constructor as much as possible.
 **/
@ActivityScoped
final class HomePresenter implements HomeContract.Presenter {

    private final HomeInteractor mHomeInteractor;

    @Nullable
    private HomeContract.View mHomeView;

    @Inject
    HomePresenter(HomeInteractor homeInteractor) {
        mHomeInteractor = homeInteractor;
    }

    @Override
    public void takeView(HomeContract.View view) {
        this.mHomeView = view;
        //loadTasks(false);
    }

    @Override
    public void dropView() {
        mHomeView = null;
    }
}