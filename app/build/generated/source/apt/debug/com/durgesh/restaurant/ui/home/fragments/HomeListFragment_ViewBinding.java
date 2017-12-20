// Generated code from Butter Knife. Do not modify!
package com.durgesh.restaurant.ui.home.fragments;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.durgesh.restaurant.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class HomeListFragment_ViewBinding implements Unbinder {
  private HomeListFragment target;

  private View view2131558610;

  private View view2131558609;

  @UiThread
  public HomeListFragment_ViewBinding(final HomeListFragment target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.txt_filter, "field 'mTxtFilter', method 'openSecondActivity', and method 'openMapActivityCurrentPlace'");
    target.mTxtFilter = Utils.castView(view, R.id.txt_filter, "field 'mTxtFilter'", TextView.class);
    view2131558610 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.openSecondActivity();
        target.openMapActivityCurrentPlace();
      }
    });
    view = Utils.findRequiredView(source, R.id.txt_current_place, "field 'mTxtCurrentPlace' and method 'openHomeLocation'");
    target.mTxtCurrentPlace = Utils.castView(view, R.id.txt_current_place, "field 'mTxtCurrentPlace'", TextView.class);
    view2131558609 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.openHomeLocation();
      }
    });
    target.mTxtRestaurantsCount = Utils.findRequiredViewAsType(source, R.id.txt_restaurants_count, "field 'mTxtRestaurantsCount'", TextView.class);
    target.mRecyclerView = Utils.findRequiredViewAsType(source, R.id.recyclerview, "field 'mRecyclerView'", RecyclerView.class);
    target.mTxtSort = Utils.findRequiredViewAsType(source, R.id.txt_sort, "field 'mTxtSort'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    HomeListFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mTxtFilter = null;
    target.mTxtCurrentPlace = null;
    target.mTxtRestaurantsCount = null;
    target.mRecyclerView = null;
    target.mTxtSort = null;

    view2131558610.setOnClickListener(null);
    view2131558610 = null;
    view2131558609.setOnClickListener(null);
    view2131558609 = null;
  }
}
