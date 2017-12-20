package com.durgesh.restaurant.ui.home.fragments;

import android.app.Fragment;
import dagger.android.DaggerFragment_MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class CouponsFragment_Factory implements Factory<CouponsFragment> {
  private final Provider<DispatchingAndroidInjector<Fragment>> childFragmentInjectorProvider;

  public CouponsFragment_Factory(
      Provider<DispatchingAndroidInjector<Fragment>> childFragmentInjectorProvider) {
    this.childFragmentInjectorProvider = childFragmentInjectorProvider;
  }

  @Override
  public CouponsFragment get() {
    CouponsFragment instance = new CouponsFragment();
    DaggerFragment_MembersInjector.injectChildFragmentInjector(
        instance, childFragmentInjectorProvider.get());
    return instance;
  }

  public static Factory<CouponsFragment> create(
      Provider<DispatchingAndroidInjector<Fragment>> childFragmentInjectorProvider) {
    return new CouponsFragment_Factory(childFragmentInjectorProvider);
  }

  public static CouponsFragment newCouponsFragment() {
    return new CouponsFragment();
  }
}
