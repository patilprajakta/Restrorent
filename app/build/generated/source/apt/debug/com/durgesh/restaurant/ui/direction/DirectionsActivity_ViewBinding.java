// Generated code from Butter Knife. Do not modify!
package com.durgesh.restaurant.ui.direction;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.durgesh.restaurant.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class DirectionsActivity_ViewBinding implements Unbinder {
  private DirectionsActivity target;

  private View view2131558550;

  private View view2131558552;

  @UiThread
  public DirectionsActivity_ViewBinding(DirectionsActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public DirectionsActivity_ViewBinding(final DirectionsActivity target, View source) {
    this.target = target;

    View view;
    target.mTxtDuration = Utils.findRequiredViewAsType(source, R.id.txtDuration, "field 'mTxtDuration'", TextView.class);
    target.mTxtDistance = Utils.findRequiredViewAsType(source, R.id.txtDistInMiles, "field 'mTxtDistance'", TextView.class);
    target.mProgressBar = Utils.findRequiredViewAsType(source, R.id.progress_bar, "field 'mProgressBar'", ProgressBar.class);
    target.mFrameLayout = Utils.findRequiredViewAsType(source, R.id.frame_layout, "field 'mFrameLayout'", FrameLayout.class);
    view = Utils.findRequiredView(source, R.id.imgBackArrow, "method 'imgBackArrow'");
    view2131558550 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.imgBackArrow(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.imgShare, "method 'imgShare'");
    view2131558552 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.imgShare(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    DirectionsActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mTxtDuration = null;
    target.mTxtDistance = null;
    target.mProgressBar = null;
    target.mFrameLayout = null;

    view2131558550.setOnClickListener(null);
    view2131558550 = null;
    view2131558552.setOnClickListener(null);
    view2131558552 = null;
  }
}
