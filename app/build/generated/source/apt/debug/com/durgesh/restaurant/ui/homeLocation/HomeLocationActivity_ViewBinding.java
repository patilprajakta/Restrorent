// Generated code from Butter Knife. Do not modify!
package com.durgesh.restaurant.ui.homeLocation;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.durgesh.restaurant.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class HomeLocationActivity_ViewBinding implements Unbinder {
  private HomeLocationActivity target;

  private View view2131558558;

  private View view2131558557;

  @UiThread
  public HomeLocationActivity_ViewBinding(HomeLocationActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public HomeLocationActivity_ViewBinding(final HomeLocationActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.edt_detect_my_location, "field 'mCurrentLocation' and method 'detectCurrentLocation'");
    target.mCurrentLocation = Utils.castView(view, R.id.edt_detect_my_location, "field 'mCurrentLocation'", EditText.class);
    view2131558558 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.detectCurrentLocation();
      }
    });
    target.mAutoCompleteTv = Utils.findRequiredViewAsType(source, R.id.search_location, "field 'mAutoCompleteTv'", AutoCompleteTextView.class);
    target.mRecyclerview = Utils.findRequiredViewAsType(source, R.id.list_recent_searches, "field 'mRecyclerview'", RecyclerView.class);
    view = Utils.findRequiredView(source, R.id.img_close, "method 'closeActivity'");
    view2131558557 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.closeActivity();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    HomeLocationActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mCurrentLocation = null;
    target.mAutoCompleteTv = null;
    target.mRecyclerview = null;

    view2131558558.setOnClickListener(null);
    view2131558558 = null;
    view2131558557.setOnClickListener(null);
    view2131558557 = null;
  }
}
