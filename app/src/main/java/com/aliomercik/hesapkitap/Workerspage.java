package com.aliomercik.hesapkitap;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.aliomercik.hesapkitap.model.Workermodel;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Workerspage extends AppCompatActivity {
    TextView toplamucretTW, gunlukortalamatw, textView2;
    TableLayout table;
    TableRow tableRow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workerspage);


        toplamucretTW = findViewById(R.id.textView);
        gunlukortalamatw = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        table = findViewById(R.id.table);
        tableRow = findViewById(R.id.tablerow);
        LinkedList<Integer> list= new LinkedList<Integer>();


        try {
            GetList();
        } catch (Exception e) {
            Toast.makeText(this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            //        System.out.println(e.getLocalizedMessage());
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {


        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.add_worker, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.add_date_item:
                Intent intent = new Intent(Workerspage.this, AddRecord.class);
                startActivity(intent);
                return true;
            case R.id.add_worker_item:
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void GetList() {
        table.removeAllViews();
        WDatabase wdatabase = new WDatabase(getApplicationContext());
        List<Workermodel> workersList = new ArrayList<>();
        workersList = wdatabase.GetAllData();
        long en_kucuk = workersList.get(workersList.size() - 1).getDate();
        long en_buyuk = workersList.get(0).getDate();
        Date fark = new Date(en_buyuk - en_kucuk);
        int fark_gun = ((fark.getYear() % 70) * 365) + (fark.getMonth() * 30) + (fark.getDate() - 1);
        fark_gun++;
        int toplam_ucret = 0;
        for (Workermodel workermodel : workersList) {
            toplam_ucret += workermodel.getWage();

        }
        int ortalama_ücret = toplam_ucret / fark_gun;

        toplamucretTW.setText("toplam ödeme:" + toplam_ucret);
        gunlukortalamatw.setText("ortalama ödeme:" + ortalama_ücret);
        for (Workermodel workers : workersList) {
            View v = getLayoutInflater().inflate(R.layout.cttable_row, null);
            TextView ucret = v.findViewById(R.id.cs_ucret);
            TextView tarih = v.findViewById(R.id.cs_tarih);
            TextView adi = v.findViewById(R.id.cs_adi);
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            Date date1 = new Date(workers.getDate());
            tarih.setText(df.format(date1));
            adi.setText(workers.getName() + "   ");
            ucret.setText("" + workers.getWage() + "   ");
            table.addView(v);
        }

    }
}
