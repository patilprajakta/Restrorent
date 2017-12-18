package com.durgesh.restaurant.ui.home.fragments;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.durgesh.restaurant.HomeListAdapter;
import com.durgesh.restaurant.R;
import com.durgesh.restaurant.models.Hotel;
import com.durgesh.restaurant.models.OpeningHours;
import com.durgesh.restaurant.models.Result;
import com.durgesh.restaurant.models.googlePlaces.Place;
import com.durgesh.restaurant.network.ApiClient;
import com.durgesh.restaurant.ui.currentLocation.CurrentLocationActivity;
import com.durgesh.restaurant.ui.details.DetailsActivity;
import com.durgesh.restaurant.ui.direction.DirectionsActivity;
import com.durgesh.restaurant.ui.home.HomeContract;
import com.durgesh.restaurant.ui.homeLocation.HomeLocationActivity;
import com.durgesh.restaurant.ui.homeLocation.OnItemClickListener;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dagger.android.DaggerFragment;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Snehal Tembare on 5/9/17.

 */
public class HomeListFragment extends DaggerFragment implements HomeContract.View {


    @Inject
    HomeContract.Presenter mPresenter;

    @Inject
    public HomeListFragment() {
        // Requires empty public constructor
    }
    private static final int ACCESS_FINE_LOCATION = 1;
    private static final String TAG = "HomeListFragment";
    private FusedLocationProviderClient mFusedLocationProviderClient;
    private Location mLastKnownLocation;
    @BindView(R.id.txt_filter)
    protected TextView mTxtFilter;

    @BindView(R.id.txt_current_place)
    protected TextView mTxtCurrentPlace;

    @BindView(R.id.txt_restaurants_count)
    protected TextView mTxtRestaurantsCount;

    private ProgressDialog mDialog;
    private List<Result> resultArrayList;
    private ArrayList<Place> placeArrayList;
    private OpeningHours openingHours;
    private HomeListAdapter mListAdapter;

    @BindView(R.id.recyclerview)
    protected RecyclerView mRecyclerView;

    @BindView(R.id.txt_sort)
    protected TextView mTxtSort;

    private com.durgesh.restaurant.network.ApiHelper service;
    private Place place;

    private Activity mActivity;
    private double lat = 0;
    private double lng = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.v(TAG, "onCreate");

//        init();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        View view = inflater.inflate(R.layout.fragment_home_list, container, false);
        Log.v(TAG, "onCreateView");

        View view = null;

        if (view != null) {
            ViewGroup parent = (ViewGroup) view.getParent();
            if (parent != null)
                parent.removeView(view);
        }
        try {
            view = inflater.inflate(R.layout.fragment_home_list, container, false);
            ButterKnife.bind(this, view);

        } catch (InflateException e) {
            return view;
        }
     /*   if (getArguments()!=null){
        lat= Double.parseDouble(getArguments().getString("lat"));
        lng= Double.parseDouble(getArguments().getString("lng"));}*/
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mActivity = getActivity();
        Log.v(TAG, "onViewCreated");
//        init();
        mDialog = new ProgressDialog(mActivity);
        mDialog.setMessage(getString(R.string.please_wait));

        if (ApiClient.getGoogleClient(mActivity) != null) {
            service = ApiClient.getGoogleClient(mActivity).create(com.durgesh.restaurant.network.ApiHelper.class);
        }

