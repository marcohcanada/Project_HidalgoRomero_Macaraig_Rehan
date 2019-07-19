package com.example.listviewcustomexample;

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
 * on 2019-06-28
 */
public class MyAdapter extends ArrayAdapter<Province> {
    List<Province> provinces;
    public MyAdapter(Context context, int resource, List<Province> objects) {
        super(context, resource, objects);
        this.provinces = objects;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if(view==null){
            LayoutInflater inflater = (LayoutInflater)
                    getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.content_main, null);
        }
        TextView province = (TextView)view.findViewById(R.id.province);
        TextView city = (TextView)view.findViewById(R.id.city);
        ImageView flag = (ImageView)view.findViewById(R.id.flag);
        province.setText(provinces.get(position).name);
        city.setText(provinces.get(position).capital);
        flag.setBackgroundResource(provinces.get(position).flag);
        return view ;
    }
}
