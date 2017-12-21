package com.durgesh.restaurant.network;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;

import com.durgesh.restaurant.ui.home.fragments.HomeListFragment;

import retrofit2.Retrofit;

/**
 * Created by durgeshtrivedi on 14/12/17.
 */



public class NetworkHelper {

    public static ApiHelper getGoogleClient(Context context) {
        Retrofit googleRetrofit = ApiClient.getGoogleClient(context);
        ApiHelper service = null;
        if (googleRetrofit != null) {
            service = googleRetrofit.create(com.durgesh.restaurant.network.ApiHelper.class);
        }
        return service;
    }

    public static boolean checkPermission(Context context) {

      return  ActivityCompat.checkSelfPermission(context, android.Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission
                (context, android.Manifest.permission.ACCESS_COARSE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED;
    }

    public static void requestPermission(Activity context) {
         ActivityCompat.requestPermissions(context,
                new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION},
                HomeListFragment.HomeListConstant.ACCESS_FINE_LOCATION);
    }
}

