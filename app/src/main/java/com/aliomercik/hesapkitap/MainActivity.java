package com.aliomercik.hesapkitap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
    public void isciler(View view){
     intent = new Intent(MainActivity.this,Workerspage.class);
      startActivity(intent);
    }
    public void satilanmal(View view){
     intent=new Intent(MainActivity.this,Soldgoods.class);
     startActivity(intent);
    }
    public void karzarar(View view){
intent=new Intent(MainActivity.this,AdvantageDamage.class);
startActivity(intent);
    }
    public  void allsoldgoods(View view){

        intent=new Intent(MainActivity.this,Allsoldgoods.class);
        startActivity(intent);
// listView daki gelen verilere yeni sayfa ekle ve verileri göster
    }



}
