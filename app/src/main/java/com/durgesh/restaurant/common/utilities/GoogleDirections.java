package com.durgesh.restaurant.utilities;

import android.content.Context;
import android.util.Log;

import com.durgesh.restaurant.models.googleDir.RootGoogleDir;
import com.durgesh.restaurant.network.ApiClient;
import com.durgesh.restaurant.network.SXAPInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Prajakta Patil on 22/9/17.
 */
public class GoogleDirections {

    public static SXAPInterface service;
    public static Context mContext;
    public static RootGoogleDir mRootGoogleDir;

    public GoogleDirections(Context context) {
        this.mContext = context;

    }

    public RootGoogleDir getMapDir(String srcLat,String srcLng,String destLat, String destLng) {

        if (ApiClient.getClient(mContext) != null) {
            service = ApiClient.getClient(mContext).create(SXAPInterface.class);
            //TODO latlngs are hardcoded for now
           /* final String srcLat = "18.497895";
            final String srcLng = "73.829229";
            final String destLat = "18.504373";
            final String destLng = " 73.830680";*/

            Call<RootGoogleDir> call = service.getGoogleDir(srcLat + "," + srcLng,
                    destLat + "," + destLng);
            call.enqueue(new Callback<RootGoogleDir>() {
                @Override
                public void onResponse(Call<RootGoogleDir> call, Response<RootGoogleDir> response) {
                    Log.v("**adapter",response.body().getRoutes().get(0).getLegs().size()+"");
                    mRootGoogleDir=response.body();
                }

                @Override
                public void onFailure(Call<RootGoogleDir> call, Throwable t) {

                }
            });
        }
        return mRootGoogleDir;
    }
}
