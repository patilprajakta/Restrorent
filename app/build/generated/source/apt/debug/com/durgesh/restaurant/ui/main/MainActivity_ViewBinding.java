// Generated code from Butter Knife. Do not modify!
package com.durgesh.restaurant.ui.main;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.durgesh.restaurant.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MainActivity_ViewBinding implements Unbinder {
  private MainActivity target;

  private View view2131558567;

  private View view2131558569;

  private View view2131558568;

  @UiThread
  public MainActivity_ViewBinding(MainActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MainActivity_ViewBinding(final MainActivity target, View source) {
    this.target = target;

    View view;
    target.mTxtUserName = Utils.findRequiredViewAsType(source, R.id.txtName, "field 'mTxtUserName'", TextView.class);
    target.mTxtUserEmail = Utils.findRequiredViewAsType(source, R.id.txtEmail, "field 'mTxtUserEmail'", TextView.class);
    target.mTxtUserId = Utils.findRequiredViewAsType(source, R.id.txtUid, "field 'mTxtUserId'", TextView.class);
    view = Utils.findRequiredView(source, R.id.btnLogout, "method 'logout'");
    view2131558567 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.logout(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btnMaps, "method 'maps'");
    view2131558569 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.maps(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btnDirections, "method 'directions'");
    view2131558568 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.directions(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    MainActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mTxtUserName = null;
    target.mTxtUserEmail = null;
    target.mTxtUserId = null;

    view2131558567.setOnClickListener(null);
    view2131558567 = null;
    view2131558569.setOnClickListener(null);
    view2131558569 = null;
    view2131558568.setOnClickListener(null);
    view2131558568 = null;
  }
}
