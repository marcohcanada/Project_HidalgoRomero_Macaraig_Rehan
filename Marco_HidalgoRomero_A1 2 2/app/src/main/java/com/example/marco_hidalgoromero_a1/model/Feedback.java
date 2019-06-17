package com.example.marco_hidalgoromero_a1.model;

/**
 * Created by 991470628 : MARCO HIDALGO ROMERO
 * on 2019-06-11
 */
public class Feedback {
    String recommend;
    String hobby;
    String frequency;
    String name;
    String email;
    String phoneNumber;
    int score;

    public Feedback(String recommend, String hobby, String frequency, String name, String email, String phoneNumber, int score) {
        this.recommend = recommend;
        this.hobby = hobby;
        this.frequency = frequency;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.score = score;
    }

    public String getRecommend() {
        return recommend;
    }

    public void setRecommend(String recommend) {
        this.recommend = recommend;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "recommend='" + recommend + '\'' +
                ", hobby='" + hobby + '\'' +
                ", frequency='" + frequency + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", score=" + score +
                '}';
    }
}
