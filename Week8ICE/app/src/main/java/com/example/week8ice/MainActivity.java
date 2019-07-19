package com.example.week8ice;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText edtHeight;
    EditText edtWeight;

    Editable editableHeight;
    Editable editableWeight;

    double height;
    double heightSquared;
    double weight;
    double BMI;

    Button btnGetBMI;

    TextView tvBMI;

    boolean isChecked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.referWidgets();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        this.resetWidgets();
    }

    private void referWidgets() {
        edtHeight = findViewById(R.id.edt_height);
        edtWeight = findViewById(R.id.edt_weight);

        btnGetBMI = findViewById(R.id.btn_get_bmi);
        btnGetBMI.setOnClickListener(this);

        tvBMI = findViewById(R.id.tv_bmi);
    }

    private void getValues() throws NumberFormatException {
        editableHeight = edtHeight.getText();
        editableWeight = edtWeight.getText();

        try {

            if (editableHeight != null) {
                height = Double.parseDouble(editableHeight.toString());
                heightSquared = Math.pow(height, 2);
            }

            if (editableWeight != null) {
                weight = Double.parseDouble(editableWeight.toString());
            }

            BMI = weight / heightSquared;

            String BMIAsString = Double.toString(BMI);
            tvBMI.setText(BMIAsString);

        } catch (NumberFormatException ex) {

            tvBMI.setText("");

            if (isChecked) {
                this.showDialog();
            }

        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_get_bmi:
                Log.d("MainActivity", "Get BMI Clicked");
                this.getValues();
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_menu, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuItem item = menu.findItem(R.id.action_dialog);
        item.setChecked(isChecked);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_dialog:
                isChecked = !item.isChecked();
                item.setChecked(isChecked);
                return true;
            default:
                return false;
        }
    }

    public void showDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Enter Valid Information")
                .setMessage("Enter a valid number for height and/or weight")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        showToastMessage();
                    }
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    private void showToastMessage(){
        Toast.makeText(this, " OK Is Clicked", Toast.LENGTH_LONG).show();
    }

    private void resetWidgets() {
        edtHeight.setText("");
        edtWeight.setText("");
    }
}
