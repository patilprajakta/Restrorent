package com.durgesh.restaurant.ui.home;

import android.app.Fragment;
import com.durgesh.restaurant.dagger.FragmentScoped;
import com.durgesh.restaurant.ui.home.fragments.HomeListFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.android.FragmentKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = HomeModule_HomeListFragment.HomeListFragmentSubcomponent.class)
public abstract class HomeModule_HomeListFragment {
  private HomeModule_HomeListFragment() {}

  @Binds
  @IntoMap
  @FragmentKey(HomeListFragment.class)
  abstract AndroidInjector.Factory<? extends Fragment> bindAndroidInjectorFactory(
      HomeListFragmentSubcomponent.Builder builder);

  @Subcomponent
  @FragmentScoped
  public interface HomeListFragmentSubcomponent extends AndroidInjector<HomeListFragment> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<HomeListFragment> {}
  }
}
