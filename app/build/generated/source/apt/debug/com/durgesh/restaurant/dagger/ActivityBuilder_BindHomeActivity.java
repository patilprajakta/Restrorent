package com.durgesh.restaurant.dagger;

import android.app.Activity;
import com.durgesh.restaurant.ui.home.HomeActivity;
import com.durgesh.restaurant.ui.home.HomeModule;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module(subcomponents = ActivityBuilder_BindHomeActivity.HomeActivitySubcomponent.class)
public abstract class ActivityBuilder_BindHomeActivity {
  private ActivityBuilder_BindHomeActivity() {}

  @Binds
  @IntoMap
  @ActivityKey(HomeActivity.class)
  abstract AndroidInjector.Factory<? extends Activity> bindAndroidInjectorFactory(
      HomeActivitySubcomponent.Builder builder);

  @Subcomponent(modules = HomeModule.class)
  @ActivityScoped
  public interface HomeActivitySubcomponent extends AndroidInjector<HomeActivity> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<HomeActivity> {}
  }
}
