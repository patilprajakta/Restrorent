package com.durgesh.restaurant.dagger;

import com.durgesh.restaurant.common.Router;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class AppModule_ProvideRouterFactory implements Factory<Router> {
  private static final AppModule_ProvideRouterFactory INSTANCE =
      new AppModule_ProvideRouterFactory();

  @Override
  public Router get() {
    return Preconditions.checkNotNull(
        AppModule.provideRouter(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<Router> create() {
    return INSTANCE;
  }

  public static Router proxyProvideRouter() {
    return AppModule.provideRouter();
  }
}
