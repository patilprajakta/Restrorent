package com.durgesh.restaurant.ui;

import android.app.Activity;
import android.app.Fragment;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
import dagger.MembersInjector;
import dagger.android.DaggerApplication_MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class RestaurentApplication_MembersInjector
    implements MembersInjector<RestaurentApplication> {
  private final Provider<DispatchingAndroidInjector<Activity>> activityInjectorProvider;

  private final Provider<DispatchingAndroidInjector<BroadcastReceiver>>
      broadcastReceiverInjectorProvider;

  private final Provider<DispatchingAndroidInjector<Fragment>> fragmentInjectorProvider;

  private final Provider<DispatchingAndroidInjector<Service>> serviceInjectorProvider;

  private final Provider<DispatchingAndroidInjector<ContentProvider>>
      contentProviderInjectorProvider;

  public RestaurentApplication_MembersInjector(
      Provider<DispatchingAndroidInjector<Activity>> activityInjectorProvider,
      Provider<DispatchingAndroidInjector<BroadcastReceiver>> broadcastReceiverInjectorProvider,
      Provider<DispatchingAndroidInjector<Fragment>> fragmentInjectorProvider,
      Provider<DispatchingAndroidInjector<Service>> serviceInjectorProvider,
      Provider<DispatchingAndroidInjector<ContentProvider>> contentProviderInjectorProvider) {
    this.activityInjectorProvider = activityInjectorProvider;
    this.broadcastReceiverInjectorProvider = broadcastReceiverInjectorProvider;
    this.fragmentInjectorProvider = fragmentInjectorProvider;
    this.serviceInjectorProvider = serviceInjectorProvider;
    this.contentProviderInjectorProvider = contentProviderInjectorProvider;
  }

  public static MembersInjector<RestaurentApplication> create(
      Provider<DispatchingAndroidInjector<Activity>> activityInjectorProvider,
      Provider<DispatchingAndroidInjector<BroadcastReceiver>> broadcastReceiverInjectorProvider,
      Provider<DispatchingAndroidInjector<Fragment>> fragmentInjectorProvider,
      Provider<DispatchingAndroidInjector<Service>> serviceInjectorProvider,
      Provider<DispatchingAndroidInjector<ContentProvider>> contentProviderInjectorProvider) {
    return new RestaurentApplication_MembersInjector(
        activityInjectorProvider,
        broadcastReceiverInjectorProvider,
        fragmentInjectorProvider,
        serviceInjectorProvider,
        contentProviderInjectorProvider);
  }

  @Override
  public void injectMembers(RestaurentApplication instance) {
    DaggerApplication_MembersInjector.injectActivityInjector(
        instance, activityInjectorProvider.get());
    DaggerApplication_MembersInjector.injectBroadcastReceiverInjector(
        instance, broadcastReceiverInjectorProvider.get());
    DaggerApplication_MembersInjector.injectFragmentInjector(
        instance, fragmentInjectorProvider.get());
    DaggerApplication_MembersInjector.injectServiceInjector(
        instance, serviceInjectorProvider.get());
    DaggerApplication_MembersInjector.injectContentProviderInjector(
        instance, contentProviderInjectorProvider.get());
    DaggerApplication_MembersInjector.injectSetInjected(instance);
  }
}
