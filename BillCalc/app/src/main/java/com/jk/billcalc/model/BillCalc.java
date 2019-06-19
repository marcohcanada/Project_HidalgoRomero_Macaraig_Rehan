package com.jk.billcalc.model;

/**
 * Created by 991470628 : MARCO HIDALGO ROMERO
 * on 2019-06-19
 */
public class BillCalc {
    String accountNumber;
    String name;
    double weekdayMinutes;
    double eveningMinutes;
    double videoMinutes;
    double weekdayCharges;
    double eveningCharges;
    double videoCharges;
    double billAmountValue;

    public BillCalc(String accountNumber, String name, double weekdayMinutes, double eveningMinutes, double videoMinutes, double weekdayCharges, double eveningCharges, double videoCharges, double billAmountValue) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.weekdayMinutes = weekdayMinutes;
        this.eveningMinutes = eveningMinutes;
        this.videoMinutes = videoMinutes;
        this.weekdayCharges = weekdayCharges;
        this.eveningCharges = eveningCharges;
        this.videoCharges = videoCharges;
        this.billAmountValue = billAmountValue;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeekdayMinutes() {
        return weekdayMinutes;
    }

    public void setWeekdayMinutes(double weekdayMinutes) {
        this.weekdayMinutes = weekdayMinutes;
    }

    public double getEveningMinutes() {
        return eveningMinutes;
    }

    public void setEveningMinutes(double eveningMinutes) {
        this.eveningMinutes = eveningMinutes;
    }

    public double getVideoMinutes() {
        return videoMinutes;
    }

    public void setVideoMinutes(double videoMinutes) {
        this.videoMinutes = videoMinutes;
    }

    public double getWeekdayCharges() {
        return weekdayCharges;
    }

    public void setWeekdayCharges(double weekdayCharges) {
        this.weekdayCharges = weekdayCharges;
    }

    public double getEveningCharges() {
        return eveningCharges;
    }

    public void setEveningCharges(double eveningCharges) {
        this.eveningCharges = eveningCharges;
    }

    public double getVideoCharges() {
        return videoCharges;
    }

    public void setVideoCharges(double videoCharges) {
        this.videoCharges = videoCharges;
    }

    public double getBillAmountValue() {
        return billAmountValue;
    }

    public void setBillAmountValue(double billAmountValue) {
        this.billAmountValue = billAmountValue;
    }

    @Override
    public String toString() {
        return "BillCalc{" +
                "accountNumber='" + accountNumber + '\'' +
                ", name='" + name + '\'' +
                ", weekdayMinutes=" + weekdayMinutes +
                ", eveningMinutes=" + eveningMinutes +
                ", videoMinutes=" + videoMinutes +
                ", weekdayCharges=" + weekdayCharges +
                ", eveningCharges=" + eveningCharges +
                ", videoCharges=" + videoCharges +
                ", billAmountValue=" + billAmountValue +
                '}';
    }
}
