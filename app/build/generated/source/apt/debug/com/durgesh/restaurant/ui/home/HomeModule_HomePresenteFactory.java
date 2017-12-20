package com.durgesh.restaurant.ui.home;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class HomeModule_HomePresenteFactory implements Factory<HomeContract.Presenter> {
  private final Provider<HomeInteractor> interactorProvider;

  public HomeModule_HomePresenteFactory(Provider<HomeInteractor> interactorProvider) {
    this.interactorProvider = interactorProvider;
  }

  @Override
  public HomeContract.Presenter get() {
    return Preconditions.checkNotNull(
        HomeModule.homePresente(interactorProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<HomeContract.Presenter> create(
      Provider<HomeInteractor> interactorProvider) {
    return new HomeModule_HomePresenteFactory(interactorProvider);
  }

  public static HomeContract.Presenter proxyHomePresente(HomeInteractor interactor) {
    return HomeModule.homePresente(interactor);
  }
}
