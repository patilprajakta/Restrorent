// Generated code from Butter Knife. Do not modify!
package com.durgesh.restaurant.ui.facebook;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ProgressBar;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.durgesh.restaurant.R;
import com.facebook.login.widget.LoginButton;
import java.lang.IllegalStateException;
import java.lang.Override;

public class FacebookLoginActivity_ViewBinding implements Unbinder {
  private FacebookLoginActivity target;

  @UiThread
  public FacebookLoginActivity_ViewBinding(FacebookLoginActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public FacebookLoginActivity_ViewBinding(FacebookLoginActivity target, View source) {
    this.target = target;

    target.mLoginButton = Utils.findRequiredViewAsType(source, R.id.btnFbLogin, "field 'mLoginButton'", LoginButton.class);
    target.mProgressBar = Utils.findRequiredViewAsType(source, R.id.progress_bar, "field 'mProgressBar'", ProgressBar.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    FacebookLoginActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mLoginButton = null;
    target.mProgressBar = null;
  }
}
