package id.sch.smkn1bawang.iakprojecti2.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.sch.smkn1bawang.iakprojecti2.R;
import id.sch.smkn1bawang.iakprojecti2.model.ResponsePemilik;
import id.sch.smkn1bawang.iakprojecti2.model.ResponsePemilikDetail;
import id.sch.smkn1bawang.iakprojecti2.model.SemuapemilikItem;
import id.sch.smkn1bawang.iakprojecti2.util.api.BaseApiService;
import id.sch.smkn1bawang.iakprojecti2.util.api.UtilsApi;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TambahBukuActivity extends AppCompatActivity {
    @BindView(R.id.spinnerPemilik)
    Spinner spinnerPemilik;
    @BindView(R.id.etNamaBuku)
    EditText etNamaBuku;
    @BindView(R.id.btnPinjamBuku)
    Button btnPinjamBuku;
    ProgressDialog loading;

    Context mContext;
    BaseApiService mApiService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_buku);

        ButterKnife.bind(this);
        mContext = this;
        mApiService = UtilsApi.getAPIService();
        initSpinnerPemilik();

        spinnerPemilik.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedName = parent.getItemAtPosition(position).toString();
                Toast.makeText(mContext, "Kamu Memilih " + selectedName, Toast.LENGTH_SHORT).show();
            }

//            @Override
            public void onNothingSelected(AdapterView<?> parent){

            }
        });

        btnPinjamBuku.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requestSimpanBuku();
            }
        });
    }

    private void initSpinnerPemilik(){
        loading = ProgressDialog.show(mContext, null, "tunggu", true, false);
        mApiService.getSemuaPemilik().enqueue(new Callback<ResponsePemilik>() {
            @Override
            public void onResponse(Call<ResponsePemilik> call, Response<ResponsePemilik> response) {
                if (response.isSuccessful()){
                    loading.dismiss();
                    List<SemuapemilikItem> semuapemilikItems = response.body().getSemuapemilik();
                    List<String> listSpinner = new ArrayList<String>();
                    for (int i=0; i<semuapemilikItems.size(); i++){
                        listSpinner.add(semuapemilikItems.get(i).getNama());
                    }
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(mContext, android.R.layout.simple_spinner_item, listSpinner);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerPemilik.setAdapter(adapter);
                } else {
                    loading.dismiss();
                    Toast.makeText(mContext, "Gagal", Toast.LENGTH_SHORT).show();
                }
            }


            @Override
            public void onFailure(Call<ResponsePemilik> call, Throwable t) {
                loading.dismiss();
                Toast.makeText(mContext, "Koneksi Gagal", Toast.LENGTH_SHORT).show();


            }
        });
    }

    private void requestDetailPemilik(String namaPemilik){
        mApiService.getDetailPemilik(namaPemilik).enqueue(new Callback<ResponsePemilikDetail>() {
            @Override
            public void onResponse(Call<ResponsePemilikDetail> call, Response<ResponsePemilikDetail> response) {
                if (response.isSuccessful()){
                    if (response.body().isError()){
                        Toast.makeText(mContext, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    } else {
                        etNamaBuku.setText((CharSequence) response.body().getBuku());
                    }
                } else {
                    Toast.makeText(mContext, "Gagal", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponsePemilikDetail> call, Throwable t) {
                loading.dismiss();
                Toast.makeText(mContext, "Koneksi Gagal", Toast.LENGTH_SHORT).show();

            }

        });
    }

    private void requestSimpanBuku(){
        loading = ProgressDialog.show(mContext, null, "Tunggu", true, false);
        mApiService.simpanBukuRequest(spinnerPemilik.getSelectedItem().toString(), etNamaBuku.getText().toString())
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if (response.isSuccessful()){
                            loading.dismiss();
                            Toast.makeText(mContext, "Berhasil", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(mContext, BukuActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
                            finish();
                        } else {
                            loading.dismiss();
                            Toast.makeText(mContext, "Gagal", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {

                        loading.dismiss();
                        Toast.makeText(mContext, "Koneksi internet bermasalah", Toast.LENGTH_SHORT).show();
                    }
                });
    }

}
