package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by 991470628 : MARCO HIDALGO ROMERO
 * on 2019-07-03
 */
public class SecondAdapter extends ArrayAdapter {
    List<Province> provinces ;
    public SecondAdapter(Context context, int resource, List objects) {
        super (context, resource, objects);

        this.provinces = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.list_viiew_row, null);
        }
        TextView cityName = view.findViewById(R.id.textView);
        TextView provinceName = view.findViewById(R.id.textView2);
        ImageView im = view.findViewById(R.id.imageView);
        cityName.setText(provinces.get(position).city);
        provinceName.setText(provinces.get(position).provinceName);
        im.setBackgroundResource(provinces.get(position).image);
        return view;
    }
}
