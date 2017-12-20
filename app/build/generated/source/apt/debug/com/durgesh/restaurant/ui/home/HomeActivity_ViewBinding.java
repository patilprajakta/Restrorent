// Generated code from Butter Knife. Do not modify!
package com.durgesh.restaurant.ui.home;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.BottomNavigationView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.durgesh.restaurant.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class HomeActivity_ViewBinding implements Unbinder {
  private HomeActivity target;

  @UiThread
  public HomeActivity_ViewBinding(HomeActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public HomeActivity_ViewBinding(HomeActivity target, View source) {
    this.target = target;

    target.mBottomNavigationView = Utils.findRequiredViewAsType(source, R.id.navigation, "field 'mBottomNavigationView'", BottomNavigationView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    HomeActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mBottomNavigationView = null;
  }
}
