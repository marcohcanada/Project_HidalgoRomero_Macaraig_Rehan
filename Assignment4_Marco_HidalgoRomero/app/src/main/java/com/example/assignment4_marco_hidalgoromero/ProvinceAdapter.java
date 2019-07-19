package com.example.assignment4_marco_hidalgoromero;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.assignment4_marco_hidalgoromero.model.Province;

import java.util.List;

/**
 * Created by 991470628 : MARCO HIDALGO ROMERO
 * on 2019-07-10
 */
public class ProvinceAdapter extends ArrayAdapter {
    List<Province> provinces;
    public ProvinceAdapter(Context context, int resource, List objects) {
        super(context, resource, objects);

        this.provinces = objects;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listview_row, null);
        }

        TextView tvNameInfo = convertView.findViewById(R.id.tv_name_info);
        TextView tvCapitalInfo = convertView.findViewById(R.id.tv_capital_info);

        ImageView imgArm = convertView.findViewById(R.id.img_arm);

        tvNameInfo.setText(provinces.get(position).getName());
        tvCapitalInfo.setText(provinces.get(position).getCapital());

        imgArm.setBackgroundResource(provinces.get(position).getArmId());

        return convertView;
    }

}
