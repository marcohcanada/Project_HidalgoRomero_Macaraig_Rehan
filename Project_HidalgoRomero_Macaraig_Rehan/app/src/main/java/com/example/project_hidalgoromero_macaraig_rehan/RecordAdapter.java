package com.example.project_hidalgoromero_macaraig_rehan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.project_hidalgoromero_macaraig_rehan.model.Record;

import java.util.ArrayList;

/**
 * Created by 991470628 : MARCO HIDALGO ROMERO
 * on 2019-07-16
 */
public class RecordAdapter extends ArrayAdapter {
    ArrayList<Record> records;

    public RecordAdapter(Context context, int resource, ArrayList<Record> objects) {
        super(context, resource, objects);
        this.records = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater)
                    getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listview_records, null);
        }

        TextView tvStudentId = convertView.findViewById(R.id.tv_student_id);
        TextView tvScore = convertView.findViewById(R.id.tv_score);
        TextView tvComments = convertView.findViewById(R.id.tv_comments);
        String studentIDAsString = Integer.toString(records.get(position).getStudentID());
        tvStudentId.setText(studentIDAsString);
        String scoreAsString = Integer.toString(records.get(position).getScore());
        tvScore.setText(scoreAsString);
        tvComments.setText(records.get(position).getComments());
        return convertView;
    }
}
