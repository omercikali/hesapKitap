package com.aliomercik.hesapkitap;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.aliomercik.hesapkitap.model.Workermodel;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class AddRecord extends AppCompatActivity {
    EditText nameET, wageET, dateET;
    int year, month, day;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_record);

        nameET = findViewById(R.id.name);
        wageET = findViewById(R.id.wage);
        dateET = findViewById(R.id.date1);
        dateET.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Calendar calendar = Calendar.getInstance();
                year = calendar.get(Calendar.YEAR);
                month = calendar.get(Calendar.MONTH);
                day = calendar.get(Calendar.DAY_OF_MONTH);
                final DatePickerDialog datePicker;
                datePicker = new DatePickerDialog(AddRecord.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                        dateET.setText(dayOfMonth + "/" + (month + 1) + "/" + year);


                    }
                }, year, month, day);

                datePicker.setTitle("tarih seçiniz");
                datePicker.setButton(DialogInterface.BUTTON_POSITIVE, "Ayarla", datePicker);
                datePicker.setButton(DialogInterface.BUTTON_NEGATIVE, "İptal", datePicker);
                datePicker.show();
            }
        });
    }
    public void savecl(View view){
        try {
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            Date date = null;
            try {
                date = df.parse(day + "/" + month + "/" + year);

            } catch (Exception e) {
                e.printStackTrace();
            }
            long tarih = date.getTime();

            int wage = Integer.parseInt(wageET.getText().toString());

            String name = nameET.getText().toString();

            Workermodel workers = new Workermodel(name, wage, tarih);
            WDatabase database = new WDatabase(getApplicationContext());
            long id = database.kayıtekle(workers);

            if (id == -1) {
                Toast.makeText(getApplicationContext(), "kayıt başarısız tekrar deneyin", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getApplicationContext(), "kayıt başarılı", Toast.LENGTH_LONG).show();
            }

        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "ücret girmediniz lütfen ücreti giriniz", Toast.LENGTH_LONG).show();
        }
        finish();





    }


}
