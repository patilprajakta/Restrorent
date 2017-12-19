package com.durgesh.restaurant.ui.home;

import android.support.annotation.Nullable;

import javax.inject.Inject;

/**
 * Created by durgeshtrivedi on 19/12/17.
 */

public class HomeMapPresenter implements HomeContract.MapPresenter{
    @Nullable
    private HomeContract.MapView mapView;

    private final HomeInteracter mHomeInteractor;


    @Inject
    public HomeMapPresenter(HomeInteracter homeInteractor) {
        this.mHomeInteractor = homeInteractor;
    }

    @Override
    public void takeView(HomeContract.MapView view) {
        this.mapView = view;
    }
    @Override
    public void dropView() {

    }
}
