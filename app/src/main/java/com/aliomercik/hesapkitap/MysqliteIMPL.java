package com.aliomercik.hesapkitap;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.aliomercik.hesapkitap.model.UrunModel;

import java.util.ArrayList;
import java.util.List;

public class MysqliteIMPL extends MySQL {
    private Context context;

    public MysqliteIMPL(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public void veriekle(UrunModel urunModel) {
        SQLiteDatabase sql = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(KILOGRAM, String.valueOf(urunModel.getKilogram()));
        cv.put(KILOGRAMFIYAT, String.valueOf(urunModel.getKilogramFiyat()));
        cv.put(KASAADET, String.valueOf(urunModel.getKasaAdedi()));
        sql.insert(TABLE_NAME, null, cv);
    }

    public List<UrunModel> getAll() {
        List<UrunModel> urunModels = new ArrayList<>();
        SQLiteDatabase rd = this.getReadableDatabase();
        Cursor query = rd.query(TABLE_NAME, new String[]{ID, KILOGRAM, KILOGRAMFIYAT, KASAADET}, null, null, null, null, null, null);
        if (query.moveToFirst()) {
            do {
                UrunModel urunModel = new UrunModel();
                urunModel.setId(query.getInt(query.getColumnIndex(ID)));
                urunModel.setKasaAdedi(Integer.parseInt(query.getString(query.getColumnIndex(KASAADET))));
                urunModel.setKilogram(Double.parseDouble(query.getString(query.getColumnIndex(KILOGRAM))));
                urunModel.setKilogramFiyat(Float.parseFloat(query.getString(query.getColumnIndex(KILOGRAMFIYAT))));
                urunModels.add(urunModel);
            } while (query.moveToNext());
        }
        return urunModels;
    }
}

