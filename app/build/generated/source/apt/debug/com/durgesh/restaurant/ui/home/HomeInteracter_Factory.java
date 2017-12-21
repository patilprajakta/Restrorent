package com.durgesh.restaurant.ui.home;

import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class HomeInteracter_Factory implements Factory<HomeInteracter> {
  private static final HomeInteracter_Factory INSTANCE = new HomeInteracter_Factory();

  @Override
  public HomeInteracter get() {
    return new HomeInteracter();
  }

  public static Factory<HomeInteracter> create() {
    return INSTANCE;
  }
}
