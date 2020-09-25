package com.aliomercik.hesapkitap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.aliomercik.hesapkitap.model.UrunModel;

import java.util.List;

public class Soldgoods extends AppCompatActivity {
    EditText kasaadet;
    EditText kilogram;
    EditText kilogramfiyat;
    TextView tutar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soldgoods);
        kasaadet = findViewById(R.id.kasaadet);
        kilogram = findViewById(R.id.kilogram);
        kilogramfiyat = findViewById(R.id.kilogramfiyat);
        tutar = findViewById(R.id.tutar);

    }


    public void hesapla(View view) {
        // editteten alınan veri

        UrunModel urun = new UrunModel();
        urun.setKasaAdedi(Integer.parseInt(kasaadet.getText().toString()));
        urun.setKilogramFiyat(Float.parseFloat(kilogramfiyat.getText().toString()));
        urun.setKilogram(Double.parseDouble(kilogram.getText().toString()));
         //        // ondalık sayıya çevirme
//        float kilogramFlt = Float.parseFloat(kilogramStr);
//        float kilogramfiyatFlt = Float.parseFloat(kilogramfiyatStr);
//        //işlem
//        float carpim = kilogramFlt * kilogramfiyatFlt;
//        //yazdırma
        tutar.setText("tutar: " + urun.getTutar());
        Toast.makeText(getApplicationContext(), "kaydedildi", Toast.LENGTH_LONG).show();
          // Model  - view  - controller

        try {

            MysqliteIMPL mysqlite = new MysqliteIMPL(getApplicationContext());
            mysqlite.veriekle(urun);
              //            database = this.openOrCreateDatabase("Soldgoods", MODE_PRIVATE, null);
//            database.execSQL("CREATE TABLE IF NOT EXISTS soldgoods(id INTEGER PRIMARY KEY,kasaadet VARCHAR,kilogram VARCHAR,kilogramfiyat VARCHAR,tutar VARCHAR)");
//            String sqlstring = "INSERT INTO soldgoods (kasaadet,kilogram,kilogramfiyat,tutar)VALUES(?,?,?,?)";
//            // bi üstteki ifadeyi okumaya yarıyor
//            SQLiteStatement sqLiteStatement = database.compileStatement(sqlstring);
//            sqLiteStatement.bindString(1, kasaadetstr);
//            sqLiteStatement.bindString(2, kilogramdtbs);
//            sqLiteStatement.bindString(3, kilogramfiyatdtbs);
//            sqLiteStatement.bindString(4, carpimdtbs);
//            sqLiteStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
