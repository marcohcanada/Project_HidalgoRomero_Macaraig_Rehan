package com.example.marco_hidalgoromero_a1;

/**
 * Created by 991470628 : MARCO HIDALGO ROMERO
 * on 2019-05-29
 */
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnCancel, btnSubmit;
    RadioGroup rdoRecommend;
    RadioButton rdoSelected;
    CheckBox chkGuitar, chkFootball, chkSinging, chkChess, chkHorsebackRiding, chkReading;
    Spinner spnFrequency;
    EditText edtName, edtEmail, edtPhoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.referWidgets(); //referring to UI Views
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        this.resetWidgets();
    }

    private void referWidgets() {
        edtName = findViewById(R.id.edt_name);
        edtEmail = findViewById(R.id.edt_email);
        edtPhoneNumber = findViewById(R.id.edt_phone_number);
        rdoRecommend = findViewById(R.id.rdo_recommend);
        chkGuitar = findViewById(R.id.chk_chess);
        chkFootball = findViewById(R.id.chk_football);
        chkSinging = findViewById(R.id.chk_singing);
        chkChess = findViewById(R.id.chk_chess);
        chkHorsebackRiding = findViewById(R.id.chk_horseback_riding);
        chkReading = findViewById(R.id.chk_reading);

        spnFrequency = findViewById(R.id.spn_frequency);

        ArrayAdapter<CharSequence> frequencyAdapter = ArrayAdapter.createFromResource(this,
                R.array.frequency_array, android.R.layout.simple_spinner_dropdown_item);
        spnFrequency.setAdapter(frequencyAdapter);

        btnCancel = findViewById(R.id.btn_cancel);
        btnCancel.setOnClickListener(this);
        btnSubmit = findViewById(R.id.btn_submit);
        btnSubmit.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_cancel:
                Log.d("MainActivity", "Cancel Clicked");
                this.finishAffinity();
                break;
            case R.id.btn_submit:
                Log.d("MainActivity", "Submit Clicked");
                this.getValues();

                break;
        }
    }

    private void getValues() {

        String name = edtName.getText().toString();
        String email = edtEmail.getText().toString();
        String phoneNumber = edtPhoneNumber.getText().toString();

        rdoSelected = findViewById(rdoRecommend.getCheckedRadioButtonId());
        String recommend = rdoSelected.getText().toString();

        String hobby ="";
        if (chkGuitar.isChecked()) {
            hobby += "\nGuitar";
        }

        if (chkFootball.isChecked()) {
            hobby += "\nFootball";
        }

        if (chkSinging.isChecked()) {
            hobby += "\nSinging";
        }

        if (chkChess.isChecked()) {
            hobby += "\nChess";
        }

        if (chkHorsebackRiding.isChecked()) {
            hobby += "\nHorseback Riding";
        }

        if (chkReading.isChecked()) {
            hobby += "\nReading";
        }

        String frequency = spnFrequency.getSelectedItem().toString();

        String output = "Please verify your details: " + "\nRecommendation: " + recommend +
                "\nSelected hobbies: " + hobby + "\nNewsletter frequency: " + frequency +
                "\nName: " + name + "\nEmail: " + email + "\nPhone number: " + phoneNumber +
                "\nThank you for your feedback!";
        Log.d("MainActivity", output);
        Toast.makeText(getApplicationContext(), output, Toast.LENGTH_LONG).show();
    }

    private void resetWidgets() {
        rdoSelected.setChecked(false);
        chkGuitar.setChecked(false);
        chkFootball.setChecked(false);
        chkSinging.setChecked(false);
        chkChess.setChecked(false);
        chkHorsebackRiding.setChecked(false);
        chkReading.setChecked(false);
        spnFrequency.setSelection(0);
        edtName.setText("");
        edtEmail.setText("");
        edtPhoneNumber.setText("");
    }
}
