package id.sch.smkn1bawang.iakprojecti2.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.sch.smkn1bawang.iakprojecti2.R;
import id.sch.smkn1bawang.iakprojecti2.adapter.PemilikAdapter;
import id.sch.smkn1bawang.iakprojecti2.model.ResponsePemilik;
import id.sch.smkn1bawang.iakprojecti2.model.SemuapemilikItem;
import id.sch.smkn1bawang.iakprojecti2.util.api.BaseApiService;
import id.sch.smkn1bawang.iakprojecti2.util.api.UtilsApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PemilikActivity extends AppCompatActivity {
    @BindView(R.id.rvPemilik)
    RecyclerView rvPemilik;
    ProgressDialog loading;

    Context mContext;
    List<SemuapemilikItem> semuapemilikItemList = new ArrayList<>();
    PemilikAdapter pemilikAdapter;
    BaseApiService mApiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pemilik);

        getSupportActionBar().setTitle("Pemilik");

        ButterKnife.bind(this);
        mContext = this;
        mApiService = UtilsApi.getAPIService();

        pemilikAdapter = new PemilikAdapter(this, semuapemilikItemList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        rvPemilik.setLayoutManager(mLayoutManager);
//        rvPemilik.setAnimation(new DefaultItemAnimator());
        getResultListPemilik();
    }

    private void getResultListPemilik(){
        loading = ProgressDialog.show(this, null, "Tunggu", true, false);

        mApiService.getSemuaPemilik().enqueue(new Callback<ResponsePemilik>() {
            @Override
            public void onResponse(Call<ResponsePemilik> call, Response<ResponsePemilik> response) {
                if (response.isSuccessful()){
                    loading.dismiss();
                    final List<SemuapemilikItem> semuapemilikItems = response.body().getSemuapemilik();
                    rvPemilik.setAdapter(new PemilikAdapter(mContext, semuapemilikItems));
                    pemilikAdapter.notifyDataSetChanged();
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
}
