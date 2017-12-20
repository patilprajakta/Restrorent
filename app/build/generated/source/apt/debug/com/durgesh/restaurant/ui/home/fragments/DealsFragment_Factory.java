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
public final class DealsFragment_Factory implements Factory<DealsFragment> {
  private final Provider<DispatchingAndroidInjector<Fragment>> childFragmentInjectorProvider;

  private final Provider<HomeContract.Presenter> mPresenterProvider;

  public DealsFragment_Factory(
      Provider<DispatchingAndroidInjector<Fragment>> childFragmentInjectorProvider,
      Provider<HomeContract.Presenter> mPresenterProvider) {
    this.childFragmentInjectorProvider = childFragmentInjectorProvider;
    this.mPresenterProvider = mPresenterProvider;
  }

  @Override
  public DealsFragment get() {
    DealsFragment instance = new DealsFragment();
    DaggerFragment_MembersInjector.injectChildFragmentInjector(
        instance, childFragmentInjectorProvider.get());
    DealsFragment_MembersInjector.injectMPresenter(instance, mPresenterProvider.get());
    return instance;
  }

  public static Factory<DealsFragment> create(
      Provider<DispatchingAndroidInjector<Fragment>> childFragmentInjectorProvider,
      Provider<HomeContract.Presenter> mPresenterProvider) {
    return new DealsFragment_Factory(childFragmentInjectorProvider, mPresenterProvider);
  }

  public static DealsFragment newDealsFragment() {
    return new DealsFragment();
  }
}
