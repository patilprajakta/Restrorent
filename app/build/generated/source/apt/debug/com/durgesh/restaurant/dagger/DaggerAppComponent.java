package com.durgesh.restaurant.dagger;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
import com.durgesh.restaurant.common.Router;
import com.durgesh.restaurant.ui.BaseActivity_MembersInjector;
import com.durgesh.restaurant.ui.RestaurentApplication;
import com.durgesh.restaurant.ui.home.HomeActivity;
import com.durgesh.restaurant.ui.home.HomeActivity_MembersInjector;
import com.durgesh.restaurant.ui.home.HomeContract;
import com.durgesh.restaurant.ui.home.HomeModule_CouponsFragment;
import com.durgesh.restaurant.ui.home.HomeModule_DealsFragment;
import com.durgesh.restaurant.ui.home.HomeModule_HomeInteractorFactory;
import com.durgesh.restaurant.ui.home.HomeModule_HomeListFragment;
import com.durgesh.restaurant.ui.home.HomeModule_HomePresenteFactory;
import com.durgesh.restaurant.ui.home.HomeModule_MapFragment;
import com.durgesh.restaurant.ui.home.HomeModule_ProfileFragment;
import com.durgesh.restaurant.ui.home.HomePresenter_Factory;
import com.durgesh.restaurant.ui.home.fragments.CouponsFragment;
import com.durgesh.restaurant.ui.home.fragments.CouponsFragment_Factory;
import com.durgesh.restaurant.ui.home.fragments.DealsFragment;
import com.durgesh.restaurant.ui.home.fragments.DealsFragment_Factory;
import com.durgesh.restaurant.ui.home.fragments.DealsFragment_MembersInjector;
import com.durgesh.restaurant.ui.home.fragments.HomeListFragment;
import com.durgesh.restaurant.ui.home.fragments.HomeListFragment_Factory;
import com.durgesh.restaurant.ui.home.fragments.HomeListFragment_MembersInjector;
import com.durgesh.restaurant.ui.home.fragments.MapFragment;
import com.durgesh.restaurant.ui.home.fragments.MapFragment_Factory;
import com.durgesh.restaurant.ui.home.fragments.MapFragment_MembersInjector;
import com.durgesh.restaurant.ui.home.fragments.ProfileFragment;
import com.durgesh.restaurant.ui.home.fragments.ProfileFragment_Factory;
import com.durgesh.restaurant.ui.home.fragments.ProfileFragment_MembersInjector;
import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import dagger.android.DaggerApplication_MembersInjector;
import dagger.android.DaggerFragment_MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.DispatchingAndroidInjector_Factory;
import dagger.android.support.DaggerAppCompatActivity_MembersInjector;
import dagger.internal.DoubleCheck;
import dagger.internal.MapBuilder;
import dagger.internal.MapProviderFactory;
import dagger.internal.Preconditions;
import java.util.Collections;
import java.util.Map;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerAppComponent implements AppComponent {
  private Provider<ActivityBuilder_BindHomeActivity.HomeActivitySubcomponent.Builder>
      homeActivitySubcomponentBuilderProvider;

  private Provider<Router> provideRouterProvider;

  private DaggerAppComponent(Builder builder) {
    initialize(builder);
  }

  public static AppComponent.Builder builder() {
    return new Builder();
  }

  private Map<Class<? extends Activity>, Provider<AndroidInjector.Factory<? extends Activity>>>
      getMapOfClassOfAndProviderOfFactoryOf() {
    return Collections
        .<Class<? extends Activity>, Provider<AndroidInjector.Factory<? extends Activity>>>
            singletonMap(HomeActivity.class, (Provider) homeActivitySubcomponentBuilderProvider);
  }

  private DispatchingAndroidInjector<Activity> getDispatchingAndroidInjectorOfActivity() {
    return DispatchingAndroidInjector_Factory.newDispatchingAndroidInjector(
        getMapOfClassOfAndProviderOfFactoryOf());
  }

  private DispatchingAndroidInjector<BroadcastReceiver>
      getDispatchingAndroidInjectorOfBroadcastReceiver() {
    return DispatchingAndroidInjector_Factory.newDispatchingAndroidInjector(
        Collections
            .<Class<? extends BroadcastReceiver>,
                Provider<AndroidInjector.Factory<? extends BroadcastReceiver>>>
                emptyMap());
  }

  private DispatchingAndroidInjector<Fragment> getDispatchingAndroidInjectorOfFragment() {
    return DispatchingAndroidInjector_Factory.newDispatchingAndroidInjector(
        Collections
            .<Class<? extends Fragment>, Provider<AndroidInjector.Factory<? extends Fragment>>>
                emptyMap());
  }

  private DispatchingAndroidInjector<Service> getDispatchingAndroidInjectorOfService() {
    return DispatchingAndroidInjector_Factory.newDispatchingAndroidInjector(
        Collections
            .<Class<? extends Service>, Provider<AndroidInjector.Factory<? extends Service>>>
                emptyMap());
  }

  private DispatchingAndroidInjector<ContentProvider>
      getDispatchingAndroidInjectorOfContentProvider() {
    return DispatchingAndroidInjector_Factory.newDispatchingAndroidInjector(
        Collections
            .<Class<? extends ContentProvider>,
                Provider<AndroidInjector.Factory<? extends ContentProvider>>>
                emptyMap());
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {
    this.homeActivitySubcomponentBuilderProvider =
        new Provider<ActivityBuilder_BindHomeActivity.HomeActivitySubcomponent.Builder>() {
          @Override
          public ActivityBuilder_BindHomeActivity.HomeActivitySubcomponent.Builder get() {
            return new HomeActivitySubcomponentBuilder();
          }
        };
    this.provideRouterProvider = DoubleCheck.provider(AppModule_ProvideRouterFactory.create());
  }

  @Override
  public void inject(RestaurentApplication app) {
    injectRestaurentApplication(app);
  }

  @Override
  public void inject(DaggerApplication instance) {
    injectDaggerApplication(instance);
  }

  private RestaurentApplication injectRestaurentApplication(RestaurentApplication instance) {
    DaggerApplication_MembersInjector.injectActivityInjector(
        instance, getDispatchingAndroidInjectorOfActivity());
    DaggerApplication_MembersInjector.injectBroadcastReceiverInjector(
        instance, getDispatchingAndroidInjectorOfBroadcastReceiver());
    DaggerApplication_MembersInjector.injectFragmentInjector(
        instance, getDispatchingAndroidInjectorOfFragment());
    DaggerApplication_MembersInjector.injectServiceInjector(
        instance, getDispatchingAndroidInjectorOfService());
    DaggerApplication_MembersInjector.injectContentProviderInjector(
        instance, getDispatchingAndroidInjectorOfContentProvider());
    DaggerApplication_MembersInjector.injectSetInjected(instance);
    return instance;
  }

  private DaggerApplication injectDaggerApplication(DaggerApplication instance) {
    DaggerApplication_MembersInjector.injectActivityInjector(
        instance, getDispatchingAndroidInjectorOfActivity());
    DaggerApplication_MembersInjector.injectBroadcastReceiverInjector(
        instance, getDispatchingAndroidInjectorOfBroadcastReceiver());
    DaggerApplication_MembersInjector.injectFragmentInjector(
        instance, getDispatchingAndroidInjectorOfFragment());
    DaggerApplication_MembersInjector.injectServiceInjector(
        instance, getDispatchingAndroidInjectorOfService());
    DaggerApplication_MembersInjector.injectContentProviderInjector(
        instance, getDispatchingAndroidInjectorOfContentProvider());
    DaggerApplication_MembersInjector.injectSetInjected(instance);
    return instance;
  }

  private static final class Builder implements AppComponent.Builder {
    private Application application;

    @Override
    public AppComponent build() {
      if (application == null) {
        throw new IllegalStateException(Application.class.getCanonicalName() + " must be set");
      }
      return new DaggerAppComponent(this);
    }

    @Override
    public Builder application(Application application) {
      this.application = Preconditions.checkNotNull(application);
      return this;
    }
  }

  private final class HomeActivitySubcomponentBuilder
      extends ActivityBuilder_BindHomeActivity.HomeActivitySubcomponent.Builder {
    private HomeActivity seedInstance;

    @Override
    public ActivityBuilder_BindHomeActivity.HomeActivitySubcomponent build() {
      if (seedInstance == null) {
        throw new IllegalStateException(HomeActivity.class.getCanonicalName() + " must be set");
      }
      return new HomeActivitySubcomponentImpl(this);
    }

    @Override
    public void seedInstance(HomeActivity arg0) {
      this.seedInstance = Preconditions.checkNotNull(arg0);
    }
  }

  private final class HomeActivitySubcomponentImpl
      implements ActivityBuilder_BindHomeActivity.HomeActivitySubcomponent {
    private Provider<HomeModule_CouponsFragment.CouponsFragmentSubcomponent.Builder>
        couponsFragmentSubcomponentBuilderProvider;

    private Provider<HomeModule_DealsFragment.DealsFragmentSubcomponent.Builder>
        dealsFragmentSubcomponentBuilderProvider;

    private Provider<HomeModule_HomeListFragment.HomeListFragmentSubcomponent.Builder>
        homeListFragmentSubcomponentBuilderProvider;

    private Provider<HomeModule_MapFragment.MapFragmentSubcomponent.Builder>
        mapFragmentSubcomponentBuilderProvider;

    private Provider<HomeModule_ProfileFragment.ProfileFragmentSubcomponent.Builder>
        profileFragmentSubcomponentBuilderProvider;

    @SuppressWarnings("rawtypes")
    private Provider homePresenterProvider;

    private Provider<
            Map<Class<? extends Fragment>, Provider<AndroidInjector.Factory<? extends Fragment>>>>
        mapOfClassOfAndProviderOfFactoryOfProvider;

    private Provider<DispatchingAndroidInjector<Fragment>> dispatchingAndroidInjectorProvider2;

    private Provider<HomeContract.Presenter> homePresenteProvider;

    private Provider<HomeListFragment> homeListFragmentProvider;

    private Provider<MapFragment> mapFragmentProvider;

    private Provider<DealsFragment> dealsFragmentProvider;

    private Provider<CouponsFragment> couponsFragmentProvider;

    private Provider<ProfileFragment> profileFragmentProvider;

    private HomeActivitySubcomponentImpl(HomeActivitySubcomponentBuilder builder) {
      initialize(builder);
    }

    private DispatchingAndroidInjector<android.support.v4.app.Fragment>
        getDispatchingAndroidInjectorOfFragment() {
      return DispatchingAndroidInjector_Factory.newDispatchingAndroidInjector(
          Collections
              .<Class<? extends android.support.v4.app.Fragment>,
                  Provider<AndroidInjector.Factory<? extends android.support.v4.app.Fragment>>>
                  emptyMap());
    }

    private Map<Class<? extends Fragment>, Provider<AndroidInjector.Factory<? extends Fragment>>>
        getMapOfClassOfAndProviderOfFactoryOf() {
      return MapBuilder
          .<Class<? extends Fragment>, Provider<AndroidInjector.Factory<? extends Fragment>>>
              newMapBuilder(5)
          .put(CouponsFragment.class, (Provider) couponsFragmentSubcomponentBuilderProvider)
          .put(DealsFragment.class, (Provider) dealsFragmentSubcomponentBuilderProvider)
          .put(HomeListFragment.class, (Provider) homeListFragmentSubcomponentBuilderProvider)
          .put(MapFragment.class, (Provider) mapFragmentSubcomponentBuilderProvider)
          .put(ProfileFragment.class, (Provider) profileFragmentSubcomponentBuilderProvider)
          .build();
    }

    private DispatchingAndroidInjector<Fragment> getDispatchingAndroidInjectorOfFragment2() {
      return DispatchingAndroidInjector_Factory.newDispatchingAndroidInjector(
          getMapOfClassOfAndProviderOfFactoryOf());
    }

    private HomeContract.Presenter getPresenter() {
      return Preconditions.checkNotNull(
          HomeModule_HomePresenteFactory.proxyHomePresente(
              Preconditions.checkNotNull(
                  HomeModule_HomeInteractorFactory.proxyHomeInteractor(),
                  "Cannot return null from a non-@Nullable @Provides method")),
          "Cannot return null from a non-@Nullable @Provides method");
    }

    @SuppressWarnings("unchecked")
    private void initialize(final HomeActivitySubcomponentBuilder builder) {
      this.couponsFragmentSubcomponentBuilderProvider =
          new Provider<HomeModule_CouponsFragment.CouponsFragmentSubcomponent.Builder>() {
            @Override
            public HomeModule_CouponsFragment.CouponsFragmentSubcomponent.Builder get() {
              return new CouponsFragmentSubcomponentBuilder();
            }
          };
      this.dealsFragmentSubcomponentBuilderProvider =
          new Provider<HomeModule_DealsFragment.DealsFragmentSubcomponent.Builder>() {
            @Override
            public HomeModule_DealsFragment.DealsFragmentSubcomponent.Builder get() {
              return new DealsFragmentSubcomponentBuilder();
            }
          };
      this.homeListFragmentSubcomponentBuilderProvider =
          new Provider<HomeModule_HomeListFragment.HomeListFragmentSubcomponent.Builder>() {
            @Override
            public HomeModule_HomeListFragment.HomeListFragmentSubcomponent.Builder get() {
              return new HomeListFragmentSubcomponentBuilder();
            }
          };
      this.mapFragmentSubcomponentBuilderProvider =
          new Provider<HomeModule_MapFragment.MapFragmentSubcomponent.Builder>() {
            @Override
            public HomeModule_MapFragment.MapFragmentSubcomponent.Builder get() {
              return new MapFragmentSubcomponentBuilder();
            }
          };
      this.profileFragmentSubcomponentBuilderProvider =
          new Provider<HomeModule_ProfileFragment.ProfileFragmentSubcomponent.Builder>() {
            @Override
            public HomeModule_ProfileFragment.ProfileFragmentSubcomponent.Builder get() {
              return new ProfileFragmentSubcomponentBuilder();
            }
          };
      this.homePresenterProvider =
          DoubleCheck.provider(
              HomePresenter_Factory.create(HomeModule_HomeInteractorFactory.create()));
      this.mapOfClassOfAndProviderOfFactoryOfProvider =
          MapProviderFactory
              .<Class<? extends Fragment>, AndroidInjector.Factory<? extends Fragment>>builder(5)
              .put(CouponsFragment.class, (Provider) couponsFragmentSubcomponentBuilderProvider)
              .put(DealsFragment.class, (Provider) dealsFragmentSubcomponentBuilderProvider)
              .put(HomeListFragment.class, (Provider) homeListFragmentSubcomponentBuilderProvider)
              .put(MapFragment.class, (Provider) mapFragmentSubcomponentBuilderProvider)
              .put(ProfileFragment.class, (Provider) profileFragmentSubcomponentBuilderProvider)
              .build();
      this.dispatchingAndroidInjectorProvider2 =
          DispatchingAndroidInjector_Factory.create(mapOfClassOfAndProviderOfFactoryOfProvider);
      this.homePresenteProvider =
          HomeModule_HomePresenteFactory.create(HomeModule_HomeInteractorFactory.create());
      this.homeListFragmentProvider =
          HomeListFragment_Factory.create(
              dispatchingAndroidInjectorProvider2, homePresenteProvider);
      this.mapFragmentProvider =
          MapFragment_Factory.create(dispatchingAndroidInjectorProvider2, homePresenteProvider);
      this.dealsFragmentProvider =
          DealsFragment_Factory.create(dispatchingAndroidInjectorProvider2, homePresenteProvider);
      this.couponsFragmentProvider =
          CouponsFragment_Factory.create(dispatchingAndroidInjectorProvider2);
      this.profileFragmentProvider =
          ProfileFragment_Factory.create(dispatchingAndroidInjectorProvider2, homePresenteProvider);
    }

    @Override
    public void inject(HomeActivity arg0) {
      injectHomeActivity(arg0);
    }

    private HomeActivity injectHomeActivity(HomeActivity instance) {
      DaggerAppCompatActivity_MembersInjector.injectSupportFragmentInjector(
          instance, getDispatchingAndroidInjectorOfFragment());
      DaggerAppCompatActivity_MembersInjector.injectFrameworkFragmentInjector(
          instance, getDispatchingAndroidInjectorOfFragment2());
      BaseActivity_MembersInjector.injectRouter(
          instance, DaggerAppComponent.this.provideRouterProvider.get());
      HomeActivity_MembersInjector.injectMHomePresenter(instance, homePresenterProvider.get());
      HomeActivity_MembersInjector.injectHomeFragmentProvider(
          instance, DoubleCheck.lazy(homeListFragmentProvider));
      HomeActivity_MembersInjector.injectMapFragmentProvider(
          instance, DoubleCheck.lazy(mapFragmentProvider));
      HomeActivity_MembersInjector.injectDealsFragmentProvider(
          instance, DoubleCheck.lazy(dealsFragmentProvider));
      HomeActivity_MembersInjector.injectCouponsFragmentProvider(
          instance, DoubleCheck.lazy(couponsFragmentProvider));
      HomeActivity_MembersInjector.injectProfileFragmentProvider(
          instance, DoubleCheck.lazy(profileFragmentProvider));
      return instance;
    }

    private final class CouponsFragmentSubcomponentBuilder
        extends HomeModule_CouponsFragment.CouponsFragmentSubcomponent.Builder {
      private CouponsFragment seedInstance;

      @Override
      public HomeModule_CouponsFragment.CouponsFragmentSubcomponent build() {
        if (seedInstance == null) {
          throw new IllegalStateException(
              CouponsFragment.class.getCanonicalName() + " must be set");
        }
        return new CouponsFragmentSubcomponentImpl(this);
      }

      @Override
      public void seedInstance(CouponsFragment arg0) {
        this.seedInstance = Preconditions.checkNotNull(arg0);
      }
    }

    private final class CouponsFragmentSubcomponentImpl
        implements HomeModule_CouponsFragment.CouponsFragmentSubcomponent {
      private CouponsFragmentSubcomponentImpl(CouponsFragmentSubcomponentBuilder builder) {}

      @Override
      public void inject(CouponsFragment arg0) {
        injectCouponsFragment(arg0);
      }

      private CouponsFragment injectCouponsFragment(CouponsFragment instance) {
        DaggerFragment_MembersInjector.injectChildFragmentInjector(
            instance, HomeActivitySubcomponentImpl.this.getDispatchingAndroidInjectorOfFragment2());
        return instance;
      }
    }

    private final class DealsFragmentSubcomponentBuilder
        extends HomeModule_DealsFragment.DealsFragmentSubcomponent.Builder {
      private DealsFragment seedInstance;

      @Override
      public HomeModule_DealsFragment.DealsFragmentSubcomponent build() {
        if (seedInstance == null) {
          throw new IllegalStateException(DealsFragment.class.getCanonicalName() + " must be set");
        }
        return new DealsFragmentSubcomponentImpl(this);
      }

      @Override
      public void seedInstance(DealsFragment arg0) {
        this.seedInstance = Preconditions.checkNotNull(arg0);
      }
    }

    private final class DealsFragmentSubcomponentImpl
        implements HomeModule_DealsFragment.DealsFragmentSubcomponent {
      private DealsFragmentSubcomponentImpl(DealsFragmentSubcomponentBuilder builder) {}

      @Override
      public void inject(DealsFragment arg0) {
        injectDealsFragment(arg0);
      }

      private DealsFragment injectDealsFragment(DealsFragment instance) {
        DaggerFragment_MembersInjector.injectChildFragmentInjector(
            instance, HomeActivitySubcomponentImpl.this.getDispatchingAndroidInjectorOfFragment2());
        DealsFragment_MembersInjector.injectMPresenter(
            instance, HomeActivitySubcomponentImpl.this.getPresenter());
        return instance;
      }
    }

    private final class HomeListFragmentSubcomponentBuilder
        extends HomeModule_HomeListFragment.HomeListFragmentSubcomponent.Builder {
      private HomeListFragment seedInstance;

      @Override
      public HomeModule_HomeListFragment.HomeListFragmentSubcomponent build() {
        if (seedInstance == null) {
          throw new IllegalStateException(
              HomeListFragment.class.getCanonicalName() + " must be set");
        }
        return new HomeListFragmentSubcomponentImpl(this);
      }

      @Override
      public void seedInstance(HomeListFragment arg0) {
        this.seedInstance = Preconditions.checkNotNull(arg0);
      }
    }

    private final class HomeListFragmentSubcomponentImpl
        implements HomeModule_HomeListFragment.HomeListFragmentSubcomponent {
      private HomeListFragmentSubcomponentImpl(HomeListFragmentSubcomponentBuilder builder) {}

      @Override
      public void inject(HomeListFragment arg0) {
        injectHomeListFragment(arg0);
      }

      private HomeListFragment injectHomeListFragment(HomeListFragment instance) {
        DaggerFragment_MembersInjector.injectChildFragmentInjector(
            instance, HomeActivitySubcomponentImpl.this.getDispatchingAndroidInjectorOfFragment2());
        HomeListFragment_MembersInjector.injectMPresenter(
            instance, HomeActivitySubcomponentImpl.this.getPresenter());
        return instance;
      }
    }

    private final class MapFragmentSubcomponentBuilder
        extends HomeModule_MapFragment.MapFragmentSubcomponent.Builder {
      private MapFragment seedInstance;

      @Override
      public HomeModule_MapFragment.MapFragmentSubcomponent build() {
        if (seedInstance == null) {
          throw new IllegalStateException(MapFragment.class.getCanonicalName() + " must be set");
        }
        return new MapFragmentSubcomponentImpl(this);
      }

      @Override
      public void seedInstance(MapFragment arg0) {
        this.seedInstance = Preconditions.checkNotNull(arg0);
      }
    }

    private final class MapFragmentSubcomponentImpl
        implements HomeModule_MapFragment.MapFragmentSubcomponent {
      private MapFragmentSubcomponentImpl(MapFragmentSubcomponentBuilder builder) {}

      @Override
      public void inject(MapFragment arg0) {
        injectMapFragment(arg0);
      }

      private MapFragment injectMapFragment(MapFragment instance) {
        DaggerFragment_MembersInjector.injectChildFragmentInjector(
            instance, HomeActivitySubcomponentImpl.this.getDispatchingAndroidInjectorOfFragment2());
        MapFragment_MembersInjector.injectMPresenter(
            instance, HomeActivitySubcomponentImpl.this.getPresenter());
        return instance;
      }
    }

    private final class ProfileFragmentSubcomponentBuilder
        extends HomeModule_ProfileFragment.ProfileFragmentSubcomponent.Builder {
      private ProfileFragment seedInstance;

      @Override
      public HomeModule_ProfileFragment.ProfileFragmentSubcomponent build() {
        if (seedInstance == null) {
          throw new IllegalStateException(
              ProfileFragment.class.getCanonicalName() + " must be set");
        }
        return new ProfileFragmentSubcomponentImpl(this);
      }

      @Override
      public void seedInstance(ProfileFragment arg0) {
        this.seedInstance = Preconditions.checkNotNull(arg0);
      }
    }

    private final class ProfileFragmentSubcomponentImpl
        implements HomeModule_ProfileFragment.ProfileFragmentSubcomponent {
      private ProfileFragmentSubcomponentImpl(ProfileFragmentSubcomponentBuilder builder) {}

      @Override
      public void inject(ProfileFragment arg0) {
        injectProfileFragment(arg0);
      }

      private ProfileFragment injectProfileFragment(ProfileFragment instance) {
        DaggerFragment_MembersInjector.injectChildFragmentInjector(
            instance, HomeActivitySubcomponentImpl.this.getDispatchingAndroidInjectorOfFragment2());
        ProfileFragment_MembersInjector.injectMPresenter(
            instance, HomeActivitySubcomponentImpl.this.getPresenter());
        return instance;
      }
    }
  }
}
