package com.example.project_hidalgoromero_macaraig_rehan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvHi;

    Button btnSubmit;

    RadioGroup rdoRecords;
    RadioButton rdoSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.referWidgets();
        this.fetchExtras();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        this.resetWidgets();
    }

    private void referWidgets() {
        tvHi = findViewById(R.id.tv_hi);

        btnSubmit = findViewById(R.id.btn_submit);
        btnSubmit.setOnClickListener(this);

        rdoRecords = findViewById(R.id.rdo_records);
    }

    private void fetchExtras() {
        Intent currentIntent = this.getIntent();
        String username = currentIntent.getStringExtra("EXTRA_USERNAME");
        tvHi.setText("Hi, " + username);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_submit:
                Log.d("MainActivity", "Submit Clicked");
                this.getValues();
                break;
        }
    }

    private void getValues() {

        rdoSelected = findViewById(rdoRecords.getCheckedRadioButtonId());

        this.selectActivity();
    }

    private void selectActivity() {
        switch (rdoSelected.getId()) {
            case R.id.rdo_new_record:
                Intent newRecordIntent = new Intent(this, NewRecordActivity.class);
                startActivity(newRecordIntent);
            case R.id.rdo_previous_records:
                Intent allRecordsIntent = new Intent(this, AllRecordsActivity.class);
                startActivity(allRecordsIntent);
            case R.id.rdo_logout:
                Intent loginIntent = new Intent(this, LoginActivity.class);
                startActivity(loginIntent);
        }
    }

    private void resetWidgets() {
        rdoSelected.setChecked(false);
    }
}
