package com.example.marco_hidalgoromero_a1;

/**
 * Created by 991470628 : MARCO HIDALGO ROMERO
 * on 2019-06-05
 */

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.marco_hidalgoromero_a1.controller.FeedbackController;
import com.example.marco_hidalgoromero_a1.model.Feedback;

public class ConfirmationActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvSelectedRecommendation;
    TextView tvSelectedHobbies;
    TextView tvSelectedFrequency;
    TextView tvEnteredName;
    TextView tvEnteredEmail;
    TextView tvEnteredPhoneNumber;
    TextView tvCalculatedScore;
    Button btnDone;

    FeedbackController feedbackController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);

        feedbackController = new FeedbackController();

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
        Intent thisIntent = this.getIntent();
        String email = thisIntent.getStringExtra("EXTRA_EMAIL");

        Feedback currentFeedback = feedbackController.fetchFeedbackByEmail(email);
        tvEnteredEmail.setText(email);

        if (currentFeedback != null) {
            Log.d("MainActivity", currentFeedback.toString());

            String recommend = currentFeedback.getRecommend();
            tvSelectedRecommendation.setText(recommend);
            String hobby = currentFeedback.getHobby();
            tvSelectedHobbies.setText(hobby);
            String frequency = currentFeedback.getFrequency();
            tvSelectedFrequency.setText(frequency);
            String name = currentFeedback.getName();
            tvEnteredName.setText(name);
            String phoneNumber = currentFeedback.getPhoneNumber();
            tvEnteredPhoneNumber.setText(phoneNumber);

            int score = currentFeedback.getScore();
            String scoreAsString = Integer.toString(score);
            tvCalculatedScore.setText(scoreAsString);
        }
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
