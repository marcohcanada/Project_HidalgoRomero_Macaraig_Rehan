package com.example.gettingresultfromanactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    public void sendResult(View view) {
        EditText edtName = (EditText) findViewById(R.id.edt_name);

        String text = edtName.getText().toString();

        Intent intent = getIntent();
        intent.putExtra("result", text);
        setResult(RESULT_OK , intent);
        finish();
    }
}
