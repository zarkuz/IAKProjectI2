// Generated code from Butter Knife. Do not modify!
package id.sch.smkn1bawang.iakprojecti2.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import id.sch.smkn1bawang.iakprojecti2.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class TambahBukuActivity_ViewBinding implements Unbinder {
  private TambahBukuActivity target;

  @UiThread
  public TambahBukuActivity_ViewBinding(TambahBukuActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public TambahBukuActivity_ViewBinding(TambahBukuActivity target, View source) {
    this.target = target;

    target.spinnerPemilik = Utils.findRequiredViewAsType(source, R.id.spinnerPemilik, "field 'spinnerPemilik'", Spinner.class);
    target.etNamaBuku = Utils.findRequiredViewAsType(source, R.id.etNamaBuku, "field 'etNamaBuku'", EditText.class);
    target.btnPinjamBuku = Utils.findRequiredViewAsType(source, R.id.btnPinjamBuku, "field 'btnPinjamBuku'", Button.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    TambahBukuActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.spinnerPemilik = null;
    target.etNamaBuku = null;
    target.btnPinjamBuku = null;
  }
}
