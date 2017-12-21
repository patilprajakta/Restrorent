package com.durgesh.restaurant.ui.home.fragments;

import android.app.Fragment;
import com.durgesh.restaurant.ui.home.HomeContract;
import dagger.android.DaggerFragment_MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class MapFragment_Factory implements Factory<MapFragment> {
  private final Provider<DispatchingAndroidInjector<Fragment>> childFragmentInjectorProvider;

  private final Provider<HomeContract.MapPresenter> mapPresenterProvider;

  public MapFragment_Factory(
      Provider<DispatchingAndroidInjector<Fragment>> childFragmentInjectorProvider,
      Provider<HomeContract.MapPresenter> mapPresenterProvider) {
    this.childFragmentInjectorProvider = childFragmentInjectorProvider;
    this.mapPresenterProvider = mapPresenterProvider;
  }

  @Override
  public MapFragment get() {
    MapFragment instance = new MapFragment();
    DaggerFragment_MembersInjector.injectChildFragmentInjector(
        instance, childFragmentInjectorProvider.get());
    MapFragment_MembersInjector.injectMapPresenter(instance, mapPresenterProvider.get());
    return instance;
  }

  public static Factory<MapFragment> create(
      Provider<DispatchingAndroidInjector<Fragment>> childFragmentInjectorProvider,
      Provider<HomeContract.MapPresenter> mapPresenterProvider) {
    return new MapFragment_Factory(childFragmentInjectorProvider, mapPresenterProvider);
  }

  public static MapFragment newMapFragment() {
    return new MapFragment();
  }
}
