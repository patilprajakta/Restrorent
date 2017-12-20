// Generated code from Butter Knife. Do not modify!
package com.durgesh.restaurant.ui.camera;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.durgesh.restaurant.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class CameraActivity_ViewBinding implements Unbinder {
  private CameraActivity target;

  private View view2131558539;

  @UiThread
  public CameraActivity_ViewBinding(CameraActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public CameraActivity_ViewBinding(final CameraActivity target, View source) {
    this.target = target;

    View view;
    target.cameraPreview = Utils.findRequiredViewAsType(source, R.id.camera_preview, "field 'cameraPreview'", CameraPreview.class);
    view = Utils.findRequiredView(source, R.id.btn_capture_image, "field 'mBtnCaptureImage' and method 'onCaptureClick'");
    target.mBtnCaptureImage = Utils.castView(view, R.id.btn_capture_image, "field 'mBtnCaptureImage'", Button.class);
    view2131558539 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onCaptureClick();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    CameraActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.cameraPreview = null;
    target.mBtnCaptureImage = null;

    view2131558539.setOnClickListener(null);
    view2131558539 = null;
  }
}
