package com.example.project_hidalgoromero_macaraig_rehan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class NewRecordActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvScore;

    EditText edtStudentID;
    EditText edtComments;

    SeekBar sbScore;

    Button btnBack;
    Button btnSaveRecord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_record);

        this.referWidgets();

        tvScore.setText("Score: " + sbScore.getProgress() + "/" + sbScore.getMax());

        sbScore.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progress = 0;

            @Override
            public void onProgressChanged(SeekBar sbScore, int progresValue, boolean fromUser) {
                progress = progresValue;
                Toast.makeText(getApplicationContext(), "Changing seekbar's progress", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar sbScore) {
                Toast.makeText(getApplicationContext(), "Started tracking seekbar", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar sbScore) {
                tvScore.setText("Score: " + progress + "/" + sbScore.getMax());
                Toast.makeText(getApplicationContext(), "Stopped tracking seekbar", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        this.resetWidgets();
    }

    private void referWidgets() {
        tvScore = findViewById(R.id.tv_score);

        edtStudentID = findViewById(R.id.edt_student_id);
        edtComments = findViewById(R.id.edt_comments);

        sbScore = findViewById(R.id.sb_score);

        btnBack = findViewById(R.id.btn_back);
        btnBack.setOnClickListener(this);
        btnSaveRecord = findViewById(R.id.btn_save_record);
        btnSaveRecord.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_back:
                Intent mainIntent = new Intent(this, MainActivity.class);
                startActivity(mainIntent);
            case R.id.btn_save_record:

        }
    }

    private void resetWidgets() {
        edtStudentID.setText("");
        edtComments.setText("");
    }
}
