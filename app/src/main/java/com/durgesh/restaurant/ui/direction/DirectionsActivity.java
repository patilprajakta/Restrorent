package com.durgesh.restaurant.ui.direction;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.durgesh.restaurant.R;
import com.durgesh.restaurant.models.googleDir.RootGoogleDir;
import com.durgesh.restaurant.network.ApiClient;
import com.durgesh.restaurant.network.SXAPInterface;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.Dash;
import com.google.android.gms.maps.model.Gap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PatternItem;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Prajakta Patil on 28/8/17.

 */
public class DirectionsActivity extends AppCompatActivity implements OnMapReadyCallback {

    @BindView(R.id.txtDuration)
    protected TextView mTxtDuration;

    @BindView(R.id.txtDistInMiles)
    protected TextView mTxtDistance;

    @BindView(R.id.progress_bar)
    protected ProgressBar mProgressBar;

    @BindView(R.id.frame_layout)
    protected FrameLayout mFrameLayout;

    private Dash mDash = new Dash(50);

    private Gap mGap = new Gap(30);

    private List<PatternItem> mPatternDashed = Arrays.asList(mDash, mGap);

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_directions);
        ButterKnife.bind(this);

//        getSupportActionBar().hide();

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(DirectionsActivity.this);

        mProgressBar.setVisibility(View.VISIBLE);
        mFrameLayout.setAlpha((float) 0.3);

        getMapDir();

    }

    @OnClick(R.id.imgBackArrow)
    public void imgBackArrow(View view) {
        finish();
    }

    @OnClick(R.id.imgShare)
    public void imgShare(View view) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        //TODO latlngs are hardcoded for now
        intent.putExtra(Intent.EXTRA_TEXT, "http://maps.google.com/maps?saddr=18.497895,73.829229&daddr=18.531483,73.829509");
        startActivity(Intent.createChooser(intent, "Share"));
    }

    private void getMapDir() {
        SXAPInterface service;

        if (ApiClient.getGoogleClient(this) != null) {
            service = ApiClient.getGoogleClient(this).create(SXAPInterface.class);
            //TODO latlngs are hardcoded for now
            final String srcLat = "18.497895";
            final String srcLng = "73.829229";
            final String destLat = "18.504373";
            final String destLng = " 73.830680";

            Call<RootGoogleDir> call = service.getGoogleDir(srcLat + "," + srcLng,
                    destLat + "," + destLng);
            call.enqueue(new Callback<RootGoogleDir>() {
                @Override
                public void onResponse(Call<RootGoogleDir> call, Response<RootGoogleDir> response) {
                    if (response.isSuccessful()) {
                        mProgressBar.setVisibility(View.GONE);
                        mFrameLayout.setAlpha((float) 1.0);

                        for (int i = 0; i < response.body().getRoutes().size(); i++) {

                            if (response.body().getRoutes().get(i).getLegs().get(i).getDuration().getText() != null) {
                                mTxtDuration.setText(response.body().getRoutes().get(i).getLegs().get(i).getDuration().getText());
                            }
                            if (response.body().getRoutes().get(i).getLegs().get(i).getDistance().getValue() != null) {
                                float mile = (Float.parseFloat(response.body().getRoutes().get(i).getLegs().get(i).getDistance().getValue())) / 1609.34f;
                                mTxtDistance.setText("( " + String.format("%.2f", mile) + "mi" + " )");
                            }

                            LatLng src = new LatLng(Double.parseDouble(srcLat), Double.parseDouble(srcLng));
                            mMap.addMarker(new MarkerOptions()
                                    .position(src)
                                    .title(getString(R.string.current_loc))
                                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_marker)));

                            LatLng destination = new LatLng(Double.parseDouble(destLat), Double.parseDouble(destLng));
                            mMap.addMarker(new MarkerOptions()
                                    .position(destination)
                                    .title(getString(R.string.dest))
                                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_marker_dest)));

                            //TODO bounds are hardcoded
                            LatLng boundSouth = new LatLng(18.4973809, 73.8265186);
                            LatLng boundNorth = new LatLng(18.5042359, 73.8308388);
                            ArrayList<LatLng> bounds = new ArrayList<>();
                            bounds.add(boundNorth);
                            bounds.add(boundSouth);

                            LatLngBounds.Builder builder = new LatLngBounds.Builder();
                            builder.include(boundSouth);
                            builder.include(boundNorth);
                            mMap.moveCamera(CameraUpdateFactory.newLatLngBounds(builder.build(), 600, 800, 10));

                            String encodedString = response.body().getRoutes().get(0).getOverview_polyline().getPoints();
                            List<LatLng> list = decodePoly(encodedString);

                            PolylineOptions polyOptions = new PolylineOptions();
                            polyOptions.color(ContextCompat.getColor(DirectionsActivity.this, R.color.colorGoogleDir));
                            polyOptions.addAll(list);

                            mMap.addPolyline(new PolylineOptions()
                                    .addAll(list)
                                    .pattern(mPatternDashed)
                                    .width(20)
                                    .color(Color.rgb(230, 118, 7))
                                    .geodesic(true));
                        }
                    }
                }

                @Override
                public void onFailure(Call<RootGoogleDir> call, Throwable t) {
                    mProgressBar.setVisibility(View.GONE);
                    mFrameLayout.setAlpha((float) 1.0);
                }
            });
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this,
                android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        mMap.setMyLocationEnabled(true);
    }

    private List<LatLng> decodePoly(String encoded) {
        List<LatLng> poly = new ArrayList<>();
        int index = 0, len = encoded.length();
        int lat = 0, lng = 0;

        while (index < len) {
            int b, shift = 0, result = 0;
            do {
                b = encoded.charAt(index++) - 63;
                result |= (b & 0x1f) << shift;
                shift += 5;
            } while (b >= 0x20);
            int dlat = ((result & 1) != 0 ? ~(result >> 1) : (result >> 1));
            lat += dlat;

            shift = 0;
            result = 0;
            do {
                b = encoded.charAt(index++) - 63;
                result |= (b & 0x1f) << shift;
                shift += 5;
            } while (b >= 0x20);
            int dlng = ((result & 1) != 0 ? ~(result >> 1) : (result >> 1));
            lng += dlng;

            LatLng p = new LatLng((((double) lat / 1E5)),
                    (((double) lng / 1E5)));
            poly.add(p);
        }
        return poly;
    }
}
