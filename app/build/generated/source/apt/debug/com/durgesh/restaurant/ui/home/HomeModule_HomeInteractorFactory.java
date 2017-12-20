package com.durgesh.restaurant.ui.home;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class HomeModule_HomeInteractorFactory implements Factory<HomeInteractor> {
  private static final HomeModule_HomeInteractorFactory INSTANCE =
      new HomeModule_HomeInteractorFactory();

  @Override
  public HomeInteractor get() {
    return Preconditions.checkNotNull(
        HomeModule.homeInteractor(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<HomeInteractor> create() {
    return INSTANCE;
  }

  public static HomeInteractor proxyHomeInteractor() {
    return HomeModule.homeInteractor();
  }
}
