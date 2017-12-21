package com.durgesh.restaurant.dagger;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class AppModule_ProvideAppCpntextFactory implements Factory<Context> {
  private final Provider<Context> contextProvider;

  public AppModule_ProvideAppCpntextFactory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public Context get() {
    return Preconditions.checkNotNull(
        AppModule.provideAppContext(contextProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<Context> create(Provider<Context> contextProvider) {
    return new AppModule_ProvideAppCpntextFactory(contextProvider);
  }

  public static Context proxyProvideAppCpntext(Context context) {
    return AppModule.provideAppContext(context);
  }
}