        if (ActivityCompat.checkSelfPermission(mActivity, android.Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission
                (mActivity, android.Manifest.permission.ACCESS_COARSE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(mActivity,
                    new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION},
                    ACCESS_FINE_LOCATION);
            Log.v(TAG, "onViewCreated  - ACCESS_FINE_LOCATION");
        } else {
            mFusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(mActivity);
            Task<Location> locationResult = mFusedLocationProviderClient.getLastLocation();
            locationResult.addOnCompleteListener(mActivity, new OnCompleteListener<Location>() {
                @Override
                public void onComplete(@NonNull Task<Location> task) {
                    if (task.isSuccessful()) {
                        mLastKnownLocation = task.getResult();
                        Geocoder geocoder = new Geocoder(mActivity);
                        try {

                            Log.v("Lat", "" + mLastKnownLocation.getLatitude());
                            Log.v("Long", "" + mLastKnownLocation.getLongitude());

                            List<Address> addresses = geocoder.getFromLocation(mLastKnownLocation.getLatitude(),
                                    mLastKnownLocation.getLongitude(), 1);
                            if (addresses.size() != 0) {
                                Log.v("Full address", "" + addresses);
                                Log.v("Locality", "" + addresses.get(0).getSubLocality());
                                if (addresses.get(0).getSubLocality() != null) {
                                    mTxtCurrentPlace.setText(addresses.get(0).getSubLocality());
                                } else {
                                    if (addresses.get(0).getThoroughfare() != null) {
                                        mTxtCurrentPlace.setText(addresses.get(0).getThoroughfare());
                                    }
                                }
                            }
                            lat = mLastKnownLocation.getLatitude();
                            lng = mLastKnownLocation.getLongitude();
                            if (lat != 0 && lng != 0) {
                                callPlaceAPI(lat, lng);
                            }

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });

            mTxtSort.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    PopupMenu popupMenu = new PopupMenu(mActivity, v);
                    popupMenu.inflate(R.menu.menu_sort);
                    popupMenu.show();
                    popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            switch (item.getItemId()) {
                                case R.id.menu_rating:
                                    mTxtSort.setText(item.getTitle());
                                    break;
                                case R.id.menu_relevance:
                                    mTxtSort.setText(item.getTitle());
                                    break;
                                case R.id.menu_deals:
                                    mTxtSort.setText(item.getTitle());
                                    break;
                                case R.id.menu_discount:
                                    mTxtSort.setText(item.getTitle());
                                    break;
                                case R.id.menu_name:
                                    mTxtSort.setText(item.getTitle());
                                    break;
                            }
                            return true;
                        }
                    });
                }
            });
        }
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Log.v(TAG, "onAttach");
        mActivity = activity;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.v(TAG, "onDetach");

    }


    @OnClick(R.id.txt_filter)
    public void openSecondActivity() {
        startActivity(new Intent(mActivity, DetailsActivity.class));
    }


    private void callPlaceAPI(double lat, double lng) {
        final Call<Hotel> call = service.searchNearestPlaces(lat
                + "," + lng);
        mDialog.show();

        call.enqueue(new Callback<Hotel>() {
            @Override
            public void onResponse(Call<Hotel> call, Response<Hotel> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        mDialog.dismiss();
                        Log.v("Retrofit response", "" + response.body().toString());

                        resultArrayList = response.body().getResults();

                        //Place API call
                        if (resultArrayList != null) {
                            if (resultArrayList.size() == 0) {
                                Toast.makeText(mActivity, R.string.data_not_found, Toast.LENGTH_LONG).show();
                            } else {

                                placeArrayList = new ArrayList<>();
                                Log.v("Size", "" + resultArrayList.size());
                                mTxtRestaurantsCount.setText(String.valueOf(resultArrayList.size()) + " Restaurants");
                                for (int i = 0; i < (resultArrayList.size() - 1); i++) {

                                    Location destination = new Location("Destination");
                                    destination.setLatitude(resultArrayList.get(i).getGeometry().getLocation().getLat());
                                    destination.setLongitude(resultArrayList.get(i).getGeometry().getLocation().getLng());
                                    Log.v(TAG, "******" + resultArrayList.get(0).getName());
                                    if (resultArrayList.get(i).getOpening_hours() != null) {
                                        if (resultArrayList.get(i).getOpening_hours().getWeekday_text() != null) {
                                            openingHours = new OpeningHours(resultArrayList.get(i).getOpening_hours().isOpen_now(),
                                                    resultArrayList.get(i).getOpening_hours().getWeekday_text());
                                        } else {
                                            openingHours = new OpeningHours(resultArrayList.get(i).getOpening_hours().isOpen_now(),
                                                    null);
                                        }

                                    } else {
                                        openingHours = new OpeningHours(true, null);
                                    }

                                    if (resultArrayList.get(i) != null && resultArrayList.get(i).getPhotos() != null &&
                                            resultArrayList.get(i).getPhotos().get(0) != null &&
                                            resultArrayList.get(i).getPhotos().get(0).getPhoto_reference() != null
                                            && openingHours != null) {
                                        place = new Place(resultArrayList.get(i).getName(),
                                                resultArrayList.get(i).getRating(), null,
                                                destination.distanceTo(mLastKnownLocation),
                                                resultArrayList.get(i).getPhotos().get(0).getPhoto_reference(),
                                                openingHours);
                                    } else {
                                        place = new Place(resultArrayList.get(i).getName(),
                                                resultArrayList.get(i).getRating(), null,
                                                destination.distanceTo(mLastKnownLocation),
                                                null, null);
                                    }


                                    placeArrayList.add(place);

                                }

                                mListAdapter = new HomeListAdapter(mActivity, placeArrayList, new OnItemClickListener() {
                                    @Override
                                    public void onItemClick(Place place) {
                                        Intent intent = new Intent(mActivity, DirectionsActivity.class);
                                        startActivity(intent);
                                    }
                                });

                                mRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
                                mRecyclerView.setAdapter(mListAdapter);
                                mListAdapter.notifyDataSetChanged();

                            }
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<Hotel> call, Throwable t) {

            }
        });

    }


    @OnClick(R.id.txt_current_place)
    public void openHomeLocation() {
        Intent intent = new Intent(getActivity(), HomeLocationActivity.class);
        intent.putExtra("location", mLastKnownLocation);
        startActivityForResult(intent, 1);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.v(TAG, "onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.v(TAG, "onStart");
//        init();

    }

    @Override
    public void onResume() {
        super.onResume();
        Log.v(TAG, "onResume");
        if (lat != 0 && lng != 0) {
            callPlaceAPI(lat, lng);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.v(TAG, "onPause");

    }

    @Override
    public void onStop() {
        super.onStop();
        Log.v(TAG, "onStop");

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.v(TAG, "onDestroyView");


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.v(TAG, "onDestroy");
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.v(TAG, "onActivityResult");
        if (requestCode == 1) {
            if (data != null) {
                Log.v(TAG, "" + data.getExtras().getDouble("lat"));
                Log.v(TAG, "" + data.getExtras().getDouble("lng"));
                if (mLastKnownLocation.getLatitude() != data.getExtras().getDouble("lat")
                        && mLastKnownLocation.getLongitude() != data.getExtras().getDouble("lng")) {
                    lat = data.getExtras().getDouble("lat");
                    lng = data.getExtras().getDouble("lng");

                    if (lat != 0 && lng != 0) {
                        callPlaceAPI(lat, lng);
                    }
                }
            }
        }
    }

    @OnClick(R.id.txt_filter)
    public void openMapActivityCurrentPlace() {
        startActivity(new Intent(getActivity(), CurrentLocationActivity.class));
    }


}
