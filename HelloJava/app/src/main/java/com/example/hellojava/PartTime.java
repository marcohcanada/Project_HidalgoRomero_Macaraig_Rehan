package com.example.hellojava;

/**
 * Created by 991470628 : MARCO HIDALGO ROMERO
 * on 2019-05-16
 */
public class PartTime extends Employee {
    double basicPay;
    double hoursWorked;
    double finalPay;

    PartTime(){
        this.basicPay = 20;
        this.hoursWorked = 35;
        this.finalPay = basicPay * hoursWorked;
    }

    PartTime(double basicPay, double hoursWorked, double finalPay, double pay, String fnm, String lnm, int age){
        super(pay, fnm, lnm, age);
        this.basicPay = basicPay;
        this.hoursWorked = hoursWorked;
        this.finalPay = finalPay;
    }

    public void setBasicPay(double basicPay) {
        this.basicPay = basicPay;
    }

    public double getBasicPay() {
        return basicPay;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setFinalPay(double finalPay) {
        this.finalPay = finalPay;
    }

    public double getFinalPay() {
        return finalPay;
    }

    @Override
    public String toString() {
        return super.toString() + "\nBasic Pay : " + this.basicPay + "\nHours Worked : "
                + this.hoursWorked + "\nFinal Pay : " + this.finalPay;
    }
}
