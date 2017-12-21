package com.durgesh.restaurant.ui.home.fragments;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.location.Address;
import android.os.Bundle;
import android.support.annotation.Nullable;
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

import com.durgesh.restaurant.R;
import com.durgesh.restaurant.app.constant.RToast;
import com.durgesh.restaurant.models.Result;
import com.durgesh.restaurant.models.googlePlaces.Place;
import com.durgesh.restaurant.ui.direction.DirectionsActivity;
import com.durgesh.restaurant.ui.home.HomeContract;
import com.durgesh.restaurant.ui.home.HomeListAdapter;
import com.durgesh.restaurant.ui.homeLocation.HomeLocationActivity;
import com.durgesh.restaurant.ui.homeLocation.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dagger.android.DaggerFragment;

/**
 * Created by Snehal Tembare on 5/9/17.
 */


public class HomeListFragment extends DaggerFragment implements HomeContract.HomeView {

    @Inject
    HomeContract.Presenter mPresenter;

    public interface  HomeListConstant {
        static final int ACCESS_FINE_LOCATION  = 1;
        static final String  TAG = "HomeListFragment";

    }

    @Inject
    public HomeListFragment() {
    }

    @BindView(R.id.txt_filter)
    protected TextView mTxtFilter;

    @BindView(R.id.txt_current_place)
    protected TextView mTxtCurrentPlace;

    @BindView(R.id.txt_restaurants_count)
    protected TextView mTxtRestaurantsCount;

    private ProgressDialog mDialog;

    private HomeListAdapter mListAdapter;

    @BindView(R.id.recyclerview)
    protected RecyclerView mRecyclerView;

    @BindView(R.id.txt_sort)
    protected TextView mTxtSort;

    private Activity mActivity;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public Activity activity() {
         return getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

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
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        mPresenter.takeView(this);
        super.onViewCreated(view, savedInstanceState);
        mActivity = getActivity();
        showProgressDialog();
        mPresenter.getUserLocation();
        showPopUpMenu();
    }

    @Override
    public void updateAddress(List<Address> addresses) {
        if (addresses.size() != 0) {
            if (addresses.get(0).getSubLocality() != null) {
                mTxtCurrentPlace.setText(addresses.get(0).getSubLocality());
            } else {
                if (addresses.get(0).getThoroughfare() != null) {
                    mTxtCurrentPlace.setText(addresses.get(0).getThoroughfare());
                }
            }
        }
    }

    public void updateRestaurantCount(List<Result> resultArrayList) {
        mTxtRestaurantsCount.setText(String.valueOf(resultArrayList.size()) + " Restaurants");
    }
    @Override
    public void showProgressDialog() {
        if (mDialog == null) {
            mDialog = new ProgressDialog(mActivity);
            mDialog.setMessage(getString(R.string.please_wait));
        }
       mDialog.show();
    }

    public void dismissDialog() {
        mDialog.dismiss();
    }
    @Override
    public void showPopUpMenu() {
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

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mActivity = activity;
    }

    @OnClick(R.id.txt_filter)
    public void openSecondActivity() {
        RToast.showToast(getActivity(),"clicked");
    }


    public void loadHomeList(ArrayList<Place> placeArrayList) {
        mListAdapter = new HomeListAdapter(activity(), placeArrayList, new OnItemClickListener() {
            @Override
            public void onItemClick(Place place) {
                Intent intent = new Intent(activity(), DirectionsActivity.class);
                startActivity(intent);
            }
        });
    }
    @Override
    public void updateView() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
        mRecyclerView.setAdapter(mListAdapter);
        mListAdapter.notifyDataSetChanged();
    }

    @OnClick(R.id.txt_current_place)
    public void openHomeLocation() {
        Intent intent = new Intent(getActivity(), HomeLocationActivity.class);
        intent.putExtra("location", mPresenter.getLocation());
        startActivityForResult(intent, 1);
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.takeView(this);
        double lat = mPresenter.getLatitude();
        double lng = mPresenter.getLongitude();
        if (lat != 0 && lng != 0) {
           mPresenter.getPlaces(lat,lng);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (data != null) {
                Log.v(HomeListConstant.TAG, "" + data.getExtras().getDouble("lat"));
                Log.v(HomeListConstant.TAG, "" + data.getExtras().getDouble("lng"));
                if (mPresenter.getLocation().getLatitude() != data.getExtras().getDouble("lat")
                        && mPresenter.getLocation().getLongitude() != data.getExtras().getDouble("lng")) {
                    double lat = data.getExtras().getDouble("lat");
                            double lng = data.getExtras().getDouble("lng");
                    mPresenter.setLatitude(lat );
                    mPresenter.setLongitude( lng);

                    if (lat != 0 && lng != 0) {
                        mPresenter.getPlaces(lat, lng);
                    }
                }
            }
        }
    }

    @OnClick(R.id.txt_filter)
    public void openMapActivityCurrentPlace() {
        RToast.showToast(getActivity(), "clicked");
    }
}
