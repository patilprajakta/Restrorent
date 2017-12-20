package com.durgesh.restaurant.ui.home;

import android.app.Fragment;
import com.durgesh.restaurant.dagger.FragmentScoped;
import com.durgesh.restaurant.ui.home.fragments.DealsFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.android.FragmentKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = HomeModule_DealsFragment.DealsFragmentSubcomponent.class)
public abstract class HomeModule_DealsFragment {
  private HomeModule_DealsFragment() {}

  @Binds
  @IntoMap
  @FragmentKey(DealsFragment.class)
  abstract AndroidInjector.Factory<? extends Fragment> bindAndroidInjectorFactory(
      DealsFragmentSubcomponent.Builder builder);

  @Subcomponent
  @FragmentScoped
  public interface DealsFragmentSubcomponent extends AndroidInjector<DealsFragment> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<DealsFragment> {}
  }
}
