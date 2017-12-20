package com.durgesh.restaurant.ui.home;

import android.app.Fragment;
import com.durgesh.restaurant.dagger.FragmentScoped;
import com.durgesh.restaurant.ui.home.fragments.MapFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.android.FragmentKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = HomeModule_MapFragment.MapFragmentSubcomponent.class)
public abstract class HomeModule_MapFragment {
  private HomeModule_MapFragment() {}

  @Binds
  @IntoMap
  @FragmentKey(MapFragment.class)
  abstract AndroidInjector.Factory<? extends Fragment> bindAndroidInjectorFactory(
      MapFragmentSubcomponent.Builder builder);

  @Subcomponent
  @FragmentScoped
  public interface MapFragmentSubcomponent extends AndroidInjector<MapFragment> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MapFragment> {}
  }
}
