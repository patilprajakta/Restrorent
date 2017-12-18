package com.durgesh.restaurant.common.utilities;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.durgesh.restaurant.MyApplication;


/**
 * Created by Snehal Tembare on 1/9/17.
 */

public class NetworkUtility {

    /**
     * checks for network availability
     *
     * @return boolean variable indicating the status
     */
    public static boolean isNetworkAvailable() {
        ConnectivityManager cm =
                (ConnectivityManager) MyApplication.getInstance().
                        getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo netInfo = cm.getActiveNetworkInfo();

        return (netInfo != null && netInfo.isConnectedOrConnecting());
    }

}
