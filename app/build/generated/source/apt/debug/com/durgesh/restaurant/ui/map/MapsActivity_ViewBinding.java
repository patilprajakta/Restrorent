// Generated code from Butter Knife. Do not modify!
package com.durgesh.restaurant.ui.map;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.durgesh.restaurant.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MapsActivity_ViewBinding implements Unbinder {
  private MapsActivity target;

  private View view2131558575;

  private View view2131558574;

  @UiThread
  public MapsActivity_ViewBinding(MapsActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MapsActivity_ViewBinding(final MapsActivity target, View source) {
    this.target = target;

    View view;
    target.mRecyclerView = Utils.findRequiredViewAsType(source, R.id.recycler_view, "field 'mRecyclerView'", RecyclerView.class);
    target.mProgressBar = Utils.findRequiredViewAsType(source, R.id.progress_bar_maps, "field 'mProgressBar'", ProgressBar.class);
    target.mFrameLayout = Utils.findRequiredViewAsType(source, R.id.frame_layout_maps, "field 'mFrameLayout'", FrameLayout.class);
    view = Utils.findRequiredView(source, R.id.imgCurLoc, "method 'imgCurLoc'");
    view2131558575 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.imgCurLoc(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.imgFilter, "method 'imgFilters'");
    view2131558574 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.imgFilters(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    MapsActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mRecyclerView = null;
    target.mProgressBar = null;
    target.mFrameLayout = null;

    view2131558575.setOnClickListener(null);
    view2131558575 = null;
    view2131558574.setOnClickListener(null);
    view2131558574 = null;
  }
}
