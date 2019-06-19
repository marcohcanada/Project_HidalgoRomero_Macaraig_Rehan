package com.jk.billcalc;

import android.util.Log;

import com.jk.billcalc.model.BillCalc;

import java.util.ArrayList;

/**
 * Created by 991470628 : MARCO HIDALGO ROMERO
 * on 2019-06-19
 */
public class BillCalcSingleton {
    private static BillCalcSingleton billCalcSingleton; //lazy initialization

    private ArrayList<BillCalc> billCalcList; //list of bill calc

    //method with same name as class to initialize ArrayList only once when
    // the very first object of the class is created
    private BillCalcSingleton(){
        billCalcList = new ArrayList<BillCalc>();
    }

    //returns a single and same instance of BillCalcSingleton class always
    public static BillCalcSingleton getInstance(){
        if (billCalcSingleton == null) {
            billCalcSingleton = new BillCalcSingleton();
        }

        return billCalcSingleton;
    }

    //method to add new bill calc into the ArrayList
    public void addBillCalc(BillCalc newBillCalc) {
        billCalcList.add(newBillCalc);
        Log.d("BillCalcSingleton", "New bill calc added \n " + newBillCalc.toString());
    }

    public BillCalc getBillCalcByAccountNumber(String accountNumber) {
        for (BillCalc currentBillCalc: billCalcList) {
            //checking if the current bill calc object is the same as the one we are searching
            if (currentBillCalc.getAccountNumber().equals(accountNumber)) {
                return currentBillCalc; //bill calc found and returning object
            }
        }

        return null; //bill calc does not exist
    }
}
