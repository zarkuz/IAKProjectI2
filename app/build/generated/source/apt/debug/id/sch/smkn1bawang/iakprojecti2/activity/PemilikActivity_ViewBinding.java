// Generated code from Butter Knife. Do not modify!
package id.sch.smkn1bawang.iakprojecti2.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import id.sch.smkn1bawang.iakprojecti2.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class PemilikActivity_ViewBinding implements Unbinder {
  private PemilikActivity target;

  @UiThread
  public PemilikActivity_ViewBinding(PemilikActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public PemilikActivity_ViewBinding(PemilikActivity target, View source) {
    this.target = target;

    target.rvPemilik = Utils.findRequiredViewAsType(source, R.id.rvPemilik, "field 'rvPemilik'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    PemilikActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.rvPemilik = null;
  }
}
