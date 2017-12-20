package com.durgesh.restaurant.ui.home;

import android.app.Fragment;
import com.durgesh.restaurant.dagger.FragmentScoped;
import com.durgesh.restaurant.ui.home.fragments.CouponsFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.android.FragmentKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = HomeModule_CouponsFragment.CouponsFragmentSubcomponent.class)
public abstract class HomeModule_CouponsFragment {
  private HomeModule_CouponsFragment() {}

  @Binds
  @IntoMap
  @FragmentKey(CouponsFragment.class)
  abstract AndroidInjector.Factory<? extends Fragment> bindAndroidInjectorFactory(
      CouponsFragmentSubcomponent.Builder builder);

  @Subcomponent
  @FragmentScoped
  public interface CouponsFragmentSubcomponent extends AndroidInjector<CouponsFragment> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<CouponsFragment> {}
  }
}
