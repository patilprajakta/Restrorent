package com.durgesh.restaurant.ui.home;

import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class HomePresenter_Factory implements Factory<HomePresenter> {
  private final Provider<HomeInteracter> homeInteractorProvider;

  public HomePresenter_Factory(Provider<HomeInteracter> homeInteractorProvider) {
    this.homeInteractorProvider = homeInteractorProvider;
  }

  @Override
  public HomePresenter get() {
    return new HomePresenter(homeInteractorProvider.get());
  }

  public static Factory<HomePresenter> create(Provider<HomeInteracter> homeInteractorProvider) {
    return new HomePresenter_Factory(homeInteractorProvider);
  }

  public static HomePresenter newHomePresenter(HomeInteracter homeInteractor) {
    return new HomePresenter(homeInteractor);
  }
}
