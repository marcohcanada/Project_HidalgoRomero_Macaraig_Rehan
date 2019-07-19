package com.example.gettingresultfromanactivity;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void getText(View view) {
        Intent intent = new Intent(this, SecondActivity.class);

        startActivityForResult(intent , 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                String text = data.getExtras().getString("result");

                TextView tvDisplay = (TextView) findViewById(R.id.tv_display);
                tvDisplay.setText(text);
            }
        }
    }
}
