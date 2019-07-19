package com.example.menuexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    EditText edtHello;

    Button btnDisplay;
    Button btnReset;

    TextView tvHello;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        this.referWidgets();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        this.resetWidgets();
    }

    private void referWidgets() {
        edtHello = findViewById(R.id.edt_hello);

        btnDisplay = findViewById(R.id.btn_display);
        btnDisplay.setOnClickListener(this);
        btnReset = findViewById(R.id.btn_reset);
        btnReset.setOnClickListener(this);

        tvHello = findViewById(R.id.tv_hello);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_display:
                Log.d("Main2Activity", "Display Clicked");
                this.getValues();
                break;
            case R.id.btn_reset:
                Log.d("Main2Activity", "Reset Clicked");
                edtHello.setText(null);
                tvHello.setText("");
                break;
        }
    }

    private void getValues() {
        String name = edtHello.getText().toString();

        String output = "Hello " + name;
        tvHello.setText(output);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_menu2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_display) {
            Log.d("Main2Activity", "Display Clicked");
            this.getValues();
        }

        if (id == R.id.action_reset) {
            Log.d("Main2Activity", "Reset Clicked");
            edtHello.setText(null);
            tvHello.setText("");
        }

        return super.onOptionsItemSelected(item);
    }

    private void resetWidgets() {
        edtHello.setText("");
    }
}
