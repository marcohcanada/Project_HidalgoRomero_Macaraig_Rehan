package com.example.sharedpreferencesexample;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText edtKey;
    EditText edtValue;

    static final String MY_SHARED_PREFERENCES = "Shared_Preferences_File";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.referWidgets();
    }

    private void referWidgets() {
        edtKey = findViewById(R.id.edt_key);
        edtValue = findViewById(R.id.edt_value);
    }

    public void saveData(View view) {
        SharedPreferences preferences = getSharedPreferences(MY_SHARED_PREFERENCES, MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        String key = edtKey.getText().toString();
        String value = edtValue.getText().toString();

        editor.putString(key, value);
        editor.apply();

        //Clear EditText fields
        edtKey.setText("");
        edtValue.setText("");
    }

    public void openNextActivity(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }
}
