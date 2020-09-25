package com.aliomercik.hesapkitap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.aliomercik.hesapkitap.model.UrunModel;
import com.aliomercik.hesapkitap.tools.UrunlerAdapter;

import java.util.ArrayList;
import java.util.List;

public class Allsoldgoods extends AppCompatActivity {
    ListView listView;
    ArrayList<String> kasaarray;
    ArrayList<Integer> idarray;
    ArrayAdapter arrayAdapter;
    TextView toplamkasa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allsoldgoods);
        listView = findViewById(R.id.listView);
        kasaarray = new ArrayList<String>();
        idarray = new ArrayList<Integer>();
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, kasaarray);
        listView.setAdapter(arrayAdapter);
        toplamkasa = findViewById(R.id.toplamkasa);

         /*   listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            //    Intent intent=new Intent(Allsoldgoods.this,ShowActivity.class);
          //      intent.putExtra("soldid",idarray.get(position));
                //   startActivity(intent);
            }
        });*/

        getdata();
    }

    public void getdata() {
        try {

            List<UrunModel> all = new MysqliteIMPL(getApplicationContext()).getAll();
            UrunlerAdapter ua = new UrunlerAdapter(getLayoutInflater(), all, getApplicationContext());
            listView.setAdapter(ua);
            double toplam = 0;
            for (UrunModel u : all) {
                toplam += u.getTutar();
            }

            toplamkasa.setText(toplam +"");
//            database = this.openOrCreateDatabase("Soldgoods", MODE_PRIVATE, null);
//            Cursor cursor = database.rawQuery("SELECT*FROM soldgoods", null);
//            int kasaadetIndx = cursor.getColumnIndex("kasaadet");
//            int idIndx = cursor.getColumnIndex("id");
//            while (cursor.moveToNext()) {
//                kasaarray.add(cursor.getString(kasaadetIndx));
//                idarray.add(cursor.getInt(idIndx));
//            }
//            arrayAdapter.notifyDataSetChanged();
//            cursor.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
