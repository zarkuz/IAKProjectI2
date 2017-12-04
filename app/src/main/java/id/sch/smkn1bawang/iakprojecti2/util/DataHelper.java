package id.sch.smkn1bawang.iakprojecti2.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by root on 04/12/17.
 */

public class DataHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "catatan.db";
    private static final int DATABASE_VERSION = 1;
    public DataHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        String sql = "create table catatan(no integer primary key, isi text null);";
        Log.d("Data", "onCreate" +sql);
        db.execSQL(sql);
        sql = "insert into catatan values ('1', 'halo');";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2){

    }
}
