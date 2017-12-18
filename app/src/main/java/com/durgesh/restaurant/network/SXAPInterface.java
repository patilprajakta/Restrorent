package com.durgesh.restaurant.network;

import com.durgesh.restaurant.models.googleDir.RootGoogleDir;
import com.durgesh.restaurant.models.googlePlaces.RootGooglePlaces;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Prajakta Patil on 30/8/17.

 */

public interface SXAPInterface {
    /**
     * google directions api
     *
     * @param source
     * @param dest
     * @return
     */
    @GET(com.durgesh.restaurant.utilities.SXWebConstants.SX_GOOGLE_DIR_API)
    Call<RootGoogleDir> getGoogleDir(@Query("origin") String source,
                                     @Query("destination") String dest);

    /**
     * google places api
     *
     * @param source
     * @return
     */
    @GET(com.durgesh.restaurant.utilities.SXWebConstants.SX_GOOGLE_PLACES_API)
    Call<RootGooglePlaces> getGooglePlaces(@Query("location") String source);

    /**
     * get place photos
     *
     * @param photoreference
     * @return
     */
    @GET(com.durgesh.restaurant.utilities.SXWebConstants.SEARCH_PHOTOS)
    Call<ResponseBody> searchPhotos(@Query("photoreference") String photoreference);
}