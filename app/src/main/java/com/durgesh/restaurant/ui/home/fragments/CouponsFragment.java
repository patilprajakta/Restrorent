package com.durgesh.restaurant.ui.home.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.durgesh.restaurant.R;

import javax.inject.Inject;

import dagger.android.DaggerFragment;


/**
 * Created by Snehal Tembare on 5/9/17.

 */
public class CouponsFragment extends DaggerFragment  {
    @Inject
    public CouponsFragment(){
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
          }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_coupons, container, false);
    }
}
