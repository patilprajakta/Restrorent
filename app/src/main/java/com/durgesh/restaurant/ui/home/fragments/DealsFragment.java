package com.durgesh.restaurant.ui.home.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.durgesh.restaurant.R;
import com.durgesh.restaurant.ui.home.HomeContract;

import javax.inject.Inject;

import dagger.android.DaggerFragment;


/**
 * Created by Snehal Tembare on 5/9/17.

 */
public class DealsFragment extends DaggerFragment implements HomeContract.View {


    @Inject
    HomeContract.Presenter mPresenter;

    @Inject
    public DealsFragment(){

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_deals, container, false);
    }

}
