package com.durgesh.restaurant.ui.camera;

import android.hardware.Camera;
import android.util.Log;

/**
 * Created by Snehal Tembare on 12/9/17.

 */

public class CameraHelper {
    public static boolean cameraAvailable(Camera camera) {
        return camera != null;
    }

    public static Camera getCameraInstance() {
        Camera c = null;
        try {
            c = Camera.open();
        } catch (Exception e) {
            // Camera is not available or doesn't exist
            Log.d("getCamera failed", e.toString());
        }
        return c;
    }

}

