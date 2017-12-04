package id.sch.smkn1bawang.iakprojecti2.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by root on 04/12/17.
 */

public class SharedPrefManager {
    public static final String SP_USER_APP = "spUserApp";

    public static final String SP_NAMA = "spNama";
    public static final String SP_EMAIL = "spEmail";
    public static final String SP_SUDAH_LOGIN = "spSudahLogin";

    SharedPreferences sp;
    SharedPreferences.Editor spEditor;

    public SharedPrefManager(Context context){
        sp = context.getSharedPreferences(SP_USER_APP, Context.MODE_PRIVATE);
        spEditor = sp.edit();
    }

    public void saveSPString(String keySP, String value){
        spEditor.putString(keySP, value);
        spEditor.commit();
    }
    public void saveSPInt(String keySP, int value){
        spEditor.putInt(keySP, value);
        spEditor.commit();
    }
    public void saveSPBoolean(String keySP, Boolean value){
        spEditor.putBoolean(keySP, value);
        spEditor.commit();
    }
    public String getSpNama(){return sp.getString(SP_NAMA, "");}
    public String getSpEmail(){return sp.getString(SP_EMAIL, "");}
    public Boolean getSPSudahLogin(){return sp.getBoolean(SP_SUDAH_LOGIN, false);}

}
