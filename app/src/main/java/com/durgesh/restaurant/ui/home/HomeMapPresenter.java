package com.durgesh.restaurant.ui.home;

import android.support.annotation.Nullable;

import javax.inject.Inject;

/**
 * Created by durgeshtrivedi on 19/12/17.
 */

public class HomeMapPresenter implements HomeContract.MapPresenter{


    @Inject
    public HomeMapPresenter(HomeInteracter homeInteractor) {
    }

    @Override
    public void takeView(HomeContract.MapView view) {
        HomeContract.MapView mapView = view;
    }
    @Override
    public void dropView() {

    }
}
