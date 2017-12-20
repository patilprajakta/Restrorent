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
public final class HomeListFragment_Factory implements Factory<HomeListFragment> {
  private final Provider<DispatchingAndroidInjector<Fragment>> childFragmentInjectorProvider;

  private final Provider<HomeContract.Presenter> mPresenterProvider;

  public HomeListFragment_Factory(
      Provider<DispatchingAndroidInjector<Fragment>> childFragmentInjectorProvider,
      Provider<HomeContract.Presenter> mPresenterProvider) {
    this.childFragmentInjectorProvider = childFragmentInjectorProvider;
    this.mPresenterProvider = mPresenterProvider;
  }

  @Override
  public HomeListFragment get() {
    HomeListFragment instance = new HomeListFragment();
    DaggerFragment_MembersInjector.injectChildFragmentInjector(
        instance, childFragmentInjectorProvider.get());
    HomeListFragment_MembersInjector.injectMPresenter(instance, mPresenterProvider.get());
    return instance;
  }

  public static Factory<HomeListFragment> create(
      Provider<DispatchingAndroidInjector<Fragment>> childFragmentInjectorProvider,
      Provider<HomeContract.Presenter> mPresenterProvider) {
    return new HomeListFragment_Factory(childFragmentInjectorProvider, mPresenterProvider);
  }

  public static HomeListFragment newHomeListFragment() {
    return new HomeListFragment();
  }
}
