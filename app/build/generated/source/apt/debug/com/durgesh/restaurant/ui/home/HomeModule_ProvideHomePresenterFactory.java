package com.durgesh.restaurant.ui.home;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class HomeModule_ProvideHomePresenterFactory
    implements Factory<HomeContract.Presenter> {
  private final Provider<HomeInteracter> interactorProvider;

  public HomeModule_ProvideHomePresenterFactory(Provider<HomeInteracter> interactorProvider) {
    this.interactorProvider = interactorProvider;
  }

  @Override
  public HomeContract.Presenter get() {
    return Preconditions.checkNotNull(
        HomeModule.provideHomePresenter(interactorProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<HomeContract.Presenter> create(
      Provider<HomeInteracter> interactorProvider) {
    return new HomeModule_ProvideHomePresenterFactory(interactorProvider);
  }

  public static HomeContract.Presenter proxyProvideHomePresenter(HomeInteracter interactor) {
    return HomeModule.provideHomePresenter(interactor);
  }
}
