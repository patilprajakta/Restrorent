package com.durgesh.restaurant.utilities;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Prajakta Patil on 30/8/17.
 */
public class SXLog {

    public static final String RC_LOG_TAG = "Restrorent";

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
        Log.d(RC_LOG_TAG, message);
    }
}