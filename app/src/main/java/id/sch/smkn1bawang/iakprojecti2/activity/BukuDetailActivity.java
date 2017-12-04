package id.sch.smkn1bawang.iakprojecti2.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.amulyakhare.textdrawable.TextDrawable;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.sch.smkn1bawang.iakprojecti2.R;
import id.sch.smkn1bawang.iakprojecti2.util.Constant;
import id.sch.smkn1bawang.iakprojecti2.util.api.BaseApiService;
import id.sch.smkn1bawang.iakprojecti2.util.api.UtilsApi;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BukuDetailActivity extends AppCompatActivity {

    @BindView(R.id.ivTextDrawable)
    ImageView ivTextDrawable;
    @BindView(R.id.tvNamaPemilik)
    TextView tvNamaPemilik;
    @BindView(R.id.tvNamaBuku)
    TextView tvNamaBuku;
    @BindView(R.id.btnHapus)
    Button btnHapus;
    ProgressDialog loading;

    String mId, mNamaPemilik, mNamaBuku;

    Context mContext;
    BaseApiService mApiService;

    public String[] mColors = {
            "#39add1", // light blue
            "#3079ab", // dark blue
            "#c25975", // mauve
            "#e15258", // red
            "#f9845b", // orange
            "#838cc7", // lavender
            "#7d669e", // purple
            "#53bbb4", // aqua
            "#51b46d", // green
            "#e0ab18", // mustard
            "#637a91", // dark gray
            "#f092b0", // pink
            "#b7c0c7"  // light gray
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buku_detail);
        getSupportActionBar().setTitle("Detail Buku");

        ButterKnife.bind(this);
        mContext = this;
        mApiService = UtilsApi.getAPIService();

        Intent intent = getIntent();
        mId = intent.getStringExtra(Constant.KEY_ID_BUKU);
        mNamaPemilik = intent.getStringExtra(Constant.KEY_NAMA_PEMILIK);
        mNamaBuku = intent.getStringExtra(Constant.KEY_BUKU);

        tvNamaPemilik.setText(mNamaPemilik);
        tvNamaBuku.setText(mNamaBuku);
        String firstCharNamaBuku = mNamaBuku.substring(0,1);
        TextDrawable drawable = TextDrawable.builder()
                .buildRound(firstCharNamaBuku, getColor());
        ivTextDrawable.setImageDrawable(drawable);

        btnHapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requestDeleteBuku();
            }
        });
    }
    private void requestDeleteBuku(){
        loading = ProgressDialog.show(mContext, null, "Tunggu", true, false);

        mApiService.deleteBuku(mId).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()){
                    loading.dismiss();
                    Toast.makeText(mContext, "Berhasil", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(mContext, BukuActivity.class)
                            .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
                    finish();
                } else {
                    loading.dismiss();
                    Toast.makeText(mContext, "Gagal", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                loading.dismiss();
                Toast.makeText(mContext, "Koneksi Bermasalah", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public int getColor() {
        String color;
        Random randomGenerator = new Random();
        int randomNumber = randomGenerator.nextInt(mColors.length);
        color = mColors[randomNumber];
        int colorAsInt = Color.parseColor(color);
        return colorAsInt;
    }
}
