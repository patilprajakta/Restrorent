package com.durgesh.restaurant.utility;


import com.durgesh.restaurant.models.Hotel;
import com.durgesh.restaurant.models.ImageCompareResponse;
import com.durgesh.restaurant.models.PlaceDetails;
import com.durgesh.restaurant.models.PlacesAutoCompleteData;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Snehal Tembare on 1/9/17.
 */

public interface SnapXInterface {

    @GET(com.durgesh.restaurant.utility.WebConstants.SEARCH_PLACES)
    Call<Hotel> searchNearestPlaces(@Query("location") String location);

    @GET(com.durgesh.restaurant.utility.WebConstants.SEARCH_PHOTOS)
    Call<ResponseBody> searchPhotos(@Query("photoreference") String photoreference);

    @GET(com.durgesh.restaurant.utility.WebConstants.SEARCH_PREDICTIONS)
    Call<PlacesAutoCompleteData> searchPredictions(@Query("input") String photoreference);

    @Headers("Content-Type: application/x-www-form-urlencoded;charset=UTF-8")
    @POST(com.durgesh.restaurant.utility.WebConstants.UPLOAD_IMAGE)
    Call<ImageCompareResponse> uploadImage(@Body RequestBody key);


    @GET(com.durgesh.restaurant.utility.WebConstants.PLACE_DETAILS)
    Call<PlaceDetails> placeDetails(@Query("placeid") String placeid);

}
