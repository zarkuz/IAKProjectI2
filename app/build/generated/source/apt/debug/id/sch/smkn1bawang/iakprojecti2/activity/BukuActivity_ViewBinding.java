// Generated code from Butter Knife. Do not modify!
package id.sch.smkn1bawang.iakprojecti2.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import id.sch.smkn1bawang.iakprojecti2.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class BukuActivity_ViewBinding implements Unbinder {
  private BukuActivity target;

  @UiThread
  public BukuActivity_ViewBinding(BukuActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public BukuActivity_ViewBinding(BukuActivity target, View source) {
    this.target = target;

    target.btnTambahBuku = Utils.findRequiredViewAsType(source, R.id.btnTambahBuku, "field 'btnTambahBuku'", Button.class);
    target.tvBelumBuku = Utils.findRequiredViewAsType(source, R.id.tvBelumBuku, "field 'tvBelumBuku'", TextView.class);
    target.rvBuku = Utils.findRequiredViewAsType(source, R.id.rvBuku, "field 'rvBuku'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    BukuActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.btnTambahBuku = null;
    target.tvBelumBuku = null;
    target.rvBuku = null;
  }
}
