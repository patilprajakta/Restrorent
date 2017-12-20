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
public final class DealsFragment_MembersInjector implements MembersInjector<DealsFragment> {
  private final Provider<DispatchingAndroidInjector<Fragment>> childFragmentInjectorProvider;

  private final Provider<HomeContract.Presenter> mPresenterProvider;

  public DealsFragment_MembersInjector(
      Provider<DispatchingAndroidInjector<Fragment>> childFragmentInjectorProvider,
      Provider<HomeContract.Presenter> mPresenterProvider) {
    this.childFragmentInjectorProvider = childFragmentInjectorProvider;
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<DealsFragment> create(
      Provider<DispatchingAndroidInjector<Fragment>> childFragmentInjectorProvider,
      Provider<HomeContract.Presenter> mPresenterProvider) {
    return new DealsFragment_MembersInjector(childFragmentInjectorProvider, mPresenterProvider);
  }

  @Override
  public void injectMembers(DealsFragment instance) {
    DaggerFragment_MembersInjector.injectChildFragmentInjector(
        instance, childFragmentInjectorProvider.get());
    injectMPresenter(instance, mPresenterProvider.get());
  }

  public static void injectMPresenter(DealsFragment instance, HomeContract.Presenter mPresenter) {
    instance.mPresenter = mPresenter;
  }
}
