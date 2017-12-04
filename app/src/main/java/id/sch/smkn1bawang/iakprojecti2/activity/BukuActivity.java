package id.sch.smkn1bawang.iakprojecti2.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.app.ProgressDialog;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.sch.smkn1bawang.iakprojecti2.R;
import id.sch.smkn1bawang.iakprojecti2.adapter.BukuAdapter;
import id.sch.smkn1bawang.iakprojecti2.model.ResponseBuku;
import id.sch.smkn1bawang.iakprojecti2.model.SemuabukuItem;
import id.sch.smkn1bawang.iakprojecti2.util.Constant;
import id.sch.smkn1bawang.iakprojecti2.util.RecyclerItemClickListener;
import id.sch.smkn1bawang.iakprojecti2.util.api.BaseApiService;
import id.sch.smkn1bawang.iakprojecti2.util.api.UtilsApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BukuActivity extends AppCompatActivity {
    @BindView(R.id.btnTambahBuku)
    Button btnTambahBuku;
    @BindView(R.id.tvBelumBuku)
    TextView tvBelumBuku;
    @BindView(R.id.rvBuku)
    RecyclerView rvBuku;
    ProgressDialog loading;

    Context mContext;
    List<SemuabukuItem> semuabukuItemList = new ArrayList<>();
    BukuAdapter bukuAdapter;
    BaseApiService mApiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buku);

        getSupportActionBar().setTitle("Daftar Buku");

        ButterKnife.bind(this);
        mApiService = UtilsApi.getAPIService();
        mContext = this;

        bukuAdapter = new BukuAdapter(this, semuabukuItemList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        rvBuku.setLayoutManager(mLayoutManager);
        rvBuku.setItemAnimator(new DefaultItemAnimator());

        getDataBuku();

        btnTambahBuku.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BukuActivity.this, TambahBukuActivity2.class));
            }
        });
    }

    private void getDataBuku(){
        loading = ProgressDialog.show(mContext, null, "Tunggu...", true, false);
        mApiService.getSemuaBuku().enqueue(new Callback<ResponseBuku>() {
            @Override
            public void onResponse(Call<ResponseBuku> call, Response<ResponseBuku> response) {
                if (response.isSuccessful()){
                    loading.dismiss();
                    if (response.body().isError()){
                        tvBelumBuku.setVisibility(View.VISIBLE);
                    } else {
                        final List<SemuabukuItem> semuabukuItems = response.body().getSemuabuku();
                        rvBuku.setAdapter(new BukuAdapter(mContext, semuabukuItems));
                        bukuAdapter.notifyDataSetChanged();
                        initDataIntent(semuabukuItems);
                    }
                } else {
                    loading.dismiss();
                    Toast.makeText(mContext, "Gagal Ambil Data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseBuku> call, Throwable t) {
                loading.dismiss();
                Toast.makeText(mContext, "Cek Koneksi", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initDataIntent(final List<SemuabukuItem> bukuList){
        rvBuku.addOnItemTouchListener(
                new RecyclerItemClickListener(mContext, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        String id = bukuList.get(position).getId();
                        String namapemilik = bukuList.get(position).getNamaPemilik();
                        String buku = bukuList.get(position).getBuku();
                        Intent detailBuku = new Intent(mContext, BukuDetailActivity.class);
                        detailBuku.putExtra(Constant.KEY_ID_BUKU, id);
                        detailBuku.putExtra(Constant.KEY_NAMA_PEMILIK, namapemilik);
                        detailBuku.putExtra(Constant.KEY_BUKU, buku);
                        startActivity(detailBuku);
                    }
                })
        );
    }
}
