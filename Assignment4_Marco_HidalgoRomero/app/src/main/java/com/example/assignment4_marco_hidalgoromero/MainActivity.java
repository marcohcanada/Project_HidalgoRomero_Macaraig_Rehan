package com.example.assignment4_marco_hidalgoromero;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnSelect;

    TextView tvSelectedName;
    TextView tvSelectedCapital;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.referWidgets();
    }

    private void referWidgets() {
        btnSelect = findViewById(R.id.btn_select);
        btnSelect.setOnClickListener(this);

        tvSelectedName = findViewById(R.id.tv_selected_name);
        tvSelectedCapital = findViewById(R.id.tv_selected_capital);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_select:
                showAlertDialog(v);
        }
    }

    public void showAlertDialog(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Would You Like to Open Second Activity?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        openNextActivity();
                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //Stays in MainActivity
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    private void openNextActivity() {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivityForResult(intent, 1);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK){
                String name = data.getStringExtra("PROVINCE NAME");
                tvSelectedName.setText(name);

                String capital = data.getStringExtra("CAPITAL CITY");
                tvSelectedCapital.setText(capital);
        }

            if (resultCode == Activity.RESULT_CANCELED) {
                //No result
            }
        }
    }
}
