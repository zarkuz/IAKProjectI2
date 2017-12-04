// Generated code from Butter Knife. Do not modify!
package id.sch.smkn1bawang.iakprojecti2.adapter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import id.sch.smkn1bawang.iakprojecti2.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class PemilikAdapter$PemilikHolder_ViewBinding implements Unbinder {
  private PemilikAdapter.PemilikHolder target;

  @UiThread
  public PemilikAdapter$PemilikHolder_ViewBinding(PemilikAdapter.PemilikHolder target,
      View source) {
    this.target = target;

    target.ivTextDrawable = Utils.findRequiredViewAsType(source, R.id.ivTextDrawable, "field 'ivTextDrawable'", ImageView.class);
    target.tvNamaBuku = Utils.findRequiredViewAsType(source, R.id.tvNamaBuku, "field 'tvNamaBuku'", TextView.class);
    target.tvNamaPemilik = Utils.findRequiredViewAsType(source, R.id.tvNamaPemilik, "field 'tvNamaPemilik'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    PemilikAdapter.PemilikHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.ivTextDrawable = null;
    target.tvNamaBuku = null;
    target.tvNamaPemilik = null;
  }
}
