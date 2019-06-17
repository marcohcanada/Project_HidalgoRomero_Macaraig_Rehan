package com.example.marco_hidalgoromero_a1.controller;

import com.example.marco_hidalgoromero_a1.FeedbackSingleton;
import com.example.marco_hidalgoromero_a1.model.Feedback;

import java.util.ArrayList;

/**
 * Created by 991470628 : MARCO HIDALGO ROMERO
 * on 2019-06-13
 */
public class FeedbackController {
    public void insertFeedback(Feedback newFeedback){
        FeedbackSingleton.getInstance().addFeedback(newFeedback);
    }

    public Feedback fetchFeedbackByEmail(String email){
        return FeedbackSingleton.getInstance().getFeedbackByEmail(email);
    }
}
