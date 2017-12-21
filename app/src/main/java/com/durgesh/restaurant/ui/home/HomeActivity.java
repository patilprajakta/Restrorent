package com.durgesh.restaurant.ui.home;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.view.MenuItem;

import com.durgesh.restaurant.R;
import com.durgesh.restaurant.ui.BaseActivity;
import com.durgesh.restaurant.ui.home.fragments.CouponsFragment;
import com.durgesh.restaurant.ui.home.fragments.DealsFragment;
import com.durgesh.restaurant.ui.home.fragments.HomeListFragment;
import com.durgesh.restaurant.ui.home.fragments.MapFragment;
import com.durgesh.restaurant.ui.home.fragments.ProfileFragment;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.Lazy;


/**
 * Created by Snehal Tembare on 24/8/17.

 */
public class HomeActivity extends BaseActivity {

    @Inject
    HomePresenter mHomePresenter;

    @Inject
    Lazy<HomeListFragment> homeFragmentProvider;

    @Inject
    Lazy<MapFragment> mapFragmentProvider;

    @Inject
    Lazy<DealsFragment> dealsFragmentProvider;

    @Inject
    Lazy<CouponsFragment> couponsFragmentProvider;

    @Inject
    Lazy<ProfileFragment> profileFragmentProvider;

    @BindView(R.id.navigation)
    protected BottomNavigationView mBottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;
                switch (item.getItemId()) {

                    case R.id.menu_list:
                        selectedFragment = homeFragmentProvider.get();
                        break;
                    case R.id.menu_map:
                        selectedFragment = mapFragmentProvider.get();
                        break;
                    case R.id.menu_deals:
                        selectedFragment = dealsFragmentProvider.get();
                        break;
                    case R.id.menu_coupons:
                        selectedFragment = couponsFragmentProvider.get();
                        break;
                    case R.id.menu_profile:
                        selectedFragment = profileFragmentProvider.get();
                        break;
                }

                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.frame_layout, selectedFragment);
                transaction.commit();
                return true;
            }
        });
        Fragment fragment =  homeFragmentProvider.get();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout, fragment);
        transaction.commit();
    }

    @Override
    public void onDestroy() {
        mHomePresenter.dropView();
        super.onDestroy();
    }
}
