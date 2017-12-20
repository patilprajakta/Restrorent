// Generated code from Butter Knife. Do not modify!
package com.durgesh.restaurant.ui.details;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.durgesh.restaurant.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class DetailsActivity_ViewBinding implements Unbinder {
  private DetailsActivity target;

  @UiThread
  public DetailsActivity_ViewBinding(DetailsActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public DetailsActivity_ViewBinding(DetailsActivity target, View source) {
    this.target = target;

    target.imageView = Utils.findRequiredViewAsType(source, R.id.image, "field 'imageView'", ImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    DetailsActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.imageView = null;
  }
}
