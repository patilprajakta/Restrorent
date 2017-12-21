package com.durgesh.restaurant.ui.home;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.support.annotation.NonNull;
import android.widget.Toast;

import com.durgesh.restaurant.R;
import com.durgesh.restaurant.models.Hotel;
import com.durgesh.restaurant.models.OpeningHours;
import com.durgesh.restaurant.models.Result;
import com.durgesh.restaurant.models.googlePlaces.Place;
import com.durgesh.restaurant.network.ApiHelper;
import com.durgesh.restaurant.network.NetworkHelper;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by durgeshtrivedi on 15/12/17.
 */

public class HomeInteracter {

    private HomeContract.Presenter  presenter;

    private HomeContract.HomeView  homeView;

    private Context context;

    private ApiHelper apiHelper;

    private Location mLastKnownLocation;

    @Inject
    public HomeInteracter() {

    }
    public void setHomeView(HomeContract.HomeView  homeView) {
        this.homeView = homeView;
    }
    public void setPresenter(HomeContract.Presenter  presenter) {
        this.presenter = presenter;
    }

    public void setMapPresenter(HomeContract.MapPresenter  presenter) {
        HomeContract.MapPresenter mapPresenter = presenter;
    }

    public void getUserLocation() {
        context = homeView.activity().getApplicationContext();
        apiHelper = NetworkHelper.getGoogleClient(context);

        if (NetworkHelper.checkPermission(context)) {
             NetworkHelper.requestPermission(homeView.activity());
        } else {
            FusedLocationProviderClient mFusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(context);
            Task<Location> locationResult = mFusedLocationProviderClient.getLastLocation();
            locationResult.addOnCompleteListener(homeView.activity(), new OnCompleteListener<Location>() {
                @Override
                public void onComplete(@NonNull Task<Location> task) {
                    if (task.isSuccessful()) {
                        mLastKnownLocation = task.getResult();
                        presenter.setLocation(mLastKnownLocation);
                        Geocoder geocoder = new Geocoder(context);
                        try {
                            List<Address> addresses = geocoder.getFromLocation(mLastKnownLocation.getLatitude(),
                                    mLastKnownLocation.getLongitude(), 1);
                            homeView.updateAddress(addresses);
                            callPlaceAPI( mLastKnownLocation.getLatitude(), mLastKnownLocation.getLongitude());

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }
    }

    public void getPlaces(double lat, double lng) {
        context = homeView.activity().getApplicationContext();
        callPlaceAPI(lat, lng);
    }

    private void callPlaceAPI(double lat, double lng) {
        final Call<Hotel> call = apiHelper.searchNearestPlaces(lat
                + "," + lng);
        homeView.showProgressDialog();

        call.enqueue(new Callback<Hotel>() {
            @Override
            public void onResponse(Call<Hotel> call, Response<Hotel> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        homeView.dismissDialog();
                        populateResult(response);
                    }
                }
                homeView.dismissDialog();
            }

            @Override
            public void onFailure(Call<Hotel> call, Throwable t) {
                homeView.dismissDialog();
            }
        });

    }

    private void populateResult(Response<Hotel> response) {
        List<Result> resultArrayList = response.body().getResults();

        if (resultArrayList != null) {
            if (resultArrayList.size() == 0) {
                Toast.makeText(homeView.activity(), R.string.data_not_found, Toast.LENGTH_LONG).show();
            } else {

                ArrayList<Place> placeArrayList = new ArrayList<>();
                homeView.updateRestaurantCount(resultArrayList);

                for (int index = 0; index < (resultArrayList.size() - 1); index++) {
                    Location destination = getLocation(index, resultArrayList);
                    OpeningHours openingHours = getOpeningHours(index, resultArrayList);
                    Place place = getPlace(index, destination,resultArrayList, openingHours);
                    placeArrayList.add(place);
                }

                homeView.loadHomeList(placeArrayList);
                homeView.updateView();

            }
        }
    }

    private Place getPlace(int index, Location destination, List<Result> resultArrayList, OpeningHours openingHours) {
        Place place = null;
        if (resultArrayList.get(index) != null && resultArrayList.get(index).getPhotos() != null &&
                resultArrayList.get(index).getPhotos().get(0) != null &&
                resultArrayList.get(index).getPhotos().get(0).getPhoto_reference() != null
                && openingHours != null) {
            place = new Place(resultArrayList.get(index).getName(),
                    resultArrayList.get(index).getRating(), null,
                    destination.distanceTo(mLastKnownLocation),
                    resultArrayList.get(index).getPhotos().get(0).getPhoto_reference(),
                    openingHours);
        } else {
            place = new Place(resultArrayList.get(index).getName(),
                    resultArrayList.get(index).getRating(), null,
                    destination.distanceTo(mLastKnownLocation),
                    null, null);
        }
        return place;
    }


    private OpeningHours getOpeningHours(int index, List<Result> resultArrayList) {
        OpeningHours openingHours;
        if (resultArrayList.get(index).getOpening_hours() != null) {
            if (resultArrayList.get(index).getOpening_hours().getWeekday_text() != null) {
                openingHours = new OpeningHours(resultArrayList.get(index).getOpening_hours().isOpen_now(),
                        resultArrayList.get(index).getOpening_hours().getWeekday_text());
            } else {
                openingHours = new OpeningHours(resultArrayList.get(index).getOpening_hours().isOpen_now(),
                        null);
            }

        } else {
            openingHours = new OpeningHours(true, null);
        }

        return openingHours;
    }

    private Location getLocation(int index,List<Result> resultArrayList ) {
      Location destination =  new Location("Destination");
        destination.setLatitude(resultArrayList.get(index).getGeometry().getLocation().getLat());
        destination.setLongitude(resultArrayList.get(index).getGeometry().getLocation().getLng());
        return destination;
    }
}
