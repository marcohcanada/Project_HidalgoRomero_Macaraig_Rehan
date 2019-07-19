package com.example.sharedpreferencesexample;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    EditText edtEnterKey;

    static final String MY_SHARED_PREFERENCES = "Shared_Preferences_File";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        this.referWidgets();
    }

    private void referWidgets() {
        edtEnterKey = findViewById(R.id.edt_enter_key);
    }

    public void readData() {
        String key = edtEnterKey.getText().toString();
        SharedPreferences preferences = getSharedPreferences(MY_SHARED_PREFERENCES, MODE_PRIVATE);
        String value = preferences.getString(key, "");
        Toast.makeText(this, "value " + value, Toast.LENGTH_LONG).show();
    }
}
