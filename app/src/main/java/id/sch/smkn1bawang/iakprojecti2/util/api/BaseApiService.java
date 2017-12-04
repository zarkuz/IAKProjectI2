package id.sch.smkn1bawang.iakprojecti2.util.api;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import id.sch.smkn1bawang.iakprojecti2.model.ResponsePemilik;
import id.sch.smkn1bawang.iakprojecti2.model.ResponseBuku;
import id.sch.smkn1bawang.iakprojecti2.model.ResponsePemilikDetail;

/**
 * Created by root on 04/12/17.
 */

public interface BaseApiService {

    @FormUrlEncoded
    @POST("login.php")
    Call<ResponseBody> loginRequest(@Field("email") String email, @Field("password") String password);
    @FormUrlEncoded
    @POST("register.php")
    Call<ResponseBody> registerRequest(@Field("nama") String nama, @Field("email") String email, @Field("password") String password);

    @GET("semuapemilik")
    Call<ResponsePemilik> getSemuaPemilik();
    @GET("pemilik/{namapemilik}")
    Call<ResponsePemilikDetail> getDetailPemilik(@Path("namapemilik") String namapemilik);
    @GET("buku")
    Call<ResponseBuku> getSemuaBuku();

    @FormUrlEncoded
    @POST("buku")
    Call<ResponseBody> simpanBukuRequest(@Field("nama_pemilik") String namapemilik, @Field("buku") String namabuku);

    @DELETE("buku/{idbuku}")
    Call<ResponseBody> deleteBuku(@Path("idbuku") String idbuku);


}
