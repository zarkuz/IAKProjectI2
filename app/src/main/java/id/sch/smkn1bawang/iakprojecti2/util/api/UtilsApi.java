package id.sch.smkn1bawang.iakprojecti2.util.api;

/**
 * Created by root on 04/12/17.
 */

public class UtilsApi {
    public static final String BASE_URL_API ="http://192.168.0.102/API-me-master/";
     public static BaseApiService getAPIService(){
         return RetrofitClient.getClient(BASE_URL_API).create(BaseApiService.class);
     }
}
