// Generated code from Butter Knife. Do not modify!
package id.sch.smkn1bawang.iakprojecti2.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import id.sch.smkn1bawang.iakprojecti2.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MainActivity_ViewBinding implements Unbinder {
  private MainActivity target;

  @UiThread
  public MainActivity_ViewBinding(MainActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MainActivity_ViewBinding(MainActivity target, View source) {
    this.target = target;

    target.tvResultNama = Utils.findRequiredViewAsType(source, R.id.tvResultNama, "field 'tvResultNama'", TextView.class);
    target.btnLogout = Utils.findRequiredViewAsType(source, R.id.btnLogout, "field 'btnLogout'", Button.class);
    target.btnLihatPemilik = Utils.findRequiredViewAsType(source, R.id.btnLihatPemilik, "field 'btnLihatPemilik'", Button.class);
    target.btnLihatBuku = Utils.findRequiredViewAsType(source, R.id.btnLihatBuku, "field 'btnLihatBuku'", Button.class);
    target.btnTampilkan = Utils.findRequiredViewAsType(source, R.id.btnTampilkan, "field 'btnTampilkan'", Button.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MainActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvResultNama = null;
    target.btnLogout = null;
    target.btnLihatPemilik = null;
    target.btnLihatBuku = null;
    target.btnTampilkan = null;
  }
}
