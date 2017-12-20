package com.durgesh.restaurant.common;

import android.app.Activity;

/**
 * This class encapsulates the necessary boilerplate code for navigating from one activity to another.
 * Created by durgeshtrivedi on 15/12/17.
 */

public class Router {

    private Activity mActivity;

    /**
     * This method should be called whenever the foreground activity changes, so that the
     * always contains the latest activity which the user is interacting with
     */
    public void setActivity(Activity activity) {
        mActivity = activity;
    }

}

