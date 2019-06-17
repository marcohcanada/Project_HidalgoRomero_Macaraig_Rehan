package com.example.marco_hidalgoromero_a1;

import android.util.Log;

import com.example.marco_hidalgoromero_a1.model.Feedback;

import java.util.ArrayList;

/**
 * Created by 991470628 : MARCO HIDALGO ROMERO
 * on 2019-06-13
 */
public class FeedbackSingleton {
    private static FeedbackSingleton feedbackSingleton; //lazy initialization

    private ArrayList<Feedback> feedbackList; //list of feedback

    //method with same name as class to initialize ArrayList only once when
    // the very first object of the class is created
    private FeedbackSingleton(){
        feedbackList = new ArrayList<Feedback>();
    }

    //returns a single and same instance of FeedbackSingleton class always
    public static FeedbackSingleton getInstance(){
        if (feedbackSingleton == null) {
            feedbackSingleton = new FeedbackSingleton();
        }

        return feedbackSingleton;
    }

    //method to add new feedback into the ArrayList
    public void addFeedback(Feedback newFeedback){
        feedbackList.add(newFeedback);
        Log.d("FeedbackSingleton", "New feedback added \n " + newFeedback.toString());
    }

    public Feedback getFeedbackByEmail(String email){
        for (Feedback currentFeedback: feedbackList){
            //checking if the current feedback object is the same as the one we are searching
            if (currentFeedback.getEmail().equals(email)){
                return currentFeedback; //feedback found and returning object
            }
        }

        return null; //feedback does not exist
    }
}
