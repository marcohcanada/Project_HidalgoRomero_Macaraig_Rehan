package com.jk.billcalc.controller;

import com.jk.billcalc.BillCalcSingleton;
import com.jk.billcalc.model.BillCalc;

/**
 * Created by 991470628 : MARCO HIDALGO ROMERO
 * on 2019-06-19
 */
public class BillCalcController {
    public void insertBillCalc(BillCalc newBillCalc){
        BillCalcSingleton.getInstance().addBillCalc(newBillCalc);
    }

    public BillCalc fetchBillCalcByAccountNumber(String accountNumber) {
        return BillCalcSingleton.getInstance().getBillCalcByAccountNumber(accountNumber);
    }
}
