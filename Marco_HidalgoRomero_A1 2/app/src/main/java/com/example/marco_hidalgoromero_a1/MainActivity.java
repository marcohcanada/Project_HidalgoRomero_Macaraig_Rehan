package com.example.marco_hidalgoromero_a1;

/**
 * Created by 991470628 : MARCO HIDALGO ROMERO
 * on 2019-05-29
 */
import android.content.Intent;
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
    String recommend, hobby, frequency, name, email, phoneNumber, output;
    int score = 0;

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
        chkGuitar = findViewById(R.id.chk_guitar);
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
                this.openNextActivity();
                break;
        }
    }

    private void getValues() {

        name = edtName.getText().toString();
        email = edtEmail.getText().toString();
        phoneNumber = edtPhoneNumber.getText().toString();

        rdoSelected = findViewById(rdoRecommend.getCheckedRadioButtonId());
        recommend = rdoSelected.getText().toString();

        hobby ="";
        if (chkGuitar.isChecked()) {
            hobby += getResources().getString(R.string.guitar) + "\n";
        }

        if (chkFootball.isChecked()) {
            hobby += getResources().getString(R.string.football) + "\n";
        }

        if (chkSinging.isChecked()) {
            hobby += getResources().getString(R.string.singing) + "\n";
        }

        if (chkChess.isChecked()) {
            hobby += getResources().getString(R.string.chess) + "\n";
        }

        if (chkHorsebackRiding.isChecked()) {
            hobby += getResources().getString(R.string.horseback_riding) + "\n";
        }

        if (chkReading.isChecked()) {
            hobby += getResources().getString(R.string.reading) + "\n";
        }

        frequency = spnFrequency.getSelectedItem().toString();

        this.calculateScore();

        output = "Please verify your details: " + "\nRecommendation: " + recommend +
                "\nSelected hobbies: " + hobby + "\nNewsletter frequency: " + frequency +
                "\nName: " + name + "\nEmail: " + email + "\nPhone number: " + phoneNumber +
                "\nThank you for your feedback!";
        Log.d("MainActivity", output);
        Toast.makeText(getApplicationContext(), output, Toast.LENGTH_LONG).show();
    }

    private void calculateScore() {
        switch (rdoSelected.getId()) {
            case R.id.rdo_yes:
                if (frequency == getResources().getString(R.string.daily)) {
                    score += 20;
                }
                if (frequency == getResources().getString(R.string.weekly)) {
                    score += 15;
                }
                if (frequency == getResources().getString(R.string.monthly)) {
                    score += 10;
                }
                break;
            case R.id.rdo_no:
                if (frequency == getResources().getString(R.string.daily)) {
                    score += 5;
                }
                break;
            case R.id.rdo_maybe:
                if (frequency == getResources().getString(R.string.daily)) {
                    score += 5;
                }
                if (frequency == getResources().getString(R.string.weekly)) {
                    score += 2;
                }
                break;
        }
    }

    private void openNextActivity() {
        Intent confirmationIntent = new Intent(this, ConfirmationActivity.class);
        //sending data to next activity
        confirmationIntent.putExtra("EXTRA_RECOMMEND", recommend);
        confirmationIntent.putExtra("EXTRA_HOBBY", hobby);
        confirmationIntent.putExtra("EXTRA_FREQUENCY", frequency);
        confirmationIntent.putExtra("EXTRA_NAME", name);
        confirmationIntent.putExtra("EXTRA_EMAIL", email);
        confirmationIntent.putExtra("EXTRA_PHONE_NUMBER", phoneNumber);
        confirmationIntent.putExtra("EXTRA_SCORE", score);
        startActivity(confirmationIntent);
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
