package com.durgesh.restaurant.ui.home;

/**
 * Created by durgeshtrivedi on 15/12/17.
 */

import android.app.Activity;
import android.location.Address;
import android.location.Location;

import com.durgesh.restaurant.models.Result;
import com.durgesh.restaurant.models.googlePlaces.Place;
import com.durgesh.restaurant.ui.BasePresenter;
import com.durgesh.restaurant.ui.BaseView;

import java.util.ArrayList;
import java.util.List;

/**
 * This specifies the contract between the view and the presenter.
 */
public interface HomeContract {

    interface HomeView extends BaseView<Presenter> {

        void showPopUpMenu();
        void updateAddress(List<Address> addresses);
        void showProgressDialog();
        void dismissDialog();
        void updateRestaurantCount(List<Result> resultArrayList);
        void updateView();
        Activity activity();
        void loadHomeList(ArrayList<Place> placeArrayList);
    }

    interface Presenter extends BasePresenter<HomeView> {

        void getUserLocation();

        void getPlaces(double lat, double lng);

         double getLatitude();

         void setLatitude(double latitude);

         double getLongitude();

         void setLongitude(double longitude);

         Location getLocation();

         void setLocation(Location location);

    }

    interface MapView extends BaseView<MapPresenter> {

    }

    interface MapPresenter extends BasePresenter<MapView> {

    }
}

