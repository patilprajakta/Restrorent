package com.durgesh.restaurant.ui.map;

import android.content.Context;
import android.util.Log;

import com.durgesh.restaurant.models.Prediction;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

/**
 * Created by Snehal Tembare on 26/9/17.

 */

public class PlaceAPI {
    private Context context;
    public static ArrayList<Prediction> PREDICTIONS = new ArrayList<>();

    public PlaceAPI(Context context) {
        this.context = context;
    }

    /* private ArrayList<String> placeArray = new ArrayList<>();
     private SnapXInterface service;
     private Context context;


     public PlaceAPI(Context context) {
         this.context = context;
     }

     public ArrayList<String> autocomplete (String input) {
         service = ApiClient.getGoogleClient(context).create(SnapXInterface.class);

         Call<PlacesAutoCompleteData> call = service.searchPredictions(input);

         call.enqueue(new Callback<PlacesAutoCompleteData>() {
             @Override
             public void onResponse(Call<PlacesAutoCompleteData> call, Response<PlacesAutoCompleteData> response) {
                 if (response.body() != null) {
                     if (response.body().getPredictions() != null
                             && response.body().getPredictions().size() != 0) {
                         placeArray.clear();
                         for (int i = 0; i < response.body().getPredictions().size(); i++) {
                             placeArray.add(response.body().getPredictions().get(i).getDescription());
                         }
 //                        callBack.searchPredictions(placeArray);
                     }
 //                    else {
 //                        callBack.searchPredictions(null);
 //                    }
                 }

             }

             @Override
             public void onFailure(Call<PlacesAutoCompleteData> call, Throwable t) {

             }
         });

         return placeArray;
     }*/
    private static final String TAG = PlaceAPI.class.getSimpleName();
    private com.durgesh.restaurant.utility.SnapXInterface service;
    private Context mContext;

    private static final String PLACES_API_BASE = "https://maps.googleapis.com/maps/api/place";
    private static final String TYPE_AUTOCOMPLETE = "/autocomplete";
    private static final String OUT_JSON = "/json";

    private static final String API_KEY = "AIzaSyBE60eBPlcvijgNGHK3X-Odd8zHJ2WksNk";

    public void autocomplete(String input) {

   /* Using Retrofit

        final ArrayList<String> resultList = new ArrayList<>();
      service = ApiClient.getGoogleClient(context).create(SnapXInterface.class);

        Call<PlacesAutoCompleteData> call = service.searchPredictions(input);

        call.enqueue(new Callback<PlacesAutoCompleteData>() {
            @Override
            public void onResponse(Call<PlacesAutoCompleteData> call, Response<PlacesAutoCompleteData> response) {
                if (response.body() != null) {
                    if (response.body().getPredictions() != null
                            && response.body().getPredictions().size() != 0) {
                        for (int i = 0; i < response.body().getPredictions().size(); i++) {
                            resultList.add(response.body().getPredictions().get(i).getDescription());
                        }
                    }
                }

            }

            @Override
            public void onFailure(Call<PlacesAutoCompleteData> call, Throwable t) {

            }
        });

        return resultList;*/

        ArrayList<String> resultList = null;

        HttpURLConnection conn = null;
        StringBuilder jsonResults = new StringBuilder();

        try {
            StringBuilder sb = new StringBuilder(PLACES_API_BASE + TYPE_AUTOCOMPLETE + OUT_JSON);
            sb.append("?key=" + API_KEY);
//            sb.append("&types=(cities)");
            sb.append("&input=" + URLEncoder.encode(input, "utf8"));

            URL url = new URL(sb.toString());
            Log.v(TAG, "Link " + url);
            conn = (HttpURLConnection) url.openConnection();
            InputStreamReader in = new InputStreamReader(conn.getInputStream());

            // Load the results into a StringBuilder
            int read;
            char[] buff = new char[1024];
            while ((read = in.read(buff)) != -1) {
                jsonResults.append(buff, 0, read);
            }
        } catch (MalformedURLException e) {
            Log.e(TAG, "Error processing Places API URL", e);
//            return resultList;
//            return PREDICTIONS;
        } catch (IOException e) {
            Log.e(TAG, "Error connecting to Places API", e);
//            return resultList;
//            return PREDICTIONS;
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }

        try {
            // Log.d(TAG, jsonResults.toString());

            // Create a JSON object hierarchy from the results
            JSONObject jsonObj = new JSONObject(jsonResults.toString());
            JSONArray predsJsonArray = jsonObj.getJSONArray("predictions");

            // Extract the Place descriptions from the results
            resultList = new ArrayList<String>(predsJsonArray.length());
//            PREDICTIONS = new ArrayList<Prediction>();


            for (int i = 0; i < predsJsonArray.length(); i++) {
                if (predsJsonArray.getJSONObject(i).getString("place_id") != null) {
//                    resultList.add(predsJsonArray.getJSONObject(i).getString("description"));

//                    Log.v("Place and Desc",predsJsonArray.getJSONObject(i).getString("description")
//                            +"-"+predsJsonArray.getJSONObject(i).getString("place_id"));
                    Prediction p = new Prediction();
                    p.setDescription(predsJsonArray.getJSONObject(i).getString("description"));
                    p.setPlace_id(predsJsonArray.getJSONObject(i).getString("place_id"));
                    Log.v("autocomplete",""+PREDICTIONS.add(p));
                }/*else {
                    resultList.add(predsJsonArray.getJSONObject(i).getString("description"));
                    p.setDescription(predsJsonArray.getJSONObject(i).getString("description"));
                    p.setPlace_id(null);
                    PREDICTIONS.add(p);
                }*/

            }
        } catch (JSONException e) {
            Log.e(TAG, "Cannot process JSON results", e);
        }

//        return resultList;
//        return PREDICTIONS;
    }
}
