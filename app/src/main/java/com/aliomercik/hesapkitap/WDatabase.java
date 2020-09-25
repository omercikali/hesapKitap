package com.aliomercik.hesapkitap;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

import androidx.annotation.Nullable;

import com.aliomercik.hesapkitap.model.Workermodel;

import java.util.ArrayList;
import java.util.List;

public class WDatabase extends SQLiteOpenHelper {
    private static final String WDATABASE = "Workers";
    private static final String TABLENAME = "workers";
    private static final int VERSION = 1;

    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String WAGE = "wage";
    private static final String DATE = "date";


    public WDatabase(@Nullable Context context) {
        super(context, WDATABASE, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create_table = "CREATE TABLE " + TABLENAME +
                "(" + ID + " INTEGER PRIMARY KEY, " +
                NAME + " TEXT, " +
                WAGE + " INTEGER NOT NULL, " +
                DATE + " INTEGER NOT NULL) ";
        db.execSQL(create_table);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLENAME);
        onCreate(db);

    }

    public List<Workermodel> GetAllData() {
        SQLiteDatabase database = this.getReadableDatabase();
        String[] sutunlar = new String[]{NAME, WAGE, DATE};
        Cursor cursor = database.query(TABLENAME, sutunlar, null, null, null, null, DATE+" desc");
        int nameIX = cursor.getColumnIndex(NAME);
        int wageIX = cursor.getColumnIndex(WAGE);
        int dateIX = cursor.getColumnIndex(DATE);

        List<Workermodel> workersList = new ArrayList<Workermodel>();
        if (cursor.moveToFirst()) {
            do {

                Workermodel workers = new Workermodel();

                workers.setName(cursor.getString(nameIX));
                workers.setWage(cursor.getInt(wageIX));
                workers.setDate(cursor.getLong(dateIX));

                workersList.add(workers);
            }
            while (cursor.moveToNext());
        }

        database.close();


        return workersList;
    }

    public long kayıtekle(Workermodel workers) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(NAME, workers.getName());
        cv.put(WAGE, workers.getWage());
        cv.put(DATE, workers.getDate());
        long id = db.insert(TABLENAME, null, cv);
        db.close();

        return id;
    }
}
