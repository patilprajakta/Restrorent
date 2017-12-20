package com.durgesh.restaurant.ui.home;

import android.support.v4.app.Fragment;
import com.durgesh.restaurant.common.Router;
import com.durgesh.restaurant.ui.BaseActivity_MembersInjector;
import com.durgesh.restaurant.ui.home.fragments.CouponsFragment;
import com.durgesh.restaurant.ui.home.fragments.DealsFragment;
import com.durgesh.restaurant.ui.home.fragments.HomeListFragment;
import com.durgesh.restaurant.ui.home.fragments.MapFragment;
import com.durgesh.restaurant.ui.home.fragments.ProfileFragment;
import dagger.Lazy;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.DaggerAppCompatActivity_MembersInjector;
import dagger.internal.DoubleCheck;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class HomeActivity_MembersInjector implements MembersInjector<HomeActivity> {
  private final Provider<DispatchingAndroidInjector<Fragment>> supportFragmentInjectorProvider;

  private final Provider<DispatchingAndroidInjector<android.app.Fragment>>
      frameworkFragmentInjectorProvider;

  private final Provider<Router> routerProvider;

  private final Provider<HomePresenter> mHomePresenterProvider;

  private final Provider<HomeListFragment> homeFragmentProvider;

  private final Provider<MapFragment> mapFragmentProvider;

  private final Provider<DealsFragment> dealsFragmentProvider;

  private final Provider<CouponsFragment> couponsFragmentProvider;

  private final Provider<ProfileFragment> profileFragmentProvider;

  public HomeActivity_MembersInjector(
      Provider<DispatchingAndroidInjector<Fragment>> supportFragmentInjectorProvider,
      Provider<DispatchingAndroidInjector<android.app.Fragment>> frameworkFragmentInjectorProvider,
      Provider<Router> routerProvider,
      Provider<HomePresenter> mHomePresenterProvider,
      Provider<HomeListFragment> homeFragmentProvider,
      Provider<MapFragment> mapFragmentProvider,
      Provider<DealsFragment> dealsFragmentProvider,
      Provider<CouponsFragment> couponsFragmentProvider,
      Provider<ProfileFragment> profileFragmentProvider) {
    this.supportFragmentInjectorProvider = supportFragmentInjectorProvider;
    this.frameworkFragmentInjectorProvider = frameworkFragmentInjectorProvider;
    this.routerProvider = routerProvider;
    this.mHomePresenterProvider = mHomePresenterProvider;
    this.homeFragmentProvider = homeFragmentProvider;
    this.mapFragmentProvider = mapFragmentProvider;
    this.dealsFragmentProvider = dealsFragmentProvider;
    this.couponsFragmentProvider = couponsFragmentProvider;
    this.profileFragmentProvider = profileFragmentProvider;
  }

  public static MembersInjector<HomeActivity> create(
      Provider<DispatchingAndroidInjector<Fragment>> supportFragmentInjectorProvider,
      Provider<DispatchingAndroidInjector<android.app.Fragment>> frameworkFragmentInjectorProvider,
      Provider<Router> routerProvider,
      Provider<HomePresenter> mHomePresenterProvider,
      Provider<HomeListFragment> homeFragmentProvider,
      Provider<MapFragment> mapFragmentProvider,
      Provider<DealsFragment> dealsFragmentProvider,
      Provider<CouponsFragment> couponsFragmentProvider,
      Provider<ProfileFragment> profileFragmentProvider) {
    return new HomeActivity_MembersInjector(
        supportFragmentInjectorProvider,
        frameworkFragmentInjectorProvider,
        routerProvider,
        mHomePresenterProvider,
        homeFragmentProvider,
        mapFragmentProvider,
        dealsFragmentProvider,
        couponsFragmentProvider,
        profileFragmentProvider);
  }

  @Override
  public void injectMembers(HomeActivity instance) {
    DaggerAppCompatActivity_MembersInjector.injectSupportFragmentInjector(
        instance, supportFragmentInjectorProvider.get());
    DaggerAppCompatActivity_MembersInjector.injectFrameworkFragmentInjector(
        instance, frameworkFragmentInjectorProvider.get());
    BaseActivity_MembersInjector.injectRouter(instance, routerProvider.get());
    injectMHomePresenter(instance, mHomePresenterProvider.get());
    injectHomeFragmentProvider(instance, DoubleCheck.lazy(homeFragmentProvider));
    injectMapFragmentProvider(instance, DoubleCheck.lazy(mapFragmentProvider));
    injectDealsFragmentProvider(instance, DoubleCheck.lazy(dealsFragmentProvider));
    injectCouponsFragmentProvider(instance, DoubleCheck.lazy(couponsFragmentProvider));
    injectProfileFragmentProvider(instance, DoubleCheck.lazy(profileFragmentProvider));
  }

  public static void injectMHomePresenter(HomeActivity instance, Object mHomePresenter) {
    instance.mHomePresenter = (HomePresenter) mHomePresenter;
  }

  public static void injectHomeFragmentProvider(
      HomeActivity instance, Lazy<HomeListFragment> homeFragmentProvider) {
    instance.homeFragmentProvider = homeFragmentProvider;
  }

  public static void injectMapFragmentProvider(
      HomeActivity instance, Lazy<MapFragment> mapFragmentProvider) {
    instance.mapFragmentProvider = mapFragmentProvider;
  }

  public static void injectDealsFragmentProvider(
      HomeActivity instance, Lazy<DealsFragment> dealsFragmentProvider) {
    instance.dealsFragmentProvider = dealsFragmentProvider;
  }

  public static void injectCouponsFragmentProvider(
      HomeActivity instance, Lazy<CouponsFragment> couponsFragmentProvider) {
    instance.couponsFragmentProvider = couponsFragmentProvider;
  }

  public static void injectProfileFragmentProvider(
      HomeActivity instance, Lazy<ProfileFragment> profileFragmentProvider) {
    instance.profileFragmentProvider = profileFragmentProvider;
  }
}
