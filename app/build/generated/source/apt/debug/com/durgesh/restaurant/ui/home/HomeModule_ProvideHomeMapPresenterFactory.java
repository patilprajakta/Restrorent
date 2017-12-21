package com.durgesh.restaurant.ui.home;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class HomeModule_ProvideHomeMapPresenterFactory
    implements Factory<HomeContract.MapPresenter> {
  private final Provider<HomeInteracter> interactorProvider;

  public HomeModule_ProvideHomeMapPresenterFactory(Provider<HomeInteracter> interactorProvider) {
    this.interactorProvider = interactorProvider;
  }

  @Override
  public HomeContract.MapPresenter get() {
    return Preconditions.checkNotNull(
        HomeModule.provideHomeMapPresenter(interactorProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<HomeContract.MapPresenter> create(
      Provider<HomeInteracter> interactorProvider) {
    return new HomeModule_ProvideHomeMapPresenterFactory(interactorProvider);
  }

  public static HomeContract.MapPresenter proxyProvideHomeMapPresenter(HomeInteracter interactor) {
    return HomeModule.provideHomeMapPresenter(interactor);
  }
}
