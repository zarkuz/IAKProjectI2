// Generated code from Butter Knife. Do not modify!
package id.sch.smkn1bawang.iakprojecti2.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import id.sch.smkn1bawang.iakprojecti2.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class BukuDetailActivity_ViewBinding implements Unbinder {
  private BukuDetailActivity target;

  @UiThread
  public BukuDetailActivity_ViewBinding(BukuDetailActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public BukuDetailActivity_ViewBinding(BukuDetailActivity target, View source) {
    this.target = target;

    target.ivTextDrawable = Utils.findRequiredViewAsType(source, R.id.ivTextDrawable, "field 'ivTextDrawable'", ImageView.class);
    target.tvNamaPemilik = Utils.findRequiredViewAsType(source, R.id.tvNamaPemilik, "field 'tvNamaPemilik'", TextView.class);
    target.tvNamaBuku = Utils.findRequiredViewAsType(source, R.id.tvNamaBuku, "field 'tvNamaBuku'", TextView.class);
    target.btnHapus = Utils.findRequiredViewAsType(source, R.id.btnHapus, "field 'btnHapus'", Button.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    BukuDetailActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.ivTextDrawable = null;
    target.tvNamaPemilik = null;
    target.tvNamaBuku = null;
    target.btnHapus = null;
  }
}
