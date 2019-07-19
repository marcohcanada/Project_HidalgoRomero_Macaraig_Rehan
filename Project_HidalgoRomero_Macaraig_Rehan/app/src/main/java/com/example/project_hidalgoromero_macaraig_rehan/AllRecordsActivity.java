package com.example.project_hidalgoromero_macaraig_rehan;

import android.app.Activity;
import android.content.Intent;
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
            Intent intent = new Intent(AllRecordsActivity.this, EditRecordActivity.class);


            Record record = (Record) lvRecords.getItemAtPosition(position);
            Intent studentIDIntent = new Intent();
            String studentIDAsString = Integer.toString(record.getStudentID());
            studentIDIntent.putExtra("STUDENT ID", studentIDAsString);
            setResult(Activity.RESULT_OK, studentIDIntent);

            String scoreAsString = Integer.toString(record.getScore());
            studentIDIntent.putExtra("SCORE", scoreAsString);
            setResult(Activity.RESULT_OK, studentIDIntent);
            studentIDIntent.putExtra("COMMENTS", record.getComments());
            setResult(Activity.RESULT_OK, studentIDIntent);

            finish();

        }
    };

    public void createList() {
        Record record1 = new Record(345, 8, "Good");
        recordList.add(record1);
        Record record2 = new Record(564, 9, "Very Good");
        recordList.add(record2);
    }
}
