package com.example.marco_hidalgoromero_a1;

/**
 * Created by 991470628 : MARCO HIDALGO ROMERO
 * on 2019-06-05
 */

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConfirmationActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvSelectedRecommendation,tvSelectedHobbies, tvSelectedFrequency, tvEnteredName,
            tvEnteredEmail, tvEnteredPhoneNumber, tvCalculatedScore;
    Button btnDone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);

        this.referWidgets();
        this.fetchExtras();
    }

    private void referWidgets() {
        tvSelectedRecommendation = findViewById(R.id.tv_selected_recommendation);
        tvSelectedHobbies = findViewById(R.id.tv_selected_hobbies);
        tvSelectedFrequency = findViewById(R.id.tv_selected_frequency);
        tvEnteredName = findViewById(R.id.tv_entered_name);
        tvEnteredEmail = findViewById(R.id.tv_entered_email);
        tvEnteredPhoneNumber = findViewById(R.id.tv_entered_phone_number);
        tvCalculatedScore = findViewById(R.id.tv_calculated_score);

        btnDone = findViewById(R.id.btn_done);
        btnDone.setOnClickListener(this);
    }

    private void fetchExtras() {
        Intent currentIntent = this.getIntent();
        //receiving data from previous activity
        String recommend = currentIntent.getStringExtra("EXTRA_RECOMMEND");
        tvSelectedRecommendation.setText(recommend);
        String hobby = currentIntent.getStringExtra("EXTRA_HOBBY");
        tvSelectedHobbies.setText(hobby);
        String frequency = currentIntent.getStringExtra("EXTRA_FREQUENCY");
        tvSelectedFrequency.setText(frequency);
        String name = currentIntent.getStringExtra("EXTRA_NAME");
        tvEnteredName.setText(name);
        String email = currentIntent.getStringExtra("EXTRA_EMAIL");
        tvEnteredEmail.setText(email);
        String phoneNumber = currentIntent.getStringExtra("EXTRA_PHONE_NUMBER");
        tvEnteredPhoneNumber.setText(phoneNumber);

        int score = currentIntent.getIntExtra("EXTRA_SCORE", 0);
        String scoreAsString = Integer.toString(score);
        tvCalculatedScore.setText(scoreAsString);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_done:
                finishAffinity(); //terminates app
                break;
        }
    }
}
