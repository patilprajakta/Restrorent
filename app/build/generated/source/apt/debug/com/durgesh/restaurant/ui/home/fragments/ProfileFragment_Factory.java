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
public final class ProfileFragment_Factory implements Factory<ProfileFragment> {
  private final Provider<DispatchingAndroidInjector<Fragment>> childFragmentInjectorProvider;

  private final Provider<HomeContract.Presenter> mPresenterProvider;

  public ProfileFragment_Factory(
      Provider<DispatchingAndroidInjector<Fragment>> childFragmentInjectorProvider,
      Provider<HomeContract.Presenter> mPresenterProvider) {
    this.childFragmentInjectorProvider = childFragmentInjectorProvider;
    this.mPresenterProvider = mPresenterProvider;
  }

  @Override
  public ProfileFragment get() {
    ProfileFragment instance = new ProfileFragment();
    DaggerFragment_MembersInjector.injectChildFragmentInjector(
        instance, childFragmentInjectorProvider.get());
    ProfileFragment_MembersInjector.injectMPresenter(instance, mPresenterProvider.get());
    return instance;
  }

  public static Factory<ProfileFragment> create(
      Provider<DispatchingAndroidInjector<Fragment>> childFragmentInjectorProvider,
      Provider<HomeContract.Presenter> mPresenterProvider) {
    return new ProfileFragment_Factory(childFragmentInjectorProvider, mPresenterProvider);
  }

  public static ProfileFragment newProfileFragment() {
    return new ProfileFragment();
  }
}
