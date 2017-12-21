package com.durgesh.restaurant.ui.home.fragments;

import android.app.Fragment;
import com.durgesh.restaurant.ui.home.HomeContract;
import dagger.MembersInjector;
import dagger.android.DaggerFragment_MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class MapFragment_MembersInjector implements MembersInjector<MapFragment> {
  private final Provider<DispatchingAndroidInjector<Fragment>> childFragmentInjectorProvider;

  private final Provider<HomeContract.MapPresenter> mapPresenterProvider;

  public MapFragment_MembersInjector(
      Provider<DispatchingAndroidInjector<Fragment>> childFragmentInjectorProvider,
      Provider<HomeContract.MapPresenter> mapPresenterProvider) {
    this.childFragmentInjectorProvider = childFragmentInjectorProvider;
    this.mapPresenterProvider = mapPresenterProvider;
  }

  public static MembersInjector<MapFragment> create(
      Provider<DispatchingAndroidInjector<Fragment>> childFragmentInjectorProvider,
      Provider<HomeContract.MapPresenter> mapPresenterProvider) {
    return new MapFragment_MembersInjector(childFragmentInjectorProvider, mapPresenterProvider);
  }

  @Override
  public void injectMembers(MapFragment instance) {
    DaggerFragment_MembersInjector.injectChildFragmentInjector(
        instance, childFragmentInjectorProvider.get());
    injectMapPresenter(instance, mapPresenterProvider.get());
  }

  public static void injectMapPresenter(
      MapFragment instance, HomeContract.MapPresenter mapPresenter) {
    instance.mapPresenter = mapPresenter;
  }
}
