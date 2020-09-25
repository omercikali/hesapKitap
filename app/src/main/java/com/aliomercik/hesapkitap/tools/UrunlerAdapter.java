package com.aliomercik.hesapkitap.tools;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.aliomercik.hesapkitap.R;
import com.aliomercik.hesapkitap.model.UrunModel;

import java.util.List;

public class UrunlerAdapter extends BaseAdapter {
    private LayoutInflater layoutInflater;
    private List<UrunModel> urunModels;
    private Context context;

    public UrunlerAdapter(LayoutInflater layoutInflater, List<UrunModel> urunModels, Context context) {
        this.layoutInflater = layoutInflater;
        this.urunModels = urunModels;
        this.context = context;
    }


    @Override
    public int getCount() {
        return urunModels.size();
    }

    @Override
    public Object getItem(int position) {
        return urunModels.get(position);
    }

    @Override
    public long getItemId(int position) {
        return urunModels.get(position).hashCode();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = layoutInflater.inflate(R.layout.customuruns,null);
        TextView kilogram = v.findViewById(R.id.cs_kilogram);
        TextView kilogramfiyat = v.findViewById(R.id.cs_kilogramfiyat);
        TextView kasaadet = v.findViewById(R.id.cs_kasaadedi);
        TextView tutar = v.findViewById(R.id.cs_tutar);
        UrunModel urunModel = urunModels.get(position);
        kilogram.setText(urunModel.getKilogram() +"");
        kilogramfiyat.setText(urunModel.getKilogramFiyat()+"");
        kasaadet.setText(urunModel.getKasaAdedi()+"");
        tutar.setText(urunModel.getTutar()+"");

        return v;
    }
}
