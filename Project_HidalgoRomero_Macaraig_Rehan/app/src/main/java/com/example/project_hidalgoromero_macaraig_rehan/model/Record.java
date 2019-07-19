package com.example.project_hidalgoromero_macaraig_rehan.model;

/**
 * Created by 991470628 : MARCO HIDALGO ROMERO
 * on 2019-07-16
 */
public class Record {
    int studentID;
    int score;

    String comments;

    public Record(int studentID, int score, String comments) {
        this.studentID = studentID;
        this.score = score;
        this.comments = comments;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Record{" +
                "studentID=" + studentID +
                ", score=" + score +
                ", comments='" + comments + '\'' +
                '}';
    }
}
