package com.example.project_hidalgoromero_macaraig_rehan;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class EditRecordActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvStudentID;

    EditText edtScore;
    EditText edtComments;

    Button btnCancel;
    Button btnUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_record);

        this.referWidgets();
    }

    private void referWidgets() {
        tvStudentID = findViewById(R.id.tv_student_id);

        edtScore = findViewById(R.id.edt_score);
        edtComments = findViewById(R.id.edt_comments);

        btnCancel = findViewById(R.id.btn_cancel);
        btnCancel.setOnClickListener(this);
        btnUpdate = findViewById(R.id.btn_update);
        btnUpdate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_cancel:
                Intent cancelIntent = new Intent(this, AllRecordsActivity.class);
                startActivity(cancelIntent);
            case R.id.btn_update:
                Intent updateIntent = new Intent(this, AllRecordsActivity.class);
                startActivityForResult(updateIntent, 1);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                String studentIDAsString = data.getStringExtra("STUDENT ID");
                tvStudentID.setText("Student ID: " + studentIDAsString);
                String scoreAsString = data.getStringExtra("SCORE");
                edtScore.setText(scoreAsString);
                String comments = data.getStringExtra("COMMENTS");
                edtComments.setText(comments);
            }
        }
    }
}
