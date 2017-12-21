package com.durgesh.restaurant.ui;

/**
 * Created by Prajakta Patil on 26/9/17.

 */

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;
public class BlinkingMarker extends android.support.v4.app.FragmentActivity {
    private final static String TAG = BlinkingMarker.class.getSimpleName();
    private static int DEFAULT_FPS = 10;
    private static int DEFAULT_FREQUENCY_MILLIS = 2000;
    private GoogleMap mMap;
    private int mFps;

    private int mDistinctBitmaps;

    private Bitmap mOriginalBitmap;

    private List<Marker> mMarkers;

    private Handler mUiHandler;

    private int mPrevMarkerId;

    private int mCurrentMarkerId;

    private int mDirection;

    private LatLng mNewPosition;
    private boolean mSyncMove;

    public BlinkingMarker(Bitmap bitmap, GoogleMap map, int fps, int frequencyInMillis) {
        mMap = map;
        mOriginalBitmap = bitmap;
        mFps = fps;
        calculateFps(fps, frequencyInMillis);
    }

    public void addToMap(LatLng position) throws IllegalStateException {
        checkIfUiThread();
        if (mMarkers != null) {
            return;
        }

        mMarkers = new ArrayList<>();
        for (int i = 0; i < mDistinctBitmaps; i++) {
            mMarkers.add(addMarker(adjustOpacity(mOriginalBitmap, 255 / mDistinctBitmaps * i), position));
        }
    }

    public void startBlinking() throws IllegalStateException {
        checkIfUiThread();
        if (mUiHandler != null) {
            return;
        }

        mUiHandler = new Handler();
        mCurrentMarkerId = mDistinctBitmaps - 1;
        mPrevMarkerId = mDistinctBitmaps - 1;
        mDirection = -1;

        mUiHandler.post(mBlinkerRunnable);
    }

    private void calculateFps(int fps, int blinkPeriodMillis) {
        mDistinctBitmaps = blinkPeriodMillis * fps / 2 / 1000;
    }

    private Runnable mBlinkerRunnable = new Runnable() {
        @Override
        public void run() {
            if (mCurrentMarkerId == mDistinctBitmaps - 1) {
                mDirection = -1;
            } else if (mCurrentMarkerId == 0) {
                mDirection = 1;
            }
            final LatLng newPosition = mNewPosition;
            if (newPosition != null && (!mSyncMove || mCurrentMarkerId == 0)) {
                changeMarkerVisibility(mCurrentMarkerId, mPrevMarkerId, newPosition);
                mNewPosition = null;
            } else {
                changeMarkerVisibility(mCurrentMarkerId, mPrevMarkerId, null);
            }
            mPrevMarkerId = mCurrentMarkerId;
            mCurrentMarkerId += mDirection;
            mUiHandler.postDelayed(mBlinkerRunnable, 1000 / mFps);
        }
    };

    private void moveMarkers(final LatLng newPosition) {
        for (Marker marker : mMarkers) {
            marker.setPosition(newPosition);
        }
    }

    private void changeMarkerVisibility(final int visibleMarker, final int invisibleMarker, final LatLng newLocation) {
        mMarkers.get(visibleMarker).setVisible(true);
        mMarkers.get(invisibleMarker).setVisible(false);
        if (newLocation != null)
            moveMarkers(newLocation);
    }

    private Marker addMarker(Bitmap bitmap, LatLng position) {
        MarkerOptions markerOptions = new MarkerOptions().position(position).icon(BitmapDescriptorFactory.fromBitmap(bitmap));
        Marker marker = mMap.addMarker(markerOptions);
        marker.setVisible(false);
        return marker;
    }

    private Bitmap adjustOpacity(Bitmap bitmap, int opacity) {
        Bitmap mutableBitmap = bitmap.isMutable() ? bitmap : bitmap.copy(Bitmap.Config.ARGB_8888, true);
        Canvas canvas = new Canvas(mutableBitmap);
        int colour = (opacity & 0xFF) << 24;
        canvas.drawColor(colour, PorterDuff.Mode.DST_IN);
        return mutableBitmap;
    }

    private void checkIfUiThread() throws IllegalStateException {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException("This call has to be made from the UI thread.");
        }
    }
}