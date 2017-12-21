package com.durgesh.restaurant.ui.home;

import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class HomeMapPresenter_Factory implements Factory<HomeMapPresenter> {
  private final Provider<HomeInteracter> homeInteractorProvider;

  public HomeMapPresenter_Factory(Provider<HomeInteracter> homeInteractorProvider) {
    this.homeInteractorProvider = homeInteractorProvider;
  }

  @Override
  public HomeMapPresenter get() {
    return new HomeMapPresenter(homeInteractorProvider.get());
  }

  public static Factory<HomeMapPresenter> create(Provider<HomeInteracter> homeInteractorProvider) {
    return new HomeMapPresenter_Factory(homeInteractorProvider);
  }
}
