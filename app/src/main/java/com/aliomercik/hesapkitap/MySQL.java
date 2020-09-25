package com.aliomercik.hesapkitap;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

//My SQLİTE
public class MySQL extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "urunler";
    private static final int DATABASE_VERSION = 1;
    protected static final String TABLE_NAME = "urunler_tb";
    protected static final String ID = "id";
    protected static final String KASAADET = "kasaadet";
    protected static final String KILOGRAM = "kilogram";
    protected static final String KILOGRAMFIYAT = "kilogramfiyat";
    protected static final String TUTAR = "tutar";


    public MySQL(@Nullable Context context) {
        super(context, DATABASE_NAME,null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlolustur = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME +
                "(" +
                ID + " INTEGER PRIMARY KEY," +
                KASAADET + " VARCHAR," +
                KILOGRAM + " VARCHAR," +
                KILOGRAMFIYAT + " VARCHAR," +
                  TUTAR + " VARCHAR" +
                ")";
        db.execSQL(sqlolustur);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_NAME);
    }
}
