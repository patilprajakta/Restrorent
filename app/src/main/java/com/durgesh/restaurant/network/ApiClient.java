package com.durgesh.restaurant.network;

import android.content.Context;

import com.durgesh.restaurant.R;
import com.durgesh.restaurant.app.constant.RToast;
import com.durgesh.restaurant.app.constant.RWebConstants;
import com.durgesh.restaurant.common.utilities.NetworkUtility;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Prajakta Patil on 30/8/17.

 */

public class ApiClient {

    private static Retrofit googleRetrofit = null;
    private static Retrofit retrofit = null;

    public static Retrofit getGoogleClient(Context context) {

        if (NetworkUtility.isNetworkAvailable(context)) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

            if (null == googleRetrofit) {
                googleRetrofit = new Retrofit.Builder()
                        .baseUrl(RWebConstants.GOOGLE_BASE_URL)
                        .client(client)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
            }
            return googleRetrofit;
        } else {
            RToast.showLongToast(context, context.getString(R.string.check_nw_connectivity));
            return null;
        }
    }

    public static Retrofit getClient(Context context) {

        if (NetworkUtility.isNetworkAvailable(context)) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor)
                    .readTimeout(180, TimeUnit.SECONDS)
                    .connectTimeout(180, TimeUnit.SECONDS)
                    .build();

            if (null == retrofit) {
                retrofit = new Retrofit.Builder()
                        .baseUrl(RWebConstants.BASE_URL)
                        .client(client)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
            }
            return retrofit;
        } else {
            RToast.showLongToast(context, context.getString(R.string.check_nw_connectivity));
            return null;
        }
    }
}
