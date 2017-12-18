package com.durgesh.restaurant.utility;

/**
 * Created by Snehal Tembare on 1/9/17.
 */

public class WebConstants {
    public static final String GOOGLE_BASE_URL = "https://maps.googleapis.com";

//    public static final String BASE_URL = " http://51457eef.ngrok.io/";
    public static final String BASE_URL = "  http://ec2-52-89-221-255.us-west-2.compute.amazonaws.com:3000/";
 //   public static final String BASE_URL = "http://localhost:3001/";

    public static final String SEARCH_PLACES = "/maps/api/place/nearbysearch/json?rankby=distance&type=restaurant&radious=1610&key=AIzaSyBE60eBPlcvijgNGHK3X-Odd8zHJ2WksNk";

    public static final String SEARCH_PHOTOS ="/maps/api/place/photo?maxwidth=400&key=AIzaSyBE60eBPlcvijgNGHK3X-Odd8zHJ2WksNk";

    public static final String SEARCH_PREDICTIONS ="/maps/api/place/autocomplete/json?sortby=distance&key=AIzaSyBE60eBPlcvijgNGHK3X-Odd8zHJ2WksNk";

    public static final String PLACE_DETAILS ="/maps/api/place/details/json?key=AIzaSyBE60eBPlcvijgNGHK3X-Odd8zHJ2WksNk";

    public static final String UPLOAD_IMAGE="image/";

    public static final int BAD_GATEWAY=502;
    public static final int NOT_FOUND=404;
}
