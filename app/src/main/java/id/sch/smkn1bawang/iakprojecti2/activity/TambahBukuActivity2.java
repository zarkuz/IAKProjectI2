package id.sch.smkn1bawang.iakprojecti2.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.sch.smkn1bawang.iakprojecti2.R;
import id.sch.smkn1bawang.iakprojecti2.util.api.BaseApiService;
import id.sch.smkn1bawang.iakprojecti2.util.api.UtilsApi;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TambahBukuActivity2 extends AppCompatActivity {

    @BindView(R.id.etNamaPemilik)
    EditText etNamaPemilik;
    @BindView(R.id.etNamaBuku)
    EditText etNamaBuku;
    @BindView(R.id.btnPinjamBuku)
    Button btnPinjamBuku;
    ProgressDialog loading;

    BaseApiService mApiService;
    Context mContext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_buku2);

        ButterKnife.bind(this);
        mContext = this;
        mApiService = UtilsApi.getAPIService();

        btnPinjamBuku.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requestSimpanBuku();
            }
        });
    }

    private void requestSimpanBuku(){
        loading = ProgressDialog.show(mContext, null, "Tunggu", true, false);
        mApiService.simpanBukuRequest(etNamaPemilik.getText().toString(), etNamaBuku.getText().toString())
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if (response.isSuccessful()){
                            loading.dismiss();
                            Toast.makeText(mContext, "Data Berhasil Ditambahkan", Toast.LENGTH_LONG).show();
                        } else {
                            loading.dismiss();
                            Toast.makeText(mContext, "Gagal Menyimpan Data", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        loading.dismiss();
                        Toast.makeText(mContext, "Koneksi Internet Bermasalah", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
