package com.durgesh.restaurant.dagger;

import com.durgesh.restaurant.network.NetworkHelper;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import retrofit2.Retrofit;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class NetworkModule_ProvideNetworkApiFactory implements Factory<NetworkHelper> {
  private final NetworkModule module;

  private final Provider<Retrofit> retrofitProvider;

  public NetworkModule_ProvideNetworkApiFactory(
      NetworkModule module, Provider<Retrofit> retrofitProvider) {
    this.module = module;
    this.retrofitProvider = retrofitProvider;
  }

  @Override
  public NetworkHelper get() {
    return Preconditions.checkNotNull(
        module.provideNetworkApi(retrofitProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<NetworkHelper> create(
      NetworkModule module, Provider<Retrofit> retrofitProvider) {
    return new NetworkModule_ProvideNetworkApiFactory(module, retrofitProvider);
  }

  public static NetworkHelper proxyProvideNetworkApi(NetworkModule instance, Retrofit retrofit) {
    return instance.provideNetworkApi(retrofit);
  }
}
