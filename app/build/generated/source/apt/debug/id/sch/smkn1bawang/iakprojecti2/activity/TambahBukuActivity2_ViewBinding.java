// Generated code from Butter Knife. Do not modify!
package id.sch.smkn1bawang.iakprojecti2.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import id.sch.smkn1bawang.iakprojecti2.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class TambahBukuActivity2_ViewBinding implements Unbinder {
  private TambahBukuActivity2 target;

  @UiThread
  public TambahBukuActivity2_ViewBinding(TambahBukuActivity2 target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public TambahBukuActivity2_ViewBinding(TambahBukuActivity2 target, View source) {
    this.target = target;

    target.etNamaPemilik = Utils.findRequiredViewAsType(source, R.id.etNamaPemilik, "field 'etNamaPemilik'", EditText.class);
    target.etNamaBuku = Utils.findRequiredViewAsType(source, R.id.etNamaBuku, "field 'etNamaBuku'", EditText.class);
    target.btnPinjamBuku = Utils.findRequiredViewAsType(source, R.id.btnPinjamBuku, "field 'btnPinjamBuku'", Button.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    TambahBukuActivity2 target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.etNamaPemilik = null;
    target.etNamaBuku = null;
    target.btnPinjamBuku = null;
  }
}
