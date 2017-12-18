package com.durgesh.restaurant.utility;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Snehal Tembare on 1/9/17.
 */

public class SnapXLog {
    public static final String LOG_TAG = "ReCircle";

    /**
     * Method for showing toast
     *
     * @param context
     * @param toastMessage
     */
    public static void showToast(Context context, String toastMessage) {

        Toast.makeText(context, toastMessage, Toast.LENGTH_SHORT).show();
    }

    public static void showLongToast(Context context, String toastMessage) {

        Toast.makeText(context, toastMessage, Toast.LENGTH_LONG).show();
    }

    public static void debug(String message) {
        Log.d(LOG_TAG, message);
    }
}
