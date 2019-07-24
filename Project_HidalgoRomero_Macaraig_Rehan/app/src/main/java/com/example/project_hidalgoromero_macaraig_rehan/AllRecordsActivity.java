package com.example.project_hidalgoromero_macaraig_rehan;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.project_hidalgoromero_macaraig_rehan.model.Record;

import java.util.ArrayList;

public class AllRecordsActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnBack;

    ArrayList<Record> recordList;

    ListView lvRecords;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_records);

        this.referWidgets();
        createList();
        RecordAdapter adapter = new RecordAdapter(this, R.layout.listview_records,
                recordList);
        lvRecords.setAdapter(adapter);

        lvRecords.setOnItemClickListener(lvRecordsOutput);
    }

    private void referWidgets() {
        btnBack = findViewById(R.id.btn_back);
        btnBack.setOnClickListener(this);

        recordList = new ArrayList<>();

        lvRecords = findViewById(R.id.lv_records);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_back:
                Intent mainIntent = new Intent(this, MainActivity.class);
                startActivity(mainIntent);
        }
    }

    private AdapterView.OnItemClickListener lvRecordsOutput = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            switch (position) {
                case 0:
                    Intent editRecordIntent1 = new Intent(AllRecordsActivity.this, EditRecordActivity.class);

                    Record record1 = (Record) lvRecords.getItemAtPosition(position);

                    String studentIDAsString1 = Integer.toString(record1.getStudentID());
                    editRecordIntent1.putExtra("STUDENT ID", studentIDAsString1);

                    setResult(Activity.RESULT_OK, editRecordIntent1);
                    String scoreAsString1 = Integer.toString(record1.getScore());
                    editRecordIntent1.putExtra("SCORE", scoreAsString1);
                    setResult(Activity.RESULT_OK, editRecordIntent1);
                    editRecordIntent1.putExtra("COMMENTS", record1.getComments());
                    setResult(Activity.RESULT_OK, editRecordIntent1);

                    startActivityForResult(editRecordIntent1, 1);
                    break;
                case 1:
                    Intent editRecordIntent2 = new Intent(AllRecordsActivity.this, EditRecordActivity.class);

                    Record record2 = (Record) lvRecords.getItemAtPosition(position);

                    String studentIDAsString2 = Integer.toString(record2.getStudentID());
                    editRecordIntent2.putExtra("STUDENT ID", studentIDAsString2);
                    setResult(Activity.RESULT_OK, editRecordIntent2);

                    String scoreAsString2 = Integer.toString(record2.getScore());
                    editRecordIntent2.putExtra("SCORE", scoreAsString2);
                    setResult(Activity.RESULT_OK, editRecordIntent2);
                    editRecordIntent2.putExtra("COMMENTS", record2.getComments());
                    setResult(Activity.RESULT_OK, editRecordIntent2);

                    startActivityForResult(editRecordIntent2, 1);
                    break;
            }
        }
    };

    public void createList() {
        Record record1 = new Record(345, 8, "Good");
        recordList.add(record1);
        Record record2 = new Record(564, 9, "Very Good");
        recordList.add(record2);

        //String value = sharedPreferences.getString("BTN_SAVE_RECORD", "");
    }
}
