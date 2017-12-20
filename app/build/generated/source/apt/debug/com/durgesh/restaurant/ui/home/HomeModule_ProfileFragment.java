package com.durgesh.restaurant.ui.home;

import android.app.Fragment;
import com.durgesh.restaurant.dagger.FragmentScoped;
import com.durgesh.restaurant.ui.home.fragments.ProfileFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.android.FragmentKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = HomeModule_ProfileFragment.ProfileFragmentSubcomponent.class)
public abstract class HomeModule_ProfileFragment {
  private HomeModule_ProfileFragment() {}

  @Binds
  @IntoMap
  @FragmentKey(ProfileFragment.class)
  abstract AndroidInjector.Factory<? extends Fragment> bindAndroidInjectorFactory(
      ProfileFragmentSubcomponent.Builder builder);

  @Subcomponent
  @FragmentScoped
  public interface ProfileFragmentSubcomponent extends AndroidInjector<ProfileFragment> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<ProfileFragment> {}
  }
}
