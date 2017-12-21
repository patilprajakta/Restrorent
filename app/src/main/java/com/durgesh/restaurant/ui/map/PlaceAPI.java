package com.durgesh.restaurant.ui.map;

import android.content.Context;
import android.util.Log;

import com.durgesh.restaurant.app.constant.Constants;
import com.durgesh.restaurant.models.Prediction;
import com.durgesh.restaurant.network.ApiHelper;

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
    public static ArrayList<Prediction> PREDICTIONS = new ArrayList<>();

    public PlaceAPI(Context context) {
        Context context1 = context;
    }

    private static final String PLACES_API_BASE = "https://maps.googleapis.com/maps/api/place";
    private static final String TYPE_AUTOCOMPLETE = "/autocomplete";
    private static final String OUT_JSON = "/json";

    public void autocomplete(String input) {

        HttpURLConnection conn = null;
        StringBuilder jsonResults = new StringBuilder();

        try {
            StringBuilder sb = new StringBuilder(PLACES_API_BASE + TYPE_AUTOCOMPLETE + OUT_JSON);
            sb.append("?key=" + Constants.GOOGLE_API_KEY);
            sb.append("&input=" + URLEncoder.encode(input, "utf8"));

            URL url = new URL(sb.toString());
            conn = (HttpURLConnection) url.openConnection();
            InputStreamReader in = new InputStreamReader(conn.getInputStream());
            int read;
            char[] buff = new char[1024];
            while ((read = in.read(buff)) != -1) {
                jsonResults.append(buff, 0, read);
            }
        } catch (MalformedURLException e) {
        } catch (IOException e) {
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }

        try {
            JSONObject jsonObj = new JSONObject(jsonResults.toString());
            JSONArray predsJsonArray = jsonObj.getJSONArray("predictions");
            for (int i = 0; i < predsJsonArray.length(); i++) {
                if (predsJsonArray.getJSONObject(i).getString("place_id") != null) {
                    Prediction p = new Prediction();
                    p.setDescription(predsJsonArray.getJSONObject(i).getString("description"));
                    p.setPlace_id(predsJsonArray.getJSONObject(i).getString("place_id"));
                }

            }
        } catch (JSONException e) {
        }
    }
}
